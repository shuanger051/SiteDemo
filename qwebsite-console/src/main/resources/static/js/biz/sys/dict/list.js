/**
 * Created by xuebj on 2017/3/15.
 */
var DictList = function (){
    var table = new $.Table();
    var itemTable = new $.Table();
    var dict = {}
    table.init({
        tId:"table",
        url:"/sys_dict_entry/list",
        page_size:5
    });

    itemTable.init({
        tId:"item",
        url:"/sys_dict_item/list",
        page_size:5
    });

    window.Manager = {
        add:function (){
            Tool.layer_full_screen({
                content:"./add.htm",
                end:function (){
                    table.render();
                }})
        },
        edit:function (id,e) {
            Tool.layer_full_screen({
                content:"./edit.htm?id="+ id,
                end:function (){
                    table.render();
                }
            });
            e.stopPropagation();
            return false;
        },
        del:function (id,e) {
            Tool.layer_confirm("确认删除字典项?",function () {
                Ajax.submit("delEntry", {
                    url: "/sys_dict_entry/del",
                    data: {id: id, "_method": "delete"},
                    type: "POST",
                    callback: function () {
                        Tool.layer_alert("删除成功", function () {
                            table.render();
                        });

                    }
                })
            });
            e.stopPropagation();
        },
        showItem:function (entryCode,entryName,event,obj) {
            var currentTr = $(obj);
            currentTr.parent().find("tr").removeAttr("style");
            currentTr.css({background:"#62B593"});
            if($("#itemAddBut").is(":hidden")){
                $("#itemAddBut").show();
            }
            dict["entryCode"] = entryCode;
            dict["entryName"] = entryName;
            $("#itemTitle label").text(entryCode + ":" + entryName);
            itemTable.options({entryCode:entryCode},true);
        },
        addItem:function (){
            if( dict["entryName"]){
                Tool.layer_full_screen({
                    content:"./add_item.htm",
                    end:function () {
                        itemTable.render();
                    }
                })
            }else {
                Tool.layer_alert("请先选择一个字典");
            }
        },
        editItem:function (id,e) {
            Tool.layer_full_screen({
                content:"./edit_item.htm?id="+ id,
                end:function (){
                    itemTable.render();
                }
            });
            e.stopPropagation();
            return false;
        },
        delItem:function (id,e) {
            Tool.layer_confirm("确认删除字典条目?",function (){
                Ajax.submit("delItem",{
                    url:"/sys_dict_item/del",
                    data:{id:id,"_method":"delete"},
                    type:"POST",
                    callback:function (){
                        Tool.layer_alert("删除成功",function(){
                            itemTable.render();
                        });

                    }
                })
            })
            e.stopPropagation();
            return false;
        },
        getEntry:function () {
            return {
                entryCode:dict["entryCode"],
                entryName: dict["entryName"]
            }
        }
    }

    $(function (){
        table.render();
        // itemTable.render();
        $("#searchForm").Validform({
            tip:3,
            callback:function(form){
                table.options(Tool.serializeJson(form),true);
                return false;
            }
        });
    })
}()