jQuery(function () {
	var wws = "";//本页面中 所有a标签且id为wangwang的data-username属性
	var wwSrc  = "http://amos.im.alisoft.com/msg.aw?v=2&site=cnalichn&s=1&uid=";//旺旺聊天窗口的链接，后面得拼上旺旺ID号
	var httpUrl = "$base/book/search!findWangWangSocket2.do";//黄金屋系统里请求旺旺在线状态的URL，接收参数为wws，多个旺旺ID用,号分开
	
	//遍历本页ID为wangwang的a标签，并把data-username属性里的值放入wws中
	jQuery("a#wangwang").each(function(ind){
		if(jQuery(this).attr("data-username") == ''){
			jQuery(this).parents("span").html('<a style="background:white" target="_blank" href="https://www.cn.alibaba-inc.com/staffinfo.nsf/Search?SearchView&Query='+jQuery(this).attr("data-displayName")+'&SearchOrder=4" title="去内网查['+jQuery(this).attr("data-displayName")+']">'+jQuery(this).attr("data-displayName")+'</a>');
		}else{
			wws = wws + "," + jQuery(this).attr("data-username");
		}
	});
	
	//调用系统URL批量查询旺旺状态
	jQuery.getJSON(httpUrl,{"wws":wws,"log":"no"},function(data, status){
		var json = eval(data);//将返回的字符串转成json对象
		jQuery.each( json, function(na, st){//循环处理每个json对象
		  jQuery("a[data-username="+na+"]").each(function(){//获取页面中带data-username=xx属性的对象,即对应的旺旺标签
		  	var obj = jQuery(this);
		  	obj.attr("href",wwSrc + na);//设置对应a标签的href属性为旺旺窗口链接
		  	if('y' != st){
				obj.removeClass("nodisplay");
				obj.addClass("ww-offline");
				jQuery("span#loading-"+na).addClass("nodisplay")
			}else{
				obj.removeClass("nodisplay");
				obj.addClass("ww-online");
				jQuery("span#loading-"+na).addClass("nodisplay")
			}
		  });
		}); 
	});
});
