/*
 * @parameters
 * 		id (String): the id of the popup window
 * 		title (String): the title of the popup window
 * 		width (Number): the width of the popup window
 * 		height (Number): the height of the popup window
 * 		bgDark (Boolean): if the background of the popup window is dark
 *		hideCallback (Function): after the popup window is hide, this function will be called
 * @author
 * 		gangyi.xiaogy
 *
 * @usage:
 * 		var popUp = new PopUp("id", "title", 350, 250, false);
 *		popUp.show("content");
 */
function PopUp(id, title, width, height, bgDark, hideCallback){
	_self = this;
	this.id = id;
	this.width = (width > 0)? width: 350;
	this.height = (height > 0)? height: 250;
	this.title = title;
	this.allDark = bgDark;
	this.left = (jQuery(window).width() - this.width) / 2;
	this.top = jQuery(document).scrollTop() + (jQuery(window).height() - this.height) / 2;
	this.hideCallbackEnable = true;
	if(typeof(hideCallback) == "function"){
		this.hideCallback = hideCallback;
	} else {
		this.hideCallback = null;
	}
	if(bgDark) {
    	var bgStyle = "position:absolute; display:none; height:" + jQuery(document).height() +"px; width:" + jQuery(document).width() +"px; left: 0px; top: 0px; z-index: 8888";
	} else {
		var bgStyle = "position:absolute; display:none; left:" + (this.left - 10) + "px; top: " + (this.top - 10) + "px; height: " + (this.height + 40) + "px; width: " + (this.width + 40) + "px; z-index: 8888";
	}
	var contentStyle = "position:absolute; display:none; left:" + this.left + "px; top: " + this.top + "px; height: " + this.height + "px; width: " + this.width + "px; padding:10px; visibility: visible; z-index: 9999";

	var text = "<div style='clear:both' id='pop_win_clear" + id + "'></div>";
	text += "<div class='pop_win_bg' id='pop_win_bg" + id + "' style='" + bgStyle + "'></div>";
	text += "<div class='pop_win' id='pop_win" + id + "' style='" + contentStyle + "'>";
	text += "<a class='pop_win_close' id='pop_win_close" + id + "'>X</a>";
	text += "<h2>" + title + "</h2>";
	text += "<div id='pop_win_content" + id + "' style='width: " + this.width +"px; border-top: 1px dashed rgb(204, 204, 204); padding-top: 5px; height:" + (this.height - 40) +"'></div></div>";


	jQuery("body").append(jQuery(text));

	jQuery("#pop_win_close" + id).click(
			function() {
				jQuery("#pop_win" + _self.id).hide();
				jQuery("#pop_win_bg" + _self.id).hide();
				jQuery("#pop_win" + _self.id).remove();
				jQuery("#pop_win_bg" + _self.id).remove();
				jQuery("#pop_win_content" + _self.id).remove();
				jQuery("#pop_win_clear" + _self.id).remove();
				if(_self.hideCallbackEnable && _self.hideCallback){
					hideCallback();
				}
			}
	);

	this.hide = function () {
		jQuery("#pop_win" + _self.id).hide();
		jQuery("#pop_win_bg" + _self.id).hide();
		jQuery("#pop_win" + _self.id).remove();
		jQuery("#pop_win_bg" + _self.id).remove();
		jQuery("#pop_win_content" + _self.id).remove();
		jQuery("#pop_win_clear" + _self.id).remove();
	};

	this.show = function (innerHTML) {
		jQuery("#pop_win_content" + _self.id).html(innerHTML);
		jQuery("#pop_win" + _self.id).show();
		jQuery("#pop_win_bg" + _self.id).show();
	};

	this.content = function (innerHTML) {
		jQuery("#pop_win_content" + _self.id).html(innerHTML);
	}

	this.callbackEnable = function (isEnable) {
		_self.hideCallbackEnable = isEnable;
	}
}
