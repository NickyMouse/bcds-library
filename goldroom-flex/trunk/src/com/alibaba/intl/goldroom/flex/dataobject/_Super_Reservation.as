/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - Reservation.as.
 */

package com.alibaba.intl.goldroom.flex.dataobject
{
import com.adobe.fiber.services.IFiberManagingService;
import com.adobe.fiber.valueobjects.IValueObject;
import com.alibaba.intl.goldroom.flex.dataobject.BookItem;
import com.alibaba.intl.goldroom.flex.dataobject.Member;
import flash.events.Event;
import flash.events.EventDispatcher;
import mx.events.PropertyChangeEvent;

import flash.net.registerClassAlias;
import flash.net.getClassByAlias;
import com.adobe.fiber.core.model_internal;
import com.adobe.fiber.valueobjects.IPropertyIterator;
import com.adobe.fiber.valueobjects.AvailablePropertyIterator;

use namespace model_internal;

[ExcludeClass]
public class _Super_Reservation extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void 
    {
        try 
        {
            if (flash.net.getClassByAlias("com.alibaba.intl.goldroom.dataobject.Reservation") == null)
            {
                flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.Reservation", cz);
            } 
        }
        catch (e:Error) 
        {
            flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.Reservation", cz); 
        }
    }   
     
    model_internal static function initRemoteClassAliasAllRelated() : void 
    {
        com.alibaba.intl.goldroom.flex.dataobject.BookItem.initRemoteClassAliasSingleChild();
        com.alibaba.intl.goldroom.flex.dataobject.Member.initRemoteClassAliasSingleChild();
        com.alibaba.intl.goldroom.flex.dataobject.BookInfo.initRemoteClassAliasSingleChild();
    }

	model_internal var _dminternal_model : _ReservationEntityMetadata;

	/**
	 * properties
	 */
	private var _internal_gmtModified : Date;
	private var _internal_id : int;
	private var _internal_bookItem : com.alibaba.intl.goldroom.flex.dataobject.BookItem;
	private var _internal_returnTime : Date;
	private var _internal_gmtCreate : Date;
	private var _internal_lendTime : Date;
	private var _internal_state : String;
	private var _internal_subscriber : com.alibaba.intl.goldroom.flex.dataobject.Member;

    private static var emptyArray:Array = new Array();

    /**
     * derived property cache initialization
     */  
    model_internal var _cacheInitialized_isValid:Boolean = false;   
    
	model_internal var _changeWatcherArray:Array = new Array();   

	public function _Super_Reservation() 
	{	
		_model = new _ReservationEntityMetadata(this);
	
		// Bind to own data properties for cache invalidation triggering  
       
	}

    /**
     * data property getters
     */
	[Bindable(event="propertyChange")] 
    public function get gmtModified() : Date    
    {
            return _internal_gmtModified;
    }    
	[Bindable(event="propertyChange")] 
    public function get id() : int    
    {
            return _internal_id;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookItem() : com.alibaba.intl.goldroom.flex.dataobject.BookItem    
    {
            return _internal_bookItem;
    }    
	[Bindable(event="propertyChange")] 
    public function get returnTime() : Date    
    {
            return _internal_returnTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get gmtCreate() : Date    
    {
            return _internal_gmtCreate;
    }    
	[Bindable(event="propertyChange")] 
    public function get lendTime() : Date    
    {
            return _internal_lendTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get state() : String    
    {
            return _internal_state;
    }    
	[Bindable(event="propertyChange")] 
    public function get subscriber() : com.alibaba.intl.goldroom.flex.dataobject.Member    
    {
            return _internal_subscriber;
    }    

    /**
     * data property setters
     */      
    public function set gmtModified(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:Date = _internal_gmtModified;               
        if (oldValue !== value)
        {
            _internal_gmtModified = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "gmtModified", oldValue, _internal_gmtModified));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set id(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_id;               
        if (oldValue !== value)
        {
            _internal_id = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "id", oldValue, _internal_id));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookItem(value:com.alibaba.intl.goldroom.flex.dataobject.BookItem) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:com.alibaba.intl.goldroom.flex.dataobject.BookItem = _internal_bookItem;               
        if (oldValue !== value)
        {
            _internal_bookItem = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookItem", oldValue, _internal_bookItem));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set returnTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:Date = _internal_returnTime;               
        if (oldValue !== value)
        {
            _internal_returnTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "returnTime", oldValue, _internal_returnTime));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set gmtCreate(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:Date = _internal_gmtCreate;               
        if (oldValue !== value)
        {
            _internal_gmtCreate = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "gmtCreate", oldValue, _internal_gmtCreate));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set lendTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:Date = _internal_lendTime;               
        if (oldValue !== value)
        {
            _internal_lendTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "lendTime", oldValue, _internal_lendTime));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set state(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_state;               
        if (oldValue !== value)
        {
            _internal_state = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "state", oldValue, _internal_state));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set subscriber(value:com.alibaba.intl.goldroom.flex.dataobject.Member) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:com.alibaba.intl.goldroom.flex.dataobject.Member = _internal_subscriber;               
        if (oldValue !== value)
        {
            _internal_subscriber = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "subscriber", oldValue, _internal_subscriber));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    

    /**
     * data property setter listeners
     */   

   model_internal function setterListenerAnyConstraint(value:flash.events.Event):void
   {
        if (model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }        
   }   

    /**
     * valid related derived properties
     */
    model_internal var _isValid : Boolean;
    model_internal var _invalidConstraints:Array = new Array();
    model_internal var _validationFailureMessages:Array = new Array();

    /**
     * derived property calculators
     */

    /**
     * isValid calculator
     */
    model_internal function calculateIsValid():Boolean
    {
        var violatedConsts:Array = new Array();    
        var validationFailureMessages:Array = new Array();    


		var styleValidity:Boolean = true;
	
	
	
	
	
	
	
	
    
        model_internal::_cacheInitialized_isValid = true;
        model_internal::invalidConstraints_der = violatedConsts;
        model_internal::validationFailureMessages_der = validationFailureMessages;
        return violatedConsts.length == 0 && styleValidity;
    }  

    /**
     * derived property setters
     */

    model_internal function set isValid_der(value:Boolean) : void
    {
       	var oldValue:Boolean = model_internal::_isValid;               
        if (oldValue !== value)
        {
        	model_internal::_isValid = value;
        	_model.model_internal::fireChangeEvent("isValid", oldValue, model_internal::_isValid);
        }        
    }

    /**
     * derived property getters
     */

    [Transient] 
	[Bindable(event="propertyChange")] 
    public function get _model() : _ReservationEntityMetadata
    {
		return model_internal::_dminternal_model;              
    }	
    
    public function set _model(value : _ReservationEntityMetadata) : void       
    {
    	var oldValue : _ReservationEntityMetadata = model_internal::_dminternal_model;               
        if (oldValue !== value)
        {
        	model_internal::_dminternal_model = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "_model", oldValue, model_internal::_dminternal_model));
        }     
    }      

    /**
     * methods
     */  


    /**
     *  services
     */                  
     private var _managingService:com.adobe.fiber.services.IFiberManagingService;
    
     public function set managingService(managingService:com.adobe.fiber.services.IFiberManagingService):void
     {
         _managingService = managingService;
     }                      
     
    model_internal function set invalidConstraints_der(value:Array) : void
    {  
     	var oldValue:Array = model_internal::_invalidConstraints;
     	// avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_invalidConstraints = value;   
			_model.model_internal::fireChangeEvent("invalidConstraints", oldValue, model_internal::_invalidConstraints);   
        }     	             
    }             
    
     model_internal function set validationFailureMessages_der(value:Array) : void
    {  
     	var oldValue:Array = model_internal::_validationFailureMessages;
     	// avoid firing the event when old and new value are different empty arrays
        if (oldValue !== value && (oldValue.length > 0 || value.length > 0))
        {
            model_internal::_validationFailureMessages = value;   
			_model.model_internal::fireChangeEvent("validationFailureMessages", oldValue, model_internal::_validationFailureMessages);   
        }     	             
    }        
     
     // Individual isAvailable functions     
	// fields, getters, and setters for primitive representations of complex id properties

}

}
