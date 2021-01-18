package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Commande;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommandeDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallCommandeMapper implements Mapper<SmallCommandeDTO, Commande> {

    @Override
    public SmallCommandeDTO toDTO(Commande entity) {

        if (entity == null) return null;

        SmallCommandeDTO DTO = new SmallCommandeDTO();

        DTO.setId(entity.getId());
        DTO.setDate(entity.getDate());
        DTO.setHeure(entity.getHeure());
        DTO.setMoyenPaiement(entity.getMoyenPaiement());
        DTO.setStatusPaiement(entity.getStatusPaiement());
        DTO.setStatusCommande(entity.getStatusCommande());

        return DTO;
    }

    @Override
    public Commande toEntity(SmallCommandeDTO DTO) {

        if (DTO == null) return null;

        Commande entity = new Commande();

        entity.setId(DTO.getId());
        entity.setDate(DTO.getDate());
        entity.setHeure(DTO.getHeure());
        entity.setMoyenPaiement(DTO.getMoyenPaiement());
        entity.setStatusPaiement(DTO.getStatusPaiement());
        entity.setStatusCommande(DTO.getStatusCommande());

        return entity;
    }
}
