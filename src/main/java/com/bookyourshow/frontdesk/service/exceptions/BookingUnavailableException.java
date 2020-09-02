package com.bookyourshow.frontdesk.service.exceptions;

public class BookingUnavailableException extends RuntimeException {
    public BookingUnavailableException(String s) {
        super(s);
    }
}
