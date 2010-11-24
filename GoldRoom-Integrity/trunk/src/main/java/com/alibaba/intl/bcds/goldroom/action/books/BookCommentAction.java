package com.alibaba.intl.bcds.goldroom.action.books;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.dataobject.comment.BookInfoComment;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.CommentService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;

public class BookCommentAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = -6705963595139425310L;

    private Integer           bookInfoId;
    private BookInfoService   bookInfoService;
    private BookInfo          bookInfo;
    private CommentService    commentService;
    private MemberService     memberService;

    private String            content;

    public String execute() throws Exception {
        bookInfo = bookInfoService.searchBookByInfoId(bookInfoId);
        if (getBookInfo() == null) {
            return ERROR;
        }
        UserDTO user = this.getUserDTO();
        if (user == null) {
            user = new UserDTO();
            user.setLoginId("admin");// TODO 测试用
            // return ERROR;
        }
        Member member = memberService.findMemberByLoginId(user.getLoginId());
        BookInfoComment bookInfoComment = new BookInfoComment();
        bookInfoComment.setBookInfo(bookInfo);
        bookInfoComment.setMember(member);
        bookInfoComment.setContent(content);

        if (commentService.postComment(bookInfoComment)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoService(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    public BookInfoService getBookInfoService() {
        return bookInfoService;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
