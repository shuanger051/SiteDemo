/**
 * Created by xuebj on 2017/3/15.
 */
var DictAdd = function (){

    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/sys_dict_item/get",
                data:{id:id},
                callback:function (result) {
                    var entry = parent.Manager.getEntry();
                    result["entryName"] = entry["entryName"];
                    Tool.set_form_data($("#form1"),result);
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
                Ajax.submit("editItem",{
                    url:"/sys_dict_item/edit",
                    type:"PUT",
                    data:form.serialize(),
                    callback:function (result) {
                        Tool.layer_alert("保存成功");
                    }
                })
                return false;
            }
        });
    }
    $(function () {
        _initForm();
        Service.get(Tool.getReqP("id"));
    })
}();