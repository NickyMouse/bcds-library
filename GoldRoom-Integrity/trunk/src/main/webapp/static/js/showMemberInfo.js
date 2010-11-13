var showMemberInfo = function(loginId) {
	this.callBack = function (data) {
		{
         	if (data != null && typeof data == 'object'){
    			var str="<table style='margin:auto'>";
    			str += "<tr><td style='text-align:right'>" + "姓名：" + "</td><td>" + getIntranetSearchHtml(data.name) + "</td></tr>";

    			if(data.workId) {
    				str += "<tr><td style='text-align:right'>" + "工号：" + "</td><td>" + getIntranetSearchHtml(data.workId) + "</td></tr>";
    			}

    			if(data.ext) {
    				str += "<tr><td style='text-align:right'>" + "分机：" + "</td><td>" + data.ext+ "</td></tr>";
    			}

    			if(data.location) {
    				str += "<tr><td style='text-align:right'>" + "位置：" + "</td><td>" + data.location + "</td></tr>";
    			}

    			if(data.aliTalkId) {
    				str += "<tr><td style='text-align:right'>" + "贸易通：" + "</td><td>" + data.aliTalkId + "&nbsp;&nbsp;" + getAliTalkHtml(data.aliTalkId) + "</td></tr>";
    			}

				if(data.email) {
    				str += "<tr><td style='text-align:right'>" + "Email：" + "</td><td>"+ getEmailHtml(data.email) + "</td></tr>";
    			}

    			str += "</table>";

    			if(typeof(PopUp) == "undefined") {
    				alert("Please include static/js/popup.js")
    			} else {
    				var popUp = new PopUp(1, data.name, 350, 220, false);
					popUp.show(str);
    			}
    		}
		}
	}
	if(typeof(MemberService) == "undefined") {
		alert("Please include /dwr/interface/MemberService.js")
	} else {
		MemberService.findMemberByLoginId(loginId, this.callBack);
	}
}

function getAliTalkHtml(aliTalkId) {
	var source = "<A href='http://web.im.alisoft.com/msg.aw?v=2&amp;uid=" + aliTalkId + "&amp;site=cnalichn&amp;s=1' target=_blank>";
	source += "<IMG border=0 alt='贸易通' src='http://web.im.alisoft.com/online.aw?v=2&amp;uid=" + aliTalkId + "&amp;site=cnalichn&amp;s=1'></A>";
	return source;
}

function getEmailHtml(email) {
	return "<a href='mailto:" + email + "'>" + email +"</a>";
}

function getIntranetSearchHtml(key) {
	return "<a target='_blank' href='https://www.cn.alibaba-inc.com/staffinfo.nsf/Search?SearchView&Query=" + key +"&SearchOrder=4'>" + key + "</a>";
}

