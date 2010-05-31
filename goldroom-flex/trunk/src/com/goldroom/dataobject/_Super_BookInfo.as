/**
 * This is a generated class and is not intended for modfication.  To customize behavior
 * of this value object you may modify the generated sub-class of this class - BookInfo.as.
 */

package com.goldroom.dataobject
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
public class _Super_BookInfo extends flash.events.EventDispatcher implements com.adobe.fiber.valueobjects.IValueObject
{
    model_internal static function initRemoteClassAliasSingle(cz:Class) : void 
    {
        try 
        {
            if (flash.net.getClassByAlias("com.alibaba.intl.goldroom.dataobject.BookInfo") == null)
            {
                flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.BookInfo", cz);
            } 
        }
        catch (e:Error) 
        {
            flash.net.registerClassAlias("com.alibaba.intl.goldroom.dataobject.BookInfo", cz); 
        }
    }   
     
    model_internal static function initRemoteClassAliasAllRelated() : void 
    {
    }

	model_internal var _dminternal_model : _BookInfoEntityMetadata;

	/**
	 * properties
	 */
	private var _internal_gmtModified : Date;
	private var _internal_edition : String;
	private var _internal_gmtCreate : Date;
	private var _internal_publishTime : Date;
	private var _internal_pages : int;
	private var _internal_categoryId : int;
	private var _internal_publisher : String;
	private var _internal_id : int;
	private var _internal_imgUrl : String;
	private var _internal_categoryName : String;
	private var _internal_author : String;
	private var _internal_source : String;
	private var _internal_isbn10 : String;
	private var _internal_translator : String;
	private var _internal_description : String;
	private var _internal_name : String;
	private var _internal_isbn : String;
	private var _internal_isbn13 : String;
	private var _internal_eBookUrl : String;

    private static var emptyArray:Array = new Array();

    /**
     * derived property cache initialization
     */  
    model_internal var _cacheInitialized_isValid:Boolean = false;   
    
	model_internal var _changeWatcherArray:Array = new Array();   

	public function _Super_BookInfo() 
	{	
		_model = new _BookInfoEntityMetadata(this);
	
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
    public function get edition() : String    
    {
            return _internal_edition;
    }    
	[Bindable(event="propertyChange")] 
    public function get gmtCreate() : Date    
    {
            return _internal_gmtCreate;
    }    
	[Bindable(event="propertyChange")] 
    public function get publishTime() : Date    
    {
            return _internal_publishTime;
    }    
	[Bindable(event="propertyChange")] 
    public function get pages() : int    
    {
            return _internal_pages;
    }    
	[Bindable(event="propertyChange")] 
    public function get categoryId() : int    
    {
            return _internal_categoryId;
    }    
	[Bindable(event="propertyChange")] 
    public function get publisher() : String    
    {
            return _internal_publisher;
    }    
	[Bindable(event="propertyChange")] 
    public function get id() : int    
    {
            return _internal_id;
    }    
	[Bindable(event="propertyChange")] 
    public function get imgUrl() : String    
    {
            return _internal_imgUrl;
    }    
	[Bindable(event="propertyChange")] 
    public function get categoryName() : String    
    {
            return _internal_categoryName;
    }    
	[Bindable(event="propertyChange")] 
    public function get author() : String    
    {
            return _internal_author;
    }    
	[Bindable(event="propertyChange")] 
    public function get source() : String    
    {
            return _internal_source;
    }    
	[Bindable(event="propertyChange")] 
    public function get isbn10() : String    
    {
            return _internal_isbn10;
    }    
	[Bindable(event="propertyChange")] 
    public function get translator() : String    
    {
            return _internal_translator;
    }    
	[Bindable(event="propertyChange")] 
    public function get description() : String    
    {
            return _internal_description;
    }    
	[Bindable(event="propertyChange")] 
    public function get name() : String    
    {
            return _internal_name;
    }    
	[Bindable(event="propertyChange")] 
    public function get isbn() : String    
    {
            return _internal_isbn;
    }    
	[Bindable(event="propertyChange")] 
    public function get isbn13() : String    
    {
            return _internal_isbn13;
    }    
	[Bindable(event="propertyChange")] 
    public function get eBookUrl() : String    
    {
            return _internal_eBookUrl;
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
    public function set edition(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_edition == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_edition;               
        if (oldValue !== value)
        {
            _internal_edition = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "edition", oldValue, _internal_edition));
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
    public function set publishTime(value:Date) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_publishTime == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:Date = _internal_publishTime;               
        if (oldValue !== value)
        {
            _internal_publishTime = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "publishTime", oldValue, _internal_publishTime));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set pages(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_pages;               
        if (oldValue !== value)
        {
            _internal_pages = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "pages", oldValue, _internal_pages));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set categoryId(value:int) : void 
    {    	
        var recalcValid:Boolean = false;
    	
    	
    	var oldValue:int = _internal_categoryId;               
        if (oldValue !== value)
        {
            _internal_categoryId = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "categoryId", oldValue, _internal_categoryId));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set publisher(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_publisher == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_publisher;               
        if (oldValue !== value)
        {
            _internal_publisher = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "publisher", oldValue, _internal_publisher));
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
    public function set imgUrl(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_imgUrl == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_imgUrl;               
        if (oldValue !== value)
        {
            _internal_imgUrl = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "imgUrl", oldValue, _internal_imgUrl));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set categoryName(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_categoryName == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_categoryName;               
        if (oldValue !== value)
        {
            _internal_categoryName = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "categoryName", oldValue, _internal_categoryName));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set author(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_author == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_author;               
        if (oldValue !== value)
        {
            _internal_author = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "author", oldValue, _internal_author));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set source(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_source == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_source;               
        if (oldValue !== value)
        {
            _internal_source = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "source", oldValue, _internal_source));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set isbn10(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_isbn10 == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_isbn10;               
        if (oldValue !== value)
        {
            _internal_isbn10 = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "isbn10", oldValue, _internal_isbn10));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set translator(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_translator == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_translator;               
        if (oldValue !== value)
        {
            _internal_translator = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "translator", oldValue, _internal_translator));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set description(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_description == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_description;               
        if (oldValue !== value)
        {
            _internal_description = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "description", oldValue, _internal_description));
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
    public function set isbn(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_isbn == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_isbn;               
        if (oldValue !== value)
        {
            _internal_isbn = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "isbn", oldValue, _internal_isbn));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set isbn13(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_isbn13 == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_isbn13;               
        if (oldValue !== value)
        {
            _internal_isbn13 = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "isbn13", oldValue, _internal_isbn13));
        }    	     
        
