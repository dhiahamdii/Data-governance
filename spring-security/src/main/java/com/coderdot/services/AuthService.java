package com.coderdot.services;

import com.coderdot.dto.SignupRequest;
import com.coderdot.entities.Customer;

import java.util.Optional;

public interface AuthService {
    Customer createCustomer(SignupRequest signupRequest);

    Optional<Customer> findUserById(Long id);

    void updateUserStatus(long id);

}
