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
                async:false,
                callback:function (result) {
                    $("#genderCon").html(template("radio_temp",{list:result.data.reverse()}));
                }
            })
        },
        queryIsDisable:function () {
            Ajax.query("queryIsDisableList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isDisabled"},
                async:false,
                callback:function (result) {
                    $("#isDisabledCon").html(template("radio_temp",{list:result.data.reverse()}));
                }
            })
        },
        queryUserType:function () {
            Ajax.query("queryIsAdminList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isAdmin"},
                async:false,
                callback:function (result) {
                    $("select[name='isAdmin']").html(template("selected_temp",{list:result.data}));
                }
            })
        },
        queryUser:function (id){
            Ajax.query("getBaseInfo",{
                url:"/user/get",
                data:{id:id},
                callback:function (result) {
                    result.registerTime = Tool.dateFormat(result.registerTime);
                    result.lastLoginTime = Tool.dateFormat(result.lastLoginTime);
                    Tool.set_form_data($("#form1"),result);
                    Ajax.query("getExtInfo",{
                        url:"/user/ext/get",
                        data:{id:id},
                        callback:function (result) {
                            delete result.id;
                            if(result.birthday){
                                result.birthday = Tool.dateFormat(result.birthday,"yyyy-MM-dd");
                            }
                            Tool.set_form_data($("#form1"),result);
                            $("select[name='isAdmin']").fancyspinbox();
                        }
                    })
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
                if(!!data.password){
                    data.password = encrypt.encrypt(encodeURIComponent(data.password));
                }
                Ajax.submit("saveAccount",{
                    url:"/user/edit",
                    data:data,
                    type:"PUT",
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            Manager.close();
                        })
                    }
                })
                return false;
            }
        })
    }

    $(function () {
        _initForm();
        Service.queryGender();
        Service.queryUserType();
        Service.queryIsDisable();
        Service.queryUser(Tool.getReqP("id"));
    })
}();