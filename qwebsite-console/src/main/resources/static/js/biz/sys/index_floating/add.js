var IndexFloatingAdd = function (){

    var Service = {
        queryEnabledFlagType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isShow"},
                async:false,
                callback:function (result) {
                    $("select[name='isEnabled']").html(template("selected_temp",{list:result.data}));
                    $("select[name='isEnabled']").fancyspinbox();
                }
            })
        },
        queryFloatingType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"floatingPosition"},
                async:false,
                callback:function (result) {
                    $("select[name='floatingPosition']").html(template("selected_temp",{list:result.data}));
                    $("select[name='floatingPosition']").fancyspinbox();
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

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url: path + '/index_floating/save',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在上传");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("保存成功");
                    },  //处理完成
                    resetForm:false,
                    type:'POST',
                    dataType:'json'
                };

                var checkSelectTagFlag = false;
                var checkSelectTagBanner = $("#floatingPosition option:selected").val();

                if("undefined" != checkSelectTagBanner && "" != checkSelectTagBanner && "3" == checkSelectTagBanner ){
                    checkSelectTagFlag = true;
                }

                if(!checkSelectTagFlag){
                    /**
                     * 判断浮窗内容是否被占用
                     */
                    Ajax.query("getData",{
                        url:"/index_floating/list",
                        data:{floatingPosition:$("#floatingPosition option:selected").val()},
                        callback:function (result) {
                            if(null != result && result.data.length >= 1){
                                Tool.layer_alert($("#floatingPosition").find("option:selected").text()+"位置内容已存在,请重新选择");
                            }else{
                                $("#form1").ajaxSubmit(options);
                            }
                        }
                    })
                }else{
                    $("#form1").ajaxSubmit(options);
                }
                return false;
            }
        });
    }

    $(function(){
        Service.queryEnabledFlagType();
        Service.queryFloatingType();
        _initForm();
    });

}();