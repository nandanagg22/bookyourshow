package com.bookyourshow.frontdesk.web.controller;

import com.bookyourshow.frontdesk.persistence.model.Booking;
import com.bookyourshow.frontdesk.persistence.model.BookingStatus;
import com.bookyourshow.frontdesk.persistence.repository.BookingRepository;
import com.bookyourshow.frontdesk.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/show/{showId}/booking")
public class BookingController {
    private BookingRepository bookingRepository;
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingRepository bookingRepository,
                             BookingService bookingService) {
        this.bookingRepository = bookingRepository;
        this.bookingService = bookingService;
    }

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    Iterable<Booking> loadAllBookings(@PathVariable Long showId,
                                      @RequestParam(required = false) BookingStatus status) {
        return Objects.isNull(status) ? bookingRepository.findAllByShowId(showId)
                                      : bookingRepository.findAllByShowIdAndStatus(showId, status);
    }

    @PatchMapping("{id}")
    ResponseEntity<Booking> markBookingCompleted(@PathVariable Long id,
                                                 @RequestParam BookingStatus status) {
        Booking booking = bookingRepository.findById(id)
                                           .orElseThrow(() -> new IllegalArgumentException("Booking Not found!!"));
        booking.setStatus(status);
        return ResponseEntity.ok(bookingService.save(booking));
    }
}
