package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.CommandeProduit;
import com.projet.DeuxMainsPourToi.DAL.entity.CommentProduit;
import com.projet.DeuxMainsPourToi.DAL.entity.Produit;
import com.projet.DeuxMainsPourToi.metier.DTO.ProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommandeProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommentProduitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProduitMapper implements Mapper<ProduitDTO, Produit> {

    @Autowired
    private Mapper<SmallCommandeProduitDTO, CommandeProduit> mapperCommandeProduit;

    @Autowired
    private Mapper<SmallCommentProduitDTO, CommentProduit> mapperCommentProduit;

    @Override
    public ProduitDTO toDTO(Produit entity) {

        if (entity == null) return null;

        ProduitDTO DTO = new ProduitDTO();

        DTO.setId(entity.getId());
        DTO.setType(entity.getType());
        DTO.setDescription(entity.getDescription());
        DTO.setPrix(entity.getPrix());
        if (entity.getCommandeProduits() != null)
            DTO.setCommandeProduits(entity.getCommandeProduits().stream()
                    .map(mapperCommandeProduit::toDTO).collect(Collectors.toList()));
        if (entity.getCommentProduits() != null)
            DTO.setCommentProduits(entity.getCommentProduits().stream()
                    .map(mapperCommentProduit::toDTO).collect(Collectors.toList()));

        return DTO;
    }

    @Override
    public Produit toEntity(ProduitDTO DTO) {

        if (DTO == null) return null;

        Produit entity = new Produit();

        entity.setId(DTO.getId());
        entity.setType(DTO.getType());
        entity.setDescription(DTO.getDescription());
        entity.setPrix(DTO.getPrix());
        if(DTO.getCommandeProduits() != null)
            entity.setCommandeProduits(DTO.getCommandeProduits().stream()
                    .map(mapperCommandeProduit::toEntity).collect(Collectors.toList()));
        if(DTO.getCommentProduits() != null)
            entity.setCommentProduits(DTO.getCommentProduits().stream()
                    .map(mapperCommentProduit::toEntity).collect(Collectors.toList()));

        return entity;
    }
}
