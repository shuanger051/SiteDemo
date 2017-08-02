var CredentialsEdit = function (){
    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/credential/get",
                data:{id:id},
                callback:function (result) {
                    Tool.set_form_data($("#form1"),result);
                }
            })
        },
        queryTrainerType:function () {
            Ajax.query("queryTrainerType",{
                url:"/sys_dict_item/list",
                data:{entryCode:"trainerType"},
                async:false,
                callback:function (result) {
                    $("select[name='trainerType']").html(template("selected_temp",{list:result.data}));
                    $("select[name='trainerType']").fancyspinbox();
                }
            })
        },
        queryCredentialType:function () {
            Ajax.query("queryCredentialType",{
                url:"/sys_dict_item/list",
                data:{entryCode:"credentialType"},
                async:false,
                callback:function (result) {
                    $("select[name='credentialsType']").html(template("selected_temp",{list:result.data}));
                    $("select[name='credentialsType']").fancyspinbox();
                }
            })
        },
        queryCredentialLevel:function () {
            Ajax.query("queryCredentialLevel",{
                url:"/sys_dict_item/list",
                data:{entryCode:"credentialLevel"},
                async:false,
                callback:function (result) {
                    $("select[name='credentialsLevel']").html(template("selected_temp",{list:result.data}));
                    $("select[name='credentialsLevel']").fancyspinbox();
                }
            })
        }
    }

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/credential/edit',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在提交");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("修改成功");
                    },  //处理完成
                    resetForm:false,
                    type:'post',
                    dataType:'json'
                };
                $("#form1").ajaxSubmit(options);
                return false;
            }
        });
    }

    $(function () {
        Service.queryTrainerType();
        Service.queryCredentialType();
        Service.queryCredentialLevel();
        Service.get(Tool.getReqP("id"));
        _initForm();
    })

}();