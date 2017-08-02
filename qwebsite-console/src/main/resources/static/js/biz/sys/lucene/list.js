var LuceneList = function (){

    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/lucene/queryIndex",
        page_size:10
    });

    window.Manager = {
        createIndex:function () {
            Tool.layer_confirm("更新全站搜索索引?",function () {
                Ajax.submit("delEntry", {
                    url: "/lucene/create",
                    type: "GET",
                    callback: function (result) {
                        if(result == "success"){
                            Tool.layer_alert("更新成功!", function () {
                                table.render();
                            });
                        }else{
                            Tool.layer_alert("更新失败!", function () {
                                table.render();
                            });
                        }

                    }
                })
            });
        },
        delIndex:function (id,name,e){
            Tool.layer_confirm("确认删除全站搜索索引?",function () {
                Ajax.submit("delEntry", {
                    url: "/lucene/delIndex",
                    data: {"_method": "delete"},
                    type: "POST",
                    callback: function (reslut) {
                        if(reslut == "success"){
                            Tool.layer_alert("删除成功!", function () {
                                table.render();
                            });
                        }else{
                            Tool.layer_alert("删除失败!", function () {
                                table.render();
                            });
                        }
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
        $("#queryString").bind('keypress',function(event){
            if(event.keyCode == "13"){
                $("#searchForm").submit();
            }
        });
    }


    $(function (){
        table.render();
        _initSearchForm();
        _initInputEnterEvent();
    })

}()
