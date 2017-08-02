/**
 * Created by xuebj on 2017/4/20.
 */
var ActivityApplyModel = function ($){

    var Service = {
        _get:function (id){
            Ajax.query("getActivity",{
                url:"/apply/activity/get",
                data:{id:id},
                callback:function (result) {
                    $("#contentName").text(result.title);
                    $("#contentId").val(result.id);
                }
            })
        }
    }


    function _initForm(){
        $("#applyForm").Validform({
            tiptype:3,
            callback:function (form){
                Ajax.submit("apply",{
                    url:"/apply/activity",
                    data:Tool.serializeJson(form),
                    callback:function () {
                        Tool.layer_alert("报名成功",function (){
                            window.location.href = "./index.htm?type=1";
                        })
                    }
                })
                return false;
            }
        })
    }
    $(function () {
        Service._get(Tool.getReqP("id"));
        _initForm();
    })
}(jQuery)
