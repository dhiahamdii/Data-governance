package com.coderdot.entities;

import com.coderdot.dto.EtatUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "password")
    private String password;
    private String username;
    private String fname;
    private String email;
    private boolean isActive;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")

    @ManyToOne
    @JoinColumn(name = "role_id") // Assuming "role_id" is the foreign key column name
    private Role role;
    // Getters and setters

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

/*
	public List<Role> getRoles() {
		return roles;
	}*/

    // Implement UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities/roles for the user
        return null; // You need to implement this method to return the user's authorities
    }

    @Override
    public String getPassword() {
        // Return the user's password
        return this.password;
    }

    @Override
    public String getUsername() {
        // Return the user's username
        return this.username;
    }
    // Implement other methods from UserDetails interface
    // These methods can return true or false based on your application's logic
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

