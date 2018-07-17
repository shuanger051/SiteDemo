/**
 * Created by xuebj on 2017/1/17.
 */
    var Tool = {
        getReqP:function(pname){
            var reg = new RegExp("(^|&)" + pname + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null){
                return decodeURIComponent(r[2]);
            }
            return null;
        },
        replace:function(str,p){
            return str.replace(/'/g,"\\'").replace(/"/g,'\\"');
        },
        layer_show:function (opts){
            return layer.open($.extend({
                type: 2,
                shade: 0.4,
                area: ['500px','400px'],
                maxmin: true,
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    layer.setTop(layero); //重点2
                }
            },opts||{}));
        },
        layer_full_screen:function (opts){//弹出即全屏
            var index= layer.open($.extend({
                    title:false,
                    closeBtn:false,
                    type: 2,
                    area: ['0px', '0px'],
                    zIndex: layer.zIndex, //重点1,
                    success: function(layero){
                        layer.setTop(layero); //重点2
                    }
            },opts||{}));
            layer.full(index);
            return index;

        },
        layer_alert:function (msg,callback,opts){
            return layer.msg(msg,$.extend({time:5000,shade:0.01},opts||{}),callback);
        },
        layer_confirm:function (msg,callback){
            return layer.confirm(msg, {
                title:"请确认",
                closeBtn:false,
                btn: ['确定',"取消"], //按钮
                icon:3
            }, function(){
                callback();
            });
        },
        layer_show_loading:function (){
            return layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
            });
        },
        layer_close:function (index) {
            layer.close(index);
        },
        go_back:function(){
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        },
        set_form_data:function ($form,data){
            var that = this;
            $.each(data,function (name,value){
                var o_value = value;
                value = that.htmlDecode(value);//转码显示
                var nodes = $form.find("[name='" + name + "']");
                if(nodes.size() > 0){
                    var tagName = nodes[0].tagName.toLocaleLowerCase();
                    if("input" == tagName){
                        var tagType = nodes.attr("type").toLocaleLowerCase();
                        if("radio" == tagType){
                            $form.find("input[name='" + name + "'][value='" + value + "']")[0].checked=true;
                        }else if("checkbox" == tagType){
                            $form.find("input[name='" + name + "']").each(function(){
                                this.checked = false;
                                if(this.value == value){
                                    this.checked = true;
                                }
                            })
                        }else{
                            nodes.val(value);
                        }
                    }else if("textarea" == tagName){
                        nodes.text(!!value? value :"");
                    }else if("select" == tagName){
                        // // var selectLength = $form.find("select[name='" + name + "']")[0].length;
                        // for(var i = 0;i<selectLength;i++){
                            var options = $form.find("select[name='" + name + "'] option[value='"+value+"']");
                            if(options.size() > 0){
                                options[0].selected = true;
                            }
                        // }
                    } else if("img" == tagName){
                        $form.find("img[name='" + name + "']")[0].src =  value;
                    }
                    return true;
                }

            });
        },
        dateFormat:function (date,format){
            if(!date){
                return null;
            }
            var format = format || "yyyy-MM-dd hh:mm:ss";
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
        check_radio:function (tipMsg,callback){
            var itemsFlag = false;//未被选中
            $("input:radio[name='roleRadio']").each(function () {
                if ($(this).is(':checked')) {
                    itemsFlag = true;
                    callback($(this));
                    return false;
                }
            });
            if (!itemsFlag) {
                this.layer_alert(tipMsg,null,{icon:5});
            }
        },
        /*2.用正则表达式实现html解码*/
        htmlDecode:function (str){
            if(typeof str == 'string' ){
                var s = "";
                if(str.length == 0) return "";
                s = str.replace(/&amp;/g,"&");
                s = s.replace(/&lt;/g,"<");
                s = s.replace(/&gt;/g,">");
                s = s.replace(/&nbsp;/g," ");
                s = s.replace(/&#39;/g,"\'");
                s = s.replace(/&quot;/g,"\"");
                return s;
            }
            return str;
        },
        serializeJson:function ($form){
            var result={};
            $.each($form.serializeArray(),function (){
                if($.trim(this.value) !== ""){
                    result[this.name] = this.value;
                }
            })
            return result;
        },
        serialze:function ($form) {
            var parameters= new Array();
            $.each($form.serialize().split("&"),function (){
                if(this.indexOf("=") !== (this.length - 1)){
                    parameters.push(this);
                }
            });
            return parameters.join("&");
        },
        initFileUpload:function (opts) {
            var defaultOpts = {
                dragDrop: false,
                autoSubmit: "false",  //取消自动上传
                maxFileSize: 1024 * 1024 * 5, //大小限制5M
                sizeErrorStr: "上传文件不能大于5M",
                returnType: "json",
                uploadStr: "上传",
                // maxFileCount:1,
                showStatusAfterSuccess: false,
                showProgress: false,
                headers:{accept:"application/json"},
                extErrorStr:"格式错误，只允许:",
                uploadErrorStr:"上传文件失败",
                sizeErrorStr:"文件过大，最大:",
                maxFileCountErrorStr:"上传文件过多，最大文件数:"
            }
            opts.url = path + opts.url + "?isAjax=true&_="+Math.random();
            $("#" + opts.id).uploadFile($.extend({}, defaultOpts, opts));
        },
        getMusicType:function (){
            return [
                "mp3", "wave", "wma", "wav", "asf",
                "aac", "flac","ogg","mp3pro","rm","real","midi"
            ];
        },
        getVedioType:function () {
            return [
                "flv", "swf", "mkv", "avi", "rm", "rmvb", "mpeg", "mpg",
                "ogg", "ogv", "mov", "wmv", "mp4", "webm", "mp3", "wav", "mid"];
        },
        getFileType:function () {
            return  [
                "png", "jpg", "jpeg", "gif", "bmp",
                "flv", "swf", "mkv", "avi", "rm", "rmvb", "mpeg", "mpg",
                "ogg", "ogv", "mov", "wmv", "mp4", "webm", "mp3", "wav", "mid",
                "rar", "zip", "tar", "gz", "7z", "bz2", "cab", "iso",
                "doc", "docx", "xls", "xlsx", "ppt", "pptx", "pdf", "txt", "md", "xml"
            ];
        },
        getImgType:function (){
            return ["png", "jpg", "jpeg", "gif", "bmp"];
        },
        getDanceBookType:function (){
            return ["pdf","doc","docx","txt"];
        },
        clickTr:function (event,obj) {
            var currentTr = $(obj);
            currentTr.parent().find("tr").removeAttr("style");
            currentTr.css({background:"#62B593"});
        },
        indexOfItem:function(needle,array){
            var index = -1;
            if (typeof needle == "string" || typeof needle == "number") {
                for (var i in array) {
                    if (needle === array[i]) {
                        index = i;
                    }
                }
            }
            return index;
        }
    };
