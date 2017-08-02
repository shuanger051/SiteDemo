/**
 * Created by xuebj on 2017/3/15.
 */
var NavManager = function (){
    var table = new $.Table();

    table.init({
        tId:"table",
        url:"/navigation/list",
        parameter:{parentId:-1}
    });

    var ztree_setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
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
            url:"/navigation/list",
            data:{page:1,pageSize:1000},
            type:"GET",
            callback:function (result){
                var data = result.data;
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if(zTree){
                    zTree.destroy();
                }
                var zNode = new Array();
                zNode.push({"name":"顶级导航","id":"-1","parentId":"-2",open:true});
                $.each(data,function (){
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
                Tool.layer_alert("存在子导航不允许删除");
                return false;
            }
            var index = Tool.layer_confirm("确认删除此导航?",function (){
                Tool.layer_close(index);
                Ajax.submit("delChannel",{
                    url:"/navigation/del",
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