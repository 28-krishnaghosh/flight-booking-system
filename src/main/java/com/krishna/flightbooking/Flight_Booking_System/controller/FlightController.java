package com.krishna.flightbooking.Flight_Booking_System.controller;

import com.krishna.flightbooking.Flight_Booking_System.entity.Flight;
import com.krishna.flightbooking.Flight_Booking_System.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/flights")

public class FlightController {
	@Autowired
    private FlightRepository flightRepo;

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        flight.setAvailableSeats(flight.getTotalSeats());
        return flightRepo.save(flight);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }
}
