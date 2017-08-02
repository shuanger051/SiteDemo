/**
 * Created by xuebj on 2017/3/24.
 */

var MemberList = function () {
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/sys_user_role/search_user",
        page_size:5
    });

    var roleId = Tool.getReqP("roleId");
    function _listUsers(){
        table.render();
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

    window.Manager = {
        add:function (userId) {
            Ajax.submit("addUserRole",{
                url:"/sys_user_role/save",
                data:{userId:userId,roleId:roleId},
                callback:function (result) {
                    Tool.layer_alert("添加用户成功",function (){
                        table.render();
                    })
                }
            })
        }
    }

    $(function () {
        _listUsers();
        _initSearchForm();
    })
}();
