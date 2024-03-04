package com.coderdot.controllers;
import com.coderdot.entities.Customer;
import com.coderdot.dto.UserStatus;

import com.coderdot.repository.CustomerRepository;
import com.coderdot.services.AuthService;
import com.coderdot.services.AuthServiceImpl;
import com.coderdot.services.jwt.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api")
public class LogoutController {

    private AuthService authService;
    private  CustomerRepository customerRepository ;
    @Autowired
    public LogoutController(AuthService authService, CustomerRepository customerRepository) {
        this.authService = authService;
        this.customerRepository = customerRepository;
    }
    @PostMapping(value = "/logout/{id}")
    public ResponseEntity<?> updateUserStatus(@PathVariable long id) {
        //TODO change user status..
        authService.updateUserStatus(id);
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setStatus("DISCONNECTED");
            customerRepository.save(customer);

        }
        return ResponseEntity.notFound().build();
    }
}
//ok().build();
