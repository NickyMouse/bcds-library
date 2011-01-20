package com.alibaba.intl.bcds.goldroom.service;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.intl.bcds.goldroom.dao.FavoriteDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Favorite;

@Transactional
public class FavoriteService {

    private static final Logger logger  = Logger.getLogger(FavoriteService.class);

    private static String       ERROR   = "error";
    private static String       SUCCESS = "success";
    private static String       EXISTS  = "exists";

    @Autowired
    private FavoriteDao         favoriteDao;

    public void setFavoriteDao(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    public FavoriteDao getFavoriteDao() {
        return favoriteDao;
    }

    public String save(Favorite favorite) {
        if (favorite == null) {
            return ERROR;
        }
        if (favorite.getBookInfo() == null || favorite.getBookInfo().getId() == null) {
            return ERROR;
        }
        if (favorite.getMember() == null || StringUtils.isBlank(favorite.getMember().getLoginId())) {
            return ERROR;
        }
        try {
            Integer bookInfoId = favorite.getBookInfo().getId();
            String loginId = favorite.getMember().getLoginId();
            List<Favorite> fList = favoriteDao.listFavoriteByBookInfoIdAndLoginId(bookInfoId, loginId);

            // 如果没有收藏过，那么收藏
            if (fList == null || fList.isEmpty()) {
                favoriteDao.save(favorite);
                return SUCCESS;
            } else {
                return EXISTS;
            }
        } catch (Exception e) {
            logger.error(e);
            return ERROR;
        }
    }

    public List<Favorite> listFavoriteByLoginId(String loginId, int page, int pageSize) {
        if (StringUtils.isBlank(loginId)) {
            return null;
        }
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            pageSize = 5;
        }
        return favoriteDao.listFavoriteByLoginId(loginId, page, pageSize);
    }

    public int countFavoriteByLoginId(String loginId) {
        return favoriteDao.countFavoriteByLoginId(loginId);
    }

    public int countFavoriteByBookInfoId(Integer bookInfoId) {
        if (bookInfoId == null) {
            return 0;
        }
        return favoriteDao.countFavoriteByBookInfoId(bookInfoId);
    }

    public boolean deleteFavoriteById(Integer id) {
        if (id == null) {
            return false;
        }
        return favoriteDao.deleteFavoriteById(id);
    }
}
