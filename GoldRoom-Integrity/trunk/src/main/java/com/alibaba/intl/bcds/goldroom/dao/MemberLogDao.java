package com.alibaba.intl.bcds.goldroom.dao;

import java.sql.SQLException;

import com.alibaba.intl.bcds.goldroom.dataobject.MemberLog;

public interface MemberLogDao {

    int deleteByPrimaryKey(Integer id) throws SQLException;

    void insert(MemberLog record) throws SQLException;

    void insertSelective(MemberLog record) throws SQLException;

    MemberLog selectByPrimaryKey(Integer id) throws SQLException;

    int updateByPrimaryKeySelective(MemberLog record) throws SQLException;

    int updateByPrimaryKey(MemberLog record) throws SQLException;
}
