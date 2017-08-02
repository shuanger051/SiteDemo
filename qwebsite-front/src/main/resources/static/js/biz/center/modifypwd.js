/**
 * Created by xuebj on 2017/4/20.
 */
var ModifyModel = function ($){
    function _initForm(){
        $("#modifyPwdForm").Validform({
            "tiptype":function (msg,o,cssctl){
                if(o.type == 3){
                    o.obj.siblings(".text_error").html('<img src="' + path + '/images/icon/error_s.png" alt="error">' + msg + '</div>');
                }else if(o.type == 2){
                    o.obj.siblings(".text_error").html("");
                }
            },
            usePlugin:{
                passwordstrength:{
                    minLen:6,
                    maxLen:18
                }
            },
            callback:function (form){
                var param = Tool.serializeJson(form);
                Ajax.submit("modify_pwd",{
                    url:"/account/modify_pwd",
                    data:{"old_passwd": window.encrypt.encrypt(encodeURIComponent(param.old_passwd)),"new_passwd":window.encrypt.encrypt(encodeURIComponent(param.new_passwd))},
                    callback:function () {
                        Tool.layer_alert("修改成功")
                    }
                })
                return false;
            }
        })
    }
    $(function () {
        _initForm();
    })
}(jQuery)