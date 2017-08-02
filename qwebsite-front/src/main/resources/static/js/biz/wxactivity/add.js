/**
 * Created by xuebj on 2017/4/20.
 */
var AddCourseModel = function ($){

    var Service = {
        _queryDicts: function (){
            Ajax.query("queryDicts",{
                url:"/dict/list_by_entry_code",
                data:{"entryCodes":"activityKind,activityType"},
                callback:function (result) {
                    $("#activityKind").html(_setSelect(result["activityKind"],"activityKind"));
                    $("#activityType").html(_setSelect(result["activityType"],"activityType"));
                    _initSelectEvent();
                }
            })
        }
    }

    window.Manager = {
        showImg:function (event){
            var files = event.target.files, file;
            if (files && files.length > 0) {
                var URL = window.URL || window.webkitURL;
                file = files[0];
                if(file.type.indexOf("image/") !== 0){
                    Tool.tipType("必须上传图片",{type:3},null);
                    event.target.value = "";
                    return false;
                }
                // 通过 file 生成目标 url
                var imgURL = URL.createObjectURL(file);
                $(".up_face").css({"background-image":"url(" + imgURL + ")"});
            }
        }
    }

    function _setSelect(data,id){
        var html = new Array();
        $.each(data,function (){
            html.push("<li value='"+ this["itemCode"] + "'>" + this["itemName"] + "</li>");
        });
        $("#"+id).closest(".divselect").find("cite").text(data[0].itemName);
        $("input[name='" + id + "']").val(data[0].itemCode);
        return html.join("");
    }


    function _initSelectEvent(){
        $(".divselect").click(function () {
            $(this).toggleClass("divselect_open");
        });
        $(".divselect li").click(function () {
            $(this).closest(".divselect").find("cite").text($(this).text());
            var id = $(this).parent().attr("id");
            $("input[name='"+id+"']").val($(this).attr("value"));
        });
        // 点击其它地方搜索消失
        $(window).on("click", function (e) {
            if ($(e.target).parents(".divselect").length == 0) {
                $(".divselect").removeClass("divselect_open");
            } else {
                e.stopPropagation();
            }
        });
    }


    function _initForm(){
        $("#form").Validform({
            tiptype:Tool.tipType,
            callback:function (form){
                var check = true;
                $("#test select").each(function(){
                    var v = $(this).val();
                    if(v == "请选择"){
                        check = false;
                        Tool.tipType("请选择省市区",{type:3},null);
                        return false;
                    }
                });
                if (check){
                    form.ajaxSubmit({
                        success:function (responseText, statusText, xhr, $form){
                            if(!!responseText && !!responseText.success){
                                if(responseText.success){
                                    Tool.tipSuccess("恭喜你,发布课程成功，请耐心等待管理员审核。",{callback:function (){
                                        location.href = "./activity.htm";
                                    }})
                                }else{
                                    Tool.tipType("发布课程失败，" + responseText.data,{type:3},null);

                                }
                            }
                        },error:function(XmlHttpRequest, textStatus, errorThrown){
                            if(!!XmlHttpRequest.responseText){
                                var jsonObj = $.parseJSON(XmlHttpRequest.responseText);
                                Tool.tipType("发布课程失败，" + jsonObj.data.message,{type:3},null);
                            }

                        }
                    });
                }
                return false;
            }
        })
    }

    function _initDateTime(){
        $(function(){
            var options = {
                format:"Y-m-d",
                minDate:0,
                timepicker: false
            };

            jQuery.datetimepicker.setLocale('zh-TW');

            // 日期时间选择器
            $("#biginDate").datetimepicker($.extend({},options,{
                onShow:function( ct ){
                    this.setOptions({
                        maxDate:jQuery('#endDate').val()?jQuery('#endDate').val():false
                    })
                },
            }));
            $("#endDate").datetimepicker($.extend({},options,{
                onShow:function( ct ){
                    this.setOptions({
                        minDate:jQuery('#biginDate').val()?jQuery('#biginDate').val():false
                    })
                },
            }));

            $("#beginTime").datetimepicker({
                datepicker:false,
                format:'H:i',
                step:10
            })
            $("#endTime").datetimepicker({
                datepicker:false,
                format:'H:i',
                step:10
            })

        });
    }
    $(function () {
        var ue = UE.getEditor('content');
        Service._queryDicts();
        _initForm();
        $("#test").ProvinceCity();
        _initDateTime();
    })
}(jQuery)
