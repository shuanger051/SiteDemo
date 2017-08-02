/**
 * Created by xuebj on 2017/3/15.
 */
var DictAdd = function (){

    window.Manager = {
        close:function (){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        }
    }
    $(function () {
        $("#form1").Validform({
            tip:3,
            callback:function(form){
                Ajax.submit("saveEntry",{
                    url:"/sys_dict_entry/save",
                    data:form.serialize(),
                    callback:function (result) {
                       Tool.layer_alert("保存成功",function(){
                           form[0].reset();
                       })
                    }
                })
                return false;
            }
        });
    })
}();