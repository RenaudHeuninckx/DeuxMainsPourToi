package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.CommandeProduit;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommandeProduitDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallCommandeProduitMapper implements Mapper<SmallCommandeProduitDTO, CommandeProduit> {
    @Override
    public SmallCommandeProduitDTO toDTO(CommandeProduit entity) {

        if (entity == null) return null;

        SmallCommandeProduitDTO DTO = new SmallCommandeProduitDTO();

        DTO.setId(entity.getId());
        DTO.setQte(entity.getQte());

        return DTO;
    }

    @Override
    public CommandeProduit toEntity(SmallCommandeProduitDTO DTO) {

        if (DTO == null) return null;

        CommandeProduit entity = new CommandeProduit();

        entity.setId(DTO.getId());
        entity.setQte(DTO.getQte());

        return entity;
    }
}
