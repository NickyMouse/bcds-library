package com.alibaba.intl.bcds.goldroom.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Query;

import com.alibaba.intl.bcds.goldroom.dao.BaseDao;
import com.alibaba.intl.bcds.goldroom.dao.FavoriteDao;
import com.alibaba.intl.bcds.goldroom.dataobject.Favorite;

@SuppressWarnings("unchecked")
public class FavoriteDaoImpl extends BaseDao implements FavoriteDao {

    @Override
    public List<Favorite> listFavoriteByLoginId(String loginId, int page, int pagesize) {
        if (StringUtils.isBlank(loginId)) {
            return new ArrayList<Favorite>(0);
        }

        Query q = this.createNamedQuery("listFavoriteByLoginId");
        q.setParameter("loginId", loginId);
        return q.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).list();
    }

    @Override
    public int countFavoriteByLoginId(String loginId) {
        if (StringUtils.isBlank(loginId)) {
            return 0;
        }

        Query q = this.createNamedQuery("countFavoriteByLoginId");
        q.setParameter("loginId", loginId);
        return ((Long) (q.list().get(0))).intValue();
    }

    @Override
    public List<Favorite> listFavoriteByBookInfoId(Integer bookInfoId, int page, int pagesize) {
        if (bookInfoId == null) {
            return new ArrayList<Favorite>(0);
        }

        Query q = this.createNamedQuery("listFavoriteByBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        return q.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).list();
    }

    @Override
    public int countFavoriteByBookInfoId(Integer bookInfoId) {
        if (bookInfoId == null) {
            return 0;
        }

        Query q = this.createNamedQuery("countFavoriteByBookInfoId");
        q.setParameter("bookInfoId", bookInfoId);
        return ((Long) (q.list().get(0))).intValue();
    }

    @Override
    public boolean deleteFavoriteById(Integer id) {
        Query q = this.createNamedQuery("deleteFavoriteById");
        q.setParameter("id", id);
        int resultCount = q.executeUpdate();
        return resultCount > 0 ? true : false;
    }

    @Override
    public void save(Favorite favorite) {
        favorite.setId(null);
        Date now = new Date();
        favorite.setGmtCreate(now);
        favorite.setGmtModified(now);
        super.save(favorite);
    }

    @Override
    public List<Favorite> listFavoriteByBookInfoIdAndLoginId(Integer bookInfoId, String loginId) {
        if (bookInfoId == null || StringUtils.isBlank(loginId)) {
            return new ArrayList<Favorite>(0);
        }
        Query q = this.createNamedQuery("listFavoriteByBookInfoIdAndLoginId");
        q.setParameter("bookInfoId", bookInfoId);
        q.setParameter("loginId", loginId);
        return q.list();
    }

}
