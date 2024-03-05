package com.coderdot.controllers;

import com.coderdot.entities.Customer;
import com.coderdot.exception.ResourceNotFoundException;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {


    @Autowired
    private CustomerRepository customerRepository;
    private  PasswordEncoder passwordEncoder;





        @Autowired
        private CustomerService customerService;
        @CrossOrigin(origins = "http://localhost:4200")
        @PutMapping("/change-password/{userId}")
        public ResponseEntity<String> changePassword(@PathVariable Long userId, @RequestParam String oldPassword, @RequestParam String newPassword) {
            customerService.changePassword(userId, oldPassword, newPassword);
            return ResponseEntity.ok("Password changed successfully");
        }






    //get all data
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/customer")
    public List<Customer> getcustomer(){
        return customerRepository.findAll();
    }



    //create 
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }


    // get data by id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getByID(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Customer with id "+id+"does not exists"));
        return ResponseEntity.ok(customer);
    }


    //update data
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/customer/{id}")
    public ResponseEntity<Customer> updateCustomerByID(@PathVariable Long id, @RequestBody Customer userDetails){
        Customer customer = customerRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Customer with id "+id+"does not exists"));


        customer.setName(userDetails.getName());
        customer.setPassword(userDetails.getPassword());
        Customer updatedCustomer= customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/customer/{id}/password")
    public ResponseEntity<?> updateCustomerPassword(@PathVariable Long id, @RequestParam String oldPassword, @RequestParam String newPassword) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " does not exist"));

        // Check if the provided old password matches the stored password
        if (passwordEncoder.matches(oldPassword, customer.getPassword())) {
            // If old password matches, encode and update the new password
            customer.setPassword(passwordEncoder.encode(newPassword));
            customerRepository.save(customer);
            return ResponseEntity.ok().build();
        } else {
            // If old password doesn't match, return error response
            return ResponseEntity.badRequest().body("Old password is incorrect");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/customer/{id}")
    public ResponseEntity <Map<String, Boolean>>deleteCustomer(@PathVariable Long id){

        Customer customer = customerRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Customer with id "+id+"does not exists"));

        customerRepository.delete(customer);

        Map<String, Boolean>  response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
