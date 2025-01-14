package com.crm.crm.controller;

import com.crm.crm.model.Customer;
import com.crm.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Home page mapping
    @GetMapping("/")
    public String home() {
        return "home"; // Ensure you have a home.html in the templates folder.
    }

    // Show all customers
    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer-list"; // Make sure this template (customer-list.html) exists in the templates folder.
    }

    // Show the form to add a new customer
    @GetMapping("/customers/new")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form"; // Make sure this template (customer-form.html) exists in the templates folder.
    }

    // Save a new customer
    @PostMapping("/customers/save")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    // Show the form to edit an existing customer
    @GetMapping("/customers/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id).orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + id));
        model.addAttribute("customer", customer);
        return "customer-form"; // Reuse the same form for editing.
    }

    // Save the updated customer
    @PostMapping("/customers/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/customers";
    }

    // Delete a customer
    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
    
    //FAQ Page mapping
    @GetMapping("/faq")
    public String showFaqPage() {
        return "faq"; 
    }
    
    //About Page Mapping
    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
}
