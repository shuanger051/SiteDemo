/**
 * Created by xuebj on 2017/3/20.
 */
var ChannelModel = function () {

    var Service = {
        _queryDict:function() {
            Ajax.query("queryDict", {
                url: "/sys_dict_item/list_by_entry_code",
                data: {entryCodes: "afterCheck,commentControl,allowUpdown,isDisplay"},
                async:false,
                callback: function (result) {
                    $("#commentControlCon").html(template("radio_temp", {list: result["commentControl"]}));
                    $("#allowUpdownCon").html(template("radio_temp", {list: result["allowUpdown"]}));
                    $("#isDisplayCon").html(template("radio_temp", {list: result["isDisplay"]}));
                    $("select[name='afterCheck']").html(template("selected_temp", {list: result["afterCheck"]}));

                }
            })
        },
        _getChannel:function (id){
            Ajax.query("getChannel",{
                url:"/channel/get",
                data:{id:id},
                callback:function (result) {
                    result.allowUpdown = result.allowUpdown ? 1:0;
                    Tool.set_form_data($("#form1"),result);
                    $(".placeul li:nth-child(2) a").text(result.name + "管理");
                    $(".placeul li:nth-child(3) a").text("编辑" + result.name);
                    $("select[name='afterCheck']").fancyspinbox();
                }
            })
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                // var data = Tool.serializeJson(form);
                Ajax.submit("updateChannel",{
                    url:"/channel/edit",
                    data:form.serializeArray(),
                    type:"PUT",
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            parent.Manager.updateNode(Tool.serializeJson(form));
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
        Service._getChannel(Tool.getReqP("id"));
    })
}();