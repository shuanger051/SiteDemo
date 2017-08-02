/**
 * Created by xuebj on 2017/3/28.
 */
var ContentAddModel = function ($) {
    var data = $.extend({},parent.Manager.getContent());
    $(".placeul li:nth-child(2) a").text(data.channel.name + "管理");
    $(".placeul li:nth-child(3) a").text("编辑" + data.channel.name);
    var ue ;
    function _initFormData(){
        $("#channelName").val(data.channel.name);
        data.sortDate = Tool.dateFormat(data.sortDate);
        data.contentExt.releaseDate = Tool.dateFormat(data.contentExt.releaseDate);
        Tool.set_form_data($("#form1"),data.contentExt);
        Tool.set_form_data($("#form1"),data);
        setAttachment();
        setPicture();
        setTitleImg();
        // var node = parent.Manager.getChannel();
        // Tool.set_form_data($("#form1"),{
        //     channelName:node.name,
        // })
    }
    function setAttachment() {
        var attachments = data.contentAttachments;
        if(!!attachments){
            aCount = attachments.length;
            $.each(attachments,function (index, obj) {
                $("#attachmentCont tbody").append(template("attachmentTemp",{item:obj,count:index}));
                Tool.initFileUpload({
                    id: "attachments" + index,
                    url: "/content/upload_attachment",
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
                })
            })
        }
    }

    function setPicture() {
       var pictures = data.contentPictures;
       if(!!pictures){
           count = pictures.length;
           $.each(pictures,function(index,obj){
               $("#picturesImgList").append(template("picturesTemp",{item:obj,count:index}));
               _addEvent(index);
           });
       }
    }

    function setTitleImg() {
        var pictures = data.contentExt.titleImg;
        if(!!pictures){
            $("#titleImgList").html(template("titleImgTemp",{item:{
                "imgPath":pictures
            },count:1}));
        }
    }

    function _initForm() {
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                Ajax.submit("saveContent",{
                    url:"/content/edit",
                    data:form.serializeArray(),
                    type:"put",
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
                $("#attachmentCont tbody").append(template("attachmentTemp",{item:result[0],count:currentCount}));
                if(!!isTransfer){
                    $.each(result,function (index,obj) {
                        if(!!obj.urls){
                            for (var i = 0;i < obj.urls.length ;i++){
                                ue.setContent('<p style="text-align:center" data-pdf-name="' + obj.attachmentPath + '"> <img src="' + obj.urls[i] + '" /> </p>', true);
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

    function _initTitleImg() {
        Tool.initFileUpload({
            id:"titleImg",
            url:"/content/upload_picture",
            fileName:"pictures",
            uploadStr:"上传",
            maxFileSize:1024*1024 * 1, //大小限制1M
            sizeErrorStr:"上传文件不能大于1M",
            multiple:false,
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
            $(that).parents("tr").remove();
        },
        delPicture:function (that) {
            $(that).parents("table.filetable").parent().remove();
        }
    }

    $(function () {
        if($("#txt").size() > 0){
            ue = UE.getEditor('txt');
            ue.ready(function () {
                ue.setContent(data.contentTxt.txt);
            })
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
