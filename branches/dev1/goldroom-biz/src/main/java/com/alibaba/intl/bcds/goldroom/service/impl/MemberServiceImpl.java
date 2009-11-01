package com.alibaba.intl.bcds.goldroom.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.dao.MemberDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.service.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;

	public List<Member> listMemberByLoginIds(List ids) {
		try {
			return memberDAO.listMemberByLoginIds(ids);
		} catch (SQLException e) {
			return new ArrayList<Member>();
		}
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

}
