package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.CommentDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Comment;
import com.alibaba.intl.bcds.goldroom.dataobject.comment.BookInfoComment;
import com.alibaba.intl.bcds.goldroom.dataobject.comment.ReplyComment;

@SuppressWarnings("unchecked")
public class CommentDaoImpl extends BaseDao implements CommentDao {


    public void save(Comment comment) {
        comment.setId(null);
        Date now = new Date();
        comment.setGmtCreate(now);
        comment.setGmtModified(now);
        super.save(comment);
    }

    public List<Comment> listAllComment(int page, int pageSize) {
//        Query q = em.createNamedQuery("listAllComment");
//    	return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
        Query query = createNamedQuery("listAllComment");
        return query.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list();
    }

    public List<BookInfoComment> listBookinfoCommentByBookInfoId(Integer targetId, int page, int pageSize) {
        Criteria cte = createCriteria(BookInfoComment.class);
        cte.createAlias("bookInfo", "bookInfo");
        cte.add(Restrictions.eq("bookInfo.id", targetId));
        cte.setFetchSize(pageSize);
        cte.setFirstResult((page - 1) * pageSize);
        return cte.list();

        // Query q = createQuery("SELECT c FROM BookInfoComment c WHERE bookInfo.id = ?", targetId);
        // return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).list();
    }

    /**
     * @deprecated replaced by <code> listBookinfoCommentByBookInfoId </code> or <code> listReplyCommentById </code>
     */
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

    @Override
    public List<ReplyComment> listReplyCommentByCommentId(Integer targetId, int page, int pageSize) {
        Criteria cte = createCriteria(BookInfoComment.class);
        cte.createAlias("sourceComment", "sourceComment");
        cte.add(Restrictions.eq("sourceComment.id", targetId));
        cte.setFetchSize(pageSize);
        cte.setFirstResult((page - 1) * pageSize);
        return cte.list();
    }
}
