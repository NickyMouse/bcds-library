package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.MemberDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;

@SuppressWarnings("unchecked")
public class MemberDaoImpl extends BaseDao implements MemberDao {


//	@PersistenceContext(unitName = "goldroomPU")
	private EntityManager em;

    @Override
	public Member findByEmail(String email) {
//    	Query q = em.createNamedQuery("findMemberByEmail");
//    	q.setParameter("email", email);
//    	List<Member> mList = q.getResultList();
    	List<Member> mList = getHibernateTemplate().findByNamedQueryAndNamedParam("findMemberByEmail", "email", email);
    	if(mList != null && mList.size() > 0){
    		return mList.get(0);
    	}else
    		return null;
	}



	public Member save(Member member) {
		member.setId(null);
		Date now = new Date();
		member.setGmtCreate(now);
		member.setGmtModified(now);
		em.persist(member);
		return member;
	}

	public List<Member> listMemberByLoginIds(List<String> loginIds) {
		Query q = em.createNamedQuery("listMemberByLoginIds");
		q.setParameter("loginIds", loginIds);
		return q.getResultList();
	}

	public List<Member> listMemberByStatus(Integer status) {
		Query q = em.createNamedQuery("listMemberByStatus");
		q.setParameter("status", status);
		return q.getResultList();
	}

	public Member findByLoginId(String loginId) {
		Query q = em.createNamedQuery("findByLoginId");
		q.setParameter("loginId", loginId);
		List<Member> resultList = q.getResultList();
		if (resultList != null && resultList.size() > 0) {
			return resultList.get(0);
		} else {
			return null;
		}
	}

	public boolean updateMemberByLoginId(Member member) {
		Member m = em.find(Member.class, member.getLoginId());
		if (m == null) {
			return false;
		}
		BeanUtils.copyProperties(member, m);
		em.merge(m);
		return true;
	}

	public boolean updatePasswordByLoginId(String loginId, String password) {
		Member m = em.find(Member.class, loginId);
		if (m == null) {
			return false;
		}
		m.setPassword(password);
		em.merge(m);
		return true;
	}

	public Member findByNameAndEmail(String name, String email) {
		Query q = em.createNamedQuery("findMemberByNameAndEmail");
		q.setParameter("name", name);
		q.setParameter("email", email);
		List<Member> result = q.getResultList();
		if (result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Member> listMemberByScore(int count) {
		
//		Query q = em.createNamedQuery("listMemberByScore");
//		q.setFirstResult(0);
//		q.setMaxResults(count);
//		return q.getResultList();
		
		org.hibernate.Query query = createNamedQuery("listMemberByScore");
		return query.setFirstResult(0).setMaxResults(count).list();
	}

	// public Map<String, Member> listMemberInfo() {
	// Query query;
	// return null;
	// }

}
