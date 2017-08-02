/**
 * Created by xuebj on 2017/3/17.
 */
var RoleList = function () {
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/sys_role/list"
    });

    function _listRoles(){
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
        },
        memberManager:function(id,roleName){
            Tool.layer_full_screen({
                content:"./member_list.htm?id=" + id + "&roleName=" + roleName
            })
            event.stopPropagation();
            return false;
        },
        del:function (id,event) {
            Tool.layer_confirm("删除角色需谨慎，确认删除?",function (){
               Ajax.submit("delRole",{
                   url: "/sys_role/del",
                   data:{id:id,"_method":"DELETE"},
                   callback:function () {
                       Tool.layer_alert("删除成功",function(){
                           table.render();
                       })
                   }
               })
            });
            event.stopPropagation();
            return false;
        }
    }
    
    $(function () {
        _listRoles();
    })
}();
