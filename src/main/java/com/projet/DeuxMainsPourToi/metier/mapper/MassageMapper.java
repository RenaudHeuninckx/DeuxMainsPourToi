package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentMassage;
import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import com.projet.DeuxMainsPourToi.DAL.entity.Planning;
import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommentMassageDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallPlanningDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MassageMapper implements Mapper<MassageDTO, Massage> {

    @Autowired
    private Mapper<SmallPlanningDTO, Planning> mapperPlanning;

    @Autowired
    private Mapper<SmallCommentMassageDTO, CommentMassage> mapperCommentMassage;

    @Override
    public MassageDTO toDTO(Massage entity) {

        if (entity == null) return null;

        MassageDTO DTO = new MassageDTO();

        DTO.setId(entity.getId());
        DTO.setNom(entity.getNom());
        DTO.setType(entity.getType());
        DTO.setDescription(entity.getDescription());
        DTO.setDuree(entity.getDuree());
        DTO.setPrix(entity.getPrix());
        if (entity.getPlannings() != null)
            DTO.setPlannings(entity.getPlannings().stream()
                    .map(mapperPlanning::toDTO).collect(Collectors.toList()));
        if (entity.getCommentMassages() != null)
            DTO.setCommentMassages(entity.getCommentMassages().stream()
                    .map(mapperCommentMassage::toDTO).collect(Collectors.toList()));

        return DTO;
    }

    @Override
    public Massage toEntity(MassageDTO DTO) {

        if ( DTO == null ) return null;

        Massage entity = new Massage();

        entity.setId(DTO.getId());
        entity.setNom(DTO.getNom());
        entity.setType(DTO.getType());
        entity.setDuree(DTO.getDuree());
        entity.setDescription(DTO.getDescription());
        entity.setPrix(DTO.getPrix());
        if (DTO.getPlannings() != null)
            entity.setPlannings(DTO.getPlannings().stream()
                    .map(mapperPlanning::toEntity).collect(Collectors.toList()));
        if (DTO.getCommentMassages() != null)
            entity.setCommentMassages(DTO.getCommentMassages().stream()
                    .map(mapperCommentMassage::toEntity).collect(Collectors.toList()));
        return entity;
    }
}
