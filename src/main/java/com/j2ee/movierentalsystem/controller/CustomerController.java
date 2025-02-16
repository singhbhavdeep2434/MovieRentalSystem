package com.j2ee.movierentalsystem.controller;

import com.j2ee.movierentalsystem.model.Customer;
import com.j2ee.movierentalsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// @RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("register")
    public String registerCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "register-customer";
    }

    @PostMapping("register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.registerCustomer(customer);
        return "redirect:/customer-list";
    }

    @GetMapping("/customer-list")
    public String getCustomerList(Model model) {
        List<Customer> customers = customerService.getCustomerList(); // Fetch all customers
        model.addAttribute("customers", customers); // Pass the list to the view
        return "customer-list"; // Return the Thymeleaf template name
    }

    @GetMapping("/{id}")
    public String getCustomerById(Model model, @PathVariable int id) {
        customerService.getCustomerById(id);
        return "customerDetails";
    }
}
