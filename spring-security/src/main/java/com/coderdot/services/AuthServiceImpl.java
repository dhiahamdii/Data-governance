package com.coderdot.services;

import com.coderdot.dto.SignupRequest;
import com.coderdot.dto.UserStatus;
import com.coderdot.entities.Customer;
import com.coderdot.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository CustomerRepository;

    @Autowired
    public AuthServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Customer createCustomer(SignupRequest signupRequest) {
        //Check if customer already exist
        if (customerRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(signupRequest,customer);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setPassword(hashPassword);
        Customer createdCustomer = customerRepository.save(customer);
        customer.setId(createdCustomer.getId());
        return customer;
    }
    @Override
    public Optional<Customer> findUserById(Long id) {
        return customerRepository.findById(id);
    }
    @Override
    public void updateUserStatus(long id) {
        Optional<Customer> customer = CustomerRepository.findById(id);
        if (customer.isPresent()) {
            customer.get().setStatus(UserStatus.DISCONNECTED.name());
            customerRepository.save(customer.orElse(null));
        }
    }
}
