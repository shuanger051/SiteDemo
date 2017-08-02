$.Tipmsg.w.money = "金额数值必须为整数或小数，小数点后不超过2位！";
$.Datatype.money = function(gets, obj, curform, datatype) {
		var v = obj.val();
		return /^\d+\.?\d{0,2}$/.test(v);
}
$.Tipmsg.w.zn = "格式不正确，比例必须为正浮点数！";
$.Datatype.zn = function(gets, obj, curform, datatype) {
		var v = obj.val();
		return /^\d+(\.\d+)?$/.test(v);
}
$.Tipmsg.w.userName = "请填写5到17位";
$.Datatype.userName= function (gets, obj, curform, datatype){
    var v = obj.val();
    return /^[a-zA-Z]\w{5,17}$/.test(v);
}
$.Tipmsg.w.pwd = "6-10位数字、字母、特殊字符";
$.Datatype.pwd = function(gets, obj, curform, datatype) {
	var v = obj.val();
	return  /^(?![^a-zA-Z]+$)(?!\D+$)(?![a-zA-Z0-9]+$).{6,16}$/.test(v);
}

$.Tipmsg.w.stockCode = "请输入正确的证券代码";
$.Datatype.stockCode = function(gets, obj, curform, datatype) {
	var v = obj.val();
	return /^\d{6}$/.test(v);
}
$.Tipmsg.w.warn = "数值必须为整数或小数，小数点后不超过2位！";
$.Datatype.warn = function(gets, obj, curform, datatype) {
	var v = obj.val();
	return /^\d+\.?\d{0,2}$/.test(v);
}
$.Tipmsg.w.ny = "请填写英文、数字、_的字符";
$.Datatype.ny = function (gets, obj, curform, datatype){
    var v = obj.val();
    return /^[\w\d_]+$/.test(v);
}
$.Tipmsg.w["ny6-10"] = "请填写6到10位的英文、数字、_的字符";
$.Datatype["ny6-10"] = function (gets, obj, curform, datatype){
    var v = obj.val();
    return /^[\w\d_]{6,10}$/.test(v);
}
$.Tipmsg.w.zhen = "请填写中文和字母的";
$.Datatype.zhen = function (gets, obj, curform, datatype){
    var v = obj.val();
    return /[\u4e00-\u9fa5a-zA-Z]/.test(v);
}
$.Tipmsg.w["zhen1-10"] = "请填写1到10位的中文和字母字符";
$.Datatype["zhen1-10"] = function (gets, obj, curform, datatype){
    var v = obj.val();
    return /[\u4e00-\u9fa5a-zA-Z]{1,10}/.test(v);
}
$.Tipmsg.w.empty = "请不要填写内容";
$.Datatype.empty = function (gets, obj, curform, datatype){
    var v = obj.val();
    return ""==v;
}
$.Tipmsg.w.url = "请填写准确的URL地址";
$.Datatype.url = function (gets, obj, curform, datatype){
    var v = obj.val();
    var urlRegExp=/(^#{1,}$)|([a-zA-z]+:\/\/[^\s]*)|((\/?[a-zA-Z0-9]*)(\/[a-zA-Z0-9]*)(.[a-zA-Z]*)?)/;
    return urlRegExp.test(v);
}
$.Tipmsg.w.file = "请选择需要上传的文件";
$.Datatype.file = function (gets, obj, curform, datatype) {
    var v = obj.val()
    if (v.length > 1 && v != '') {
        if(v != "请选择需要上传的文件..."){
            var lodt = v.lastIndexOf(".");
            var type = v.substring(lodt + 1);
            if (type != "jpg" && type != "png" && type != "jpeg") {
                $.Tipmsg.w.file = "文件格式只能为：jpg/png/jpeg";
                obj.val("");
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }

    } else {
        return false;
    }
}

$.Tipmsg.w.IdentityCode = "请填写正确的身份证号码";
$.Datatype.IdentityCode = function (code) {
    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
    var pass= true;
    if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
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
    return pass;
}

$.Tipmsg.w.mobile = "请填写正确的手机号码";
$.Datatype.mobile = function (gets, obj, curform, datatype){
    var v = obj.val();
    var urlRegExp = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    return urlRegExp.test(v);
}

$.Tipmsg.w.email = "请填写正确的邮箱地址";
$.Datatype.email = function (gets, obj, curform, datatype){
    var v = obj.val();
    var urlRegExp = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    return urlRegExp.test(v);
}

$.Tipmsg.w.QQ = "请填写正确的QQ号码";
$.Datatype.QQ = function (gets, obj, curform, datatype){
    var v = obj.val();
    var urlRegExp = /^[1-9]\d{4,9}$/;
    return urlRegExp.test(v);
}

$.Tipmsg.w.height = "请填写正确的身高(cm)";
$.Datatype.height = function (gets, obj, curform, datatype){
    var v = obj.val();
    var urlRegExp = /^[1-9]\d{1,2}$/;
    return urlRegExp.test(v);
}

$.Tipmsg.w.num = "数字为（0-99）之间";
$.Datatype.num = function (gets, obj, curform, datatype){
    var v = obj.val();
    var urlRegExp = /^[1-9]\d{0,1}$/;
    return urlRegExp.test(v);
}