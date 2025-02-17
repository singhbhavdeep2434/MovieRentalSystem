package com.j2ee.movierentalsystem.service;

import com.j2ee.movierentalsystem.dao.CustomerRepository;
import com.j2ee.movierentalsystem.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(Customer customer) {
        customer.setRegisteredDate(LocalDate.now());
        customerRepository.save(customer);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    public Customer getCustomerById(int id) {

        return customerRepository.findById(id);
    }

    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }
}
