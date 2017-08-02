var ActivityList = function (){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/activity_square/queryList",
        page_size:10
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

            var flag = false;

            Ajax.submit("delEntry", {
                url: "/activity_square_apply/queryList",
                data: {contentId: id},
                type: "GET",
                async : false,
                callback: function (result) {
                    if(result.data.length != 0){
                        flag = true;
                    }
                }
            });

            if (!flag){
                Tool.layer_confirm("确认删除此条数据?",function () {
                    Ajax.submit("delEntry", {
                        url: "/activity_square/del",
                        data: {id: id, "_method": "delete"},
                        type: "POST",
                        callback: function () {
                            Tool.layer_alert("删除成功", function () {
                                table.render();
                            });
                        }
                    })
                });
            }else{
                Tool.layer_alert("当前活动已有报名人员，不可删除", function () {
                    return false;
                });
            }

            e.stopPropagation();
        },
        selectThis:function (event,obj) {
            var currentTr = $(obj);
            currentTr.parent().find("tr").removeAttr("style");
            currentTr.css({background:"#62B593"});
        }
    }


    function _initInputEnterEvent() {
        $("#title").bind('keypress',function(event){
            if(event.keyCode == "13"){
                $("#searchForm").submit();
            }
        });
    }

    function _initSearchForm() {
        $("#searchForm").Validform({
            tip:3,
            callback:function(form){
                table.options(Tool.serializeJson(form),true);
                return false;
            }
        });
    }


    $(function (){
        table.render();
        _initSearchForm();
        _initInputEnterEvent();
    })
}()