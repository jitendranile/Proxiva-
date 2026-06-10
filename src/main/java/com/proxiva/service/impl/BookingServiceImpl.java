package com.proxiva.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxiva.model.Booking;
import com.proxiva.repository.BookingRepository;
import com.proxiva.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBookingStatus(Long bookingId, String status) {

        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if (booking != null) {
            booking.setStatus(status);
            return bookingRepository.save(booking);
        }

        return null;
    }
}