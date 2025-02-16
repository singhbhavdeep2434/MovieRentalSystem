package com.j2ee.movierentalsystem.dao;

import com.j2ee.movierentalsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int id);
    Customer findCustomerByEmail(String email);

}
