/**
 * Created by xuebj on 2017/3/20.
 */
var MemberListModel = function () {
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/sys_user_role/list_user",
        parameter:{roleId:Tool.getReqP("id")}
    });

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        addMember:function () {
            Tool.layer_show({
                title:"添加角色成员(" + Tool.getReqP("roleName") + ")",
                content:"./add_member.htm?roleId=" + Tool.getReqP("id"),
                end:function (){
                    table.render();
                }
            })
        },
        del:function (userId,roleId) {
            Tool.layer_confirm("是否移除该用户的角色?",function (){
                Ajax.submit("delMember",{
                    url:"/sys_user_role/remove",
                    data:{userId:userId,roleId:roleId,"_method":"delete"},
                    callback:function(result){
                        Tool.layer_alert("删除成功",function(){
                            table.render();
                        })
                    }
                })
            });
        }
    }

    $(function () {
        $(".formtitle1 span").text(Tool.getReqP("roleName") + "成员列表")
        table.render();
    })
}();