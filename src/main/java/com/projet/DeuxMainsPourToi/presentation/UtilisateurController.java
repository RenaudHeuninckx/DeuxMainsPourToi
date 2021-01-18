package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.UtilisateurContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;
import com.projet.DeuxMainsPourToi.metier.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UtilisateurDTO toCreate) throws ElementAlreadyExistException {
        service.create(toCreate);
        return ResponseEntity.ok("Utilisateur ajouté.");
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

    @GetMapping("/date")
    public ResponseEntity<UtilisateurContainer> getByInscrit(@RequestParam("date") String date) throws Exception {
        Date dateOk = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<UtilisateurDTO> list = service.getByInscrit(dateOk);
        return ResponseEntity.ok(new UtilisateurContainer(list, list.size()));
    }

    @GetMapping("/dateall")
    public ResponseEntity<UtilisateurContainer> getAllByInscrit(@RequestParam("date") String date) throws Exception{
        Date dateOk = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        List<UtilisateurDTO> list = service.getAllByInscrit(dateOk);
        return ResponseEntity.ok(new UtilisateurContainer(list, list.size()));
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
