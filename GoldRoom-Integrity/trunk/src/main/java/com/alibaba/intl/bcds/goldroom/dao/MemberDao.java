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
    
    Member findByEmail(String email);
    
}
