package com.coderdot.services;

import com.coderdot.entities.Customer;
import com.coderdot.exception.ResourceNotFoundException;
import com.coderdot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void changePassword(Long userId, String oldPassword, String newPassword) {
        Customer customer = customerRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (!passwordEncoder.matches(oldPassword, customer.getPassword())) {
            throw new IllegalArgumentException("Invalid old password");
        }
        customer.setPassword(passwordEncoder.encode(newPassword));
        customerRepository.save(customer);
    }
}
