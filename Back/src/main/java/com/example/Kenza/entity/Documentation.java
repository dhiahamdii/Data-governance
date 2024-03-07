package com.example.Kenza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private String Label;

    private String Fichier;

    private String Type;
    @JsonIgnore
    @OneToMany(mappedBy = "documentation", cascade = CascadeType.ALL)
    private List<Loi> lois = new ArrayList<>();
}
