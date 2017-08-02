var PartnerAdd = function (){
    var ue ;
    var Service = {
        queryEnabledFlagType:function () {
            Ajax.query("queryEnabledFlagList",{
                url:"/sys_dict_item/list_by_entry_code",
                data:{entryCodes:"isShow,teacherType,teacherLevel"},
                async:false,
                callback:function (result) {
                    $("select[name='isEnabled']").html(template("selected_temp",{list:result["isShow"]}));
                    $("select[name='type']").html(template("selected_temp",{list:result["teacherType"]}));
                    $("select[name='level']").html(template("selected_temp",{list:result["teacherLevel"]}));
                }
            })
        },
        getTeacher:function (id){
            Ajax.query("getTeacher",{
                url:"/teacher/get",
                data:{id:id},
                callback:function (result) {
                    result.headImg = viewPath + result.headImg;
                    result.releaseDate = Tool.dateFormat(result.releaseDate);
                    ue.ready(function (){
                        ue.setContent(result.txt||'');
                    })
                    Tool.set_form_data($("#form1"),result);
                    $("select[name='isEnabled']").fancyspinbox();
                    $("select[name='type']").fancyspinbox();
                    $("select[name='level']").fancyspinbox();
                }
            })
        }
    }

    function _initForm(){
        $("#form1").Validform({
            tip:3,
            callback:function(){
                var options = {
                    url:path + '/teacher/edit',
                    beforeSubmit:function () {
                        Tool.layer_alert("正在上传");
                    },  //提交前处理
                    success:function () {
                        Tool.layer_alert("保存成功",function () {
                            Tool.go_back();
                        });
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
        ue = UE.getEditor('txt');
        Service.queryEnabledFlagType();
        Service.getTeacher(Tool.getReqP("id"));
        _initForm();
    });

}();