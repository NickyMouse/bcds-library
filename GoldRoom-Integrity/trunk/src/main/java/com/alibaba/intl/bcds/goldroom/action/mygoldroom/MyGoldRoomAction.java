/**
 * 
 */
package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.MemberService;

/**
 * @author Harrison
 *
 */
public class MyGoldRoomAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6435296145588549915L;
	
	private Member member;
	private MemberService memberService;
	
	
	/**
	 * 显示注册页面
	 * @return
	 */
	public String viewRegisterPage(){
		return SUCCESS;
	}
	
	/**
	 * 完成注册业务
	 * @return
	 */
	public String doRegister(){
		if(member != null){
			memberService.applyMember(member);
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * @return the memberService
	 */
	public MemberService getMemberService() {
		return memberService;
	}

	/**
	 * @param memberService the memberService to set
	 */
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
