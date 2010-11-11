package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.ReservationDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;

@SuppressWarnings("unchecked")
public class ReservationDaoImpl extends BaseDao implements ReservationDao {

//	@PersistenceContext(unitName = "goldroomPU")
	private EntityManager em;

	public Reservation save(Reservation reservation) {
		reservation.setId(null);
		Date now = new Date();
		reservation.setGmtCreate(now);
		reservation.setGmtModified(now);
		em.persist(reservation);
		return reservation;
	}

	public Reservation findById(Integer id) {
		return em.find(Reservation.class, id);
	}

	public boolean updateById(Reservation reservation) {
		Reservation r = em.find(Reservation.class, reservation.getId());
		if (r == null) {
			return false;
		}
		BeanUtils.copyProperties(reservation, r);
		r.setGmtModified(new Date());
		em.merge(r);
		return true;
	}

	public boolean cutReservationToLog(Reservation reservation) {
		Query q = em.createNamedQuery("deleteReservationById");
		q.setParameter("id", reservation.getId());
		int resultCount = q.executeUpdate();
		return resultCount > 0 ? true : false;
	}

	public boolean updateStateByBookItemId(int bookItemId, String state) {
		Query q = em.createNamedQuery("findReservationByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		List<Reservation> resultList = q.getResultList();
		if (resultList != null && resultList.size() > 0) {
			Reservation r = resultList.get(0);
			if (r != null) {
				r.setState(state);
			}
			em.merge(r);
			return true;
		} else {
			return false;
		}
	}

	public List<Reservation> listByLoginId(String loginId, int page,
			int pageSize) {
		Query q = em.createNamedQuery("listReservationByLoginId");
		q.setParameter("loginId", loginId);
		return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.getResultList();
	}

	public int countByLogindId(String loginId) {
		Query q = em.createNamedQuery("countReservationByLoginId");
		q.setParameter("loginId", loginId);
		return ((Long) q.getSingleResult()).intValue();
	}

	public List<Reservation> listByBookItemId(Integer bookItemId) {
		Query q = em.createNamedQuery("listReservationByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		return q.getResultList();
	}

	public int countByBookItemId(Integer bookItemId) {
		Query q = em.createNamedQuery("countReservationByBookItemId");
		q.setParameter("bookItemId", bookItemId);
		return ((Long) q.getSingleResult()).intValue();
	}

	public boolean deleteReservation(Integer id) {
		if (id == null) {
			return false;
		}
		Query q = em.createNamedQuery("deleteReservationById");
		q.setParameter("id", id);
		return q.executeUpdate() > 0;
	}

	@Override
	public List<Reservation> listByLoginIdAndState(String loginId,
			String state, int page, int pageSize) {
		Query q = em.createNamedQuery("listReservationByLoginIdAndState");
		q.setParameter("loginId", loginId);
		q.setParameter("state", state);
		return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize)
				.getResultList();
	}

	@Override
	public int countByLogindIdAndState(String loginId, String state) {
		Query q = em.createNamedQuery("countReservationByLoginIdAndState");
		q.setParameter("loginId", loginId);
		q.setParameter("state", state);
		return ((Long) q.getSingleResult()).intValue();
	}
}
