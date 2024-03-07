package com.coderdot.services;

import com.coderdot.entities.Role;
import com.coderdot.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);

    // New method to retrieve roles by username
    List<String> findRolesByUsername(String username);
}
