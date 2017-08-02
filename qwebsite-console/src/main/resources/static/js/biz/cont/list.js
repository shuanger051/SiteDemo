/**
 * Created by xuebj on 2017/3/15.
 */
var ContentList = function (){
    var table = new $.Table();

    table.init({
        tId:"table",
        url:"/content/list"
    });

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
                if(!treeNode.isParent){
                    _showChannelsList(treeNode);
                }else{
                    treeNode.open = true;
                    return false;
                }
            }
        }
    };

    function _showChannelsList(treeNode) {
        operatorTreeNode = treeNode;
        table.options({
            channelId:treeNode.id
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
    var editContent;
    window.Manager = {
        getContent:function () {
            return editContent;
        },
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
        audit:function (id,event) {
            Ajax.submit("audit",{
                url: "/content/audit",
                data:{id:id,"isRejected":false},
                type:"PUT",
                callback:function (result) {
                    table.render();
                    Tool.layer_alert("审核完成");
                }
            })
            event.stopPropagation();
            return false;
        },
        showReject:function (id,event) {
            Tool.layer_show({
                type:1,
                title:"退回",
                area: ['500px','200px'],
                content:getRejectHtml(id)
            })
            event.stopPropagation();
            return false;
        },
        reject:function (id) {
            Ajax.submit("audit",{
                url: "/content/audit",
                data:{id:id,isRejected:true,checkOpinion:$("#checkOpinion").val()},
                type:"PUT",
                callback:function () {
                    layer.closeAll();
                    Tool.layer_alert("已退回",function(){
                        table.render();
                    });

                }
            })
        },
        add:function () {
            if(!operatorTreeNode){
                Tool.layer_alert("请先选择栏目");
                return false;
            }
            Tool.layer_full_screen({
                content: "./" + operatorTreeNode.tplModel + "/add.htm",
                end:function (){
                    table.render();
                }
            })
        },
        edit:function (id,event) {
            findContentById(id);
            if(!!editContent){
                Tool.layer_full_screen({
                    content:"./" + editContent.channel.tplModel + "/edit.htm?id=" + id,
                    end:function () {
                        editContent = null;
                        table.render();
                    }
                })
            }
            event.stopPropagation();
            return false;
        },
        del:function (id,event){
            var index = Tool.layer_confirm("确认删除此内容?",function (){
                Tool.layer_close(index);
                Ajax.submit("delContent",{
                    url:"/content/del",
                    data:{id:id,"_method":"delete"},
                    callback:function (){
                        Tool.layer_alert("删除成功",function () {
                            table.render();
                        })
                    }
                })
            });
            event.stopPropagation();
            return false;
        }
    }

    function getRejectHtml(id){
        var html = "";
        html += '<div class="rightinfo" ><ul class="forminfo">'
            + '<li><label>审核意见</label><textarea name="checkOpinion" id="checkOpinion" class="textinput" style="width: 325px;height: 64px;" maxlength="100"></textarea></li>'
            + '<li><label>&nbsp;</label><input style="float: right;margin-right: 28px;" class="btn" value="确认保存" type="button" onclick="Manager.reject('+ id + ')"/></li>'
            + '</ul></div>';
        return html;
    }

    function findContentById(id) {
        var data = table.getData();
        $.each(data,function (){
            if(this.id ==  id){
                editContent = this;
                return false;
            }
        });
    }

    function _initSearchForm() {
        $("#searchForm").Validform({
            tip:3,
            callback:function(form){
                var data = Tool.serializeJson(form);
                if(!!operatorTreeNode){
                    data = $.extend(data,{channelId:operatorTreeNode.id});
                }
                table.options(data,true);
                return false;
            }
        })
    }

    function _queryDict() {
        Ajax.query("queryDict",{
            url:"/sys_dict_item/list_by_entry_code",
            data:{entryCodes:"contentStatus"},
            callback:function (result) {
                var data = result["contentStatus"];
                data.unshift({itemCode:"",itemName:"全部"});

                $("select[name='status']").html(template("selected_temp",{list:result["contentStatus"]}));
                $("select[name='status']").fancyspinbox();
            }
        })
    }

    $(function (){
        _queryDict();
        _listChannels();
        _initSearchForm();
        table.render();
    })
}()