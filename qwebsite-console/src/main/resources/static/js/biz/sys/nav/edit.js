/**
 * Created by xuebj on 2017/3/20.
 */
var NavEditModel = function () {

    var Service = {
        _queryDict:function() {
            Ajax.query("queryDict", {
                url: "/sys_dict_item/list_by_entry_code",
                data: {entryCodes: "isExpand,isDisplay"},
                async:false,
                callback: function (result) {
                    $("#isExpandCon").html(template("radio_temp",{list:result["isExpand"]}));
                    $("#isDisplayCon").html(template("radio_temp",{list:result["isDisplay"]}));

                }
            })
        },
        _getNav:function (id){
            Ajax.query("getChannel",{
                url:"/navigation/get",
                data:{id:id},
                callback:function (result) {
                    Tool.set_form_data($("#form1"),result);
                }
            })
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                var data = Tool.serializeJson(form);
                if(!data.isBlank){
                    data.isBlank = 0;
                }
                Ajax.submit("updateNav",{
                    url:"/navigation/edit",
                    data:data,
                    type:"PUT",
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            parent.Manager.updateNode(data);
                            Tool.go_back();
                        })
                    }
                })
                return false;
            }
        })
    }

    $(function () {
        _initForm();
        Service._queryDict();
        Service._getNav(Tool.getReqP("id"));
    })
}();