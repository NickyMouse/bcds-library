package com.alibaba.intl.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;

import com.alibaba.intl.goldroom.dao.MemberDao;
import com.alibaba.intl.goldroom.dataobject.Member;

@SuppressWarnings("unchecked")
public class MemberDaoImpl implements MemberDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

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
        return null;
    }

    public Member findByLoginId(String loginId) {
        return em.find(Member.class, loginId);
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

    // public Map<String, Member> listMemberInfo() {
    // Query query;
    // return null;
    // }

}