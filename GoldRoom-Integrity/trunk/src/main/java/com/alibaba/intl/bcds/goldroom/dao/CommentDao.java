package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Comment;
import com.alibaba.intl.bcds.goldroom.dataobject.comment.BookInfoComment;
import com.alibaba.intl.bcds.goldroom.dataobject.comment.ReplyComment;

public interface CommentDao {

    public List<Comment> listAllComment(int page, int pageSize);

    // public List<Comment> listByTargetTypeAndTargetId(String targetType, Integer targetId, int page, int pageSize);

    public List<Comment> listByLoginId(String loginId, int page, int pageSize);

    public void save(Comment comment);

    public boolean deleteById(Integer commentId);

    public List<BookInfoComment> listBookinfoCommentByBookInfoId(Integer targetId, int page, int pageSize);

    public List<ReplyComment> listReplyCommentByCommentId(Integer targetId, int page, int pageSize);

}
