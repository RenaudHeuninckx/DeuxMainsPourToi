package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.UtilisateurContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;
import com.projet.DeuxMainsPourToi.metier.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody UtilisateurDTO toCreate) throws ElementAlreadyExistException {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<UtilisateurContainer> getAll(){
        List<UtilisateurDTO> list = service.getAll();
        return ResponseEntity.ok(new UtilisateurContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UtilisateurDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Utilisateur mis à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Utilisateur supprimé.");
    }
}
