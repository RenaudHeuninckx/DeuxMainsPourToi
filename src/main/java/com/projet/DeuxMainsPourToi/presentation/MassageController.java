package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.MassageContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;
import com.projet.DeuxMainsPourToi.metier.service.MassageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/massage")
public class MassageController {

    private final MassageService service;

    public MassageController(MassageService service) {
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<String> create(@RequestBody MassageDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
        return ResponseEntity.ok("Massage ajouté.");
    }

    @GetMapping
    private ResponseEntity<MassageContainer> getAll(){
        List<MassageDTO> list = service.getAll();
        return ResponseEntity.ok(new MassageContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    private ResponseEntity<MassageDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody MassageDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Massage mis à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Massage supprimé.");
    }
}
