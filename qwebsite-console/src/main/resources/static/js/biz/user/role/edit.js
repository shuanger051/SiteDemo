/**
 * Created by xuebj on 2017/3/15.
 */
var RoleAdd = function (){

    var ztree_setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
        },
        data: {
            key: {
                name: "name",
                url: "http",
                icon: "icon_p"
            },
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: ""
            }
        },
        check: {
            enable: true,
            autoCheckTrigger: false,
            chkboxType: { "Y" : "ps", "N" : "s" }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                var ztreeObj = $.fn.zTree.getZTreeObj("treeDemo");
                treeNode.checked = !treeNode.checked;
                ztreeObj.updateNode(treeNode,true);
            }
        }
    };


    function _initForm(){
        var perIds ;
        $("#form1").Validform({
            tiptype:3,
            beforeSubmit:function (form) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                var obj = zTree.getCheckedNodes();
                var ids = new Array();
                $.each(obj,function (){
                    if(this.id > 0){
                        ids.push(this.id);
                    }
                });
                var isSuper = form.find("input[name='isSuper']:checked").val();
                if(isSuper == "0" && ids.length == 0){
                    Tool.layer_alert("请至少选择一个权限");
                    return false;
                }
                perIds = ids;
            },
            callback:function(form){
                Ajax.submit("editRole",{
                    url:"/sys_role/edit",
                    type:"PUT",
                    data:$.extend(Tool.serializeJson(form),{"pers":perIds.join(",")}),
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            Manager.close();
                        })
                    }
                })
                return false;
            }
        });
    }

    var Services = {
        queryPers:function (roleId){
            Ajax.query("listPers",{
                url:"/sys_permission/list",
                data:{pageSize:10000,page:1},
                callback:function (pers){
                    Ajax.query("getRolePers",{
                        url:"/sys_role_permission/list",
                        data:{pageSize:10000,page:1,roleId:roleId},
                        callback:function (result) {
                            var zNode = new Array();
                            zNode.push({"name":"全部","id":"-1","parentId":"-2",open:true,nocheck:false});
                            $.each(pers.data,function (index,object){
                                $.each(result.data,function (){
                                    if(object.id == this.permissionId){
                                        object.checked = true;
                                        object.open = true;
                                    }
                                })
                                zNode.push(object);
                            });
                            var t = $("#tree");
                            t = $.fn.zTree.init(t, ztree_setting,zNode);
                        }
                    })
                }
            });
        },
        getRole:function (id){
            Ajax.query("getRole",{
                url:"/sys_role/get",
                data:{id:id},
                callback:function (result) {
                    Tool.set_form_data($("#form1"),result);
                }
            })
        }
    }

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        }
    }


    var roleId = Tool.getReqP("id");
    $(function () {
        _initForm();
        Services.getRole(roleId);
        Services.queryPers(roleId);

    })
}();