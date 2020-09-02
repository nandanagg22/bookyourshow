package com.bookyourshow.frontdesk.web.controller;

import com.bookyourshow.frontdesk.persistence.model.Booking;
import com.bookyourshow.frontdesk.persistence.repository.BookingRepository;
import com.bookyourshow.frontdesk.service.BookingService;
import com.bookyourshow.frontdesk.web.dto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private BookingRepository bookingRepository;
    private BookingService bookingService;

    public OrderController(BookingRepository bookingRepository,
                           BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    @PostMapping
    ResponseEntity<List<Booking>> createOrder(@RequestBody @Validated OrderDto order) {
        List<Booking> bookings = convertToBookings(order);
        bookings = bookingService.bookSeats(bookings);
        return new ResponseEntity<>(bookings, HttpStatus.CREATED);
    }

    private List<Booking> convertToBookings(OrderDto order) {
        List<Booking> bookings =
                bookingRepository.findAllByShowIdAndSeatNumberIn(order.getShowId(), order.getSeatNumbers());
        if (bookings.size() != order.getSeatNumbers().size()) {
            throw new IllegalArgumentException("Unable to find seat numbers !!");
        }
        return bookings;
    }

}
