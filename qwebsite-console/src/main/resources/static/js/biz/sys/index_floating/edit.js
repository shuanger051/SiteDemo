var IndexFloatingEdit = function (){
    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/index_floating/get",
                data:{id:id},
                callback:function (result) {
                    result.logo = viewPath + result.logo;
                    Tool.set_form_data($("#form1"),result);
                    $("select[name='floatingPosition']").fancyspinbox();
                    $("select[name='isEnabled']").fancyspinbox();
                }
            })
        },
        queryEnabledFlagType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isShow"},
                async:false,
                callback:function (result) {
                    $("select[name='isEnabled']").html(template("selected_temp",{list:result.data}));
                }
            })
        },
        queryFloatingType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"floatingPosition"},
                async:false,
                callback:function (result) {
                    $("select[name='floatingPosition']").html(template("selected_temp",{list:result.data}));
                }
            })
        }
    }

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        selectChange:function(val){

            var checkSelectTagFlag = false;
            if("undefined" != val && "" != val && "3" == val ){
                checkSelectTagFlag = true;
            }
            if(!checkSelectTagFlag){
                Ajax.query("getData",{
                    url:"/index_floating/list",
                    data:{floatingPosition:val},
                    callback:function (result) {
                        if(null != result && result.data.length >= 1){
                            Tool.layer_alert("当前浮窗位置已存在内容");
                            return false;
                        }else{
                            return true;
                        }
                    }
                })
            }else{
                return true;
            }
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/index_floating/edit',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在上传");
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
    $(function () {
        Service.queryEnabledFlagType();
        Service.queryFloatingType();
        _initForm();
        Service.get(Tool.getReqP("id"));
    })
}();