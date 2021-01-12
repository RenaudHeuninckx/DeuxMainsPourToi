package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentMassage;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommentMassageDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallCommentMassageMapper implements Mapper<SmallCommentMassageDTO, CommentMassage> {
    @Override
    public SmallCommentMassageDTO toDTO(CommentMassage entity) {

        if (entity == null) return null;

        SmallCommentMassageDTO DTO = new SmallCommentMassageDTO();

        DTO.setId(entity.getId());
        DTO.setDescription(entity.getDescription());
        DTO.setDate(entity.getDate());

        return DTO;
    }

    @Override
    public CommentMassage toEntity(SmallCommentMassageDTO DTO) {

        if (DTO == null) return null;

        CommentMassage entity = new CommentMassage();

        entity.setId(DTO.getId());
        entity.setDescription(DTO.getDescription());
        entity.setDate(DTO.getDate());

        return entity;
    }
}
