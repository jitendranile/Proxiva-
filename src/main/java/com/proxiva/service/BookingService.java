package com.proxiva.service;

import java.util.List;
import com.proxiva.model.Booking;

public interface BookingService {

    Booking createBooking(Booking booking);

    List<Booking> getBookingsByUserId(Long userId);

    List<Booking> getAllBookings();

    Booking updateBookingStatus(Long bookingId, String status);
}