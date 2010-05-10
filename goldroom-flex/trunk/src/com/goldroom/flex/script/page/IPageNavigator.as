package com.goldroom.flex.script.page
{
	public interface IPageNavigator
	{
		function turnToPage(page:int):void;
		
		function getCurrentPage():int;
		
		function getTotalCount():int;
	}
}