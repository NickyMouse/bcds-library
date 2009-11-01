package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public interface MemberService {
	List<Member> listMemberByLoginIds(List ids);
}
