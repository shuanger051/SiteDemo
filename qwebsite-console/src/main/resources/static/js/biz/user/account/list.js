/**
 * Created by xuebj on 2017/3/17.
 */
var AccountList = function () {
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/user/list"
    });

    function _listUsers(){
        table.render();
    }


    window.Manager = {
        add:function (){
            Tool.layer_full_screen({
                content:"./add.htm",
                end:function (){
                    table.render();
                }
            })
        },
        edit:function (id,event) {
            Tool.layer_full_screen({
                content:"./edit.htm?id=" + id,
                end:function (){
                    table.render();
                }
            })
            event.stopPropagation();
            return false;
        }
        // del:function (id,event) {
        //     Tool.layer_confirm("删除用户需谨慎，确认删除?",function (){
        //        Ajax.submit("delRole",{
        //            url: "/user/del",
        //            data:{id:id,"_method":"DELETE"},
        //            callback:function () {
        //                Tool.layer_alert("删除成功",function(){
        //                    table.render();
        //                })
        //            }
        //        })
        //     });
        // }
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
    
    $(function () {
        _listUsers();
        _initSearchForm();
    })
}();
