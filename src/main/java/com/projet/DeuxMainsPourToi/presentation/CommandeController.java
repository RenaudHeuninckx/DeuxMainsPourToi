package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.CommandeDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.CommandeContainer;
import com.projet.DeuxMainsPourToi.metier.service.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final CommandeService service;

    public CommandeController(CommandeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CommandeDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
        return ResponseEntity.ok("Commande ajoutée.");
    }

    @GetMapping
    public ResponseEntity<CommandeContainer> getAll(){
        List<CommandeDTO> list = service.getAll();
        return ResponseEntity.ok(new CommandeContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CommandeDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Commande mise à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Commande supprimée.");
    }
}
