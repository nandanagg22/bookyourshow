package com.bookyourshow.frontdesk.persistence.repository;

import com.bookyourshow.frontdesk.persistence.model.Booking;
import com.bookyourshow.frontdesk.persistence.model.BookingStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;

public interface BookingRepository extends PagingAndSortingRepository<Booking, Long> {
    List<Booking> findAllByShowId(Long showId);
    List<Booking> findAllByShowIdAndStatus(Long showId, BookingStatus status);
    List<Booking> findAllByShowIdAndSeatNumberIn(Long showId, List<String> seatNumbers);
    List<Booking> findAllByStatusAndBookingTimeLessThan(BookingStatus bookingStatus, Timestamp timestamp);
}
