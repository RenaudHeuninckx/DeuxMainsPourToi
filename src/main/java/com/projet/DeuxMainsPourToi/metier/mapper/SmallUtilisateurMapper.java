package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallUtilisateurDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallUtilisateurMapper implements Mapper<SmallUtilisateurDTO, Utilisateur> {
    @Override
    public SmallUtilisateurDTO toDTO(Utilisateur entity) {

        if (entity == null) return null;

        SmallUtilisateurDTO DTO = new SmallUtilisateurDTO();

        DTO.setId(entity.getId());
        DTO.setNom(entity.getNom());
        DTO.setPrenom(entity.getPrenom());
        DTO.setPseudo(entity.getPseudo());
        DTO.setEmail(entity.getEmail());
        DTO.setPassword(entity.getPassword());
        DTO.setTel(entity.getTel());
        DTO.setGsm(entity.getGsm());
        DTO.setAdresse(entity.getAdresse());
        DTO.setCp(entity.getCp());
        DTO.setLoc(entity.getLoc());
        DTO.setComplAdr(entity.getComplAdr());
        DTO.setDateNaiss(entity.getDateNaiss());
        DTO.setAdmin(entity.isAdmin());
        DTO.setInscrit(entity.getInscrit());
        DTO.setSupprime(entity.getSupprime());

        return DTO;
    }

    @Override
    public Utilisateur toEntity(SmallUtilisateurDTO DTO) {

        if (DTO == null) return null;

        Utilisateur entity = new Utilisateur();

        entity.setId(DTO.getId());
        entity.setNom(DTO.getNom());
        entity.setPrenom(DTO.getPrenom());
        entity.setPseudo(DTO.getPseudo());
        entity.setEmail(DTO.getEmail());
        entity.setPassword(DTO.getPassword());
        entity.setTel(DTO.getTel());
        entity.setGsm(DTO.getGsm());
        entity.setAdresse(DTO.getAdresse());
        entity.setCp(DTO.getCp());
        entity.setLoc(DTO.getLoc());
        entity.setComplAdr(DTO.getComplAdr());
        entity.setDateNaiss(DTO.getDateNaiss());
        entity.setAdmin(DTO.isAdmin());
        entity.setInscrit(DTO.getInscrit());
        entity.setSupprime(DTO.getSupprime());

        return entity;
    }
}
