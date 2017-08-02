var BrogrollList = function (){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/friendlink/list",
        page_size:5
    });

    window.BlogrollManager = {
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
        del:function (id,name,e) {
            Tool.layer_confirm("确认删除此友情链接?",function () {
                Ajax.submit("delEntry", {
                    url: "/friendlink/del",
                    data: {id: id,fileName:name, "_method": "delete"},
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
        selectThis:function (event,obj) {
            var currentTr = $(obj);
            currentTr.parent().find("tr").removeAttr("style");
            currentTr.css({background:"#62B593"});
        }
    }

    $(function (){
        table.render();
        $("#searchForm").Validform({
            tip:3,
            callback:function(form){
                table.options(Tool.serializeJson(form),true);
                return false;
            }
        });
    })
}()