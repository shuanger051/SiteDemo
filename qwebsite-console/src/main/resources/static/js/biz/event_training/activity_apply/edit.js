var ActivityApplyEdit = function (){
    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/activity_apply/get",
                data:{id:id},
                callback:function (result) {
                    Tool.set_form_data($("#form1"),result);
                    $("select[name='sex']").fancyspinbox();
                }
            })
        },
        queryGenderType:function () {
            Ajax.query("queryGenderList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"gender"},
                callback:function (result) {
                    $("select[name='sex']").html(template("selected_temp",{list:result.data}));
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
                    url:path + '/activity_apply/edit',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在提交");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("修改成功");
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
        Service.queryGenderType();
        _initForm();
        Service.get(Tool.getReqP("id"));
    })
}();