package com.alibaba.intl.bcds.goldroom.action.mygoldroom;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.action.base.BaseAction;
import com.alibaba.intl.bcds.goldroom.dataobject.BookInfo;
import com.alibaba.intl.bcds.goldroom.dataobject.Favorite;
import com.alibaba.intl.bcds.goldroom.dataobject.Member;
import com.alibaba.intl.bcds.goldroom.dataobject.UserDTO;
import com.alibaba.intl.bcds.goldroom.service.FavoriteService;

public class FavoriteAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = 3480850856658644213L;

    private List<Favorite>    favoriteList;
    private int               totalCount;
    private FavoriteService   favoriteService;
    private int               page;
    private int               pageSize;
    private Integer           bookInfoId;
    private Integer           favoriteId;

    private String            result;

    /**
     * view favorite list
     *
     * @return
     */
    public String doViewMyFavoriteList() {
        UserDTO userDTO = this.getUserDTO();
        if (userDTO == null) {
            return ERROR;
        }
        if (pageSize <= 0) {
            pageSize = 5;
        }
        if(page <=0){
            page = 1;
        }
        String loginId = userDTO.getLoginId();
        this.favoriteList = favoriteService.listFavoriteByLoginId(loginId, page, pageSize);
        this.totalCount = favoriteService.countFavoriteByLoginId(loginId);
        return SUCCESS;
    }

    /**
     * add a favorite
     *
     * @return
     */
    public String doAddFavorite() {
        UserDTO userDTO = this.getUserDTO();
        if (userDTO == null) {
            result = "needLogin";
            return SUCCESS;
        }

        String loginId = userDTO.getLoginId();

        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(bookInfoId);

        Member member = new Member();
        member.setLoginId(loginId);

        Favorite favorite = new Favorite();
        favorite.setBookInfo(bookInfo);
        favorite.setMember(member);

        result = favoriteService.save(favorite);

        return SUCCESS;
    }

    /**
     * delete favorite by favorite id
     *
     * @return
     */
    public String doDelFavorite() {
        setResult(ERROR);
        if (favoriteId != null) {
            if (favoriteService.deleteFavoriteById(favoriteId)) {
                setResult(SUCCESS);
                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            return ERROR;
        }

    }

    public List<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public FavoriteService getFavoriteService() {
        return favoriteService;
    }

    public void setFavoriteService(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
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

    public Integer getBookInfoId() {
        return bookInfoId;
    }

    public void setBookInfoId(Integer bookInfoId) {
        this.bookInfoId = bookInfoId;
    }

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
