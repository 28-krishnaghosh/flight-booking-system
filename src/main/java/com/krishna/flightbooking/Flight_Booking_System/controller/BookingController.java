package com.krishna.flightbooking.Flight_Booking_System.controller;

import com.krishna.flightbooking.Flight_Booking_System.entity.Booking;
import com.krishna.flightbooking.Flight_Booking_System.enums.BookingStatus;
import com.krishna.flightbooking.Flight_Booking_System.enums.PaymentStatus;
import com.krishna.flightbooking.Flight_Booking_System.repository.BookingRepository;
import com.krishna.flightbooking.Flight_Booking_System.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")

public class BookingController {

	@Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private FlightRepository flightRepo;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        var flight = flightRepo.findById(booking.getFlight().getId()).orElseThrow();
        flight.setAvailableSeats(flight.getAvailableSeats() - booking.getNumberOfSeats());
        flightRepo.save(flight);

        booking.setBookingTime(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setPaymentStatus(PaymentStatus.PAID);
        booking.setTotalPrice(flight.getPrice() * booking.getNumberOfSeats());
        
        return bookingRepo.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }
}
