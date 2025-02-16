package com.j2ee.movierentalsystem.service;
import com.j2ee.movierentalsystem.dao.RentalRepository;
import com.j2ee.movierentalsystem.model.Rental;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public List<Rental> getRentalHistory(int customerId) {
        return rentalRepository.findByCustomerId(customerId);
    }

    public void rentMovie(Rental rental) {
        rentalRepository.save(rental);
    }

    public void returnMovie(int rentalId) {
        rentalRepository.deleteById(rentalId);
    }
}
