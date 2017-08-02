// banner
if ((navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){}else{
	window.addEventListener("load",function(){
		var innerbn = document.getElementById("bnActive");
		innerbn != null ? innerbn.classList.add("active") : 0;
	});
}
// end banner



if (typeof $ != "undefined"){
;$(function(){

//个人下拉二级
	$('.header_club:has(ul)').hover(function(){
	$(this).children('.header_club_ul').stop().slideDown();
	},function(){
	$(this).children('.header_club_ul').stop().slideUp();
	});
//

//隔行变色
$('.even_ul').each(function(){
$(this).children('li:odd').addClass('even_li');
});
//
	
//左导航
$('.click_ul li').click(function(){
$(this).addClass('active').siblings().removeClass('active');
});
//
	
//分享功能 
$('.o_share:has(div)').hover(function(){
$(this).children('.sec_share_box').fadeIn();
},function(){
$(this).children('.sec_share_box').fadeOut();
});
//

//标签导航
// $(".tab_nav dd a:first").addClass("tab_light");
// $(".tab_box > div").hide();
// $(".tab_box > div:first").show();
// $('.tab_nav dd a').click(function(){
// $(this).addClass('tab_light').siblings().removeClass('tab_light');
// $(".tab_box > div").hide().eq($('.tab_nav dd a').index(this)).fadeIn();
// });
	
//二级标签导航
$(".sec_tab_nav li a:first").addClass("tab_light");
$(".sec_tab_box > div").hide(); 
$(".sec_tab_box > div:first").show(); 
$('.sec_tab_nav li a').click(function(){ 
$(this).addClass('tab_light').siblings().removeClass('tab_light'); 
$(".sec_tab_box > div").hide().eq($('.sec_tab_nav li a').index(this)).fadeIn();
}); 	
//
	

// 浮动导航
(function(){
	var headerWrap = $("#headerWrap");
	if (headerWrap.length != 0) {
		var headerWrapH = headerWrap.offset().top,
			stopProdp = $("#stop_homeNav");
		if (stopProdp.length != 0) {
			var stopProdpH = stopProdp.offset().top;
		};
		//滚动条事件
		$(window).scroll(function(){
			var scroH = $(this).scrollTop();
			if(scroH>headerWrapH){
			    headerWrap.addClass("Topheader");
			    if (scroH>=stopProdpH) {
			    	 headerWrap.removeClass("Topheader");
			    };
			}else{
			    headerWrap.removeClass("Topheader");
			}
		});
	};
	// 
	var	$homeNav = $("#homeNav");
	if (typeof $.fn.onePageNav == "function") {
		$homeNav.onePageNav();
	};
})();
// end 浮动导航


// 
if ($().slide) {
$(".banner").slide({mainCell:".bd",titCell:".hd",effect:"leftLoop", vis:"auto",autoPage: true, autoPlay: true, pnLoop:true, delayTime: 500, interTime: 5000});
//
$(".ann_scroll").slide({mainCell:".bd",effect:"topLoop",autoPage: true, autoPlay: true, pnLoop:false, vis:1, interTime: 5000});
//
$(".pic_scroll").slide({titCell:".hd",mainCell:".bd",effect:"leftLoop",autoPage: true, autoPlay: true, pnLoop:false, vis:7, scroll: 1, interTime: 5000});
//
$(".pro_scroll").slide({mainCell:".bd",effect:"left",autoPage: true, autoPlay: true, pnLoop:false, vis:5, interTime: 5000});
//
};
// end

//文本框
function placeholder(input){
	var placeholder = input.attr("placeholder"),
		defaultValue = input.defaultValue;
	if(!defaultValue){
		input.val() == "" ?	input.val(placeholder).addClass("phcolor") : 0;
	}
	input.focus(function(){
		input.val() == placeholder ? $(this).val("") : 0;
	});
	input.blur(function(){
		input.val() == "" ? $(this).val(placeholder).addClass("phcolor") : 0;
	});
	input.keydown(function(){
		$(this).removeClass("phcolor");
	});
}
;$(function(){
	supportPlaceholder="placeholder"in document.createElement("input");
	if(!supportPlaceholder){
		$("input").each(function(){
			var type = $(this).attr("type");
			text = $(this).attr("placeholder");
			if(type == "text" || type == "number" || type == "search" || type == "email" || type == "date" || type == "url"){
				placeholder($(this));
			}
		});
	}
});
//end文本框
	
	
//返回顶部
var ftoolTop = $("#ftoolTop");
	ftoolTop.click(function (e){
		e.preventDefault();
		$("html,body").animate({scrollTop:0},500);
	});
$(window).on("DOMContentLoaded scroll resize", function(){
		$(this).scrollTop() == 0 ? ftoolTop.hide() : ftoolTop.show();
	});
//


	

//下拉选择
//         (function () {
//             $(".divselect").click(function () {
//                 $(this).toggleClass("divselect_open");
//             });
//             $(".divselect li").click(function () {
//                 $(this).closest(".divselect").find("cite").text($(this).text());
//             });
//             // 点击其它地方搜索消失
//             $(window).on("click", function (e) {
//                 if ($(e.target).parents(".divselect").length == 0) {
//                     $(".divselect").removeClass("divselect_open");
//                 } else {
//                     e.stopPropagation();
//                 }
//             });
//         })();
        //end 下拉选择


});
};
// end jq