package com.example.GestionRelationsEntites.service;

import com.example.GestionRelationsEntites.model.Role;
import com.example.GestionRelationsEntites.model.Utilisateur;
import com.example.GestionRelationsEntites.model.UtilisateurImage;
import com.example.GestionRelationsEntites.repository.RoleRepository;
import com.example.GestionRelationsEntites.repository.UtilisateurImageRepository;
import com.example.GestionRelationsEntites.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UtilisateurImageRepository utilisateurImageRepository;

    // Méthode pour récupérer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Méthode pour créer un nouvel utilisateur avec un rôle associé
    public Utilisateur creerUtilisateur(Utilisateur utilisateur, Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role non trouvé"));
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    // Méthode pour récupérer un utilisateur par son ID
    public Utilisateur getUtilisateurParId(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    // Méthode pour associer un rôle à un utilisateur
    public Utilisateur associerRole(Long utilisateurId, Long roleId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role non trouvé"));
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    // Méthode pour ajouter une image à un utilisateur
    public Utilisateur ajouterImage(Long utilisateurId, UtilisateurImage image) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        image = utilisateurImageRepository.save(image);
        utilisateur.setImage(image);
        return utilisateurRepository.save(utilisateur);
    }

    // Méthode pour supprimer un utilisateur par son ID
    public void supprimerUtilisateur(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur non trouvé");
        }
        utilisateurRepository.deleteById(id);
    }
}

