package com.coderdot.controllers;

import com.coderdot.entities.Role;
import com.coderdot.entities.User;
import com.coderdot.repository.RoleRepository;
import com.coderdot.repository.UserRepository;
import com.coderdot.services.EMAILSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private EMAILSenderService mailService;

    @Autowired
    private RoleRepository roleRepository;
    // Endpoint to get all users
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    // Get User by ID
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Assuming the role ID is provided in the user object


        String pwd = user.getPassword();
        PasswordEncoder pass = new BCryptPasswordEncoder();
        user.setPassword(pass.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    @CrossOrigin(origins = "http://localhost:4200")

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            updatedUser.setId(userId.intValue());
            // Assuming the role ID is provided in the updated user object


            userRepository.save(updatedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Delete User
    @CrossOrigin(origins = "http://localhost:4200")

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
