package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.CommentMassageDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.CommentMassageContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;
import com.projet.DeuxMainsPourToi.metier.service.CommentMassageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/comment_massage")
public class CommentMassageController {

    private final CommentMassageService service;

    public CommentMassageController(CommentMassageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CommentMassageDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
        return ResponseEntity.ok("Commentaire massage ajouté.");
    }

    @GetMapping
    public ResponseEntity<CommentMassageContainer> getALl(){
        List<CommentMassageDTO> list = service.getAll();
        return ResponseEntity.ok(new CommentMassageContainer(list, list.size()));
    }

    @GetMapping("/massage/{id}")
    public ResponseEntity<CommentMassageContainer> getAllByMassageMassageID(@PathVariable int id){
        List<CommentMassageDTO> list = service.getAllByMassageIdMassage(id);
        System.out.println(list);
        return ResponseEntity.ok(new CommentMassageContainer( list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentMassageDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody CommentMassageDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Commentaire massage mis à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Commentaire massage supprimé.");
    }
}
