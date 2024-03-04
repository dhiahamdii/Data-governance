package com.coderdot.controllers;
import com.coderdot.exception.ResourceNotFoundException;
import com.coderdot.dto.EtatUser;
import com.coderdot.entities.User;
import com.coderdot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //get all data
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user")
    public List <User> getAllUsers(){
        return userRepository.findAll();
    }



    //create 
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }


    // get data by id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getByID(@PathVariable Long id) {
        User user = userRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("User with id "+id+"does not exists"));
        return ResponseEntity.ok(user);
    }


    //update data
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ("/user/{id}")
    public ResponseEntity<User> updateUserByID(@PathVariable Long id, @RequestBody User employeeDetails){
        User user = userRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("User with id "+id+"does not exists"));


        user.setFname(employeeDetails.getFname());
        user.setLname(employeeDetails.getLname());
        user.setEmail(employeeDetails.getEmail());
        user.setDepartment(employeeDetails.getDepartment());
        user.setDesignation(employeeDetails.getDesignation());
        user.setJoiningDate(employeeDetails.getJoiningDate());
        user.setSalary(employeeDetails.getSalary());

        User updatedUser= userRepository.save(user);

        return ResponseEntity.ok(updatedUser);
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/user/{id}")
    public ResponseEntity <Map<String, Boolean>>deleteUser(@PathVariable Long id){

        User user = userRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("User with id "+id+"does not exists"));

        userRepository.delete(user);

        Map<String, Boolean>  response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
}}
