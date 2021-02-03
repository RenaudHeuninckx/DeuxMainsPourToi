package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import com.projet.DeuxMainsPourToi.DAL.repository.UtilisateurRepository;
import com.projet.DeuxMainsPourToi.Exception.*;
import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.UtilisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements CrudService<UtilisateurDTO, Integer> {

    @Autowired
    private UtilisateurMapper mapperUtilisateur;

    @Autowired
    private UtilisateurRepository repoUtilisateur;

    @Override
    public void create(@Valid UtilisateurDTO toCreate) throws ElementAlreadyExistException, InputNotUniqueException {
        if (repoUtilisateur.existsById(toCreate.getId()))
            throw new UtilisateurAlreadyExistException(toCreate.getId());
        List<Utilisateur> utilisateurs = repoUtilisateur.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getPseudo().equals(toCreate.getPseudo())) throw new PseudoNotUniqueException(toCreate.getPseudo());
            if (utilisateur.getEmail().equals(toCreate.getEmail())) throw new EmailNotUniqueException(toCreate.getEmail());
        }
        repoUtilisateur.save(mapperUtilisateur.toEntity(toCreate));
    }

    @Override
    public UtilisateurDTO getOne(Integer id) throws ElementNotFoundException {
        Utilisateur utilisateur = repoUtilisateur.findById(id)
                .orElseThrow( () -> new UtilisateurNotFoundException(id));
        return mapperUtilisateur.toDTO(utilisateur);
    }

    @Override
    public List<UtilisateurDTO> getAll() {
        return repoUtilisateur.findAll()
                .stream()
                .map(mapperUtilisateur::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid UtilisateurDTO toUpdate) throws ElementNotFoundException, InputNotUniqueException {
        if(!repoUtilisateur.existsById(toUpdate.getId()))
            throw new UtilisateurNotFoundException(toUpdate.getId());
        List<Utilisateur> utilisateurs = repoUtilisateur.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getId() != toUpdate.getId()) {
                if (utilisateur.getPseudo().equals(toUpdate.getPseudo()))
                    throw new PseudoNotUniqueException(toUpdate.getPseudo());
                if (utilisateur.getEmail().equals(toUpdate.getEmail()))
                    throw new EmailNotUniqueException(toUpdate.getEmail());
            }
        }
        repoUtilisateur.save(mapperUtilisateur.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if(!repoUtilisateur.existsById(toDelete))
            throw new UtilisateurNotFoundException(toDelete);
        repoUtilisateur.deleteById(toDelete);
    }

    public List<UtilisateurDTO> getByInscrit(Date date) {
        return repoUtilisateur.findByInscrit(date).stream().map(mapperUtilisateur::toDTO).collect(Collectors.toList());
    }

    public List<UtilisateurDTO> getAllByInscrit(Date date) {
        return repoUtilisateur.getAllByInscrit(date).stream().map(mapperUtilisateur::toDTO).collect(Collectors.toList());
    }

    public UtilisateurDTO findByEmail(String email) throws EmailNotFoundException{
        if (repoUtilisateur.findByEmail(email) == null)
            throw new EmailNotFoundException(email);
        return  mapperUtilisateur.toDTO(repoUtilisateur.findByEmail(email));
    }

}
