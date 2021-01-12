package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Produit;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallProduitDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallProduitMapper implements Mapper<SmallProduitDTO, Produit> {
    @Override
    public SmallProduitDTO toDTO(Produit entity) {

        if (entity == null) return null;

        SmallProduitDTO DTO = new SmallProduitDTO();

        DTO.setId(entity.getId());
        DTO.setType(entity.getType());
        DTO.setDescription(entity.getDescription());
        DTO.setPrix(entity.getPrix());

        return DTO;
    }

    @Override
    public Produit toEntity(SmallProduitDTO DTO) {

        if (DTO == null) return null;

        Produit entity = new Produit();

        entity.setId(DTO.getId());
        entity.setType(DTO.getType());
        entity.setDescription(DTO.getDescription());
        entity.setPrix(DTO.getPrix());

        return entity;
    }
}
