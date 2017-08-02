/**
 * Created by xuebj on 2017/5/10.
 */
var CIndexModel = function ($){


    $("#searchForm").Validform({
        tiptype:function(msg,o,cssctl){
            if(o.type == 3){
                Tool.layer_alert(msg,null,{icon:5})
            }
        },
        beforeSubmit:function(form){
            var credentialsTypeName = $("#credentialsType cite").text();
            var credentialsType = 1;
            $("#credentialsType li").each(function (){
                if($(this).text() == credentialsTypeName){
                    credentialsType = $(this).attr("data-value");
                }
            })
            var trainerTypeName = $("#trainerType cite").text();
            var trainerType = 1;
            $("#trainerType li").each(function (){
                if($(this).text() == trainerTypeName){
                    trainerType = $(this).attr("data-value");
                }
            })
            Ajax.submit("queryCert",{
                url:"/credential/page",
                data: $.extend(Tool.serializeJson(form),{trainerType:trainerType,credentialsType:credentialsType}),
                type:"get",
                callback:function (result){
                    if(result.total >= 1){
                        var data = _.sortBy(result.data,"credentialsLevel");
                        var html = template("resultTmp",{data:data[data.length - 1]});
                        $("#showResult").html(html);
                    }else{
                        $("#showResult").html('<div style="color:#888;font-size: 30px">未搜索到相关证书</div>');
                    }
                }

            })
            return false;
        }
    });
    // 下拉选择
        (function () {
            $(".divselect").click(function () {
                $(this).toggleClass("divselect_open");
            });
            $(".divselect li").click(function () {
                $(this).closest(".divselect").find("cite").text($(this).text());
            });
            // 点击其它地方搜索消失
            $(window).on("click", function (e) {
                if ($(e.target).parents(".divselect").length == 0) {
                    $(".divselect").removeClass("divselect_open");
                } else {
                    e.stopPropagation();
                }
            });
        })();
    // end 下拉选择
}(jQuery);