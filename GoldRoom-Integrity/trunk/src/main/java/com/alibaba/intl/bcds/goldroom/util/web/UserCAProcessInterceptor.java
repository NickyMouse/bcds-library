/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.util.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Harrison
 *
 */
public class UserCAProcessInterceptor extends AbstractInterceptor {

	private MemberService memberService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 6777422615852927394L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
	    HttpSession session = req.getSession();
	    
	    UserDTO userDto = (UserDTO)session.getAttribute(UserDTO.MEMBER_LOGGED_SESSION_KEY);
	    if(userDto == null){
	    	//用户未登录
	    	String email = req.getHeader(UserDTO.MEMBER_CA_DN_KEY);
	    	if(email != null){
	    		// 有证书
	    		Member member = memberService.findMemberByEmail(email);
	    		if(member != null && StringUtils.isNotBlank(member.getName())){
	    			userDto = new UserDTO();
	    			userDto.setId(member.getId());
	    			userDto.setUserName(member.getName());
	    			userDto.setScore(member.getScore());
	    			
	    			session.setAttribute(UserDTO.MEMBER_LOGGED_SESSION_KEY, userDto);
	    		}
	    	}
	    }
		return invocation.invoke();
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
