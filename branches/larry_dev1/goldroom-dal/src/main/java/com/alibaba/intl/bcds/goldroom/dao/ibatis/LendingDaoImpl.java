/**
 * Project: goldroom-dal
 * 
 * File Created at 2009-10-24
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.sql.SQLException;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.LendingDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Lending;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * TODO Comment of LendingDaoImpl
 * 
 * @author Zimmem
 */
public class LendingDaoImpl extends SqlMapClientDaoSupport implements
		LendingDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.intl.bcds.goldroom.dao.LendingDao#cutLendingToLog(int)
	 */
	@Override
	public void cutLendingToLog(int lendId) {
		// getSqlMapClientTemplate().insert("LENDING.cutLendingToLog", lending);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.alibaba.intl.bcds.goldroom.dao.LendingDao#cutLendingToLog(com.alibaba
	 * .intl.bcds.goldroom.dataobject.Lending)
	 */
	@Override
	public void cutLendingToLog(final Lending lending) {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			@Override
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.insert("LENDING.copyLendingToLog", lending.getId());
				executor.delete("LENDING.deleteById", lending.getId());
				return null;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.alibaba.intl.bcds.goldroom.dao.LendingDao#findById(int)
	 */
	@Override
	public Lending findById(int lendId) {
		return (Lending) getSqlMapClientTemplate().queryForObject(
				"LENDING.findById", lendId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.alibaba.intl.bcds.goldroom.dao.LendingDao#insert(com.alibaba.intl
	 * .bcds.goldroom.dataobject.Lending)
	 */
	@Override
	public void insert(Lending lending) {
		getSqlMapClientTemplate().insert("LENDING.insert", lending);
	}

	@Override
	public void updateRealReturnTime(int lendingId) {
		getSqlMapClientTemplate().update("LENDING.updateRealReturnTime",
				lendingId);
	}

}
