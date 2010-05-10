package com.alibaba.intl.bcds.goldroom.dao;

import com.alibaba.intl.bcds.goldroom.dataobject.Role;
import java.sql.SQLException;

public interface RoleDAO {

	int deleteByPrimaryKey(Integer id) throws SQLException;

	void insert(Role record) throws SQLException;

	void insertSelective(Role record) throws SQLException;

	Role selectByPrimaryKey(Integer id) throws SQLException;

	int updateByPrimaryKeySelective(Role record) throws SQLException;

	int updateByPrimaryKey(Role record) throws SQLException;
}