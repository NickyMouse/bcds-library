/**
 * Project: goldroom-biz
 * 
 * File Created at 2009-10-21
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.service.result;

/**
 * 用于返回service的处理结果，适用于比较复杂的逻辑
 * 
 * @author Zimmem
 */
public class Result {

    /**
     * SUCCESS对象是一个单例，只用于返回成功信息，如需要携带其它信息，请使用<code>new Result(true);</code>
     */
    public static Result SUCCESS = new Result(true) {
                                     public void setErrorMsg(String errorMsg) {
                                         throw new IllegalStateException(
                                                 "the Result.SUCCESS object can't not access setter");
                                     }

                                     public void setSuccess(boolean success) {
                                         throw new IllegalStateException(
                                                 "the Result.SUCCESS object can't not access setter");
                                     }

                                     public void setReturnObject(Object returnObject) {
                                         throw new IllegalStateException(
                                                 "the Result.SUCCESS object can't not access setter");
                                     }
                                 };

    public Result() {

    }

    /**
     * @param success 是否成功
     */
    public Result(boolean success) {
        this();
        this.success = success;
    }

    /**
     * @param success 是否成功
     * @param errorMsg 错误消息
     */
    public Result(boolean success, String errorMsg) {
        this(success);
        this.errorMsg = errorMsg;

    }

    /**
     * @param success 是否成功
     * @param errorMsg 错误消息
     * @param returnObject 需要返回给web层的对象
     */
    public Result(boolean success, String errorMsg, Object returnObject) {
        this(success, errorMsg);
        this.returnObject = returnObject;

    }

    private boolean success;
    private String  errorMsg;
    private Object  returnObject;

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return the returnObject
     */
    public Object getReturnObject() {
        return returnObject;
    }

    /**
     * @param returnObject the returnObject to set
     */
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

}
