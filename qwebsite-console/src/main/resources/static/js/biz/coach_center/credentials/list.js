var CredentialsList = function (){
    var table = new $.Table();
    table.init({
        tId:"table",
        url:"/credential/queryList",
        page_size:10
    });

    var Service = {

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
        del:function (id,name,e){
            Tool.layer_confirm("确认删除此资质信息?",function () {
                Ajax.submit("delEntry", {
                    url: "/credential/del",
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
                    url: "/credential/delSelectedBox",
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
        },
        exportExcel:function () {
            var name = $("#name").val();
            var workUnit =  $("#workUnit").val();

            Ajax.query("getData",{
                url:"/credential/checkExport?name="+name+"&workUnit="+workUnit,
                callback:function (result) {
                    if(result=="success"){
                        window.location.href = path +  "/credential/export?name="+name+"&workUnit="+workUnit;
                    }else{
                        Tool.layer_alert("导出数据不能大于5000条，请先查询");
                    }
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

    function _initImportForm() {
        $("#importForm").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/credential/import',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在导入Excel数据");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("导入完成");
                        table.render();
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
        $("#name").bind('keypress',function(event){
            if(event.keyCode == "13"){
                $("#searchForm").submit();
            }
        });
    }

    $(function (){
        table.render();
        _initInputEnterEvent();
        _initSearchForm();
        _initImportForm();
    })
}()
