/**
 * Created by xuebj on 2017/3/15.
 */
var ChannelList = function (){
    var table = new $.Table();

    table.init({
        tId:"table",
        url:"/channel/list",
        parameter:{parentId:-1}
    });


    // function addHoverDom(treeId, treeNode) {
    //     var sObj = $("#" + treeNode.tId + "_span");
    //     if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
    //     var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
    //         + "' title='add node' onfocus='this.blur();'></span>";
    //     sObj.after(addStr);
    //     var btn = $("#addBtn_"+treeNode.tId);
        //     if (btn) btn.bind("click", function(){
        //         _showAddForm(treeNode);
        //         //var zTree = $.fn.zTree.getZTreeObj("tree");
        //         //zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
        //         return false;
        //     });
        //
        //     if(!treeNode.isParent){ //非父节点
        //         var removeStr = "<span class='button remove' id='removeBtn_" + treeNode.tId
        //             + "' title='remove node' onfocus='this.blur();'></span>";
        //         sObj.after(removeStr);
        //         var removeBtn = $("#removeBtn_" + treeNode.tId);
        //         if(!!removeBtn) {
        //             removeBtn.bind("click", function () {
        //                 Tool.layer_confirm("确认删除权限[" + treeNode.name + "]?", function () {
        //                     Ajax.submit("del", {
        //                         url: "/sys_permission/del",
        //                         data: {id: treeNode.id, "_method": "delete"},
        //                         type: "POST",
        //                         async: false,
        //                         callback: function () {
        //                             Tool.layer_alert("删除成功", function () {
        //                                 var zTree = $.fn.zTree.getZTreeObj("tree");
        //                                 zTree.removeNode(treeNode);
        //                             });
        //                         }
        //                     })
        //                 })
        //                 return false;
        //             });
        //         }
        //     }
        // };
        // function removeHoverDom(treeId, treeNode) {
        //     $("#addBtn_"+treeNode.tId).unbind().remove();
        //     if($("#removeBtn_" + treeNode.tId).size() > 0){
        //         $("#removeBtn_" + treeNode.tId).unbind().remove();
        //     }
        // };

    var ztree_setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false,
            // addHoverDom:addHoverDom,
            // removeHoverDom: removeHoverDom
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
                _showChannelsList(treeNode);
            }
        }
    };

    function _showChannelsList(treeNode) {
        operatorTreeNode = treeNode;
        table.options({
            parentId:treeNode.id
        },true)
    }

    function _listChannels (){
        Ajax.query("listChannels",{
            url:"/channel/list",
            data:{page:1,pageSize:1000},
            type:"GET",
            callback:function (result){
                var data = result.data;
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if(zTree){
                    zTree.destroy();
                }
                var zNode = new Array();
                zNode.push({"name":"顶级栏目","id":"-1","parentId":"-2",open:true});
                $.each(data,function (){
                    this.open = true;
                    zNode.push(this);
                })
                var t = $("#tree");
                t = $.fn.zTree.init(t, ztree_setting,zNode);
            }
        })
    }

    var operatorTreeNode ;
    window.Manager = {
        getChannel:function (){
            return operatorTreeNode;
        },
        addNode:function (node){
            if(node){
                var zTree = $.fn.zTree.getZTreeObj("tree");
                zTree.addNodes(operatorTreeNode, node);
                operatorTreeNode.open = true;
            }
        },
        updateNode:function (node) {
            if(node){
                var zTree = $.fn.zTree.getZTreeObj("tree");
                var editNode = zTree.getNodesByFilter(function (ztreeNode){return ztreeNode.id == node.id},true);
                editNode = $.extend(editNode,node);
                zTree.updateNode(editNode);
            }
        },
        add:function () {
            if(!operatorTreeNode){
                Tool.layer_alert("请先选择一个父栏目");
                return false;
            }
            Tool.layer_full_screen({
                content: "./add.htm",
                end:function (){
                    table.render();
                }
            })
        },
        edit:function (id,event) {
            Tool.layer_full_screen({
                content:"./edit.htm?id=" + id,
                end:function () {
                    table.render();
                }
            })
            event.stopPropagation();
            return false;
        },
        del:function (id,event){
            //判断是否存在子栏目
            var zTree = $.fn.zTree.getZTreeObj("tree");
            var node = zTree.getNodesByFilter(function (ztreeNode){return ztreeNode.id == id},true);
            if(node.isParent){
                Tool.layer_alert("存在子栏目不允许删除");
                return false;
            }
            var index = Tool.layer_confirm("确认删除此栏目?",function (){
                Tool.layer_close(index);
                Ajax.submit("delChannel",{
                    url:"/channel/del",
                    data:{id:id,"_method":"delete"},
                    callback:function (){
                        Tool.layer_alert("删除成功",function () {
                            table.render();
                            zTree.removeNode(node);
                        })
                    }
                })
            });
            event.stopPropagation();
            return false;
        }
    }

    $(function (){
        _listChannels();
        table.render();
    })
}()