/**
 * Created by xuebj on 2017/3/15.
 */
var RoleList = function (){

    var newCount=1;
    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='add node' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if (btn) btn.bind("click", function(){
            _showAddForm(treeNode);
            //var zTree = $.fn.zTree.getZTreeObj("tree");
            //zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
            return false;
        });

        if(!treeNode.isParent){ //非父节点
            var removeStr = "<span class='button remove' id='removeBtn_" + treeNode.tId
                + "' title='remove node' onfocus='this.blur();'></span>";
            sObj.after(removeStr);
            var removeBtn = $("#removeBtn_" + treeNode.tId);
            if(!!removeBtn) {
                removeBtn.bind("click", function () {
                    Tool.layer_confirm("确认删除权限[" + treeNode.name + "]?", function () {
                        Ajax.submit("del", {
                            url: "/sys_permission/del",
                            data: {id: treeNode.id, "_method": "delete"},
                            type: "POST",
                            async: false,
                            callback: function () {
                                Tool.layer_alert("删除成功", function () {
                                    var zTree = $.fn.zTree.getZTreeObj("tree");
                                    zTree.removeNode(treeNode);
                                });
                            }
                        })
                    })
                    return false;
                });
            }
        }
    };
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
        if($("#removeBtn_" + treeNode.tId).size() > 0){
            $("#removeBtn_" + treeNode.tId).unbind().remove();
        }
    };

    var ztree_setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false,
            addHoverDom:addHoverDom,
            removeHoverDom: removeHoverDom
        },
        edit:{
            // enable: true,
            showRenameBtn:false
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
        callback: {
            beforeClick: function (treeId, treeNode) {
                _showEditForm(treeNode);
            }
        }
    };

    var addParentNode = null;
    var editNode = null;
    var vform1=null;
    var vform2=null;

    function _showAddForm(treeNode){
        addParentNode = treeNode;
        var parent = {
            parentId:treeNode.id,
            parentName:treeNode.name
        }
        $("#editForm").hide();
        $("#addForm").show();
        Tool.set_form_data($("#form1"),parent);
    }

    function _showEditForm(treeNode){
        editNode = treeNode;
        vform2.resetForm();
        $("#addForm").hide();
        $("#editForm").show();
        var node = {
            id : treeNode.id,
            name :treeNode.name,
            uri:treeNode.uri,
            icon:treeNode.icon,
            isMenu:treeNode.isMenu
        }
        Tool.set_form_data($("#form2"),node);
    }

    function _listPer(){
        Ajax.query("listPers",{
            url:"/sys_permission/list",
            data:{page:1,pageSize:1000},
            type:"GET",
            callback:function (result){
                var data = result.data;
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if(zTree){
                    zTree.destroy();
                }
                var zNode = new Array();
                zNode.push({"name":"权限根","id":"-1","parentId":"-2",open:true});
                $.each(data,function (){
                    zNode.push(this);
                })
                var t = $("#tree");
                t = $.fn.zTree.init(t, ztree_setting,zNode);
            }
        })
    }

    function _initForm(){
        vform1= $("#form1").Validform({ //add form
            tiptype:3,
            callback:function(form){
                Ajax.submit("savePer",{
                    url:"/sys_permission/save",
                    data:form.serialize(),
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            if(addParentNode){
                                var zTree = $.fn.zTree.getZTreeObj("tree");
                                zTree.addNodes(addParentNode, $.extend(Tool.serializeJson(form),{id:result}));
                            }
                            vform1.resetForm();
                        })
                    }
                })
                return false;
            }
        });
        vform2 = $("#form2").Validform({ //edit form
            tiptype:3,
            callback:function(form){
                Ajax.submit("savePer",{
                    url:"/sys_permission/edit",
                    type:"PUT",
                    data:form.serialize(),
                    callback:function (result) {
                        Tool.layer_alert("保存成功",function(){
                            if(editNode){
                                editNode = $.extend(editNode,Tool.serializeJson(form));
                                var zTree = $.fn.zTree.getZTreeObj("tree");
                                zTree.updateNode(editNode);
                            }
                        })
                    }
                })
                return false;
            }
        });
    }
    $(function (){
        _listPer();
        _initForm();
    })
}()