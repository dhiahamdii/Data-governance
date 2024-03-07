package com.coderdot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_role", columnDefinition = "VARCHAR(255)")
    private String nomRole;

    public String getRole() {
        return nomRole;
    }

    @Column(name = "description_role", columnDefinition = "VARCHAR(255)")
    private String descriptionRole;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<User> users;
}
