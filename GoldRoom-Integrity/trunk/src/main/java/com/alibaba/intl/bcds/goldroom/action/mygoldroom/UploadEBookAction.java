package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import java.util.Date;

import org.apache.commons.lang.xwork.StringUtils;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.constaints.BookItemStateEnum;
import com.alibaba.intl.bcds.goldroom.constaints.BookStoreState;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;

public class UploadEBookAction extends BaseAction {

    /**
    *
    */
    private static final long serialVersionUID = 8866434764023038616L;

    private String            isbn;

    private Integer           bookInfoId;

    private String            tags;

    private String            remark;

    private BookItemService   bookItemService;

    private BookInfoService   bookInfoService;

    private boolean           submitFlag;

    private BookInfo          bookInfo;

    private boolean           ebookExist;

    public String execute() throws Exception {
        UserDTO user = this.getUserDTO();
        if (user == null) {
            return ERROR;
        }
        if (StringUtils.isBlank(isbn)) {
            return "showForm";
        } else if (!submitFlag) {
            bookInfo = bookInfoService.findBookInfoByIsbn(isbn);
            isbn = isbn.trim();
            if (BookStoreState.isEBookExist(bookInfo.getStoreState())) {
                ebookExist = true;
            }
            return "showForm";
        }
        isbn = isbn.trim();
        Member currentMember = new Member();
        currentMember.setLoginId(user.getLoginId());

        BookInfo currentBookInfo = new BookInfo();
        currentBookInfo.setId(bookInfoId);

        BookItem bookItem = new BookItem();
        bookItem.setFirstAddTime(new Date());
        bookItem.setAddTime(bookItem.getFirstAddTime());

        bookItem.setState(BookItemStateEnum.IDLE.getValue());
        bookItem.setRemark(remark);
        bookItem.setOwner(currentMember);
        bookItem.setBookInfo(currentBookInfo);

        if (bookItemService.addEbookItem(bookItem)) {
            ebookExist = false;
            return SUCCESS;
        } else {
            // ebook exist;
            ebookExist = true;
            return ERROR;
        }
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    public BookItemService getBookItemService() {
        return bookItemService;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setSubmitFlag(boolean submitFlag) {
        this.submitFlag = submitFlag;
    }

    public boolean getSubmitFlag() {
        return submitFlag;
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

    public void setEbookExist(boolean ebookExist) {
        this.ebookExist = ebookExist;
    }

    public boolean getEbookExist() {
        return ebookExist;
    }

}
