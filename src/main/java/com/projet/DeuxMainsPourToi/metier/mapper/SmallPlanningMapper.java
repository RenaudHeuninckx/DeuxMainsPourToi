package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Planning;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallPlanningDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallPlanningMapper implements Mapper<SmallPlanningDTO, Planning> {
    @Override
    public SmallPlanningDTO toDTO(Planning entity) {

        if (entity == null) return null;

        SmallPlanningDTO DTO = new SmallPlanningDTO();

        DTO.setId(entity.getId());
        DTO.setRendezVousDate(entity.getRendezVousDate());
        DTO.setRendezVousHeure(entity.getRendezVousHeure());
        DTO.setCommentaire(entity.getCommentaire());

        return DTO;
    }

    @Override
    public Planning toEntity(SmallPlanningDTO DTO) {

        if (DTO == null) return null;

        Planning entity = new Planning();

        entity.setId(DTO.getId());
        entity.setRendezVousDate(DTO.getRendezVousDate());
        entity.setRendezVousHeure(DTO.getRendezVousHeure());
        entity.setCommentaire(DTO.getCommentaire());

        return entity;
    }
}
