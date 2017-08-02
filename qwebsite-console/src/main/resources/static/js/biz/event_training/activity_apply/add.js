var ActivityApplyAdd = function (){

    var Service = {
        queryGenderType:function () {
            Ajax.query("queryGenderList",{
                url:"/sys_dict_item/list",
                data:{entryCode:"gender"},
                async:false,
                callback:function (result) {
                    $("select[name='sex']").html(template("selected_temp",{list:result.data}));
                    $("select[name='sex']").fancyspinbox();
                }
            })
        }
    }

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        checkIdNoStatus:function () {
            //校验身份证号是否已存在
            Ajax.query("queryGenderList",{
                url:"/activity_apply/getInfoByIdNo",
                data:{idNo:$("input[name='idNo']").val() },
                callback:function (result) {
                    if(result){
                        Tool.layer_alert("该身份证号用户已存在");
                        $("input[name='idNo']").focus();
                    }
                }
            })
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/activity_apply/save',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在提交");
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

    $(function(){
        Service.queryGenderType();
        _initForm();
    });

}();