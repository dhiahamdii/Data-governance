package com.coderdot.services;

import com.coderdot.entities.Role;
import com.coderdot.entities.User;
import com.coderdot.repository.RoleRepository;
import com.coderdot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRep;
    @Autowired
    private RoleRepository roleRep;
    @Autowired
    @Qualifier("passwordEncoder") // Use the correct qualifier here
    private PasswordEncoder bCryptPasswordEncoder; // Change the type to PasswordEncoder

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }
    @Override
    public User addRoleToUser(String username, String roleName) {
        User user = userRep.findByUsername(username);
        Role role = roleRep.findByNomRole(roleName);

        // Check if the user or role is null
        if (user == null || role == null) {
            throw new IllegalArgumentException("User or role not found");
        }

        user.setRole(role); // Set the role directly to the user

        return userRep.save(user); // Save the updated user
    }

    @Override
    public List<String> findRolesByUsername(String username) {
        return null;
    }

    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }
    @Override
    public User findUserByUsername(String username) {
        return userRep.findByUsername(username);
    }
}
