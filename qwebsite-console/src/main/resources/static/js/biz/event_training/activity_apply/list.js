var ActivityApplyList = function (){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/activity_apply/queryList",
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
                data:{entryCode:"gender"},
                async:false,
                callback:function (result) {
                    var obj = {itemCode:"",itemName:"全部"};
                    result.data.unshift(obj);
                    $("#sex").html(template("selected_temp",{list:result.data}));
                    $("#sex").fancyspinbox();
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
                    url: "/activity_apply/del",
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
                    url: "/activity_apply/edit",
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
                    url: "/activity_apply/delSelectedBox",
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
            var realName = $("#realName").val();
            var sex =  $("#sex").val();
            var readFlag = $("#readFlag").val();
            Ajax.query("getData",{
                url:"/activity_apply/checkExport?realName="+realName+"&sex="+sex+"&readFlag="+readFlag,
                callback:function (result) {
                    if(result=="success"){
                        window.top.location.href = path + "/activity_apply/export?realName="+realName+"&sex="+sex+"&readFlag="+readFlag;
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
                url:"/activity_apply/get",
                data:{id:id},
                callback:function (result) {
                    Tool.set_form_data($("#tipInfo"),result);
                }
            })
        },
        importExcel:function () {
            $("#file_select").val("");
            $("#file_select").trigger("click");
        },
        checkImportExcel:function () {
            var SrcFile = $("#file_select").val();
            if(null != SrcFile && "" != SrcFile && "undefined" != SrcFile){
                var AcceptFileTypes = new Array("xlsx");
                var fileTypeFlag = "0";
                var newFileName = SrcFile.split('.');
                newFileName = newFileName[newFileName.length-1];
                for(var i=0;i<AcceptFileTypes.length;i++){
                    if(AcceptFileTypes[i] == newFileName){
                        fileTypeFlag = "1";
                    }
                }
                if(fileTypeFlag == "0"){
                    Tool.layer_alert("抱歉只支持.xlsx文件");
                    return false;
                }

                $("#importForm").submit();

            }
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

    function _initImportForm() {
        $("#importForm").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/activity_apply/import',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在导入Excel数据");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("导入完成");
                    },  //处理完成
                    resetForm:false,
                    type:'POST',
                    dataType:'json'
                };
                $("#importForm").ajaxSubmit(options);
                return false;
            }
        });
    }

    function _initInputEnterEvent() {
        $("#realName").bind('keypress',function(event){
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
        table.render();
        _initSearchForm();
        _initImportForm();
        _initInputEnterEvent();
    })
}()
