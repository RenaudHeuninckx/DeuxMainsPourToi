package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentProduit;
import com.projet.DeuxMainsPourToi.DAL.entity.Produit;
import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.CommentProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallUtilisateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentProduitMapper implements Mapper<CommentProduitDTO, CommentProduit> {

    @Autowired
    private Mapper<SmallProduitDTO, Produit> mapperProduit;

    @Autowired
    private Mapper<SmallUtilisateurDTO, Utilisateur> mapperUtilisateur;

    @Override
    public CommentProduitDTO toDTO(CommentProduit entity) {

        if (entity == null) return null;

        CommentProduitDTO DTO = new CommentProduitDTO();

        DTO.setId(entity.getId());
        DTO.setProduit(mapperProduit.toDTO(entity.getProduit()));
        DTO.setUtilisateur(mapperUtilisateur.toDTO(entity.getUtilisateur()));
        DTO.setDescription(entity.getDescription());
        DTO.setDate(entity.getDate());

        return DTO;
    }

    @Override
    public CommentProduit toEntity(CommentProduitDTO DTO) {

        if (DTO == null) return null;

        CommentProduit entity = new CommentProduit();

        entity.setId(DTO.getId());
        entity.setProduit(mapperProduit.toEntity(DTO.getProduit()));
        entity.setUtilisateur(mapperUtilisateur.toEntity(DTO.getUtilisateur()));
        entity.setDescription(DTO.getDescription());
        entity.setDate(DTO.getDate());

        return entity;
    }
}
