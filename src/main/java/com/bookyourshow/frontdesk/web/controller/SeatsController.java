package com.bookyourshow.frontdesk.web.controller;

import com.bookyourshow.frontdesk.persistence.model.Booking;
import com.bookyourshow.frontdesk.persistence.model.BookingStatus;
import com.bookyourshow.frontdesk.persistence.repository.BookingRepository;
import com.bookyourshow.frontdesk.web.dto.SeatDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/show/{showId}/seats")
public class SeatsController {

    private BookingRepository bookingRepository;

    public SeatsController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public Iterable<SeatDto> findAllSeatsForShow(@PathVariable Long showId) {
        return bookingRepository.findAllByShowId(showId)
                .stream()
                .map(this::convertToSeatDTO)
                .collect(Collectors.toList());
    }

    private SeatDto convertToSeatDTO(Booking booking) {
        return new SeatDto(booking.getSeatNumber(),
                           booking.getStatus().equals(BookingStatus.IN_PROGRESS)
                           ? BookingStatus.BOOKED : booking.getStatus());
    }
}
