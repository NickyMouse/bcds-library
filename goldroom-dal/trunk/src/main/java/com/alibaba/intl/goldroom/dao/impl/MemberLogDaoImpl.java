package com.alibaba.intl.goldroom.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.alibaba.intl.goldroom.dao.MemberLogDao;
import com.alibaba.intl.goldroom.dataobject.MemberLog;

public class MemberLogDaoImpl implements MemberLogDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public int deleteByPrimaryKey(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    public void insert(MemberLog record) throws SQLException {
        // TODO Auto-generated method stub

    }

    public void insertSelective(MemberLog record) throws SQLException {
        // TODO Auto-generated method stub

    }

    public MemberLog selectByPrimaryKey(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public int updateByPrimaryKeySelective(MemberLog record) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    public int updateByPrimaryKey(MemberLog record) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
