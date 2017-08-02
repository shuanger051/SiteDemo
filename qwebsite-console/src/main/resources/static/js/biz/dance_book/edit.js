/**
 * Created by xuebj on 2017/5/11.
 */
var DanceBookEditModel = function ($){
    var ue;
    
    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                Ajax.submit("updateChannel",{
                    url:"/chorgraphy/edit",
                    data:form.serializeArray(),
                    type:"put",
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            Tool.go_back();
                        })
                    }
                });
                return false;
            }
        })
    }

    var Service = {
        _queryDict:function (){
            Ajax.query("queryDict", {
                url: "/sys_dict_item/list_by_entry_code",
                data: {entryCodes: "danceBookLevel,danceWall"},
                async: false,
                callback: function (result) {
                    $("select[name='level']").html(template("selected_temp", {list: result["danceBookLevel"]}));
                    $("select[name='wall']").html(template("selected_temp", {list: result["danceWall"]}));

                }
            });
        },
        getDanceBook: function (id){
            Ajax.query("getDanceBook",{
                url:"/chorgraphy/get",
                data:{id:id},
                callback:function (result){
                    result.upDate = Tool.dateFormat(result.upDate);
                    ue.ready(function () {
                        ue.setContent(result.content);
                    })
                    Tool.set_form_data($("#form1"),result);
                    $("select[name='level']").fancyspinbox();
                    $("select[name='wall']").fancyspinbox();
                    $("select[name='starts']").fancyspinbox();
                }
            })
        },
        _queryAttachment:function (danceId){
            Ajax.query("queryDanceBookAttachments",{
                url:"/chorgraphy_attachment/list",
                data:{chorgraphyId:danceId},
                callback:function (result){
                    if(result.total > 0){
                        var attachments = result.data;
                        $.each(attachments,function (index, obj) {
                            $("#attachmentCont tbody").append(template("attachmentTemp",{item:obj,count:index}));
                            Tool.initFileUpload({
                                id: "attachments" + index,
                                url: "/chorgraphy/upload_attachment",
                                fileName: "attachments",
                                uploadStr: "修改",
                                maxFileSize: 1024 * 1024 * 200, //大小限制1M
                                sizeErrorStr: "上传文件不能大于200M",
                                allowedTypes: getFileType(),
                                multiple:false,
                                formData: getFormDate(),
                                onSuccess:function(files,data,xhr,pd){
                                    if(!data.success){
                                        Tool.layer_alert(data.data.message);
                                        return;
                                    }
                                    var result = data.data;
                                    var tr =  $("#attachments" + index).parents("tr");
                                    var p =tr.find("input[data-t='path']").val();
                                    tr.find("input[data-t='name']").val(result[0].attachmentName);
                                    tr.find("input[data-t='path']").val(result[0].attachmentPath);
                                }
                            })
                        })
                    }
                }
            })
        }
    }

    var aCount = -1;

    function _initAttatchments() {
        Tool.initFileUpload({
            id: "fileuploader",
            url:"/chorgraphy/upload_attachment",
            fileName:"attachments",
            uploadStr: "批量上传",
            maxFileSize: 1024 * 1024 * 10, //大小限制1M
            sizeErrorStr: "上传文件不能大于10M",
            allowedTypes: getFileType(),
            formData: getFormDate(),
            onSuccess: function (files, data, xhr, pd) {
                if(!data.success){
                    Tool.layer_alert(data.data.message);
                    return;
                }
                var currentCount = ++aCount;
                var result = data.data;
                $("#attachmentCont tbody").append(template("attachmentTemp",{item:result[0],count:currentCount}));
                Tool.initFileUpload({
                    id: "attachments"+ currentCount,
                    url: "/content/upload_attachment",
                    fileName: "attachments",
                    uploadStr: "修改",
                    maxFileSize: 1024 * 1024 * 10, //大小限制1M
                    sizeErrorStr: "上传文件不能大于10M",
                    allowedTypes: getFileType(),
                    multiple:false,
                    formData: getFormDate(),
                    onSuccess: function (files, data, xhr, pd) {
                        if(!data.success){
                            Tool.layer_alert(data.data.message);
                            return;
                        }
                        var result = data.data;
                        var tr = $("#attachments" + currentCount).parents("tr");
                        var p = tr.find("input[data-t='path']").val();
                        tr.find("input[data-t='name']").val(result[0].attachmentName);
                        tr.find("input[data-t='path']").val(result[0].attachmentPath);
                    }
                });
            }
        });
    }

    $(function () {
        if ($("#txt").size() > 0) {
            ue = UE.getEditor('txt',{
                    toolbars:[
                        [ 'source', '|', 'undo', 'redo', '|',
                        'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
                        'rowspacingtop', 'rowspacingbottom', 'lineheight', '|', 'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|'],
                        ['directionalityltr', 'directionalityrtl', 'indent', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
                        'link', 'unlink',  '|', 'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols']
                    ],
                textarea:"content"
            });
        }
        var danceId  = Tool.getReqP("id");
        _initForm();
        _initAttatchments();
        Service._queryDict();
        Service._queryAttachment(danceId)
        Service.getDanceBook(danceId);
    });
}(jQuery);
