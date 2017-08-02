var ActivityEdit = function (){

    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/train_square/get",
                data:{id:id},
                callback:function (result) {
                    result.gmtBegin = Tool.dateFormat(result.gmtBegin,"yyyy-MM-dd");
                    result.gmtEnd = Tool.dateFormat(result.gmtEnd,"yyyy-MM-dd");
                    Tool.set_form_data($("#form1"),result);
                    var provinces = new Array("北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "内蒙古", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "广西", "海南省", "四川省", "贵州省", "云南省", "西藏", "陕西省", "甘肃省", "青海省", "宁夏", "新疆", "香港", "澳门", "台湾省");
                    var index = Tool.indexOfItem(result.province,provinces);
                    index++;
                    geoSetup(index);
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
                    url:path + '/train_square/edit',
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
        _initForm();
        Service.get(Tool.getReqP("id"));

    })
}();