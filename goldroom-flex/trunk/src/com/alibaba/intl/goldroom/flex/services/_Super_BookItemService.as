/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this service wrapper you may modify the generated sub-class of this class - BookItemService.as.
 */
package com.alibaba.intl.goldroom.flex.services
{
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper;
import com.adobe.serializers.utility.TypeUtility;
import com.alibaba.intl.goldroom.flex.dataobject.BookItem;
import com.alibaba.intl.goldroom.flex.dataobject.BookItemResult;
import mx.collections.ArrayCollection;
import mx.rpc.AbstractOperation;
import mx.rpc.AsyncToken;
import mx.rpc.remoting.Operation;
import mx.rpc.remoting.RemoteObject;

import mx.collections.ItemResponder;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

[ExcludeClass]
internal class _Super_BookItemService extends com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper
{      
       
    // Constructor
    public function _Super_BookItemService()
    {
        // initialize service control
        _serviceControl = new mx.rpc.remoting.RemoteObject();
        
        var operations:Object = new Object();
        var operation:mx.rpc.remoting.Operation;
         
        operation = new mx.rpc.remoting.Operation(null, "listBookItemsByLoginIdsAndBookInfoId");
		 operation.resultElementType = com.alibaba.intl.goldroom.flex.dataobject.BookItem;
        operations["listBookItemsByLoginIdsAndBookInfoId"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookItem._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "getBookDetailByIdAndOwner");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookItem; 		 
        operations["getBookDetailByIdAndOwner"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookItem._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "listBookItemsByLoginIdAndStateAndBookInfoIds");
		 operation.resultElementType = com.alibaba.intl.goldroom.flex.dataobject.BookItem;
        operations["listBookItemsByLoginIdAndStateAndBookInfoIds"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookItem._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "offShelves");
		 operation.resultType = Boolean; 		 
        operations["offShelves"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "reputOnShelves");
		 operation.resultType = Boolean; 		 
        operations["reputOnShelves"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "addBookItem");
        operations["addBookItem"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "deleteBookItem");
		 operation.resultType = Boolean; 		 
        operations["deleteBookItem"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "listBookItemsByLoginIdAndState");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.BookItemResult; 		 
        operations["listBookItemsByLoginIdAndState"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookItemResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "listBookItemByBookInfoId");
		 operation.resultElementType = com.alibaba.intl.goldroom.flex.dataobject.BookItem;
        operations["listBookItemByBookInfoId"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.BookItem._initRemoteClassAlias();
    
        _serviceControl.operations = operations;   
		_serviceControl.convertResultHandler = com.adobe.serializers.utility.TypeUtility.convertResultHandler;
		destination = "bookItemService";
        
    
                      
         model_internal::initialize();
    }

	/**
	  * This method is a generated wrapper used to call the 'listBookItemsByLoginIdsAndBookInfoId' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listBookItemsByLoginIdsAndBookInfoId(arg0:ArrayCollection, arg1:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listBookItemsByLoginIdsAndBookInfoId");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'getBookDetailByIdAndOwner' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function getBookDetailByIdAndOwner(arg0:String, arg1:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("getBookDetailByIdAndOwner");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'listBookItemsByLoginIdAndStateAndBookInfoIds' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listBookItemsByLoginIdAndStateAndBookInfoIds(arg0:String, arg1:String, arg2:ArrayCollection) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listBookItemsByLoginIdAndStateAndBookInfoIds");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'offShelves' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function offShelves(arg0:int, arg1:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("offShelves");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'reputOnShelves' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function reputOnShelves(arg0:int, arg1:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("reputOnShelves");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'addBookItem' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function addBookItem(arg0:com.alibaba.intl.goldroom.flex.dataobject.BookItem) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("addBookItem");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'deleteBookItem' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function deleteBookItem(arg0:int, arg1:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("deleteBookItem");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'listBookItemsByLoginIdAndState' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listBookItemsByLoginIdAndState(arg0:String, arg1:String, arg2:int, arg3:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listBookItemsByLoginIdAndState");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2,arg3) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'listBookItemByBookInfoId' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listBookItemByBookInfoId(arg0:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listBookItemByBookInfoId");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
}

}
