package com.alibaba.intl.goldroom.result;

import java.util.List;

import com.alibaba.intl.goldroom.dataobject.Reservation;

public class ReservationResult extends Result {

    private List<Reservation> reservationList;

    public ReservationResult(List<Reservation> reservationList, int totalCount) {
        this.totalCount = totalCount;
        this.setReservationList(reservationList);
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

}
