/**
 * Created by xuebj on 2017/3/13.
 */
var LoginMod = function (){
    window.encrypt = new JSEncrypt();
    Ajax.query("getKey",{
        url: "/crypto/public_key",
        async:true,
        callback:function (publicKey) {
            encrypt.setPublicKey(publicKey);
        }
    })

    $(function () {
        $("#form1").Validform({
            tiptype: function (msg, o, css) {
                if (o.type == 3) {
                    Tool.layer_alert(msg);
                } else if (o.type == 2) {

                }
            },
            beforeSubmit:function(form){
                $("#password").val(encrypt.encrypt(encodeURIComponent($("#password").val())));
                return true;
            }
        });
        $("#vimg").click(function (){
            $("#vimg").attr("src","./jcaptcha.jpeg?_="+new Date().getMilliseconds());
        })
    })

}();