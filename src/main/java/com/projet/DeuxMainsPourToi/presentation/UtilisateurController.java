package com.projet.DeuxMainsPourToi.presentation;

import com.projet.DeuxMainsPourToi.Exception.*;
import com.projet.DeuxMainsPourToi.metier.DTO.Container.UtilisateurContainer;
import com.projet.DeuxMainsPourToi.metier.DTO.InfoLoginDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.UpdPwdDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;
import com.projet.DeuxMainsPourToi.metier.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }



    @PostMapping
    public ResponseEntity<String> create(@RequestBody UtilisateurDTO toCreate) throws ElementAlreadyExistException, InputNotUniqueException {
        service.create(toCreate);
        return ResponseEntity.ok("Utilisateur ajouté.");
    }

    @GetMapping
    public ResponseEntity<UtilisateurContainer> getAll(){
        List<UtilisateurDTO> list = service.getAll();
        list.forEach(u ->{u.setPassword(null);});
        return ResponseEntity.ok(new UtilisateurContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        UtilisateurDTO utilisateurDTO = service.getOne(id);
        utilisateurDTO.setPassword(null);
        return ResponseEntity.ok(utilisateurDTO);
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

    @GetMapping("/login")
    public ResponseEntity<InfoLoginDTO> getInfoLogin(@RequestParam("email") String email) throws EmailNotFoundException {
        InfoLoginDTO infoLoginDTO = new InfoLoginDTO();
        UtilisateurDTO utilisateurDTO = service.findByEmail(email);
        infoLoginDTO.setPassword(utilisateurDTO.getPassword());
        infoLoginDTO.setAdmin(utilisateurDTO.isAdmin());
        return ResponseEntity.ok(infoLoginDTO);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UtilisateurDTO toUpdate) throws Exception{
        UtilisateurDTO utilisateurDTO = service.getOne(toUpdate.getId());
        toUpdate.setPassword(utilisateurDTO.getPassword());
        service.update(toUpdate);
        return ResponseEntity.ok("Utilisateur mis à jour.");
    }

    @PutMapping("/updpwd")
    public  ResponseEntity<String> updatePassword(UpdPwdDTO updPwdDTO) throws Exception{
        UtilisateurDTO toUpdate = service.findByEmail(updPwdDTO.getEmail());
        if (!toUpdate.getPassword().equals(updPwdDTO.getOldPwd()))
            throw new BadPasswordException();
        toUpdate.setPassword(updPwdDTO.getNewPwd());
        service.update(toUpdate);
        return ResponseEntity.ok("Mot de passe mis à jour.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws ElementNotFoundException{
        service.delete(id);
        return ResponseEntity.ok("Utilisateur supprimé.");
    }

}
