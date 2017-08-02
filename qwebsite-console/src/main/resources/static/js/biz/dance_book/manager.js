var CredentialsList = function (){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/chorgraphy/list",
        page_size:10
    });

    var Service = {
        _queryDict:function (){
            Ajax.query("queryDict", {
                url: "/sys_dict_item/list_by_entry_code",
                data: {entryCodes: "danceBookStatus"},
                callback: function (result) {
                    var statusOptions = result["danceBookStatus"];
                    statusOptions.unshift({itemName:"全部",entryCode:""});
                    $("select[name='status']").html(template("selected_temp", {list: statusOptions})).fancyspinbox();
                }
            });
        }
    }

    $("#form1").Validform({
        tip:3,
        callback:function(form){
            var data = Tool.serializeJson(form);
            table.options(data,true);
            return false;
        }
    })

    window.Manager = {
        add:function () {
            Tool.layer_full_screen({
                content: './add.htm',
                end:function () {
                    table.render();
                }})
        },
        edit:function (id,e) {
            Tool.layer_full_screen({
                content:"./edit.htm?id="+ id,
                end:function (){
                    table.render();
                }
            });
            e.stopPropagation();
            return false;
        },
        publish:function (id,e){
            Tool.layer_confirm("确认发布?",function () {
                Ajax.submit("publishDanceBook",{
                    url:"/chorgraphy/publish",
                    data:{id:id},
                    type:"PUT",
                    callback:function (result){
                        Tool.layer_alert("发布成功!", function () {
                            table.render();
                        });
                    }
                })
            })
            e.stopPropagation();
            return false;
        },
        del:function (id,name,e){
            Tool.layer_confirm("确认删除此舞谱?",function () {
                Ajax.submit("delEntry", {
                    url: "/chorgraphy/del",
                    data: {id: id, "_method": "delete"},
                    type: "POST",
                    callback: function () {
                        Tool.layer_alert("删除成功!", function () {
                            table.render();
                        });
                    }
                })
            });
            e.stopPropagation();
        }
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

    function _initInputEnterEvent() {
        $("#name").bind('keypress',function(event){
            if(event.keyCode == "13"){
                $("#searchForm").submit();
            }
        });
    }

    $(function (){
        Service._queryDict();
        table.render();
        _initInputEnterEvent();
        _initSearchForm();
    })
}()
