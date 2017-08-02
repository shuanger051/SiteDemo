"use strict"
;
(function ($){
    var _defaultOpts = {
        tId:"tab",//table id
        url:"",//获取数据URL
        parameter:{}, //数据请求参数
        page:1,
        page_size:10,
        lager_size:10000,
        setting:{}
    }
    /**
     *
     * @param opts
     * @constructor
     */
    var Table = function () {
    }


    Table.prototype.init = function (options) {
        this.opts = $.extend({},_defaultOpts,options);
        this.currDataSize=0;
        this.currPage=1;
        this.pages = 1;
        return this;
    }
    Table.prototype.options = function (parameters, isRest){
        if(isRest){
            this.opts.parameter = parameters || {};
        }else{
            this.opts.parameter = $.extend({},this.opts.parameter,parameters || {});
        }
        //清除分页信息
        this.currPage =1;
        this.currDataSize =0
        //重新渲染表格
        this.render();
    }

    Table.prototype.addItem = function (){
        //最后一页并且 已满
        // if(this.currDataSize == this.opts.page_size && this.currPage == this.pages){
            this.currPage = (this.currDataSize == this.opts.page_size && this.currPage == this.pages) ? this.currPage + 1 : this.currPage;
            this.render();
        // }else if(this.currDataSize < this.opts.page_size){

        // }
    }

    Table.prototype.delItem = function (){
        this.currPage = (this.currPage > 1 && this.currDataSize == 1) ? this.currPage - 1 : this.currPage;
        this.render();
    }

    Table.prototype.render=function () {
        var _that = this;
        Ajax.query(_that.opts.tId + "queryData",{
            url:_that.opts.url,
            type:"get",
            data:$.extend({page:_that.currPage,pageSize:_that.opts.page_size},this.opts.parameter),
            callback:function (result){
                _that.data = result.data;
                _that.currDataSize = result.data.length;
                _that.pages = Math.ceil(result.total/_that.opts.page_size);
                var html = template(_that.opts.tId + "_temp",{list:result.data});
                $("#" + _that.opts.tId).html(html);
                $("#" + _that.opts.tId + '_page').Page($.extend({
                    pages: _that.pages,
                    curr: _that.currPage,
                    total:result.total,
                    pageSize:_that.opts.page_size,
                    jump:function (obj,first) {
                        if(!first){
                            _that.currPage = obj.curr;
                            _that.render();
                        }
                    }
                },_that.opts.setting));
            }
        })
    }
    //获取当前的的数据对象
    Table.prototype.getData = function () {
        return this.data;
    }

    $.Table = Table;
})(jQuery);
