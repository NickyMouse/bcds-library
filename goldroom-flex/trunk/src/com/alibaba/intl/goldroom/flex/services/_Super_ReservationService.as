/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this service wrapper you may modify the generated sub-class of this class - ReservationService.as.
 */
package com.alibaba.intl.goldroom.flex.services
{
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper;
import com.adobe.serializers.utility.TypeUtility;
import com.alibaba.intl.goldroom.flex.dataobject.ReservationResult;
import mx.rpc.AbstractOperation;
import mx.rpc.AsyncToken;
import mx.rpc.remoting.Operation;
import mx.rpc.remoting.RemoteObject;

import mx.collections.ItemResponder;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

[ExcludeClass]
internal class _Super_ReservationService extends com.adobe.fiber.services.wrapper.RemoteObjectServiceWrapper
{      
       
    // Constructor
    public function _Super_ReservationService()
    {
        // initialize service control
        _serviceControl = new mx.rpc.remoting.RemoteObject();
        
        var operations:Object = new Object();
        var operation:mx.rpc.remoting.Operation;
         
        operation = new mx.rpc.remoting.Operation(null, "listReservationByBookItemId");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.ReservationResult; 		 
        operations["listReservationByBookItemId"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.ReservationResult._initRemoteClassAlias();
        operation = new mx.rpc.remoting.Operation(null, "reserve");
		 operation.resultType = Boolean; 		 
        operations["reserve"] = operation;

        operation = new mx.rpc.remoting.Operation(null, "listReservatedBooksBySubscriber");
		 operation.resultType = com.alibaba.intl.goldroom.flex.dataobject.ReservationResult; 		 
        operations["listReservatedBooksBySubscriber"] = operation;

        com.alibaba.intl.goldroom.flex.dataobject.ReservationResult._initRemoteClassAlias();
    
        _serviceControl.operations = operations;   
		_serviceControl.convertResultHandler = com.adobe.serializers.utility.TypeUtility.convertResultHandler;
		destination = "reservationService";
        
    
                      
         model_internal::initialize();
    }

	/**
	  * This method is a generated wrapper used to call the 'listReservationByBookItemId' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listReservationByBookItemId(arg0:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listReservationByBookItemId");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'reserve' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function reserve(arg0:String, arg1:int, arg2:Date, arg3:Date) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("reserve");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2,arg3) ;

		return _internal_token;
	}   
	 
	/**
	  * This method is a generated wrapper used to call the 'listReservatedBooksBySubscriber' operation. It returns an mx.rpc.AsyncToken whose 
	  * result property will be populated with the result of the operation when the server response is received. 
	  * To use this result from MXML code, define a CallResponder component and assign its token property to this method's return value. 
	  * You can then bind to CallResponder.lastResult or listen for the CallResponder.result or fault events.
      *
      * @see mx.rpc.AsyncToken
      * @see mx.rpc.CallResponder 
      *
      * @return an mx.rpc.AsyncToken whose result property will be populated with the result of the operation when the server response is received.
	  */          
	public function listReservatedBooksBySubscriber(arg0:String, arg1:int, arg2:int) : mx.rpc.AsyncToken
	{
		var _internal_operation:mx.rpc.AbstractOperation = _serviceControl.getOperation("listReservatedBooksBySubscriber");
		var _internal_token:mx.rpc.AsyncToken = _internal_operation.send(arg0,arg1,arg2) ;

		return _internal_token;
	}   
	 
}

}
