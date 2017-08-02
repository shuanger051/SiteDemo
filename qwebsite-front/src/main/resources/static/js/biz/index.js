/**
 * Created by xuebj on 2017/4/10.
 */
var IndexModel = function($){
    window.encrypt = new JSEncrypt();
    Ajax.query("getKey",{
        url: "/crypto/public_key",
        async:true,
        callback:function (publicKey) {
            encrypt.setPublicKey(publicKey);
        },
        failure:function (data){
            console.info("获取数据超时");
        }
    })
    function _initEvent() {
        $("#form1").Validform({
            tipSweep:true,
            tiptype:function (msg,o,cssctl){
                if(o.type == 3){
                    Tool.layer_alert(msg);
                }
            },
            beforeSubmit:function(form){
                Ajax.submit("login",{
                    url:"/account/login",
                    data:{password:encrypt.encrypt(encodeURIComponent($("#password").val())),account:$("#account").val()},
                    callback:function (result){
                        window.location.reload();
                    }
                })
                return false;
            }
        });
        $("#form2").Validform({
            tip:3,
            beforeSubmit:function(form){
                Ajax.submit("regist",{
                    url:"/account/regist",
                    data:{password:encrypt.encrypt(encodeURIComponent(form.find("input[name='password']").val())),account:form.find("input[name='account']").val()},
                    callback:function (result){
                        // window.location.reload();
                    }
                })
                return false;
            }
        });
        // $("#vimg").click(function (){
        //     $("#vimg").attr("src","./jcaptcha.jpeg?_="+new Date().getMilliseconds());
        // })
    }
    
    $(function () {
        _initEvent();
    })
}(jQuery);