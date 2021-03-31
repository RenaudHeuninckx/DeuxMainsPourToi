package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.CommandeProduitContainer;
import com.projet.DeuxMainsPourToi.metier.service.CommandeProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/commande_produit")
public class CommandeProduitController {

    private final CommandeProduitService service;

    public CommandeProduitController(CommandeProduitService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CommandeProduitDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
        return ResponseEntity.ok("Commande produit ajouté.");
    }

    @GetMapping
    public ResponseEntity<CommandeProduitContainer> getAll(){
        List<CommandeProduitDTO> list = service.getAll();
        return ResponseEntity.ok(new CommandeProduitContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeProduitDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CommandeProduitDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Commande produit mis à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Commande produit supprimé.");
    }
}
