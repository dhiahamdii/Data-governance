package com.example.Kenza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Loi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private int numero ;
    @JsonIgnore
    @ManyToOne
    private Documentation documentation;
    @JsonIgnore
    @OneToMany (mappedBy = "loi")
    private List<Regle> regles;

}
