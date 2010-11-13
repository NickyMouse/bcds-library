package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.BeanUtils;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;

@SuppressWarnings("unchecked")
public class ReservationDaoImpl extends BaseDao implements ReservationDao {

	public Reservation save(Reservation reservation) {
		reservation.setId(null);
		Date now = new Date();
		reservation.setGmtCreate(now);
		reservation.setGmtModified(now);
		super.save(reservation);
		return reservation;
	}

	public Reservation findById(Integer id) {
		return this.get(Reservation.class, id);
	}

	public boolean updateById(Reservation reservation) {
		Reservation r = this.get(Reservation.class, reservation.getId());
		if (r == null) {
			return false;
		}
		BeanUtils.copyProperties(reservation, r);
		r.setGmtModified(new Date());
		this.update(r);
		return true;
	}

	public boolean cutReservationToLog(Reservation reservation) {
		Query q = this.createNamedQuery("deleteReservationById");
		q.setParameter("id", reservation.getId());
		int resultCount = q.executeUpdate();
		return resultCount > 0 ? true : false;
	}

	public boolean updateStateByBookItemId(int bookItemId, String state) {
		Query q = this.createNamedQuery("findReservationByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		List<Reservation> resultList = q.list();
		if (resultList != null && resultList.size() > 0) {
			Reservation r = resultList.get(0);
			if (r != null) {
				r.setState(state);
			}
			this.update(r);
			return true;
		} else {
			return false;
		}
	}

	public List<Reservation> listByLoginId(String loginId, int page,
			int pageSize) {
		Query q = this.createNamedQuery("listReservationByLoginId");
		q.setParameter("loginId", loginId);
		return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.list();
	}

	public int countByLogindId(String loginId) {
		Query q = this.createNamedQuery("countReservationByLoginId");
		q.setParameter("loginId", loginId);
		return ((Long) q.list().get(0)).intValue();
	}

	public List<Reservation> listByBookItemId(Integer bookItemId) {
		Query q = this.createNamedQuery("listReservationByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		return q.list();
	}

	public int countByBookItemId(Integer bookItemId) {
		Query q = this.createNamedQuery("countReservationByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		return ((Long) q.list().get(0)).intValue();
	}

	public boolean deleteReservation(Integer id) {
		if (id == null) {
			return false;
		}
		Query q = this.createNamedQuery("deleteReservationById");
		q.setParameter("id", id);
		return q.executeUpdate() > 0;
	}

	@Override
	public List<Reservation> listByLoginIdAndState(String loginId,
			String state, int page, int pageSize) {
		Query q = this.createNamedQuery("listReservationByLoginIdAndState");
		q.setParameter("loginId", loginId);
		q.setParameter("state", state);
		return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.list();
	}

	@Override
	public int countByLogindIdAndState(String loginId, String state) {
		Query q = this.createNamedQuery("countReservationByLoginIdAndState");
		q.setParameter("loginId", loginId);
		q.setParameter("state", state);
		return ((Long) q.list().get(0)).intValue();
	}
}
