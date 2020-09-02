package com.bookyourshow.frontdesk.service.impl;

import com.bookyourshow.frontdesk.persistence.model.Booking;
import com.bookyourshow.frontdesk.persistence.model.BookingStatus;
import com.bookyourshow.frontdesk.persistence.repository.BookingRepository;
import com.bookyourshow.frontdesk.service.BookingService;
import com.bookyourshow.frontdesk.service.exceptions.BookingUnavailableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @PersistenceContext
    private EntityManager entityManager;
    private BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public List<Booking> bookSeats(List<Booking> bookings) {
        List<Booking> bookedSeats = new ArrayList<>();

        bookings.forEach(booking -> {
            Booking bookingObj = entityManager.find(Booking.class, booking.getId(), LockModeType.PESSIMISTIC_WRITE);
            entityManager.refresh(bookingObj);
            //latency();
            ensureBookingAvailable(bookingObj);

            bookingObj.setBookingTime(new Timestamp(System.currentTimeMillis()));
            bookingObj.setStatus(BookingStatus.IN_PROGRESS);
            entityManager.persist(bookingObj);
            entityManager.flush();

            bookedSeats.add(bookingObj);
        });

        return bookedSeats;
    }

    private void ensureBookingAvailable(Booking bookingObj) {
        if (!bookingObj.getStatus().equals(BookingStatus.AVAILABLE)) {
            throw new BookingUnavailableException("seat number : " + bookingObj.getSeatNumber() + " unavailable");
        }
    }

    private void latency() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
