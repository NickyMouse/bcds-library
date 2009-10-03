package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.sql.SQLException;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.MemberDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDAOImpl extends SqlMapClientDaoSupport implements MemberDAO {

    public MemberDAOImpl(SqlMapClient sqlMapClient) {
    }

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        Member key = new Member();
        key.setId(id);
        return getSqlMapClientTemplate().delete("MEMBER.deleteByPrimaryKey", key);
    }

    public void insert(Member record) throws SQLException {
        getSqlMapClientTemplate().insert("MEMBER.insert", record);
    }

    public void insertSelective(Member record) throws SQLException {
        getSqlMapClientTemplate().insert("MEMBER.insertSelective", record);
    }

    public Member selectByPrimaryKey(Integer id) throws SQLException {
        Member key = new Member();
        key.setId(id);
        return (Member) getSqlMapClientTemplate().queryForObject("MEMBER.selectByPrimaryKey", key);
    }

    public int updateByPrimaryKeySelective(Member record) throws SQLException {
        return getSqlMapClientTemplate().update("MEMBER.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(Member record) throws SQLException {
        return getSqlMapClientTemplate().update("MEMBER.updateByPrimaryKey", record);
    }
}
