package com.j2ee.movierentalsystem.dao;

import com.j2ee.movierentalsystem.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    List<Rental> findByCustomerId(int customerId);
    void deleteById(int rentalId);
}
