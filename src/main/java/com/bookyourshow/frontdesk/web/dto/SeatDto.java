package com.bookyourshow.frontdesk.web.dto;

import com.bookyourshow.frontdesk.persistence.model.BookingStatus;

public class SeatDto {
    private String seatNumber;
    private BookingStatus status;

    public SeatDto(String seatNumber, BookingStatus status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
