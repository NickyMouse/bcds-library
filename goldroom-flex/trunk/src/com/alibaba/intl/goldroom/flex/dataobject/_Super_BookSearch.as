/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - BookSearch.as.
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
public class _Super_BookSearch extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void 
    {
        try 
        {
            if (flash.net.getClassByAlias("com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch") == null)
            {
                flash.net.registerClassAlias("com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch", cz);
            } 
        }
        catch (e:Error) 
        {
            flash.net.registerClassAlias("com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch", cz); 
        }
    }   
     
    model_internal static function initRemoteClassAliasAllRelated() : void 
    {
    }

	model_internal var _dminternal_model : _BookSearchEntityMetadata;

	/**
	 * properties
	 */
	private var _internal_bookOwners : String;
	private var _internal_bookImgUrl : String;
	private var _internal_bookPages : int;
	private var _internal_bookPublisher : String;
	private var _internal_itemAddTime : Date;
	private var _internal_bookEdition : String;
	private var _internal_itemFirstAddTime : Date;
	private var _internal_bookAuthor : String;
	private var _internal_bookIsbn : String;
	private var _internal_bookPublishTime : Date;
	private var _internal_bookInfoId : int;
	private var _internal_bookDescription : String;
	private var _internal_bookCategoryId : int;
	private var _internal_bookTags : String;
	private var _internal_bookTranslator : String;
	private var _internal_bookName : String;

    private static var emptyArray:Array = new Array();

    /**
     * derived property cache initialization
     */  
    model_internal var _cacheInitialized_isValid:Boolean = false;   
    
	model_internal var _changeWatcherArray:Array = new Array();   

	public function _Super_BookSearch() 
	{	
		_model = new _BookSearchEntityMetadata(this);
	
		// Bind to own data properties for cache invalidation triggering  
       
	}

    /**
     * data property getters
     */
	[Bindable(event="propertyChange")] 
    public function get bookOwners() : String    
    {
            return _internal_bookOwners;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookImgUrl() : String    
    {
            return _internal_bookImgUrl;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookPages() : int    
    {
            return _internal_bookPages;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookPublisher() : String    
    {
            return _internal_bookPublisher;
    }    
	[Bindable(event="propertyChange")] 
    public function get itemAddTime() : Date    
    {
            return _internal_itemAddTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookEdition() : String    
    {
            return _internal_bookEdition;
    }    
	[Bindable(event="propertyChange")] 
    public function get itemFirstAddTime() : Date    
    {
            return _internal_itemFirstAddTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookAuthor() : String    
    {
            return _internal_bookAuthor;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookIsbn() : String    
    {
            return _internal_bookIsbn;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookPublishTime() : Date    
    {
            return _internal_bookPublishTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookInfoId() : int    
    {
            return _internal_bookInfoId;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookDescription() : String    
    {
            return _internal_bookDescription;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookCategoryId() : int    
    {
            return _internal_bookCategoryId;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookTags() : String    
    {
            return _internal_bookTags;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookTranslator() : String    
    {
            return _internal_bookTranslator;
    }    
	[Bindable(event="propertyChange")] 
    public function get bookName() : String    
    {
            return _internal_bookName;
    }    

    /**
     * data property setters
     */      
    public function set bookOwners(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookOwners;               
        if (oldValue !== value)
        {
            _internal_bookOwners = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookOwners", oldValue, _internal_bookOwners));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookImgUrl(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookImgUrl;               
        if (oldValue !== value)
        {
            _internal_bookImgUrl = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookImgUrl", oldValue, _internal_bookImgUrl));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookPages(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_bookPages;               
        if (oldValue !== value)
        {
            _internal_bookPages = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookPages", oldValue, _internal_bookPages));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookPublisher(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookPublisher;               
        if (oldValue !== value)
        {
            _internal_bookPublisher = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookPublisher", oldValue, _internal_bookPublisher));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set itemAddTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:Date = _internal_itemAddTime;               
        if (oldValue !== value)
        {
            _internal_itemAddTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "itemAddTime", oldValue, _internal_itemAddTime));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookEdition(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookEdition;               
        if (oldValue !== value)
        {
            _internal_bookEdition = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookEdition", oldValue, _internal_bookEdition));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set itemFirstAddTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:Date = _internal_itemFirstAddTime;               
        if (oldValue !== value)
        {
            _internal_itemFirstAddTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "itemFirstAddTime", oldValue, _internal_itemFirstAddTime));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookAuthor(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookAuthor;               
        if (oldValue !== value)
        {
            _internal_bookAuthor = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookAuthor", oldValue, _internal_bookAuthor));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookIsbn(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookIsbn;               
        if (oldValue !== value)
        {
            _internal_bookIsbn = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookIsbn", oldValue, _internal_bookIsbn));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookPublishTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:Date = _internal_bookPublishTime;               
        if (oldValue !== value)
        {
            _internal_bookPublishTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookPublishTime", oldValue, _internal_bookPublishTime));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookInfoId(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_bookInfoId;               
        if (oldValue !== value)
        {
            _internal_bookInfoId = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookInfoId", oldValue, _internal_bookInfoId));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookDescription(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookDescription;               
        if (oldValue !== value)
        {
            _internal_bookDescription = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookDescription", oldValue, _internal_bookDescription));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookCategoryId(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_bookCategoryId;               
        if (oldValue !== value)
        {
            _internal_bookCategoryId = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookCategoryId", oldValue, _internal_bookCategoryId));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookTags(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookTags;               
        if (oldValue !== value)
        {
            _internal_bookTags = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookTags", oldValue, _internal_bookTags));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookTranslator(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookTranslator;               
        if (oldValue !== value)
        {
            _internal_bookTranslator = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookTranslator", oldValue, _internal_bookTranslator));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set bookName(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:String = _internal_bookName;               
        if (oldValue !== value)
        {
            _internal_bookName = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "bookName", oldValue, _internal_bookName));
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
    public function get _model() : _BookSearchEntityMetadata
    {
		return model_internal::_dminternal_model;              
    }	
    
    public function set _model(value : _BookSearchEntityMetadata) : void       
    {
    	var oldValue : _BookSearchEntityMetadata = model_internal::_dminternal_model;               
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
