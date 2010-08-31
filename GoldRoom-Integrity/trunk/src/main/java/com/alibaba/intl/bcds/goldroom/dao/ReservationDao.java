package com.alibaba.intl.bcds.goldroom.dao;

import java.util.List;

import com.alibaba.intl.bcds.goldroom.dataobject.Reservation;

public interface ReservationDao {

    Reservation save(Reservation reservation);

    Reservation findById(Integer id);

    boolean updateById(Reservation reservation);

    boolean cutReservationToLog(Reservation reservation);

    boolean updateStateByBookItemId(int bookItemId, String state);

    // boolean updateStateById(int reservationId, String state);

    List<Reservation> listByLoginId(String loginId, int page, int pageSize);

    int countByLogindId(String loginId);
    
    List<Reservation> listByBookItemId(Integer bookItemId);
    int countByBookItemId(Integer bookItemId);
    
    boolean deleteReservation(Integer id);
}
