/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - BookItem.as.
 */

package com.alibaba.intl.goldroom.flex.dataobject
{
import com.adobe.fiber.services.IFiberManagingService;
import com.adobe.fiber.valueobjects.IValueObject;
import com.alibaba.intl.goldroom.flex.dataobject.BookInfo;
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
public class _Super_BookItem extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void 
    {
        try 
        {
            if (flash.net.getClassByAlias("com.alibaba.intl.goldroom.dataobject.BookItem") == null)
            {
                flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.BookItem", cz);
            } 
        }
        catch (e:Error) 
        {
            flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.BookItem", cz); 
        }
    }   
     
    model_internal static function initRemoteClassAliasAllRelated() : void 
    {
        com.alibaba.intl.goldroom.flex.dataobject.Member.initRemoteClassAliasSingleChild();
        com.alibaba.intl.goldroom.flex.dataobject.BookInfo.initRemoteClassAliasSingleChild();
    }

	model_internal var _dminternal_model : _BookItemEntityMetadata;

	/**
	 * properties
	 */
	private var _internal_gmtModified : Date;
	private var _internal_id : int;
	private var _internal_tags : String;
	private var _internal_member : com.alibaba.intl.goldroom.flex.dataobject.Member;
	private var _internal_firstAddTime : Date;
	private var _internal_gmtCreate : Date;
	private var _internal_remark : String;
	private var _internal_state : String;
	private var _internal_removeTime : Date;
	private var _internal_bookInfo : com.alibaba.intl.goldroom.flex.dataobject.BookInfo;
	private var _internal_addTime : Date;

    private static var emptyArray:Array = new Array();

    /**
     * derived property cache initialization
     */  
    model_internal var _cacheInitialized_isValid:Boolean = false;   
    
	model_internal var _changeWatcherArray:Array = new Array();   

	public function _Super_BookItem() 
	{	
		_model = new _BookItemEntityMetadata(this);
	
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
    public function get tags() : String    
    {
            return _internal_tags;
    }    
	[Bindable(event="propertyChange")] 
    public function get member() : com.alibaba.intl.goldroom.flex.dataobject.Member    
    {
            return _internal_member;
    }    
	[Bindable(event="propertyChange")] 
    public function get firstAddTime() : Date    
    {
            return _internal_firstAddTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get gmtCreate() : Date    
    {
            return _internal_gmtCreate;
    }    
	[Bindable(event="propertyChange")] 
    public function get remark() : String    
    {
            return _internal_remark;
    }    
	[Bindable(event="propertyChange")] 
    public function get state() : String    
    {
            return _internal_state;
    }    
	[Bindable(event="propertyChange")] 
    public function get removeTime() : Date    
    {
            return _internal_removeTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookInfo() : com.alibaba.intl.goldroom.flex.dataobject.BookInfo    
    {
            return _internal_bookInfo;
    }    
	[Bindable(event="propertyChange")] 
    public function get addTime() : Date    
    {
            return _internal_addTime;
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
    public function set tags(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_tags == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_tags;               
        if (oldValue !== value)
        {
            _internal_tags = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "tags", oldValue, _internal_tags));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set member(value:com.alibaba.intl.goldroom.flex.dataobject.Member) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_member == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:com.alibaba.intl.goldroom.flex.dataobject.Member = _internal_member;               
        if (oldValue !== value)
        {
            _internal_member = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "member", oldValue, _internal_member));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set firstAddTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_firstAddTime == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:Date = _internal_firstAddTime;               
        if (oldValue !== value)
        {
            _internal_firstAddTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "firstAddTime", oldValue, _internal_firstAddTime));
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
    public function set remark(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_remark == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_remark;               
        if (oldValue !== value)
        {
            _internal_remark = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "remark", oldValue, _internal_remark));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set state(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_state == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
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
    public function set removeTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_removeTime == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:Date = _internal_removeTime;               
        if (oldValue !== value)
        {
            _internal_removeTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "removeTime", oldValue, _internal_removeTime));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookInfo(value:com.alibaba.intl.goldroom.flex.dataobject.BookInfo) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_bookInfo == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:com.alibaba.intl.goldroom.flex.dataobject.BookInfo = _internal_bookInfo;               
        if (oldValue !== value)
        {
            _internal_bookInfo = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookInfo", oldValue, _internal_bookInfo));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set addTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_addTime == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:Date = _internal_addTime;               
        if (oldValue !== value)
        {
            _internal_addTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "addTime", oldValue, _internal_addTime));
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
		if (_model.isTagsAvailable && _internal_tags == null)
		{
			violatedConsts.push("tagsIsRequired");
			validationFailureMessages.push("tags is required");
		}
		if (_model.isMemberAvailable && _internal_member == null)
		{
			violatedConsts.push("memberIsRequired");
			validationFailureMessages.push("member is required");
		}
		if (_model.isFirstAddTimeAvailable && _internal_firstAddTime == null)
		{
			violatedConsts.push("firstAddTimeIsRequired");
			validationFailureMessages.push("firstAddTime is required");
		}
		if (_model.isGmtCreateAvailable && _internal_gmtCreate == null)
		{
			violatedConsts.push("gmtCreateIsRequired");
			validationFailureMessages.push("gmtCreate is required");
		}
		if (_model.isRemarkAvailable && _internal_remark == null)
		{
			violatedConsts.push("remarkIsRequired");
			validationFailureMessages.push("remark is required");
		}
		if (_model.isStateAvailable && _internal_state == null)
		{
			violatedConsts.push("stateIsRequired");
			validationFailureMessages.push("state is required");
		}
		if (_model.isRemoveTimeAvailable && _internal_removeTime == null)
		{
			violatedConsts.push("removeTimeIsRequired");
			validationFailureMessages.push("removeTime is required");
		}
		if (_model.isBookInfoAvailable && _internal_bookInfo == null)
		{
			violatedConsts.push("bookInfoIsRequired");
			validationFailureMessages.push("bookInfo is required");
		}
		if (_model.isAddTimeAvailable && _internal_addTime == null)
		{
			violatedConsts.push("addTimeIsRequired");
			validationFailureMessages.push("addTime is required");
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
    public function get _model() : _BookItemEntityMetadata
    {
		return model_internal::_dminternal_model;              
    }	
    
    public function set _model(value : _BookItemEntityMetadata) : void       
    {
    	var oldValue : _BookItemEntityMetadata = model_internal::_dminternal_model;               
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
