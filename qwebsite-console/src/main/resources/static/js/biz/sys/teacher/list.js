/**
 * Created by xuebj on 2017/4/6.
 */
var TeacherModel = function ($){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/teacher/list",
        pageSize:5
    });

    window.Manager = {
        add:function () {
            Tool.layer_full_screen({
                content:"./add.htm",
                end:function (){
                    table.render();
                }
            });
            return false;
        },
        edit:function (id,e){
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
            Tool.layer_confirm("确认删除此名师?",function () {
                Ajax.submit("delTeacher", {
                    url: "/teacher/del",
                    data: {id: id, _method: "delete"},
                    type: "POST",
                    callback: function (result) {
                        Tool.layer_alert("删除成功!", function () {
                            table.render();
                        });
                    }
                })
            });
            e.stopPropagation();
            return false;
        },
        exportExcel:function () {
            var data = Tool.serialze($("#searchForm"));
            window.location.href = "/teacher/export?" + data;
        }
    }

    function initForm(){
        $("#searchForm").Validform({
            tip:3,
            callback:function(form){
                var data = Tool.serializeJson(form);
                table.options(data,true);
                return false;
            }
        })
    }

    var Services = {
        queryEnabledFlagType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list_by_entry_code",
                data:{entryCodes:"teacherType,teacherLevel"},
                callback:function (result) {
                    var data = result["teacherType"];
                    data.unshift({itemName:"全部",entryCode:""});
                    $("select[name='type']").html(template("selected_temp",{list:data})).fancyspinbox();
                    var levleData = result["teacherLevel"];
                    levleData.unshift({itemName:"全部",entryCode:""});
                    $("select[name='level']").html(template("selected_temp",{list:levleData})).fancyspinbox();
                }
            })
        }
    }

    $(function () {
        table.render();
        Services.queryEnabledFlagType();
        initForm();
    })
}(jQuery);