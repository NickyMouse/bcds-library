/**
 * Project: goldroom-dal File Created at 2009-10-24 $Id$ Copyright 2008 Alibaba.com Croporation Limited. All rights
 * reserved. This software is the confidential and proprietary information of Alibaba Company.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.LendingDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Lending;

@SuppressWarnings("unchecked")
public class LendingDaoImpl extends BaseDao implements LendingDao {

	public Lending save(Lending lending) {
		lending.setId(null);
		Date now = new Date();
		lending.setGmtCreate(now);
		lending.setGmtModified(now);
		super.save(lending);
		return lending;
	}

	public boolean deleteLendingById(int lendId) {
		Query q = this.createNamedQuery("deleteLendingById");
		q.setParameter("id", lendId);
		int resultCount = q.executeUpdate();
		return resultCount > 0 ? true : false;
	}

	public boolean deleteLendingById(Lending lending) {
		Query q = this.createNamedQuery("deleteLendingById");
		q.setParameter("id", lending.getId());
		int resultCount = q.executeUpdate();
		return resultCount > 0 ? true : false;
	}

	public Lending findById(int lendId) {
		return this.get(Lending.class, lendId);
	}

	public boolean updateRealReturnTime(int lendingId) {
		Lending l = this.get(Lending.class, lendingId);
		if (l == null) {
			return false;
		}
		l.setRealReturnTime(new Date());
		this.update(l);
		return true;
	}

	public List<Lending> listLendingByLoginId(String loginId, int page,
			int pageSize) {
		Query q = this.createNamedQuery("listLendingByLoginId");
		q.setParameter("loginId", loginId);
		return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.list();
	}

	public List<Lending> listByLoginId(String loginId, int page, int pageSize) {
		Query q = this.createNamedQuery("listLendingByLoginId");
		q.setParameter("loginId", loginId);
		return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.list();
	}

	public int countByLogindId(String loginId) {
		Query q = this.createNamedQuery("countLendingByLoginId");
		q.setParameter("loginId", loginId);
		return ((Long) q.list().get(0)).intValue();
	}

	public int countByBookItemId(Integer bookItemId) {
		Query q = this.createNamedQuery("countLendingByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		return ((Long) q.list().get(0)).intValue();
	}

	public List<Lending> listByBookItemId(Integer bookItemId) {
		Query q = this.createNamedQuery("listLendingByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		return q.list();
	}

	/**
	 * 根据条件查找出借阅记录
	 *
	 * @param isExpire
	 *            借阅是否过期，当isExpire为真，返回的都是过期的记录；否则都是未过期的
	 * @return
	 */

	public List<Lending> listLendingWithExpireDays(boolean isExpire) {

		String hsql = "SELECT l FROM Lending l";
		if (isExpire) {
			// 过期的数据
			 hsql = hsql + " where TO_DAYS(l.returnTime) - TO_DAYS(NOW())<0";

		} else {
			 hsql = hsql + " where TO_DAYS(l.returnTime) - TO_DAYS(NOW())=3";
			// 离还书还有三天
		}

		return this.find(hsql);

	}
}
