/**
 * Created by xuebj on 2017/3/27.
 */
var NavAddModel = function ($) {


    function _initFormData(){
        var node = parent.Manager.getChannel();
        Tool.set_form_data($("#form1"),{
            parentId:node.id,
            parentName:node.name
        })
    }

    function _queryDict() {
        Ajax.query("queryDict",{
            url:"/sys_dict_item/list_by_entry_code",
            data:{entryCodes:"isExpand,isDisplay"},
            callback:function (result) {
                $("#isExpandCon").html(template("radio_temp",{list:result["isExpand"]}));
                $("#isDisplayCon").html(template("radio_temp",{list:result["isDisplay"]}));
            }
        })
    }

    function _initForm() {
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                var data = Tool.serializeJson(form);
                if(!data.isBlank){
                    data.isBlank = 0;
                }
                Ajax.submit("saveNav",{
                    url:"/navigation/save",
                    data:data,
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            parent.Manager.addNode($.extend(data,{id:result}));
                            Tool.go_back();
                        })
                    }
                })
                return false;
            }
        })
    }

    $(function () {
        _initFormData();
        _queryDict();
        _initForm();
    })



}(jQuery)