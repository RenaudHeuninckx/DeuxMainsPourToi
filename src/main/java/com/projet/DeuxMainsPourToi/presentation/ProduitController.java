package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.ProduitContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.ProduitDTO;
import com.projet.DeuxMainsPourToi.metier.service.ProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produit")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProduitDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
        return ResponseEntity.ok("Produit ajouté.");
    }

    @GetMapping
    public ResponseEntity<ProduitContainer> getAll(){
        List<ProduitDTO> list = service.getAll();
        return ResponseEntity.ok(new ProduitContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ProduitDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Produit mis à jour");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Produit supprimé.");
    }
}
