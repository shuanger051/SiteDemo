/**
 * Created by xuebj on 2017/3/16.
 */
;(function ($){
    var index = 0;
    $.fn.Page = function (options) {
        var that = this;
        var p = new Page(options,that);
    }

    var index = 0;//支持多表格
    var Page = function (options,$this){
        var that = this;
        var conf = that.config = options || {};
        conf.item = index++;
        conf.cont = $this;
        that.render(true);
    }

    Page.prototype.view = function (){
        var that = this, conf = that.config, view=[],dict={};
        conf.pages = conf.pages|0; //总页数
        conf.curr = (conf.curr|0) || 1; //当前页
        conf.total = conf.total|0; //总记录条数
        conf.groups = 'groups' in conf ? (conf.groups|0) : 5; //连续显示页数
        if(conf.pages <= 1){
           return "";
        }
        if(conf.groups > conf.pages){
            conf.groups = conf.pages;
        }
        //计算当前组,按groups数 进行分组，如groups = 5 那么 就是每5页一组，index 表示 当前页在组里面
        dict.index = Math.ceil((conf.curr + ((conf.groups > 1 && conf.groups !== conf.pages) ? 1 : 0))/(conf.groups === 0 ? 1 : conf.groups));
        //当前页非首页，则输出上一页
        if(conf.curr > 1){
            view.push('<li class="paginItem"><a href="javascript:;" data-page="'+ (conf.curr - 1) +'"><span class="pagepre"></span></a></li>');
        }
        // 当前组非首组，则输出首页
        if(dict.index > 1 && conf.groups !== 0){
            view.push('<li class="paginItem more"><a href="javascript:;">&#x2026;</a></li>');
        }
        //输出当前页组
        dict.poor = Math.floor((conf.groups-1)/2); //计算 groups 中间页到头尾的偏移量，显示奇数页 比较合理和好看
        dict.start = dict.index > 1 ? conf.curr - dict.poor : 1; //计算需要显示的第一个页数
        dict.end = dict.index > 1 ? (function(){
                var max = conf.curr + (conf.groups - dict.poor - 1);
                return max > conf.pages ? conf.pages : max;
            }()) : conf.groups;// 计算显示的最后一个页数,是否为第一组
        if(dict.end - dict.start < conf.groups - 1){ //最后一组状态
            dict.start = dict.end - conf.groups + 1;
        }
        for(; dict.start <= dict.end; dict.start++){
            if(dict.start === conf.curr){
                view.push('<li class="paginItem current"><a href="javascript:;">'+conf.curr+'</a></li>');
            }else{
                view.push('<li class="paginItem"><a href="javascript:;" data-page="'+ dict.start +'">'+ dict.start +'</a></li>');
            }
        }
        //总页数大于连续分页数，且当前组最大页小于总页，输出尾页
        if(conf.pages > conf.groups && dict.end < conf.pages && conf.groups !== 0){
            view.push('<li class="paginItem more"><a href="javascript:;">&#x2026;</a></li>');
        }
        //当前页不为尾页时，输出下一页
        dict.flow = conf.groups > 0;
        if(conf.curr !== conf.pages && dict.flow){
            view.push((function(){
                return (dict.flow && conf.curr === conf.pages)
                    ? '<li class="paginItem"><a href="javascript:;">没有更多了</a></li>'
                    :'<li class="paginItem"><a href="javascript:;" data-page="'+ (conf.curr + 1) +'"><span class="pagenxt"></span></a></li>';
            }()));
        }

        return  '<div class="pagin" id="page-' + conf.item + '">'
                + '<div class="message">共<i class="blue">'+conf.total+'</i>条记录，当前显示第&nbsp;<i class="blue">' + conf.curr + '&nbsp;</i>页</div>'
                + '<ul class="paginList">'
                + view.join('')
                + '</ul>'
                +'</div>';
    }

    Page.prototype.jump = function ($element) {
        if(!$element){
            return ;
        }
        var that = this, conf = that.config;
        $element.find("a").click(function () {
            var $li = $(this).parent();
            if ($li.hasClass("current") || $li.hasClass("more")) {
                return
            } else {
                var curr = $(this).attr("data-page") | 0;
                conf.curr = curr;
                that.render();
            }
        })
    }

    //渲染分页
    Page.prototype.render = function (load){
        var that = this,conf = that.config;
        var view = that.view();
        conf.cont.html(view);
        conf.jump && conf.jump(conf, load);
        that.jump($('#page-' + conf.item));
    }
})(jQuery);

