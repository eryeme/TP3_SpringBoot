package com.example.GestionRelationsEntites.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;

    @ManyToOne
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private UtilisateurImage image;
}
