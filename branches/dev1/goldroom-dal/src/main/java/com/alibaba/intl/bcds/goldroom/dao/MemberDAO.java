package com.alibaba.intl.bcds.goldroom.dao;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Member;

public interface MemberDAO {

    Integer insert(Member member);

    List<Member> listMemberByLoginIds(List<Integer> loginIds) throws SQLException;

    List<Member> listMemberByIds(List<Integer> ids) throws SQLException;

    List<Member> listMemberByStatus(Integer status);

    public Integer updateByLoginIds(final List<Member> members);

    Member selectByLoginId(String loginId);

}
