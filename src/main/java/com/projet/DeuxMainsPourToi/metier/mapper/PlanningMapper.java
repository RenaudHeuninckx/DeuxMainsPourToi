package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import com.projet.DeuxMainsPourToi.DAL.entity.Planning;
import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import com.projet.DeuxMainsPourToi.metier.DTO.PlanningDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallMassageDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallUtilisateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanningMapper implements Mapper<PlanningDTO, Planning> {

    @Autowired
    private Mapper<SmallUtilisateurDTO, Utilisateur> mapperUtilisateur;

    @Autowired
    private  Mapper<SmallMassageDTO, Massage> mapperMassage;

    @Override
    public PlanningDTO toDTO(Planning entity) {

        if (entity == null) return null;

        PlanningDTO DTO = new PlanningDTO();

        DTO.setId(entity.getId());
        DTO.setUtilisateur(mapperUtilisateur.toDTO(entity.getUtilisateur()));
        DTO.setMassage(mapperMassage.toDTO(entity.getMassage()));
        DTO.setRendezVousDate(entity.getRendezVousDate());
        DTO.setRendezVousHeure(entity.getRendezVousHeure());
        DTO.setCommentaire(entity.getCommentaire());

        return DTO;
    }

    @Override
    public Planning toEntity(PlanningDTO DTO) {

        if (DTO == null) return null;

        Planning entity = new Planning();

        entity.setId(DTO.getId());
        entity.setUtilisateur(mapperUtilisateur.toEntity(DTO.getUtilisateur()));
        entity.setMassage(mapperMassage.toEntity(DTO.getMassage()));
        entity.setRendezVousDate(DTO.getRendezVousDate());
        entity.setRendezVousHeure(DTO.getRendezVousHeure());
        entity.setCommentaire(DTO.getCommentaire());

        return entity;
    }
}
