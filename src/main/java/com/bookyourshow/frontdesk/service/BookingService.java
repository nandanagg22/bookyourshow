package com.bookyourshow.frontdesk.service;

import com.bookyourshow.frontdesk.persistence.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<Booking> bookSeats(List<Booking> bookings);
    Booking save(Booking booking);
}
