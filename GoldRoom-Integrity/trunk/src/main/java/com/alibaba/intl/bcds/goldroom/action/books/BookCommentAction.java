package com.alibaba.intl.bcds.goldroom.action.books;

import net.sf.json.JSONObject;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.dataobject.comment.BookInfoComment;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.CommentService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;
import com.alibaba.intl.bcds.goldroom.util.StringUtils;

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
        JSONObject result = new JSONObject();

        if (getBookInfo() == null) {
            result.put("result", "error");
            result.put("msg", "无效的bookInfoId");
            json = result.toString();
            return ERROR;
        }
        UserDTO user = this.getUserDTO();
        if (user == null) {
            result.put("result", "error");
            result.put("msg", "没有登陆");
            json = result.toString();
            return ERROR;
        }
        Member member = memberService.findMemberByLoginId(user.getLoginId());
        BookInfoComment bookInfoComment = new BookInfoComment();
        bookInfoComment.setBookInfo(bookInfo);
        bookInfoComment.setMember(member);
        bookInfoComment.setContent(content);

        if (commentService.postComment(bookInfoComment)) {
            result.put("result", "success");
            result.put("gmtCreate", StringUtils.converDateToString(bookInfoComment.getGmtCreate()));
            result.put("memberName", member.getName());
            result.put("msg", "OK");
            json = result.toString();
            return SUCCESS;
        } else {
            result.put("result", "error");
            result.put("msg", "评价失败");
            json = result.toString();
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
