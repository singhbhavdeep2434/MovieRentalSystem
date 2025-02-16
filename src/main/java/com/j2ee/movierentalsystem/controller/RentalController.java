package com.j2ee.movierentalsystem.controller;

import ch.qos.logback.core.model.Model;
import com.j2ee.movierentalsystem.model.Rental;
import com.j2ee.movierentalsystem.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("rent")
    public String rent(Model model) {
        return "rentals/rent";
    }

    @PostMapping("rent")
    public String rent(@ModelAttribute Rental rental) {
        rentalService.rentMovie(rental);
        return "rentals/rent";
    }

    @GetMapping
    public String showRentals(Model model) {
        // rentalService.getRentalHistory();
        return "rentalHistory";
    }

    @PostMapping("return/{rentalId}")
    public String returnRental(@PathVariable int rentalId, Model model) {
        rentalService.returnMovie(rentalId);
        return "rentalHistory";
    }

}
