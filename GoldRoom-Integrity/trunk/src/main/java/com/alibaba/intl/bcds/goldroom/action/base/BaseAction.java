/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.action.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 基础Action
 * @author Harrison
 *
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4907073245785057170L;

	private HttpServletRequest request;
	private Map<Object, Object> session;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the session
	 */
	public Map<Object, Object> getSession() {
		return session;
	}

}
