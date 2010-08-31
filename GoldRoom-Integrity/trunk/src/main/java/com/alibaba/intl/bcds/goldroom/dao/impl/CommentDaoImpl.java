package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.alibaba.intl.bcds.goldroom.dao.CommentDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Comment;

@SuppressWarnings("unchecked")
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext(unitName = "goldroomPU")
    private EntityManager em;

    public void save(Comment comment) {
        comment.setId(null);
        Date now = new Date();
        comment.setGmtCreate(now);
        comment.setGmtModified(now);
        em.persist(comment);
    }

    public List<Comment> listAllComment(int page, int pageSize) {
        Query q = em.createNamedQuery("listAllComment");
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }

    public List<Comment> listByTargetTypeAndTargetId(String targetType, Integer targetId, int page, int pageSize) {
        Query q = em.createNamedQuery("listCommentByTargetTypeAndTargetId");
        q.setParameter("targetType", targetType);
        q.setParameter("targetId", targetId);
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }

    public List<Comment> listByLoginId(String loginId, int page, int pageSize) {
        Query q = em.createNamedQuery("listCommentByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }

    public boolean deleteById(Integer id) {
        Query q = em.createNamedQuery("deleteCommentById");
        q.setParameter("id", id);
        int result = q.executeUpdate();
        return result > 0;
    }
}
