package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import com.alibaba.intl.bcds.goldroom.dao.RoleDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.Role;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RoleDAOImpl extends SqlMapClientDaoSupport implements RoleDAO {

	public int deleteByPrimaryKey(Integer id) throws SQLException {
		Role key = new Role();
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete("ROLE.deleteByPrimaryKey",
				key);
		return rows;
	}

	public void insert(Role record) throws SQLException {
		getSqlMapClientTemplate().insert("ROLE.insert", record);
	}

	public void insertSelective(Role record) throws SQLException {
		getSqlMapClientTemplate().insert("ROLE.insertSelective", record);
	}

	public Role selectByPrimaryKey(Integer id) throws SQLException {
		Role key = new Role();
		key.setId(id);
		Role record = (Role) getSqlMapClientTemplate().queryForObject(
				"ROLE.selectByPrimaryKey", key);
		return record;
	}

	public int updateByPrimaryKeySelective(Role record) throws SQLException {
		int rows = getSqlMapClientTemplate().update(
				"ROLE.updateByPrimaryKeySelective", record);
		return rows;
	}

	public int updateByPrimaryKey(Role record) throws SQLException {
		int rows = getSqlMapClientTemplate().update("ROLE.updateByPrimaryKey",
				record);
		return rows;
	}

	public Integer updateByLoginIds(List<Integer> ids) {
		return null;
	}

}
