package com.alibaba.intl.bcds.goldroom.web.utils;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.dao.MemberDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public class MemberInfoCache {
	private Map<String, Member> memberMap;
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void reBuild() {
		init();
	}

	public void init() {
		memberMap = memberDAO.listMemberInfo();
	}

	public Member getMemberInfo(String loginId) {
		return memberMap.get(loginId);
	}

	/**
	 * 更新用户信息，若不存在该用户的信息，则返回false,不对cache做任何改变
	 * @param memberInfo
	 * @return
	 */
	public boolean updateMemberInfo(Member memberInfo) {
		String loginId = memberInfo.getLoginId();
		if (StringUtils.isNotEmpty(loginId) && memberMap.containsKey(loginId)) {
			memberMap.put(loginId, memberInfo);
			return true;
		}
		return false;
	}
	
	/**
	 * 添加用户信息到cache中，若 已经存在该用户的信息，则返回false，不对cache做任何改变
	 * @param memberInfo
	 * @return
	 */
	public boolean addMemberInfo(Member memberInfo){
		String loginId = memberInfo.getLoginId();
		if (StringUtils.isNotEmpty(loginId) && !memberMap.containsKey(loginId)) {
			memberMap.put(loginId, memberInfo);
			return true;
		}
		return false;
	}
}
