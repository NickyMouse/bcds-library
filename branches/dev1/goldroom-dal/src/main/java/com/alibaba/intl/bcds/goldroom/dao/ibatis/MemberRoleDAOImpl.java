package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import com.alibaba.intl.bcds.goldroom.dao.MemberRoleDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.MemberRole;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MemberRoleDAOImpl extends SqlMapClientDaoSupport implements MemberRoleDAO {

    public void insert(MemberRole record) throws SQLException {
        getSqlMapClientTemplate().insert("MEMBER_ROLE.insert", record);
    }

    @Override
    public Map<Integer, MemberRole> mapMemberRoleByMemberIds(List<Integer> memberIds) {
        return getSqlMapClientTemplate().queryForMap("MEMBER_ROLE.listMemberRoleByMemberIds", memberIds, "memberId");
    }

}
