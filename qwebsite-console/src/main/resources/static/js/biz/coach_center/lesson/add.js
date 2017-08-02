var LessonAdd = function (){

    var Service = {

        queryLessonKindType:function () {
            Ajax.query("queryGenderList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"lessonKind"},
                async:false,
                callback:function (result) {
                    $("select[name='lessonKind']").html(template("selected_temp",{list:result.data}));
                    $("select[name='lessonKind']").fancyspinbox();
                }
            })
        },
        queryLessonType:function () {
            Ajax.query("queryGenderList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"lessonType"},
                async:false,
                callback:function (result) {
                    $("select[name='lessonType']").html(template("selected_temp",{list:result.data}));
                    $("select[name='lessonType']").fancyspinbox();
                }
            })
        },
        queryShowFlag:function () {
            Ajax.query("queryGenderList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isDisplay"},
                async:false,
                callback:function (result) {
                    $("select[name='appShowFlag']").html(template("selected_temp",{list:result.data}));
                    $("select[name='appShowFlag']").fancyspinbox();
                    $("select[name='appointmentFlag']").html(template("selected_temp",{list:result.data}));
                    $("select[name='appointmentFlag']").fancyspinbox();
                }
            })
        }
    }

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        flagChange:function (obj) {
            var val = obj.options[obj.selectedIndex].value;
            if(val == 1){
                $("#appointmentDays-li").show();
            }else{
                $("#appointmentDays-li").hide();
            }
        },
        lessonTypeChange:function (obj) {
            var val = obj.options[obj.selectedIndex].value;
            if(val == 2){
                $("#person_no-li").show();
            }else{
                $("#person_no-li").hide();
            }
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/less/save',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在提交");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("保存成功");
                    },  //处理完成
                    resetForm:false,
                    type:'POST',
                    dataType:'json'
                };

                $("#form1").ajaxSubmit(options);
                return false;
            }
        });
    }



    $(function(){
        Service.queryLessonKindType();
        Service.queryLessonType();
        Service.queryShowFlag();
        geoSetup();
        _initForm();
    });

}();