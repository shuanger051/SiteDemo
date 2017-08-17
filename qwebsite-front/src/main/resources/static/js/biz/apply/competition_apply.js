/**
 * Created by xuebj on 2017/4/20.
 */
var TrainApplyModel = function ($){

    var Service = {
        _get:function (id){
            Ajax.query("getTrain",{
                url:"/apply/competition/get",
                data:{id:id},
                callback:function (result) {
                    $("#contentName").text(result.title);
                    $("#contentId").val(result.id);
                    var divisions = result.division;
                    if(!!divisions && divisions != "") {
                        divisions = divisions.replace(/，/g, ",").split(",");
                        $("#division").html(template("divisionTemp",{list:divisions}));
                        initSelect();
                    }
                }
            })
        },
        _queryDictItem:function (){
            Ajax.query("getItem",{
                url:"/dict/list_by_entry_code",
                data:{
                    "entryCodes":"projectKind"
                },
                async: false,
                callback:function (result){
                    $("#projectKindSpan").html(template("selectTemp",{list:result.projectKind}));
                }
            })
        },
        _queryTeamTypeDictItem:function () {
            Ajax.query("getItem1",{
                url:"/dict/list_by_entry_code",
                data:{
                    "entryCodes":"teamType"
                },
                async: false,
                callback:function (result){
                    $("#teamTypeSelect").html("");
                    $("#teamTypeSelect").html(result.teamType[0].itemName);
                    $("#teamType").val(result.teamType[0].itemCode);
                }
            })
        }
    }



    function _initForm(){
        $("#applyForm").Validform({
            tiptype:3,
            callback:function (form){
                var data={};
                $.each(form.serializeArray(),function (){
                    if($.trim(this.value) !== ""){
                        if(!!data[this.name]){
                            data[this.name] = data[this.name] + "," + this.value;
                        }else{
                            data[this.name] = this.value;
                        }

                    }
                })
                data.division = $("#division div cite").text();
                Ajax.submit("apply",{
                    url:"/apply/competition",
                    data: data,
                    callback:function () {
                        Tool.layer_alert("报名成功",function (){
                            window.location.href = "./index.htm?type=3";
                        })
                    }
                })
                return false;
            }
        })
    }
    $(function () {
        Service._queryDictItem();
        Service._queryTeamTypeDictItem();
        Service._get(Tool.getReqP("id"));
        _initForm();
    })
    //下拉选择

        function initSelect(){
                $(".divselect").click(function () {
                    $(this).toggleClass("divselect_open");
                });
                $(".divselect li").click(function () {
                    $(this).closest(".divselect").find("cite").text($(this).text());
                    if($(this).val()){
                        $("#teamType").val($(this).val());
                    }
                });
                // 点击其它地方搜索消失
                $(window).on("click", function (e) {
                    if ($(e.target).parents(".divselect").length == 0) {
                        $(".divselect").removeClass("divselect_open");
                    } else {
                        e.stopPropagation();
                    }
                });
        }

    //end 下拉选择
}(jQuery)
