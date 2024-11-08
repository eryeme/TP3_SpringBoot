package com.example.GestionRelationsEntites.controller;

import com.example.GestionRelationsEntites.model.UtilisateurImage;
import com.example.GestionRelationsEntites.repository.UtilisateurImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur-images")
public class UtilisateurImageController {

    @Autowired
    private UtilisateurImageRepository utilisateurImageRepository;

    // Récupérer toutes les images des utilisateurs
    @GetMapping
    public List<UtilisateurImage> getAllUtilisateurImages() {
        return utilisateurImageRepository.findAll();
    }

    // Créer une nouvelle image pour un utilisateur
    @PostMapping
    public UtilisateurImage createImage(@RequestBody UtilisateurImage utilisateurImage) {
        return utilisateurImageRepository.save(utilisateurImage);
    }

    // Supprimer une image par ID
    @DeleteMapping("/{imageId}")
    public void deleteImage(@PathVariable Long imageId) {
        if (!utilisateurImageRepository.existsById(imageId)) {
            throw new RuntimeException("Image non trouvée");
        }
        utilisateurImageRepository.deleteById(imageId);
    }

    // Récupérer une image d'utilisateur par ID
    @GetMapping("/{imageId}")
    public UtilisateurImage getImageById(@PathVariable Long imageId) {
        return utilisateurImageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image non trouvée"));
    }
}

