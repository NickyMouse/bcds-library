package com.alibaba.intl.bcds.goldroom.action.detail;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.search.commons.dataobject.BookSearch;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.MemberService;

public class BookDetailAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = -6705963595139425310L;

    private Integer           bookInfoId;
    private BookInfoService   bookInfoService;
    private BookSearch        bookSearch;
    private MemberService     memberService;

    // private Member owner;
    public String execute() throws Exception {
        bookSearch = bookInfoService.searchBookByInfoId(bookInfoId);
        // owner = memberService.findMemberByLoginId(loginId);
        if (bookSearch == null) {
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

    public void setBookSearch(BookSearch bookSearch) {
        this.bookSearch = bookSearch;
    }

    public BookSearch getBookSearch() {
        return bookSearch;
    }
}
