package com.j2ee.movierentalsystem.controller;

import com.j2ee.movierentalsystem.model.Customer;
import com.j2ee.movierentalsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("register")
    public String registerCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "register-customer";
    }

    @PostMapping("register")
    public String registerCustomer(Model model, Customer customer) {
        customerService.registerCustomer(customer);
        return "redirect:/customers/list";
    }

    @GetMapping({"id"})
    public String getCustomerById(Model model, @PathVariable int id) {
        customerService.getCustomerById(id);
        return "customerDetails";
    }
}
