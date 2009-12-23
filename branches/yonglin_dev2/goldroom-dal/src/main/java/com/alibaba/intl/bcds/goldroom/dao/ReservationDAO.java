package com.alibaba.intl.bcds.goldroom.dao;

import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;

public interface ReservationDAO {

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    void insert(Reservation record);

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    void insertSelective(Reservation record);

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    Reservation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    int updateByPrimaryKeySelective(Reservation record);

    /**
     * This method was generated by Apache iBATIS ibator. This method
     * corresponds to the database table RESERVATION
     * 
     * @ibatorgenerated Tue Sep 29 19:05:09 CST 2009
     */
    int updateByPrimaryKey(Reservation record);

    /**
     * @param reservation
     */
    void cutReservationToLog(Reservation reservation);
    
    /**
     * 根据bookItemId 更新借阅的状态
     * @param bookItemId
     * @param state
     */
    int updateStateByBookItemId(int bookItemId, String state);
    
    /**
     * 根据id 更新借阅的状态
     * @param bookItemId
     * @param state
     */
    int updateStateById(int reservationId, String state);
    
    
}
