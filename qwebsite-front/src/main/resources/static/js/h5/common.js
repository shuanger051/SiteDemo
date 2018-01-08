//设置字体 
  	!function(e, t) {
	    function i() {
	        var t = n.getBoundingClientRect().width;
	        t / m > 540 && (t = 540 * m);
	        var i = t / 10;
	        n.style.fontSize = i + "px",
	        s.rem = e.rem = i
	    }
	    var a, r = e.document, n = r.documentElement, o = r.querySelector('meta[name="viewport"]'), l = r.querySelector('meta[name="flexible"]'), m = 0, d = 0, s = t.flexible || (t.flexible = {});
	    if (o) {
	        console.warn("将根据已有的meta标签来设置缩放比例");
	        var p = o.getAttribute("content").match(/initial\-scale=([\d\.]+)/);
	        p && (d = parseFloat(p[1]),
	        m = parseInt(1 / d))
	    } else if (l) {
	        var c = l.getAttribute("content");
	        if (c) {
						var u = c.match(/initial\-dpr=([\d\.]+)/)
						  , f = c.match(/maximum\-dpr=([\d\.]+)/);
						u && (m = parseFloat(u[1]),
						d = parseFloat((1 / m).toFixed(2))),
						f && (m = parseFloat(f[1]),
						d = parseFloat((1 / m).toFixed(2)))
	        }
	    }
	    if (!m && !d) {
	        var v = e.navigator.appVersion.match(/android/gi)
	          , h = e.chrome
	          , x = e.navigator.appVersion.match(/iphone|ipad/gi)
	          , b = e.devicePixelRatio
	          , w = (v || x) && h;
	        m = x || w ? b >= 3 && (!m || m >= 3) ? 3 : b >= 2 && (!m || m >= 2) ? 2 : 1 : 1,
	        d = 1 / m
	    }
	    if (n.setAttribute("data-dpr", m),
	    !o)
	        if (o = r.createElement("meta"),
		        o.setAttribute("name", "viewport"),
		        o.setAttribute("content", "initial-scale=" + d + ", maximum-scale=" + d + ", minimum-scale=" + d + ", user-scalable=no"),n.firstElementChild)
								n.firstElementChild.appendChild(o);
	        else {
						var g = r.createElement("div");
						g.appendChild(o),
						r.write(g.innerHTML)
	        }
	    e.addEventListener("resize", function() {
	        clearTimeout(a),
	        a = setTimeout(i, 300)
	    }, !1),
	    e.addEventListener("pageshow", function(e) {
	        e.persisted && (clearTimeout(a),
	        a = setTimeout(i, 300))
	    }, !1),
	    "complete" === r.readyState ? r.body.style.fontSize = 12 * m + "px" : r.addEventListener("DOMContentLoaded", function(e) {
	        r.body.style.fontSize = 12 * m + "px"
	    }, !1),
	    i(),
	    s.dpr = e.dpr = m,
	    s.refreshRem = i,
	    s.rem2px = function(e) {
	        var t = parseFloat(e) * this.rem;
	        return "string" == typeof e && e.match(/rem$/) && (t += "px"),
	        t
	    }
	    ,
	    s.px2rem = function(e) {
	        var t = parseFloat(e) / this.rem;
	        return "string" == typeof e && e.match(/px$/) && (t += "rem"), t
	    }
	}(window, window.lib || (window.lib = {}));
		
		
	;(function($, undefined){
	  var prefix = '', eventPrefix,
	    vendors = { Webkit: 'webkit', Moz: '', O: 'o' },
	    testEl = document.createElement('div'),
	    supportedTransforms = /^((translate|rotate|scale)(X|Y|Z|3d)?|matrix(3d)?|perspective|skew(X|Y)?)$/i,
	    transform,
	    transitionProperty, transitionDuration, transitionTiming, transitionDelay,
	    animationName, animationDuration, animationTiming, animationDelay,
	    cssReset = {}
	
	  function dasherize(str) { return str.replace(/([A-Z])/g, '-$1').toLowerCase() }
	  function normalizeEvent(name) { return eventPrefix ? eventPrefix + name : name.toLowerCase() }
	
	  if (testEl.style.transform === undefined) $.each(vendors, function(vendor, event){
	    if (testEl.style[vendor + 'TransitionProperty'] !== undefined) {
	      prefix = '-' + vendor.toLowerCase() + '-'
	      eventPrefix = event
	      return false
	    }
	  })
	
	  transform = prefix + 'transform'
	  cssReset[transitionProperty = prefix + 'transition-property'] =
	  cssReset[transitionDuration = prefix + 'transition-duration'] =
	  cssReset[transitionDelay    = prefix + 'transition-delay'] =
	  cssReset[transitionTiming   = prefix + 'transition-timing-function'] =
	  cssReset[animationName      = prefix + 'animation-name'] =
	  cssReset[animationDuration  = prefix + 'animation-duration'] =
	  cssReset[animationDelay     = prefix + 'animation-delay'] =
	  cssReset[animationTiming    = prefix + 'animation-timing-function'] = ''
	
	  $.fx = {
	    off: (eventPrefix === undefined && testEl.style.transitionProperty === undefined),
	    speeds: { _default: 400, fast: 200, slow: 600 },
	    cssPrefix: prefix,
	    transitionEnd: normalizeEvent('TransitionEnd'),
	    animationEnd: normalizeEvent('AnimationEnd')
	  }
	
	  $.fn.animate = function(properties, duration, ease, callback, delay){
	    if ($.isFunction(duration))
	      callback = duration, ease = undefined, duration = undefined
	    if ($.isFunction(ease))
	      callback = ease, ease = undefined
	    if ($.isPlainObject(duration))
	      ease = duration.easing, callback = duration.complete, delay = duration.delay, duration = duration.duration
	    if (duration) duration = (typeof duration == 'number' ? duration :
	                    ($.fx.speeds[duration] || $.fx.speeds._default)) / 1000
	    if (delay) delay = parseFloat(delay) / 1000
	    return this.anim(properties, duration, ease, callback, delay)
	  }
	
	  $.fn.anim = function(properties, duration, ease, callback, delay){
	    var key, cssValues = {}, cssProperties, transforms = '',
	        that = this, wrappedCallback, endEvent = $.fx.transitionEnd,
	        fired = false
	
	    if (duration === undefined) duration = $.fx.speeds._default / 1000
	    if (delay === undefined) delay = 0
	    if ($.fx.off) duration = 0
	
	    if (typeof properties == 'string') {
	      // keyframe animation
	      cssValues[animationName] = properties
	      cssValues[animationDuration] = duration + 's'
	      cssValues[animationDelay] = delay + 's'
	      cssValues[animationTiming] = (ease || 'linear')
	      endEvent = $.fx.animationEnd
	    } else {
	      cssProperties = []
	      // CSS transitions
	      for (key in properties)
	        if (supportedTransforms.test(key)) transforms += key + '(' + properties[key] + ') '
	        else cssValues[key] = properties[key], cssProperties.push(dasherize(key))
	
	      if (transforms) cssValues[transform] = transforms, cssProperties.push(transform)
	      if (duration > 0 && typeof properties === 'object') {
	        cssValues[transitionProperty] = cssProperties.join(', ')
	        cssValues[transitionDuration] = duration + 's'
	        cssValues[transitionDelay] = delay + 's'
	        cssValues[transitionTiming] = (ease || 'linear')
	      }
	    }
	
	    wrappedCallback = function(event){
	      if (typeof event !== 'undefined') {
	        if (event.target !== event.currentTarget) return // makes sure the event didn't bubble from "below"
	        $(event.target).unbind(endEvent, wrappedCallback)
	      } else
	        $(this).unbind(endEvent, wrappedCallback) // triggered by setTimeout
	
	      fired = true
	      $(this).css(cssReset)
	      callback && callback.call(this)
	    }
	    if (duration > 0){
	      this.bind(endEvent, wrappedCallback)
	      // transitionEnd is not always firing on older Android phones
	      // so make sure it gets fired
	      setTimeout(function(){
	        if (fired) return
	        wrappedCallback.call(that)
	      }, ((duration + delay) * 1000) + 25)
	    }
	
	    // trigger page reflow so new elements can animate
	    this.size() && this.get(0).clientLeft
	
	    this.css(cssValues)
	
	    if (duration <= 0) setTimeout(function() {
	      that.each(function(){ wrappedCallback.call(this) })
	    }, 0)
	
	    return this
	  }
	
	  testEl = null
	})(Zepto);
	
	;(function($, undefined){
		  var document = window.document, docElem = document.documentElement,
		    origShow = $.fn.show, origHide = $.fn.hide, origToggle = $.fn.toggle
		
		  function anim(el, speed, opacity, scale, callback) {
		    if (typeof speed == 'function' && !callback) callback = speed, speed = undefined
		    var props = { opacity: opacity }
		    if (scale) {
		      props.scale = scale
		      el.css($.fx.cssPrefix + 'transform-origin', '0 0')
		    }
		    return el.animate(props, speed, null, callback)
		  }		
		  function hide(el, speed, scale, callback) {
		    return anim(el, speed, 0, scale, function(){
		      origHide.call($(this))
		      callback && callback.call(this)
		    })
		  }

		
		  $.fn.fadeTo = function(speed, opacity, callback) {
		    return anim(this, speed, opacity, null, callback)
		  }		
		  $.fn.fadeIn = function(speed, callback) {
		    var target = this.css('opacity')
		    if (target > 0) this.css('opacity', 0)
		    else target = 1
		    return origShow.call(this).fadeTo(speed, target, callback)
		  }
		
		  $.fn.fadeOut = function(speed, callback) {
		    return hide(this, speed, null, callback)
		  }
		
		})(Zepto);		
			
  		
  		//去除error
  		$('.TR-input').on('focus', function() {
  			if($(this).hasClass('error')) {
				$(this).removeClass('error');
				if($(this)[0].nodeName.toLowerCase() == 'input') {
					$(this).val('');
				}
				
  			}
  		})
  		
  		//简单验证
  		$.Validate = {
  			isAllTrue: true,
			valid:function(){},
  			init: function(valid) {
  				this.valid = valid;
  			},
			check:function (){
                this.isAllTrue = true;
                this.isEmpty();
                if(!!this.isAllTrue) {
                    this.valid();
                }
                return this.isAllTrue;
			},
  			isEmpty: function() {
				var that = this;
  					$('.TR-input').forEach(function(value,idx) {
                        var elm = value, val;
                        if(!$(value).attr("ignore")){ // 忽略
                            if($(elm)[0].nodeName.toLowerCase() == 'input' || $(elm)[0].nodeName.toLowerCase() == 'textarea') {
                                val = $(elm).val();
                            } else {
                                val = $(elm).text();
                            }
                            if(val.trim() == '' || val.trim() == '选择组别') {
                                $(elm).val($(elm).attr("placeholder")).addClass('error');
                                that.isAllTrue = false;
                            }
                        }
  					});		
  			},
  			telValid: function(elm) {
  				if(!(/^((1[3|5|8|7][0-9]{1})+\d{8})$/.test(elm.val()))) {
  					elm.val(elm.attr("errormsg")).addClass('error');
  					this.isAllTrue = false;
  				}
  			},
            nameValid:function (elm){
                if(!(/[\u4e00-\u9fa5a-zA-Z]/.test(elm.val()))) {
                    elm.val(elm.attr("errormsg")).addClass('error');
                    this.isAllTrue = false;
                }
			},
  			emailValid: function(elm) {
  				if(!(/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(elm.val()))) {
  					elm.val(elm.attr("errormsg")).addClass('error');
  					this.isAllTrue = false;
  				}
  			},
			heightValid:function (elm){
                if(!(/^[1-9]\d{1,2}$/.test(elm.val()))) {
                    elm.val(elm.attr("errormsg")).addClass('error');
                    this.isAllTrue = false;
                }
			},
			qqValid:function (elm){
                if(elm.val() !== "" && !(/^[1-9]\d{4,9}$/.test(elm.val()))) {
                    elm.val(elm.attr("errormsg")).addClass('error');
                    this.isAllTrue = false;
                }
			},
			identityValid:function (elm){
  				var code = elm.val();
                var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
                var pass= true;
                if(!code || !/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/i.test(code)){
                    pass = false;
                }else if(!city[code.substr(0,2)]){
                    pass = false;
                }else{
                    //18位身份证需要验证最后一位校验位
                    if(code.length == 18){
                        code = code.split('');
                        //∑(ai×Wi)(mod 11)
                        //加权因子
                        var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                        //校验位
                        var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                        var sum = 0;
                        var ai = 0;
                        var wi = 0;
                        for (var i = 0; i < 17; i++){
                            ai = code[i];
                            wi = factor[i];
                            sum += ai * wi;
                        }
                        var last = parity[sum % 11];
                        if(parity[sum % 11] != code[17]){
                            pass =false;
                        }
                    }
                }
                if(!pass){
                    elm.val(elm.attr("errormsg")).addClass('error');
                    this.isAllTrue = pass;
				}
			}
  		};

	$.Tool = {
		dateFormat :function (date,format){
            if(!date){
                return null;
            }
            var format = format || "yyyy-MM-dd";
            var date = new Date(date);
            var map = {
                "M": date.getMonth() + 1, //月份
                "d": date.getDate(), //日
                "h": date.getHours(), //小时
                "m": date.getMinutes(), //分
                "s": date.getSeconds(), //秒
                "q": Math.floor((date.getMonth() + 3) / 3), //季度
                "S": date.getMilliseconds() //毫秒
            };

            format = format.replace(/([yMdhmsqS])+/g, function(all, t){
                var v = map[t];
                if (v !== undefined) {
                    if (all.length > 1) {
                        v = '0' + v;
                        v = v.substr(v.length - 2);
                    }
                    return v;
                }
                else if (t === 'y') {
                    return (date.getFullYear() + '').substr(4 - all.length);
                }
                return all;
            });
            return format;
        },
        getReqP:function(pname){
            var reg = new RegExp("(^|&)" + pname + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null){
                return decodeURIComponent(r[2]);
            }
            return null;
        },
        getTitle:function(title){
            if(!!title){
                return title.length > 13? title.substring(0,13) + "..." : title;
            }
            return "无标题";
        },
        serializeJson:function ($form){
            var result={};
            $.each($form.serializeArray(),function (){
                if($.trim(this.value) !== ""){
                    result[this.name] = this.value;
                }
            })
            return result;
		}
    }