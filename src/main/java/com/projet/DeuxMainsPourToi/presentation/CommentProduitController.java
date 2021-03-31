package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.CommentProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.CommentProduitContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.ProduitDTO;
import com.projet.DeuxMainsPourToi.metier.service.CommentProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/comment_produit")
public class CommentProduitController {

    private final CommentProduitService service;

    public CommentProduitController(CommentProduitService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CommentProduitDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
        return ResponseEntity.ok("Commentaire produit ajouté.");
    }

    @GetMapping
    public ResponseEntity<CommentProduitContainer> getAll(){
        List<CommentProduitDTO> list = service.getAll();
        return ResponseEntity.ok(new CommentProduitContainer(list, list.size()));
    }

    @GetMapping("/produit/{id}")
    public ResponseEntity<CommentProduitContainer> getAllByProduitProduitId(@PathVariable int id){
        List<CommentProduitDTO> list = service.getAllByProduitIdProduit(id);
        return ResponseEntity.ok(new CommentProduitContainer(list,list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentProduitDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CommentProduitDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Commentaire produit mis à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Commentaire produit supprimé.");
    }
}
