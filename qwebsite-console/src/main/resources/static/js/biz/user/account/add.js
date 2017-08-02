/**
 * Created by xuebj on 2017/3/20.
 */
var AccountAdd = function () {

    var encrypt = new JSEncrypt();
    Ajax.query("getKey",{
        url: "/crypto/public_key",
        async:true,
        callback:function (publicKey) {
            encrypt.setPublicKey(publicKey);
        }
    })


    var Service = {
        queryGender:function () {
            Ajax.query("queryGenderList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"gender"},
                callback:function (result) {
                    $("#genderCon").html(template("radio_temp",{list:result.data.reverse()}));
                }
            })
        },
        queryUserType:function () {
            Ajax.query("queryIsAdminList",{
            url:"/sys_dict_item/list",
            data:{entryCode:"isAdmin"},
            callback:function (result) {
                $("select[name='isAdmin']").html(template("selected_temp",{list:result.data}));
                $("select[name='isAdmin']").fancyspinbox();
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
            callback:function(form){
                var data = Tool.serializeJson(form);
                data.password = encrypt.encrypt(encodeURIComponent(data.password));
                Ajax.submit("saveEntry",{
                    url:"/user/save",
                    data:data,
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            // form[0].reset();
                        })
                    }
                })
                return false;
            }
        })
    }

    $(function () {
        Service.queryGender();
        Service.queryUserType();
        _initForm();
    })
}();