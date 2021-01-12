package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentProduit;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommentProduitDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallCommentProduitMapper implements Mapper<SmallCommentProduitDTO, CommentProduit> {
    @Override
    public SmallCommentProduitDTO toDTO(CommentProduit entity) {

        if (entity == null) return null;

        SmallCommentProduitDTO DTO = new SmallCommentProduitDTO();

        DTO.setId(entity.getId());
        DTO.setDescription(entity.getDescription());
        DTO.setDate(entity.getDate());

        return DTO;
    }

    @Override
    public CommentProduit toEntity(SmallCommentProduitDTO DTO) {

        if (DTO == null) return null;

        CommentProduit entity = new CommentProduit();

        entity.setId(DTO.getId());
        entity.setDescription(DTO.getDescription());
        entity.setDate(DTO.getDate());

        return entity;
    }
}
