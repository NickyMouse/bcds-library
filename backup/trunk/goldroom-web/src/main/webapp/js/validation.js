// 字符串两边去空
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
// 校验密码
String.prototype.isLegalPassword = function() {
	if (this.match(/[\u4e00-\u9fa5]/g) != null) { //密码不能含有汉字
		return false;
	}
	else if(this.match(/\s/g) != null) { //密码不能含有空格
		return false;
	}
	else {
		return true;
	}
}
// 校验工号
String.prototype.isLegalWorkId = function() {
	if (this.match(/[^0-9]/g) != null) { // 工号只能为数值型
		return false;
	}
	else {
		return true;
	}
}