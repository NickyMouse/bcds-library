package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Favorite;

public interface FavoriteDao {

    List<Favorite> listFavoriteByLoginId(String loginId, int page, int pagesize);

    int countFavoriteByLoginId(String loginId);

    List<Favorite> listFavoriteByBookInfoId(Integer bookInfoId, int page, int pagesize);

    int countFavoriteByBookInfoId(Integer bookInfoId);

    boolean deleteFavoriteById(Integer id);

    void save(Favorite favorite);

    List<Favorite> listFavoriteByBookInfoIdAndLoginId(Integer bookInfoId, String loginId);
}
