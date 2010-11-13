package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import org.apache.commons.lang.StringUtils;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.constaints.BookItemStateEnum;
import com.alibaba.intl.bcds.goldroom.dataobject.BookItem;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.result.BookItemResult;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;

public class MyBooksListAction extends BaseAction {

    /**
	 *
	 */
    private static final long serialVersionUID = -4469003624699130274L;
    private BookItemService   bookItemService;

    private String            state;

    private int               page;
    private int               pageSize;
    private Integer           anchorBookItemId;
    private BookItem          anchorBookItem;
    private BookItemResult    bookItemResult;

    public BookItemService getBookItemService() {
        return bookItemService;
    }

    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String execute() throws Exception {
        UserDTO user = this.getUserDTO();
        if (user == null) {
            return ERROR;
        }
        if (page <= 0) {
            page = 1;
        }
        if (StringUtils.isBlank(state) || !BookItemStateEnum.isValidState(state)) {
            state = "all";
        }
        bookItemResult = bookItemService.listBookItemsByLoginIdAndState(user.getLoginId(), state, page, pageSize);

        if (anchorBookItemId != null) {
            anchorBookItem = bookItemService.findById(anchorBookItemId);
        }
        return SUCCESS;
    }

    public void setBookItemResult(BookItemResult bookItemResult) {
        this.bookItemResult = bookItemResult;
    }

    public BookItemResult getBookItemResult() {
        return bookItemResult;
    }

    public void setAnchorBookItemId(Integer anchorBookItemId) {
        this.anchorBookItemId = anchorBookItemId;
    }

    public Integer getAnchorBookItemId() {
        return anchorBookItemId;
    }

    public void setAnchorBookItem(BookItem anchorBookItem) {
        this.anchorBookItem = anchorBookItem;
    }

    public BookItem getAnchorBookItem() {
        return anchorBookItem;
    }
}
