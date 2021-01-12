package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallMassageDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallMassageMapper implements Mapper<SmallMassageDTO, Massage> {
    @Override
    public SmallMassageDTO toDTO(Massage entity) {

        if (entity == null) return null;

        SmallMassageDTO DTO = new SmallMassageDTO();

        DTO.setId(entity.getId());
        DTO.setNom(entity.getNom());
        DTO.setType(entity.getType());
        DTO.setDescription(entity.getDescription());
        DTO.setDuree(entity.getDuree());
        DTO.setPrix(entity.getPrix());

        return DTO;
    }

    @Override
    public Massage toEntity(SmallMassageDTO DTO) {

        if (DTO == null) return null;

        Massage entity = new Massage();

        entity.setId(DTO.getId());
        entity.setNom(DTO.getNom());
        entity.setType(DTO.getType());
        entity.setDescription(DTO.getDescription());
        entity.setDuree(DTO.getDuree());
        entity.setPrix(DTO.getPrix());

        return entity;
    }
}
