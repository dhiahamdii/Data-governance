package com.example.Kenza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Regle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String Contenu ;

    private String Nom ;
    @JsonIgnore
    @ManyToOne
    private  Loi  loi;
}
