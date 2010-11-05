package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public interface MemberDao {

	Member save(Member member);

	List<Member> listMemberByLoginIds(List<String> loginIds);

	List<Member> listMemberByStatus(Integer status);

	Member findByLoginId(String loginId);

	boolean updateMemberByLoginId(Member member);

	boolean updatePasswordByLoginId(String loginId, String password);

	Member findByNameAndEmail(String name, String email);

	/**
	 * 按积分排序获取用户列表
	 * @param count 获取的用户数量
	 * @return
	 */
	List<Member> listMemberByScore(int count);

    Member findByEmail(String email);
    
}
