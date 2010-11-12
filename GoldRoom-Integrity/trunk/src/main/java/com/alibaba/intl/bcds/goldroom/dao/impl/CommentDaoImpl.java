package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.CommentDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Comment;

@SuppressWarnings("unchecked")
public class CommentDaoImpl extends BaseDao implements CommentDao {


    public void save(Comment comment) {
        comment.setId(null);
        Date now = new Date();
        comment.setGmtCreate(now);
        comment.setGmtModified(now);
        this.save(comment);
    }

    public List<Comment> listAllComment(int page, int pageSize) {
//        Query q = em.createNamedQuery("listAllComment");
//    	return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
        org.hibernate.Query query = createNamedQuery("listAllComment");
        return query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list();
    }

    public List<Comment> listByTargetTypeAndTargetId(String targetType, Integer targetId, int page, int pageSize) {
        Query q = this.createNamedQuery("listCommentByTargetTypeAndTargetId");
        q.setParameter("targetType", targetType);
        q.setParameter("targetId", targetId);
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list();
    }

    public List<Comment> listByLoginId(String loginId, int page, int pageSize) {
        Query q = this.createNamedQuery("listCommentByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list();
    }

    public boolean deleteById(Integer id) {
        Query q = this.createNamedQuery("deleteCommentById");
        q.setParameter("id", id);
        int result = q.executeUpdate();
        return result > 0;
    }
}
