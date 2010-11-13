package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.BookItemService;

public class BookManageAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = -4208533421503635231L;

    private String            type;
    private Integer           bookItemId;
    private BookItemService   bookItemService;

    private String            result;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setBookItemService(BookItemService bookItemService) {
        this.bookItemService = bookItemService;
    }

    public BookItemService getBookItemService() {
        return bookItemService;
    }

    public String execute() throws Exception {
        UserDTO user = this.getUserDTO();
        if (user == null || type == null || bookItemId == null) {
            return ERROR;
        }

        if ("onShelve".equals(type)) {
            bookItemService.reputOnShelves(bookItemId, user.getLoginId());
            result = SUCCESS;
        } else if ("offShelve".equals(type)) {
            bookItemService.offShelves(bookItemId, user.getLoginId());
            result = SUCCESS;
        } else {
            result = ERROR;
        }

        return result;
    }

    public void setBookItemId(Integer bookItemId) {
        this.bookItemId = bookItemId;
    }

    public Integer getBookItemId() {
        return bookItemId;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
