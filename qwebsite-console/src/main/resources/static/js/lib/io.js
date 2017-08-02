"use strict"
;
var Ajax = function () {
    /**
     *  内部默认参数
     **/
    var _default = {
        ajax_params: {
            type: "POST",
            dataType: "json",
            async: true,
            crossDomain: true,
            timeout: 5000,
            success: function (result) {
                console.info(result);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                // 通常 textStatus 和 errorThrown 之中
                // 只有一个会包含信息
                // this; // 调用本次AJAX请求时传递的options参数
                // console.error(textStatus);
            },
            sendBefore: function (XMLHttpRequest) {
            },
            complete: function (XMLHttpRequest, textStatus) {
            }//不管成功失败都会调用
        }
    };
    /**
     * 合并之后的全局配置
     **/
    var _global_options = $.extend({
        failure: function (data) {//默认错误显示方式
            //console.info(data.message);
            Tool.layer_alert(data.message, null, {icon: 5});
        },
        path: "",//默认全局路径,一般不用配置,使用相对路径即可
    }, _default.ajax_params);
    /**
     * ajax 请求映射表
     * @type {{submit: {}, query: {}}}
     * @private
     */
    var _mappings = {
        submit: {},//提交类ajax 请求映射临时保存对象
        query: {}//查询类ajax 请求映射临时保存对象
    };

    return {
        /*
         * 全局配置ajax 参数
         * */
        config: function (options) {
            _global_options = $.extend(_global_options, options || {});
        },
        //提交类ajax，对同一个ajax进行二次控制
        /**
         * name {String}    此ajax 名称
         * options {Json}   参数,见_ajax 参数说明
         * callback {json}  表示请求开始和结束时的回调函数，和ajax的beforeSend 和 complete对应， 一般用于控制样式操作
         *{
             *       before 发送之前方法,用于加载loading等
             *       after  完成之后的方法，用于去掉loading等
             *   }
         */
        submit: function (name, options, callback) {
            var index;
            if (_canBuild(name, _mappings.submit)) {
                _modifyMapping(name, _mappings.submit, 1);
            } else {
                return;
            }
            var opts = $.extend({}, _global_options, options || {});
            opts.sendBefore = function (xhr) {
                if (!!callback && callback.before) {
                    callback.before(xhr);
                }
                // index = tools.layer_show_loading();
            }
            opts.complete = function (xhr, textStatus) {
                if (!!callback && !!callback.after) {
                    callback.after(xhr, textStatus);
                }
                // tools.layer_close(index);
                _modifyMapping(name, _mappings.submit, 0);
            }
            opts.success = function (result) {
                _buildSuccess(opts.callback, opts.failure)(result);
            }
            opts.error = _buildFailure(opts.failure);
            //真正调用Ajax
            _ajax(opts);

        },
        //查询类ajax，增加二次请求控制，网络不稳定时，防止第一次请求结果覆盖第二次请求结果（第二次Ajax比第一次先返回）
        query: function (name, options) {
            var time = new Date().getTime();
            _mappings.query[name] = time;
            var opts = $.extend({}, _global_options, options || {});
            opts["type"] = "GET";
            opts.success = function (result) {
                if (_mappings.query[name] === time) {//时间相同才处理
                    _buildSuccess(opts.callback, opts.failure)(result);
                }
            }
            opts.error = function (XMLHttpRequest, textStatus, errorThrown) {
                if (_mappings.query[name] === time) {
                    _buildFailure(opts.failure)(XMLHttpRequest, textStatus, errorThrown);
                }
            }
            _ajax(opts);
        }
    }

    /**
     * 内部ajax最原始的方法
     *1、url:         请求地址，对同域的应该使用相对地址，对跨域的使用绝对地址
     *2、type:        请求地址，默认post类型
     *3、dataType:    数据格式，默认使用json 表示数据库返回的数据格式
     *4、data：       需要发送到服务端的数据，json格式
     *5、async:       是否异步请求，默认为true表示异步
     *6、crossDomain: 是否是跨域请求，默认为false,全局配置，看项目情况
     *7、callback:    成功之后的回调函数
     *8、failure:     失败之后的回调函数
     *9、sendBefor:   发送之前的方法
     *10、complete:   完成之后调用的方法 不管成功还是失败
     *11、timeout:    默认超时时间
     *
     *
     **/

    function _ajax(p) {
        if (p.url.indexOf("http://") == -1 || p.url.indexOf("https://") == -1) {//绝对路径
            p.url = p.path  + p.url;
        }
        _addRandomNum2Url(p);//增加随机数
        $.ajax(p);
    }

    function _addRandomNum2Url(opts) {
        if (opts.type.toLowerCase() == "get") {
            opts.data = $.extend(opts.data || {}, {"_r": Math.random()});
        } else {
            if(!!opts.data["_method"]){
                opts.data = $.extend(opts.data || {}, {"isAjax": "true"});
            }
            opts.url = opts.url + "?_r=" + Math.random();
        }
    }

    /**
     * 1、判断是否可以构建ajax 请求
     **/
    function _canBuild(name, mappings) {
        var count = mappings[name];
        return !count;//undefined,null 0 可以构建
    }

    /**
     * 修改映射文件
     * type {number} 1:表示构建请求，0:表示重置请求（请求完成时候重置状态）
     **/
    function _modifyMapping(name, mappings, type) {
        mappings[name] = type;
    }

    /**
     *  构建成功函数,ajax返回标准格式{success:true,data{}}
     *  param callback {function}   真正回调函数
     **/
    function _buildSuccess(callback, failure) {
        return function (result) {
            if (result.success) {
                if (callback) {
                    callback(result.data);
                }
            } else {
                if (failure) {
                    failure(result.data);
                }
            }
        }
    }

    /**
     * 构建错误处理函数
     **/
    function _buildFailure(failure) {
        return function (XMLHttpRequest, textStatus, errorThrown) {
            if (!!XMLHttpRequest.responseText) {
                failure($.parseJSON(XMLHttpRequest.responseText).data);
            } else {
                failure({
                    "message": textStatus,
                    "code": "SYS-01"//Ajax请求错误,后台未返回任何信息,如超时等
                });
            }
        }
    }
}();
