package com.example.backendspr.models;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Documentation")
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDocumentation;
    private String description;
    @Enumerated(EnumType.STRING)
    private Loi TypeLoi;

    @Enumerated(EnumType.STRING)
    private Regle Regle;

}


