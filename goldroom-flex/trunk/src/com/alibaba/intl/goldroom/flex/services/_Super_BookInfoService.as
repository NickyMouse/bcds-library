/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this service wrapper you may modify the generated sub-class of this class - BookInfoService.as.
 */
package com.alibaba.intl.goldroom.flex.services
{
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper;
import com.adobe.serializers.utility.TypeUtility;
import com.alibaba.intl.goldroom.flex.dataobject.BookInfo;
import com.alibaba.intl.goldroom.flex.dataobject.BookSearch;
import com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult;
import mx.collections.ArrayCollection;
import mx.rpc.AbstractOperation;
import mx.rpc.AsyncToken;
import mx.rpc.remoting.Operation;
import mx.rpc.remoting.RemoteObject;

import mx.collections.ItemResponder;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

[ExcludeClass]
internal class _Super_BookInfoService extends com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper
{      
       
    // Constructor
    public function _Super_BookInfoService()
    {
        // initialize service control
        _serviceControl = new mx.rpc.remoting.RemoteObject();
        
        var operations:Object = new Object();
        var operation:mx.rpc.remoting.Operation;
         
        operation = new mx.rpc.remoting.Operation(null, "findBookInfoById");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookInfo; 		 
        operations["findBookInfoById"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookInfo._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "advancedBookSearch");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult; 		 
        operations["advancedBookSearch"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "searchBookByTime");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult; 		 
        operations["searchBookByTime"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "searchBookByInfoId");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookSearch; 		 
        operations["searchBookByInfoId"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookSearch._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "addBookInfo");
		 operation.resultType = Boolean; 		 
        operations["addBookInfo"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "listAllBook");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult; 		 
        operations["listAllBook"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "searchBookByOwnersAndKeyword");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult; 		 
        operations["searchBookByOwnersAndKeyword"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "searchBookByKeyword");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult; 		 
        operations["searchBookByKeyword"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "searchBookByInfoIds");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult; 		 
        operations["searchBookByInfoIds"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookSearchResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "findBookInfoByIsbn");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookInfo; 		 
        operations["findBookInfoByIsbn"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookInfo._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "getBookInfoFromDbAndNetWork");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookInfo; 		 
        operations["getBookInfoFromDbAndNetWork"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookInfo._initRemoteClassAlias();
    
        _serviceControl.operations = operations;   
		_serviceControl.convertResultHandler = com.adobe.serializers.utility.TypeUtility.convertResultHandler;
		destination = "bookInfoService";
        
    
                      
         model_internal::initialize();
    }

	/**
	  * This method is a generated wrapper used to call the 'findBookInfoById' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function findBookInfoById(arg0:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("findBookInfoById");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'advancedBookSearch' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function advancedBookSearch(arg0:String, arg1:String, arg2:String, arg3:String, arg4:String, arg5:int, arg6:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("advancedBookSearch");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2,arg3,arg4,arg5,arg6) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'searchBookByTime' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function searchBookByTime(arg0:Date, arg1:Date, arg2:int, arg3:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("searchBookByTime");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2,arg3) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'searchBookByInfoId' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function searchBookByInfoId(arg0:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("searchBookByInfoId");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'addBookInfo' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function addBookInfo(arg0:com.alibaba.intl.goldroom.flex.dataobject.BookInfo) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("addBookInfo");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'listAllBook' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listAllBook(arg0:int, arg1:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listAllBook");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'searchBookByOwnersAndKeyword' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function searchBookByOwnersAndKeyword(arg0:String, arg1:String, arg2:int, arg3:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("searchBookByOwnersAndKeyword");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2,arg3) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'searchBookByKeyword' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function searchBookByKeyword(arg0:String, arg1:int, arg2:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("searchBookByKeyword");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'searchBookByInfoIds' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function searchBookByInfoIds(arg0:ArrayCollection) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("searchBookByInfoIds");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'findBookInfoByIsbn' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function findBookInfoByIsbn(arg0:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("findBookInfoByIsbn");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'getBookInfoFromDbAndNetWork' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function getBookInfoFromDbAndNetWork(arg0:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("getBookInfoFromDbAndNetWork");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
}

}
