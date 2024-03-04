package com.coderdot.controllers;

import com.coderdot.entities.Customer;
import com.coderdot.exception.ResourceNotFoundException;
import com.coderdot.repository.CustomerRepository;
import com.coderdot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

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
        customer.setEmail(userDetails.getEmail());
customer.setPassword(userDetails.getPassword());
        Customer updatedCustomer= customerRepository.save(customer);

        return ResponseEntity.ok(updatedCustomer);
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
