package com.proxiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proxiva.model.Booking;
import com.proxiva.service.BookingService;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book-service/{serviceId}")
    public String bookService(@PathVariable Long serviceId) {

        Booking booking = new Booking();

        booking.setUserId(1L);
        booking.setProviderId(1L);
        booking.setServiceId(serviceId);
        booking.setStatus("Pending");

        bookingService.createBooking(booking);

        return "redirect:/bookings";
    }

    @GetMapping("/bookings")
    public String bookingsPage(Model model) {

        model.addAttribute("bookings",
                bookingService.getBookingsByUserId(1L));

        return "bookings";
    }

    @GetMapping("/provider/bookings")
    public String providerBookings(Model model) {

        model.addAttribute("bookings",
                bookingService.getAllBookings());

        return "booking-requests";
    }

    @GetMapping("/booking/accept/{bookingId}")
    public String acceptBooking(@PathVariable Long bookingId) {

        bookingService.updateBookingStatus(bookingId, "Accepted");

        return "redirect:/provider/bookings";
    }

    @GetMapping("/booking/reject/{bookingId}")
    public String rejectBooking(@PathVariable Long bookingId) {

        bookingService.updateBookingStatus(bookingId, "Rejected");

        return "redirect:/provider/bookings";
    }

    @GetMapping("/booking/complete/{bookingId}")
    public String completeBooking(@PathVariable Long bookingId) {

        bookingService.updateBookingStatus(bookingId, "Completed");

        return "redirect:/provider/bookings";
    }

    @GetMapping("/contact-provider/{bookingId}")
    public String contactProviderPage(@PathVariable Long bookingId,
                                      Model model) {

        model.addAttribute("bookingId", bookingId);

        return "contact-provider";
    }

    @GetMapping("/payment/{bookingId}")
    public String paymentPage(@PathVariable Long bookingId,
                              Model model) {

        model.addAttribute("bookingId", bookingId);

        return "payment";
    }

    @GetMapping("/review/{bookingId}")
    public String reviewPage(@PathVariable Long bookingId,
                             Model model) {

        model.addAttribute("bookingId", bookingId);

        return "review";
    }
}