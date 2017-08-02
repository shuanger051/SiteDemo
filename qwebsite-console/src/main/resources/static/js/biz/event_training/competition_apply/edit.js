var ActivityApplyEdit = function (){
    var Service = {
        get:function (id){
            Ajax.query("getData",{
                url:"/competition_apply/get",
                data:{id:id},
                callback:function (result) {
                    //获取赛事内容
                    Ajax.query("getCompetiton",{
                        url:"/competition/get",
                        data:{id:result.contentId},
                        callback:function (competition){
                            var divisions = competition.division;
                            if(!!divisions && divisions != ""){
                                divisions = divisions.replace(/，/g, ",").split(",");
                                var array = new Array();
                                $.each(divisions,function(i,v){
                                    array.push({"itemCode":v,"itemName":v})
                                })
                                $("select[name='division']").html(template("selected_temp", {list: array}));
                            }
                            Tool.set_form_data($("#form1"), result);
                            $("select[name='projectKind']").fancyspinbox();
                            $("select[name='division']").fancyspinbox();
                        }
                    })

                }
            })
        },
        queryDicItem:function () {
            Ajax.query("queryGenderList",{
                url:"/sys_dict_item/list_by_entry_code",
                data:{entryCodes:"projectKind,division"},
                async:false,
                callback:function (result) {
                    $("select[name='projectKind']").html(template("selected_temp",{list:result.projectKind}));
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
                    url:path + '/competition_apply/edit',
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
        Service.queryDicItem();
        _initForm();
        Service.get(Tool.getReqP("id"));
    })
}();