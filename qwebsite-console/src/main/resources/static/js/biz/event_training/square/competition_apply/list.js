var TrainApplyList = function (){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/competition_square_apply/list",
        page_size:10
    });


    var Service = {
        queryReadFlagType:function () {
            Ajax.query("queryReadFlagList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isRead"},
                async:false,
                callback:function (result) {
                    var obj = {itemCode:"",itemName:"全部"};
                    result.data.unshift(obj);
                    $("#readFlag").html(template("selected_temp",{list:result.data}));
                    $("#readFlag").fancyspinbox();
                }
            })
        },
        querySexType:function () {
            Ajax.query("querySexList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"projectKind"},
                async:false,
                callback:function (result) {
                    var obj = {itemCode:"",itemName:"全部"};
                    result.data.unshift(obj);
                    $("#projectKind").html(template("selected_temp",{list:result.data}));
                    $("#projectKind").fancyspinbox();
                }
            })
        },
        queryTrainerType:function () {
            Ajax.query("querySexList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"trainerType"},
                callback:function (result) {
                    var obj = {itemCode:"",itemName:"全部"};
                    result.data.unshift(obj);
                    $("#trainerType").html(template("selected_temp",{list:result.data}));
                    $("#trainerType").fancyspinbox();
                }
            })
        }
    }

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
        del:function (id,e){
            Tool.layer_confirm("确认删除此条数据?",function () {
                Ajax.submit("delEntry", {
                    url: "/competition_square_apply/del",
                    data: {id: id,"_method": "delete"},
                    type: "POST",
                    callback: function () {
                        Tool.layer_alert("删除成功!", function () {
                            table.render();
                        });
                    }
                })
            });
            e.stopPropagation();
        },
        /**
         * 全选/反选
         */
        choseAll:function (){
            if($("#th_checkbox").is(":checked")) {
                $("input[name='checkbox']").prop("checked","true");
            }else{
                $("input[name='checkbox']").removeAttr("checked");
            }
        },
        selectThis:function (event,obj) {
            var currentTr = $(obj);
            currentTr.parent().find("tr").removeAttr("style");
            currentTr.css({background:"#62B593"});
        },
        /**
         * 异步修改阅读状态
         */
        changeReadFlag:function(id,readFlag,e){
            var changeReadFlag;
            if(0 == readFlag){
                changeReadFlag = "1";
            }else{
                changeReadFlag = "0";
            }
            var index = Tool.layer_confirm("确认改变此条信息的阅读状态?",function () {
                Tool.layer_close(index);
                Ajax.submit("updateEntry", {
                    url: "/competition_square_apply/edit",
                    data: {id: id,readFlag:changeReadFlag},
                    type: "POST",
                    callback: function () {
                        table.render();
                    }
                })
            });
            e.stopPropagation();
        },
        /**
         * 获取所有选中的checkbox的值
         */
        delAllSelectedVal:function(e){
            var spCodesTemp = "";
            $("input:checkbox[name=checkbox]:checked").each(function(i){
                if(0==i){
                    spCodesTemp = $(this).val();
                }else{
                    spCodesTemp += (","+$(this).val());
                }
            });

            if("" == spCodesTemp){
                Tool.layer_alert("请选择需要删除的项");
                return false;
            }

            Tool.layer_confirm("确认删除选中的数据?",function () {
                Ajax.submit("delEntry", {
                    url: "/competition_square_apply/delSelectedBox",
                    data: {ids: spCodesTemp, "_method": "delete"},
                    type: "POST",
                    callback: function () {
                        Tool.layer_alert("删除成功!", function () {
                            table.render();
                        });
                    }
                })
            });
            e.stopPropagation();

        },
        exportExcel:function () {
            var obj = Tool.serializeJson($("#searchForm"));
            var p ="";
            $.each(obj,function (k,v){
                p += k + "=" + v + "&";
            });
            if(p != ""){
                p.substring(0,p.length-1);
            }

            Ajax.query("getData",{
                url:"/competition_square_apply/checkExport?"+p,
                callback:function (result) {
                    if(result=="success"){
                        window.top.location.href = path +  "/competition_square_apply/export?" + p;
                    }else{
                        Tool.layer_alert("导出数据不能大于5000条，请先查询");
                    }
                }
            })
        },
        detail:function(id,e){
            $(".mengban").fadeIn(200);
            $(".mengban").addClass("mengban-fg");
            $("#tip").fadeIn(200);

            Ajax.query("getData",{
                url:"/competition_square_apply/get",
                data:{id:id},
                callback:function (result) {
                    result.gmtCreateFormat = Tool.dateFormat(result.gmtCreate);
                    Tool.set_form_data($("#tipInfo"),result);
                }
            })
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

    /**
     * 监听搜索框Enter事件
     * @private
     */
    function _initInputEnterEvent() {
        $("#realName,#idNo").bind('keypress',function(event){
            if(event.keyCode == "13"){
                $("#searchForm").submit();
            }
        });
        $(".tiptop a").click(function(){
            $(".mengban").fadeOut(200);
            $(".tip").fadeOut(200);
        });
    }

    $(function (){
        Service.queryReadFlagType();
        Service.querySexType();
        // Service.queryTrainerType();
        table.render();
        _initSearchForm();
        _initInputEnterEvent();
    })
}()
