/**
 * Created by xuebj on 2017/4/20.
 */
var RestModel = function ($){

    var vForm;

    function _initSendBtn(){
        $("#getCodeBtn").click(function (e){
            codeEvent(e);

        })
    }
    function codeEvent (e){
        e.stopPropagation();
        e.preventDefault();
        var that = $(e.currentTarget);
        if(vForm.check(false,"input[name='mobile']")){
            that.unbind();
            Ajax.submit("getPhoneCode",{
                url:"/account/send_code",
                data: {"login_id": $("input[name='mobile']").val()},
                callback:function (res){
                    Tool.layer_alert("发送成功",function (){
                        $("#pwdPanel").show();
                        that.val("120秒后重发");
                        var time = 119;
                        window.i = window.clearInterval(window.i) ||  window.setInterval(function (){
                                that.val(time-- + "秒后重发");
                                if(time == 0){
                                    window.clearInterval(window.i);
                                    that.unbind().click(function (e){
                                        codeEvent(e);
                                    })
                                    that.val("获取验证码");
                                }
                            },1000);
                    })
                },failure:function (data){
                    Tool.layer_alert(data.message, function (){
                        that.val("120秒后重发");
                        var time = 119;
                        window.i = window.clearInterval(window.i) ||  window.setInterval(function (){
                                that.val(time-- + "秒后重发");
                                if(time == 0){
                                    window.clearInterval(window.i);
                                    that.unbind().click(function (e){
                                        codeEvent(e);
                                    })
                                    that.val("获取验证码");
                                }
                            },1000);
                    }, {icon: 5});
                }
            })
        }
    }

    function _initForm(){
        vForm = $("#pwdFrom").Validform({
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
                delete param["confirmPasswd"];
                param.new_passwd = window.encrypt.encrypt(encodeURIComponent(param.new_passwd));
                Ajax.submit("reset_pwd",{
                    url:"/account/reset",
                    data:param,
                    callback:function () {
                        Tool.layer_alert("密码重置成功",function (){
                            location.href = "../index.htm";
                        })
                    }
                })
                return false;
            }
        })
    }
    $(function () {
        _initForm();
        _initSendBtn();
    })
}(jQuery)