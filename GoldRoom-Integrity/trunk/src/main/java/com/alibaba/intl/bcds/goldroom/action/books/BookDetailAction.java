package com.alibaba.intl.bcds.goldroom.action.books;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;

public class BookDetailAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = -6705963595139425310L;

    private Integer           bookInfoId;
    private BookInfoService   bookInfoService;
    private BookInfo          bookInfo;
    private MemberService     memberService;

    // private Member owner;
    public String execute() throws Exception {
        setBookInfo(bookInfoService.searchBookByInfoId(bookInfoId));
        // owner = memberService.findMemberByLoginId(loginId);
        if (getBookInfo() == null) {
            return ERROR;
        }
        return SUCCESS;
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

}
