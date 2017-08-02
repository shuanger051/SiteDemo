var WXActivityList = function (){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/wx_activity/list",
        page_size:10
    });

    var Service = {
        queryLessonStatusType:function () {
            Ajax.query("queryLessonStatusType",{
                url:"/sys_dict_item/list",
                data:{entryCode:"lessonStatus"},
                async:false,
                callback:function (result) {
                    var obj = {itemCode:"",itemName:"全部"};
                    result.data.unshift(obj);
                    $("#status").html(template("selected_temp",{list:result.data}));
                    $("#status").fancyspinbox();
                }
            })
        }
    }

    window.Manager = {
        add:function () {
            Tool.layer_full_screen({
                content: './add.htm',
                end:function () {
                    table.render();
                }})
        },
        del:function (id,name,e){
            Tool.layer_confirm("确认删除此项目信息?",function () {
                Ajax.submit("delEntry", {
                    url: "/wx_activity/del",
                    data: {id: id, "_method": "delete"},
                    type: "POST",
                    callback: function () {
                        Tool.layer_alert("删除成功!", function () {
                            table.render();
                        });
                    }
                })
            });
            e.stopPropagation();
        },
        reviewed:function(id,e){
            Tool.layer_full_screen({
                content:"./edit.htm?id="+ id,
                end:function (){
                    table.render();
                }
            });
            e.stopPropagation();
            return false;
        },
        unline:function (id,e) {
            Tool.layer_confirm("确认下线此项目?",function () {
                Ajax.submit("delEntry", {
                    url: "/wx_activity/unline",
                    data: {id: id},
                    type: "put",
                    callback: function () {
                        Tool.layer_alert("操作成功!", function () {
                            table.render();
                        });
                    }
                })
            });
            e.stopPropagation();
        }
    }

    function _initSearchForm() {
        $("#searchForm").Validform({
            tip:3,
            callback:function(form){
                var data = Tool.serializeJson(form);
                table.options(data,true);
                return false;
            }
        })
    }

    function _initInputEnterEvent() {
        $("#lessonId","#teacherName").bind('keypress',function(event){
            if(event.keyCode == "13"){
                $("#searchForm").submit();
            }
        });
    }

    $(function (){
        Service.queryLessonStatusType();
        table.render();
        _initInputEnterEvent();
        _initSearchForm();
    })
}()
