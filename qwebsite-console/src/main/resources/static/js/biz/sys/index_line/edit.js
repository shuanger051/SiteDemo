var IndexLineEdit = function (){
    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/index_line/get",
                data:{id:id},
                callback:function (result) {
                    result.logo = viewPath + result.logo;
                    Tool.set_form_data($("#form1"),result);
                    $("select[name='isEnabled']").fancyspinbox();
                }
            })
        },
        queryEnabledFlagType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"isShow"},
                async:false,
                callback:function (result) {
                    $("select[name='isEnabled']").html(template("selected_temp",{list:result.data}));
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
                    url:path + '/index_line/edit',
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

                $("#form1").ajaxSubmit(options);
                return false;
            }
        });
    }
    $(function () {
        Service.queryEnabledFlagType();
        _initForm();
        Service.get(Tool.getReqP("id"));
    })
}();