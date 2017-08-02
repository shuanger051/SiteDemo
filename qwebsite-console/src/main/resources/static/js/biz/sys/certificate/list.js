var CertificateModel = function ($){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/certificate/list",
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
            Tool.layer_confirm("确认删除?",function () {
                Ajax.submit("del",{
                    url:"/certificate/del",
                    data:{id:id,"_method":"delete"},
                    callback:function (){
                        Tool.layer_alert("删除成功!",function(){
                            table.render();
                        })
                    }
                })
            });
            e.stopPropagation();
            return false;
        }
    }

    $(function (){
        table.render();
    })
}(jQuery);
