/**
 * Created by xuebj on 2017/3/28.
 */
var ContentAddModel = function ($) {
    var ue;
    function _initFormData(){
        var now = Tool.dateFormat(new Date().getTime());
        $("#releaseDate").val(now);
        $("#sortDate").val(now);
        var node = parent.Manager.getChannel();
        $(".placeul li:nth-child(2) a").text(node.name + "管理");
        $(".placeul li:nth-child(3) a").text("添加" + node.name);
        Tool.set_form_data($("#form1"),{
            parentId:node.id,
            parentName:node.name,
            channelId:node.id
        })
    }

    function _queryDict() {
        Ajax.query("queryDict",{
            url:"/sys_dict_item/list_by_entry_code",
            data:{entryCodes:"afterCheck,commentControl,allowUpdown,isDisplay"},
            callback:function (result) {
                $("#commentControlCon").html(template("radio_temp",{list:result["commentControl"]}));
                $("#allowUpdownCon").html(template("radio_temp",{list:result["allowUpdown"]}));
                $("#isDisplayCon").html(template("radio_temp",{list:result["isDisplay"]}));
                $("select[name='afterCheck']").html(template("selected_temp",{list:result["afterCheck"]}));
                $("select[name='afterCheck']").fancyspinbox();
            }
        })
    }

    function _initForm() {
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                // var data = Tool.serializeJson(form);
                Ajax.submit("saveContent",{
                    url:"/content/save",
                    data:form.serializeArray(),
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            // parent.Manager.addNode($.extend(data,{id:result}));
                            Tool.go_back();
                        })
                    }
                })
                return false;
            }
        })
    }

    var aCount = -1;

    function _initAttatchments() {
        Tool.initFileUpload({
            id: "fileuploader",
            url:"/content/upload_attachment",
            fileName:"attachments",
            uploadStr: "批量上传",
            maxFileSize: 1024 * 1024 * 200, //大小限制1M
            sizeErrorStr: "上传文件不能大于200M",
            allowedTypes: getFileType(),
            formData: getFormDate(),
            onSuccess: function (files, data, xhr, pd) {
                if(!data.success){
                    Tool.layer_alert(data.data.message);
                    return;
                }
                    var currentCount = ++aCount;
                    var result = data.data;
                    $("#attrCont tbody").append(template("attachmentTemp",{item:result[0],count:currentCount}));
                    if(!!isTransfer){
                        $.each(result,function (index,obj) {
                            if(!!obj.urls){
                                for (var i = 0;i < obj.urls.length ;i++){
                                    ue.setContent('<p style="text-align:center" data-pdf-name="' + obj.attachmentPath + '"> <img src="' + obj.urls[i] + '" /> </p>',true);
                                }
                            }
                        })
                    }
                    Tool.initFileUpload({
                        id: "attachments"+ currentCount,
                        url: "/content/upload_attachment",
                        fileName: "attachments",
                        uploadStr: "修改",
                        maxFileSize: 1024 * 1024 * 200, //大小限制1M
                        sizeErrorStr: "上传文件不能大于200M",
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
                            if(!!isTransfer) {
                                //删除对应内容的pdf 图片
                                $("#txt iframe").contents().find("p[data-pdf-name='" + p + "']").remove();
                                $.each(result, function (index, obj) {
                                    if (!!obj.urls) {
                                        for (var i = 0; i < obj.urls.length; i++) {
                                            ue.setContent('<p style="text-align:center" data-pdf-name="' + obj.attachmentPath + '"> <img src="' + obj.urls[i] + '" /> </p>', true);
                                        }
                                    }
                                })
                            }
                        }
                    });
            }
        });
    }

    var count= -1;
    function _initPictureUpload() {
        Tool.initFileUpload({
            id:"pictureupload",
            url:"/content/upload_picture",
            fileName:"pictures",
            uploadStr:"批量上传",
            maxFileSize:1024*1024 * 5, //大小限制1M
            sizeErrorStr:"上传文件不能大于5M",
            allowedTypes:Tool.getImgType().join(","),
            onSuccess:function(files,data,xhr,pd){
                if(!data.success){
                    Tool.layer_alert(data.data.message);
                    return;
                }
                var result = data.data;
                var currentCount = ++count;
                $("#picturesImgList").append(template("picturesTemp",{item:result[0],count:currentCount}));
                _addEvent(currentCount);
            }
        })
    }

    function _addEvent(currentCount) {
        Tool.initFileUpload({
            id:"picture" + currentCount,
            url:"/content/upload_picture",
            fileName:"pictures",
            uploadStr:"修改图片",
            maxFileSize:1024*1024 * 5, //大小限制1M
            sizeErrorStr:"上传文件不能大于5M",
            multiple:false,
            allowedTypes:Tool.getImgType().join(","),
            onSuccess:function(files,data,xhr,pd){
                if(!data.success){
                    Tool.layer_alert(data.data.message);
                    return;
                }
                var result = data.data;
                $("#picture" + currentCount).parents("table").find('input[data-t="name"]').val(result[0].imgPath).end().find("img").attr("src",result[0].viewPath + result[0].imgPath);

            }
        })
    }

    /**
     * 初始化标题图
     * @private
     */
    function _initTitleImg() {
        Tool.initFileUpload({
            id:"titleImg",
            url:"/content/upload_picture",
            fileName:"pictures",
            uploadStr:"上传",
            multiple:false,
            maxFileSize:1024*1024 * 1, //大小限制1M
            sizeErrorStr:"上传文件不能大于1M",
            allowedTypes:Tool.getImgType().join(","),
            onSuccess:function(files,data,xhr,pd){
                if(!data.success){
                    Tool.layer_alert(data.data.message);
                    return;
                }
                var result = data.data;
                $("#titleImgList").html(template("titleImgTemp",{item:result[0],count:1}));
            }
        })
    }
    window.Manager = {
        delAttachment:function (that){
            if(!!isTransfer) {
                var p = $(that).parents("tr").find("input[data-t='path']").val();
                $("#txt iframe").contents().find("p[data-pdf-name='" + p + "']").remove();
            }
            $(that).parents("tr").remove();},
        delPicture:function (that) {
            $(that).parents("table.filetable").parent().remove();
        }
    }


    $(function () {
        if($("#txt").size() > 0){
            ue = UE.getEditor('txt');
        }
        if($("#titleImg").size() > 0){
            _initTitleImg();
        }
        _initFormData();
        _initForm();
        if($("#fileuploader").size() > 0){
            _initAttatchments();
        }
        if($("#pictureupload").size() >0 ){
            _initPictureUpload();
        }
    })



}(jQuery)
