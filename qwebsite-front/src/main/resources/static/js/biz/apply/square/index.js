/**
 * Created by xuebj on 2017/4/20.
 */
$(function (){

    function show(id){
        $("#c1,#c2,#c3").hide();
        $("#c"+ id).show();
    }
    var type = Tool.getReqP("type");
    if(!!type){//存在
        $("#navMenu").find("li[data-content-type='" + type + "']").addClass("active");
        show(type);
    }else{
        $("#navMenu").find("li:first-child").addClass("active");
        show(1);
    }
    var title = $("#navMenu li.active").text();
    $("#listTitle1,#listTitle2").text(title);
    $("#navTitle").text(title);
    var table = new $.Table();
    var tableTrain = new $.Table();
    var table3 = new $.Table();
    //左导航
    $('.click_ul li').unbind().click(function(){
        $(this).addClass('active').siblings().removeClass('active');
        $("#listTitle1,#listTitle2").text($(this).text());
        $("#navTitle").text($(this).text());
        var type = $(this).attr("data-content-type");
        if(type == "1"){//
            show(1);
            tableTrain.options({},false);
        }else if(type == "2"){
            show(2);
            table.options({},false);
        }else{
            show(3);
            table3.options({},false);
        }
    });
    tableTrain.init({
        tId:"tab1",
        url:"/square_apply/train/list"
    });
    table.init({
        tId:"tab2",
        url:"/square_apply/activity/list"
    });
    table3.init({
        tId:"tab3",
        url:"/square_apply/competition/list"
    })
    var t =  $('.click_ul li.active').attr("data-content-type");
    if(t == "1"){//
        tableTrain.render();
    }else if(t == "2"){
        table.render();
    }else if(t == "3"){
        table3.render();
    }

})
