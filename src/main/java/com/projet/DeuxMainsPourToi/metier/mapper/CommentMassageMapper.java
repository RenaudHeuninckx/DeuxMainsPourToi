package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentMassage;
import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import com.projet.DeuxMainsPourToi.metier.DTO.CommentMassageDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallMassageDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallUtilisateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMassageMapper implements Mapper<CommentMassageDTO, CommentMassage> {

    @Autowired
    private Mapper<SmallMassageDTO, Massage> mapperMassage;

    @Autowired
    private Mapper<SmallUtilisateurDTO, Utilisateur> mapperUtilisateur;

    @Override
    public CommentMassageDTO toDTO(CommentMassage entity) {

        if (entity == null) return null;

        CommentMassageDTO DTO = new CommentMassageDTO();

        DTO.setId(entity.getId());
        DTO.setMassage(mapperMassage.toDTO(entity.getMassage()));
        DTO.setUtilisateur(mapperUtilisateur.toDTO(entity.getUtilisateur()));
        DTO.setDescription(entity.getDescription());
        DTO.setDate(entity.getDate());

        return DTO;
    }

    @Override
    public CommentMassage toEntity(CommentMassageDTO DTO) {

        if (DTO == null) return null;

        CommentMassage entity = new CommentMassage();

        entity.setId(DTO.getId());
        entity.setMassage(mapperMassage.toEntity(DTO.getMassage()));
        entity.setUtilisateur(mapperUtilisateur.toEntity(DTO.getUtilisateur()));
        entity.setDescription(DTO.getDescription());
        entity.setDate(DTO.getDate());

        return entity;
    }
}
