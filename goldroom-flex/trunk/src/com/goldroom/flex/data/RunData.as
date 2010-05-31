package com.goldroom.flex.data
{
	import flash.utils.Dictionary;
	import com.goldroom.dataobject.Member;
	public class RunData
	{
		private static var rundata:RunData;
		private var data:Dictionary ;
		
		public function RunData()
		{
			data = new Dictionary();
		}
				
		
		public static function getRunData(): RunData{
			if(rundata == null){
				rundata = new RunData();
			}
			return rundata;
		}
		 
		public function getData(key:String):Object{
			return data[key];
		}
		
		public function putData(key:String, value:Object):Boolean {
			if(data.hasOwnProperty(key)){
				data[key] = value;
				return true;
			} else {
				data[key] = value;
				return false;
			}
		}
		
		public function getStringData(key:String):String{
			return String(data[key]);
		}
		
		public function getLoginUser() : Member{
			return Member(data["loginUser"]);
		}
		
		public function getPageSize() : int{
			return int(data["pageSize"]);
		}
	}
}