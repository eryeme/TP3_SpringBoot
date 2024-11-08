package com.example.GestionRelationsEntites.controller;

import com.example.GestionRelationsEntites.model.Utilisateur;
import com.example.GestionRelationsEntites.model.UtilisateurImage;
import com.example.GestionRelationsEntites.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @PostMapping
    public Utilisateur creerUtilisateur(@RequestBody Utilisateur utilisateur, @RequestParam Long roleId) {
        return utilisateurService.creerUtilisateur(utilisateur, roleId);
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurParId(@PathVariable Long id) {
        return utilisateurService.getUtilisateurParId(id);
    }

    @PutMapping("/{utilisateurId}/role/{roleId}")
    public Utilisateur associerRole(@PathVariable Long utilisateurId, @PathVariable Long roleId) {
        return utilisateurService.associerRole(utilisateurId, roleId);
    }

    @PostMapping("/{utilisateurId}/image")
    public Utilisateur ajouterImage(@PathVariable Long utilisateurId, @RequestBody UtilisateurImage image) {
        return utilisateurService.ajouterImage(utilisateurId, image);
    }

    @DeleteMapping("/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateur(id);
    }
}
