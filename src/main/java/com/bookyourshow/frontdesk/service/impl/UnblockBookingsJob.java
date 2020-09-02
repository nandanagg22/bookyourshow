package com.bookyourshow.frontdesk.service.impl;

import com.bookyourshow.frontdesk.persistence.model.Booking;
import com.bookyourshow.frontdesk.persistence.model.BookingStatus;
import com.bookyourshow.frontdesk.persistence.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Component
public class UnblockBookingsJob {
    private static final Logger LOG = LoggerFactory.getLogger(UnblockBookingsJob.class);
    private BookingRepository bookingRepository;
    @Value("${booking.lock.timeout}")
    public long timeoutThreshold;

    public UnblockBookingsJob(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Scheduled(fixedRate = 2000)
    @Transactional
    public void unblockLongBlockedSeats() {
        Timestamp timestamp =  new Timestamp(System.currentTimeMillis() - timeoutThreshold);
        List<Booking> bookings =
                bookingRepository.findAllByStatusAndBookingTimeLessThan(BookingStatus.IN_PROGRESS, timestamp);
        if(bookings.isEmpty()) {
            LOG.info("No in progress Booking found!!");
        }

        bookings.forEach(booking -> {
            LOG.info("Unblocking  ID: "+ booking.getId());
            booking.setStatus(BookingStatus.AVAILABLE);
            bookingRepository.save(booking);
            LOG.info("Booking  ID: "+ booking.getId() + " unblocked");
        });
    }
}
