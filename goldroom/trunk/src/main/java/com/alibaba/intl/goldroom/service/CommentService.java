package com.alibaba.intl.goldroom.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.goldroom.constaints.CommentTargetEnum;
import com.alibaba.intl.goldroom.dao.CommentDao;
import com.alibaba.intl.goldroom.dataobject.Comment;

@Service
@RemotingDestination
@Transactional
public class CommentService {

    private static Logger logger = Logger.getLogger(CommentService.class);

    @Autowired
    private CommentDao    commentDao;

    public List<Comment> listBookCommentByBookInfoId(Integer bookInfoId, int page, int pageSize) {
        if (bookInfoId == null) {
            return new ArrayList<Comment>();
        }
        logger.info("[CommentService.listByTargetTypeAndTargetId] bookInfoId:" + bookInfoId);
        return commentDao.listByTargetTypeAndTargetId(CommentTargetEnum.BOOK_INFO.getValue(), bookInfoId, page,
                                                      pageSize);
    }

    public List<Comment> listBookCommentByLoginId(String loginId, int page, int pageSize) {
        if (StringUtils.isEmpty(loginId)) {
            return new ArrayList<Comment>();
        }
        logger.info("[CommentService.listBookCommentByLoginId] loginId:" + loginId);
        return commentDao.listByLoginId(loginId, page, pageSize);
    }

    public List<Comment> listAll(int page, int pageSize) {
        return commentDao.listAllComment(page, pageSize);
    }

    public boolean postComment(Comment comment) {
        comment.setTargetType(CommentTargetEnum.BOOK_INFO.getValue());
        commentDao.save(comment);
        return true;
    }

    public boolean deleteCommentById(Integer commentId) {
        return commentDao.deleteById(commentId);
    }
}
