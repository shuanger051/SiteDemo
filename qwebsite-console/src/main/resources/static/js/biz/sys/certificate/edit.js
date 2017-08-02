var CertificateEditModel = function ($){
    var id = Tool.getReqP("id");
    var Services = {
        queryEnabledFlagType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list_by_entry_code",
                data:{entryCodes:"isShow,credentialType"},
                async:false,
                callback:function (result) {
                    $("select[name='isEnabled']").html(template("selected_temp",{list:result["isShow"]}));
                    $("select[name='type']").html(template("selected_temp",{list:result["credentialType"]}));

                }
            })
        },
        getById: function (id){
            Ajax.query("get",{
                url:"/certificate/get",
                data:{id:id},
                callback:function (result){
                    result.releaseDate = Tool.dateFormat(result.releaseDate);
                    result.img = viewPath + result.img;
                    Tool.set_form_data($("#form1"),result);
                    $("select[name='isEnabled']").fancyspinbox();
                    $("select[name='type']").fancyspinbox();
                }
            })
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/certificate/edit',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在上传");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("保存成功",function () {
                            Tool.go_back();
                        });
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
        Services.queryEnabledFlagType();
        Services.getById(id);
        _initForm();
    })

}(jQuery);
