package com.example.GestionRelationsEntites.controller;

import com.example.GestionRelationsEntites.model.Role;
import com.example.GestionRelationsEntites.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    // Récupérer tous les rôles
    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Créer un nouveau rôle
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // Supprimer un rôle par ID
    @DeleteMapping("/{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        if (!roleRepository.existsById(roleId)) {
            throw new RuntimeException("Rôle non trouvé");
        }
        roleRepository.deleteById(roleId);
    }

    // Récupérer un rôle par son ID
    @GetMapping("/{roleId}")
    public Role getRoleById(@PathVariable Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
    }

    // Recherche d'un rôle par nom
    @GetMapping("/nom/{nom}")
    public Role getRoleByNom(@PathVariable String nom) {
        return roleRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
    }
}
