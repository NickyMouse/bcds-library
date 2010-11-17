package com.alibaba.intl.bcds.goldroom.action.books;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.comment.BookInfoComment;
import com.alibaba.intl.bcds.goldroom.result.BookSearchResult;
import com.alibaba.intl.bcds.goldroom.search.commons.constrans.SearchBookType;
import com.alibaba.intl.bcds.goldroom.service.BookInfoService;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;
import com.alibaba.intl.bcds.goldroom.service.CommentService;

public class BookDetailAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = -6705963595139425310L;

    private Integer           bookInfoId;
    private BookInfoService   bookInfoService;
    private BookInfo          bookInfo;
    private BookItemService   bookItemService;
    private CommentService    commentService;

    private List<BookItem>    bookItemList;
    private List<BookInfoComment> commentList;
    private List<BookInfo>    relatedBookInfoList;

    // private Member owner;
    public String execute() throws Exception {
        setBookInfo(bookInfoService.searchBookByInfoId(bookInfoId));
        // owner = memberService.findMemberByLoginId(loginId);
        if (getBookInfo() == null) {
            return ERROR;
        }

        bookItemList = bookItemService.listBookItemByBookInfoId(bookInfoId);
        commentList = commentService.listBookCommentByBookInfoId(bookInfoId, 1, 100);
        BookSearchResult bookSearchResult = bookInfoService.searchBookByKeyword(bookInfo.getName(), SearchBookType.ALL,
                                                                                1, 10);
        relatedBookInfoList = bookSearchResult.getBookList();
        return SUCCESS;
    }

    public List<BookInfo> getRelatedBookInfoList() {
        return relatedBookInfoList;
    }

    public void setRelatedBookInfoList(List<BookInfo> relatedBookInfoList) {
        this.relatedBookInfoList = relatedBookInfoList;
    }

    public List<BookInfoComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<BookInfoComment> commentList) {
        this.commentList = commentList;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public List<BookItem> getBookItemList() {
        return bookItemList;
    }

    public void setBookItemList(List<BookItem> bookItemList) {
        this.bookItemList = bookItemList;
    }

    public BookItemService getBookItemService() {
        return bookItemService;
    }

    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
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
