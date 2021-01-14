package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.PlanningContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.PlanningDTO;
import com.projet.DeuxMainsPourToi.metier.service.PlanningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planning")
public class PlanningController {

    private final PlanningService service;

    public PlanningController(PlanningService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PlanningDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
        return ResponseEntity.ok("Planning ajouté.");
    }

    @GetMapping
    public ResponseEntity<PlanningContainer> getALl(){
        List<PlanningDTO> list = service.getAll();
        return ResponseEntity.ok(new PlanningContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanningDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PostMapping
    public ResponseEntity<String> update(@RequestBody PlanningDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Planning mis à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Planning supprimé");
    }
}
