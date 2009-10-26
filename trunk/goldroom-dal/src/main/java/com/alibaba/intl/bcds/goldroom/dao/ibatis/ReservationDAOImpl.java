package com.alibaba.intl.bcds.goldroom.dao.ibatis;

import java.sql.SQLException;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.intl.bcds.goldroom.dao.ReservationDAO;
import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ReservationDAOImpl extends SqlMapClientDaoSupport implements ReservationDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    public ReservationDAOImpl() {

    }

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    public int deleteByPrimaryKey(Integer id) {
        Reservation key = new Reservation();
        key.setId(id);
        int rows = getSqlMapClientTemplate().delete("RESERVATION.deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    public void insert(Reservation record) {
        getSqlMapClientTemplate().insert("RESERVATION.insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    public void insertSelective(Reservation record) {
        getSqlMapClientTemplate().insert("RESERVATION.insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    public Reservation selectByPrimaryKey(Integer id) {
        Reservation key = new Reservation();
        key.setId(id);
        Reservation record = (Reservation) getSqlMapClientTemplate().queryForObject(
                "RESERVATION.selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    public int updateByPrimaryKeySelective(Reservation record) {
        int rows = getSqlMapClientTemplate().update("RESERVATION.updateByPrimaryKeySelective",
                record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    public int updateByPrimaryKey(Reservation record) {
        int rows = getSqlMapClientTemplate().update("RESERVATION.updateByPrimaryKey", record);
        return rows;
    }

}
