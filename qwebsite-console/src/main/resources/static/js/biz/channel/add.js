/**
 * Created by xuebj on 2017/3/27.
 */
var ChannelAddModel = function ($) {


    function _initFormData(){
        var node = parent.Manager.getChannel();
        $(".placeul li:nth-child(2) a").text(node.name + "管理");
        $(".placeul li:nth-child(3) a").text("添加" + node.name);
        Tool.set_form_data($("#form1"),{
            parentId:node.id,
            parentName:node.name
        })
    }

    function _queryDict() {
        Ajax.query("queryDict",{
            url:"/sys_dict_item/list_by_entry_code",
            data:{entryCodes:"afterCheck,commentControl,allowUpdown,isDisplay"},
            callback:function (result) {
                $("#commentControlCon").html(template("radio_temp",{list:result["commentControl"]}));
                $("#allowUpdownCon").html(template("radio_temp",{list:result["allowUpdown"]}));
                $("#isDisplayCon").html(template("radio_temp",{list:result["isDisplay"]}));
                $("select[name='afterCheck']").html(template("selected_temp",{list:result["afterCheck"]}));
                $("select[name='afterCheck']").fancyspinbox();
            }
        })
    }

    function _initForm() {
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                var data = Tool.serializeJson(form);
                Ajax.submit("saveChannel",{
                    url:"/channel/save",
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