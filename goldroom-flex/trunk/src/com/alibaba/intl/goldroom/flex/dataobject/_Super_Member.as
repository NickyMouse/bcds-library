/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - Member.as.
 */

package com.alibaba.intl.goldroom.flex.dataobject
{
import com.adobe.fiber.services.IFiberManagingService;
import com.adobe.fiber.valueobjects.IValueObject;
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
public class _Super_Member extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void 
    {
        try 
        {
            if (flash.net.getClassByAlias("com.alibaba.intl.goldroom.dataobject.Member") == null)
            {
                flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.Member", cz);
            } 
        }
        catch (e:Error) 
        {
            flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.Member", cz); 
        }
    }   
     
    model_internal static function initRemoteClassAliasAllRelated() : void 
    {
    }

	model_internal var _dminternal_model : _MemberEntityMetadata;

	/**
	 * properties
	 */
	private var _internal_gmtModified : Date;
	private var _internal_loginId : String;
	private var _internal_gmtCreate : Date;
	private var _internal_location : String;
	private var _internal_enable : int;
	private var _internal_password : String;
	private var _internal_ext : String;
	private var _internal_id : int;
	private var _internal_aliTalkId : String;
	private var _internal_email : String;
	private var _internal_name : String;
	private var _internal_role : String;
	private var _internal_workId : int;

    private static var emptyArray:Array = new Array();

    /**
     * derived property cache initialization
     */  
    model_internal var _cacheInitialized_isValid:Boolean = false;   
    
	model_internal var _changeWatcherArray:Array = new Array();   

	public function _Super_Member() 
	{	
		_model = new _MemberEntityMetadata(this);
	
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
    public function get loginId() : String    
    {
            return _internal_loginId;
    }    
	[Bindable(event="propertyChange")] 
    public function get gmtCreate() : Date    
    {
            return _internal_gmtCreate;
    }    
	[Bindable(event="propertyChange")] 
    public function get location() : String    
    {
            return _internal_location;
    }    
	[Bindable(event="propertyChange")] 
    public function get enable() : int    
    {
            return _internal_enable;
    }    
	[Bindable(event="propertyChange")] 
    public function get password() : String    
    {
            return _internal_password;
    }    
	[Bindable(event="propertyChange")] 
    public function get ext() : String    
    {
            return _internal_ext;
    }    
	[Bindable(event="propertyChange")] 
    public function get id() : int    
    {
            return _internal_id;
    }    
	[Bindable(event="propertyChange")] 
    public function get aliTalkId() : String    
    {
            return _internal_aliTalkId;
    }    
	[Bindable(event="propertyChange")] 
    public function get email() : String    
    {
            return _internal_email;
    }    
	[Bindable(event="propertyChange")] 
    public function get name() : String    
    {
            return _internal_name;
    }    
	[Bindable(event="propertyChange")] 
    public function get role() : String    
    {
            return _internal_role;
    }    
	[Bindable(event="propertyChange")] 
    public function get workId() : int    
    {
            return _internal_workId;
    }    

    /**
     * data property setters
     */      
    public function set gmtModified(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_gmtModified == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
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
    public function set loginId(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_loginId == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_loginId;               
        if (oldValue !== value)
        {
            _internal_loginId = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "loginId", oldValue, _internal_loginId));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set gmtCreate(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_gmtCreate == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
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
    public function set location(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_location == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_location;               
        if (oldValue !== value)
        {
            _internal_location = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "location", oldValue, _internal_location));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set enable(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_enable;               
        if (oldValue !== value)
        {
            _internal_enable = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "enable", oldValue, _internal_enable));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set password(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_password == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_password;               
        if (oldValue !== value)
        {
            _internal_password = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "password", oldValue, _internal_password));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set ext(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_ext == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_ext;               
        if (oldValue !== value)
        {
            _internal_ext = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "ext", oldValue, _internal_ext));
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
    public function set aliTalkId(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_aliTalkId == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_aliTalkId;               
        if (oldValue !== value)
        {
            _internal_aliTalkId = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "aliTalkId", oldValue, _internal_aliTalkId));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set email(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_email == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_email;               
        if (oldValue !== value)
        {
            _internal_email = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "email", oldValue, _internal_email));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set name(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_name == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_name;               
        if (oldValue !== value)
        {
            _internal_name = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "name", oldValue, _internal_name));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set role(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_role == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_role;               
        if (oldValue !== value)
        {
            _internal_role = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "role", oldValue, _internal_role));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set workId(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_workId;               
        if (oldValue !== value)
        {
            _internal_workId = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "workId", oldValue, _internal_workId));
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

		if (_model.isGmtModifiedAvailable && _internal_gmtModified == null)
		{
			violatedConsts.push("gmtModifiedIsRequired");
			validationFailureMessages.push("gmtModified is required");
		}
		if (_model.isLoginIdAvailable && _internal_loginId == null)
		{
			violatedConsts.push("loginIdIsRequired");
			validationFailureMessages.push("loginId is required");
		}
		if (_model.isGmtCreateAvailable && _internal_gmtCreate == null)
		{
			violatedConsts.push("gmtCreateIsRequired");
			validationFailureMessages.push("gmtCreate is required");
		}
		if (_model.isLocationAvailable && _internal_location == null)
		{
			violatedConsts.push("locationIsRequired");
			validationFailureMessages.push("location is required");
		}
		if (_model.isPasswordAvailable && _internal_password == null)
		{
			violatedConsts.push("passwordIsRequired");
			validationFailureMessages.push("password is required");
		}
		if (_model.isExtAvailable && _internal_ext == null)
		{
			violatedConsts.push("extIsRequired");
			validationFailureMessages.push("ext is required");
		}
		if (_model.isAliTalkIdAvailable && _internal_aliTalkId == null)
		{
			violatedConsts.push("aliTalkIdIsRequired");
			validationFailureMessages.push("aliTalkId is required");
		}
		if (_model.isEmailAvailable && _internal_email == null)
		{
			violatedConsts.push("emailIsRequired");
			validationFailureMessages.push("email is required");
		}
		if (_model.isNameAvailable && _internal_name == null)
		{
			violatedConsts.push("nameIsRequired");
			validationFailureMessages.push("name is required");
		}
		if (_model.isRoleAvailable && _internal_role == null)
		{
			violatedConsts.push("roleIsRequired");
			validationFailureMessages.push("role is required");
		}

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
    public function get _model() : _MemberEntityMetadata
    {
		return model_internal::_dminternal_model;              
    }	
    
    public function set _model(value : _MemberEntityMetadata) : void       
    {
    	var oldValue : _MemberEntityMetadata = model_internal::_dminternal_model;               
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
