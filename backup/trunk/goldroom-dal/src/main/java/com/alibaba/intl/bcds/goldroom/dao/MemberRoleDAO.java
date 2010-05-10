package com.alibaba.intl.bcds.goldroom.dao;

import com.alibaba.intl.bcds.goldroom.dataobject.MemberRole;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MemberRoleDAO {

    void insert(MemberRole record) throws SQLException;

    Map<Integer, MemberRole> mapMemberRoleByMemberIds(List<Integer> memberIds);
}
