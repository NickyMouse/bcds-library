/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this service wrapper you may modify the generated sub-class of this class - MemberService.as.
 */
package com.alibaba.intl.goldroom.flex.services
{
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper;
import com.adobe.serializers.utility.TypeUtility;
import com.alibaba.intl.goldroom.flex.dataobject.Member;
import mx.collections.ArrayCollection;
import mx.rpc.AbstractOperation;
import mx.rpc.AsyncToken;
import mx.rpc.remoting.Operation;
import mx.rpc.remoting.RemoteObject;

import mx.collections.ItemResponder;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

[ExcludeClass]
internal class _Super_MemberService extends com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper
{      
       
    // Constructor
    public function _Super_MemberService()
    {
        // initialize service control
        _serviceControl = new mx.rpc.remoting.RemoteObject();
        
        var operations:Object = new Object();
        var operation:mx.rpc.remoting.Operation;
         
        operation = new mx.rpc.remoting.Operation(null, "applyMember");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.Member; 		 
        operations["applyMember"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.Member._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "tbdMembers");
		 operation.resultType = Boolean; 		 
        operations["tbdMembers"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "findMemberByLoginId");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.Member; 		 
        operations["findMemberByLoginId"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.Member._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "isLoginIdExist");
		 operation.resultType = Boolean; 		 
        operations["isLoginIdExist"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "changePassword");
		 operation.resultType = Boolean; 		 
        operations["changePassword"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "listMemberByLoginIds");
		 operation.resultElementType = com.alibaba.intl.goldroom.flex.dataobject.Member;
        operations["listMemberByLoginIds"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.Member._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "approveMember");
		 operation.resultType = Boolean; 		 
        operations["approveMember"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "login");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.Member; 		 
        operations["login"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.Member._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "updateMemberByLoginId");
		 operation.resultType = Boolean; 		 
        operations["updateMemberByLoginId"] = operation;

    
        _serviceControl.operations = operations;   
		_serviceControl.convertResultHandler = com.adobe.serializers.utility.TypeUtility.convertResultHandler;
		destination = "memberService";
        
    
                      
         model_internal::initialize();
    }

	/**
	  * This method is a generated wrapper used to call the 'applyMember' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function applyMember(arg0:com.alibaba.intl.goldroom.flex.dataobject.Member) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("applyMember");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'tbdMembers' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function tbdMembers(arg0:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("tbdMembers");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'findMemberByLoginId' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function findMemberByLoginId(arg0:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("findMemberByLoginId");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'isLoginIdExist' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function isLoginIdExist(arg0:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("isLoginIdExist");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'changePassword' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function changePassword(arg0:String, arg1:String, arg2:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("changePassword");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'listMemberByLoginIds' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listMemberByLoginIds(arg0:ArrayCollection) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listMemberByLoginIds");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'approveMember' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function approveMember(arg0:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("approveMember");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'login' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function login(arg0:String, arg1:String) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("login");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'updateMemberByLoginId' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function updateMemberByLoginId(arg0:com.alibaba.intl.goldroom.flex.dataobject.Member) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("updateMemberByLoginId");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
}

}