        if (recalcValid && model_internal::_cacheInitialized_isValid)
        {
            model_internal::isValid_der = model_internal::calculateIsValid();
        }  
    }    
    public function set eBookUrl(value:String) : void 
    {    	
        var recalcValid:Boolean = false;
    	if (value == null || _internal_eBookUrl == null)
    	{
    		recalcValid = true;
    	}	
    	
    	
    	var oldValue:String = _internal_eBookUrl;               
        if (oldValue !== value)
        {
            _internal_eBookUrl = value;
        	this.dispatchEvent(mx.events.PropertyChangeEvent.createUpdateEvent(this, "eBookUrl", oldValue, _internal_eBookUrl));
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
		if (_model.isEditionAvailable && _internal_edition == null)
		{
			violatedConsts.push("editionIsRequired");
			validationFailureMessages.push("edition is required");
		}
		if (_model.isGmtCreateAvailable && _internal_gmtCreate == null)
		{
			violatedConsts.push("gmtCreateIsRequired");
			validationFailureMessages.push("gmtCreate is required");
		}
		if (_model.isPublishTimeAvailable && _internal_publishTime == null)
		{
			violatedConsts.push("publishTimeIsRequired");
			validationFailureMessages.push("publishTime is required");
		}
		if (_model.isPublisherAvailable && _internal_publisher == null)
		{
			violatedConsts.push("publisherIsRequired");
			validationFailureMessages.push("publisher is required");
		}
		if (_model.isImgUrlAvailable && _internal_imgUrl == null)
		{
			violatedConsts.push("imgUrlIsRequired");
			validationFailureMessages.push("imgUrl is required");
		}
		if (_model.isCategoryNameAvailable && _internal_categoryName == null)
		{
			violatedConsts.push("categoryNameIsRequired");
			validationFailureMessages.push("categoryName is required");
		}
		if (_model.isAuthorAvailable && _internal_author == null)
		{
			violatedConsts.push("authorIsRequired");
			validationFailureMessages.push("author is required");
		}
		if (_model.isSourceAvailable && _internal_source == null)
		{
			violatedConsts.push("sourceIsRequired");
			validationFailureMessages.push("source is required");
		}
		if (_model.isIsbn10Available && _internal_isbn10 == null)
		{
			violatedConsts.push("isbn10IsRequired");
			validationFailureMessages.push("isbn10 is required");
		}
		if (_model.isTranslatorAvailable && _internal_translator == null)
		{
			violatedConsts.push("translatorIsRequired");
			validationFailureMessages.push("translator is required");
		}
		if (_model.isDescriptionAvailable && _internal_description == null)
		{
			violatedConsts.push("descriptionIsRequired");
			validationFailureMessages.push("description is required");
		}
		if (_model.isNameAvailable && _internal_name == null)
		{
			violatedConsts.push("nameIsRequired");
			validationFailureMessages.push("name is required");
		}
		if (_model.isIsbnAvailable && _internal_isbn == null)
		{
			violatedConsts.push("isbnIsRequired");
			validationFailureMessages.push("isbn is required");
		}
		if (_model.isIsbn13Available && _internal_isbn13 == null)
		{
			violatedConsts.push("isbn13IsRequired");
			validationFailureMessages.push("isbn13 is required");
		}
		if (_model.isEBookUrlAvailable && _internal_eBookUrl == null)
		{
			violatedConsts.push("eBookUrlIsRequired");
			validationFailureMessages.push("eBookUrl is required");
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
    public function get _model() : _BookInfoEntityMetadata
    {
		return model_internal::_dminternal_model;              
    }	
    
    public function set _model(value : _BookInfoEntityMetadata) : void       
    {
    	var oldValue : _BookInfoEntityMetadata = model_internal::_dminternal_model;               
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
