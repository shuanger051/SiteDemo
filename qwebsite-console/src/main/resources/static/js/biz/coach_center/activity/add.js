var WXActivityAdd = function (){

    var Service = {

        queryActivityKindType:function () {
            Ajax.query("queryKindList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"activityKind"},
                async:false,
                callback:function (result) {
                    $("select[name='activityKind']").html(template("selected_temp",{list:result.data}));
                    $("select[name='activityKind']").fancyspinbox();
                }
            })
        },
        queryCardType:function () {
            Ajax.query("queryTypeList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"cardType"},
                async:false,
                callback:function (result) {
                    $("select[name='activityType']").html(template("selected_temp",{list:result.data}));
                    $("select[name='activityType']").fancyspinbox();
                }
            })
        },
        queryActivityType:function () {
            Ajax.query("queryTypeList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"activityType"},
                async:false,
                callback:function (result) {
                    $("select[name='activityType']").html(template("selected_temp",{list:result.data}));
                    $("select[name='activityType']").fancyspinbox();
                }
            })
        },
        queryShowFlag:function () {
            Ajax.query("queryFlagList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isDisplay"},
                async:false,
                callback:function (result) {
                    $("select[name='appShowFlag']").html(template("selected_temp",{list:result.data}));
                    $("select[name='appShowFlag']").fancyspinbox();
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
        activityTypeChange:function (obj) {
            var val = obj.options[obj.selectedIndex].value;
            if(val == 1){
                Ajax.query("queryKindList",{
                    url:"/sys_dict_item/list",
                    data:{entryCode:"cardType"},
                    async:false,
                    callback:function (result) {
                        $("div[name=activityType]").remove();
                        $("select[name='activityType']").show();
                        $("select[name='activityType']").html(template("selected_temp",{list:result.data}));
                        $("select[name='activityType']").fancyspinbox();
                    }
                })
            }else{
                Ajax.query("queryTypeList",{
                    url:"/sys_dict_item/list",
                    data:{entryCode:"activityType"},
                    async:false,
                    callback:function (result) {
                        $("div[name=activityType]").remove();
                        $("select[name='activityType']").show();
                        $("select[name='activityType']").html(template("selected_temp",{list:result.data}));
                        $("select[name='activityType']").fancyspinbox();
                    }
                })
            }
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/wx_activity/save',
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
        Service.queryActivityKindType();
        Service.queryCardType();
        Service.queryShowFlag();
        geoSetup();
        _initForm();
    });

}();