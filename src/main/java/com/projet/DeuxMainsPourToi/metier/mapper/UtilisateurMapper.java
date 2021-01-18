package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.*;
import com.projet.DeuxMainsPourToi.metier.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UtilisateurMapper implements Mapper<UtilisateurDTO, Utilisateur> {

    @Autowired
    private Mapper<SmallPlanningDTO, Planning> mapperPlanning;

    @Autowired
    private Mapper<SmallCommandeDTO, Commande> mapperCommande;

    @Autowired
    private Mapper<SmallCommentMassageDTO, CommentMassage> mapperCommentMassage;

    @Autowired
    private Mapper<SmallCommentProduitDTO, CommentProduit> mapperCommentProduit;

    @Override
    public UtilisateurDTO toDTO(Utilisateur entity) {

        if (entity == null) return null;

        UtilisateurDTO DTO = new UtilisateurDTO();

        DTO.setId(entity.getId());
        DTO.setNom(entity.getNom());
        DTO.setPrenom(entity.getPrenom());
        DTO.setPseudo(entity.getPseudo());
        DTO.setEmail(entity.getEmail());
        DTO.setPassword(null);
        DTO.setTel(entity.getTel());
        DTO.setGsm(entity.getGsm());
        DTO.setRue(entity.getRue());
        DTO.setNum(entity.getNum());
        DTO.setBoite(entity.getBoite());
        DTO.setCp(entity.getCp());
        DTO.setLoc(entity.getLoc());
        DTO.setComplAdr(entity.getComplAdr());
        DTO.setDateNaiss(entity.getDateNaiss());
        DTO.setAdmin(entity.isAdmin());
        DTO.setInscrit(entity.getInscrit());
        DTO.setSupprime(entity.getSupprime());
        if (entity.getPlannings() != null)
            DTO.setPlannings(entity.getPlannings().stream()
                    .map(mapperPlanning::toDTO).collect(Collectors.toList()));
        if (entity.getCommandes() != null)
            DTO.setCommandes(entity.getCommandes().stream()
                    .map(mapperCommande::toDTO).collect(Collectors.toList()));
        if (entity.getCommentMassages() != null)
            DTO.setCommentMassages(entity.getCommentMassages().stream()
                    .map(mapperCommentMassage::toDTO).collect(Collectors.toList()));
        if (entity.getCommentProduits() != null)
            DTO.setCommentProduits(entity.getCommentProduits().stream()
                    .map(mapperCommentProduit::toDTO).collect(Collectors.toList()));

        return DTO;
    }

    @Override
    public Utilisateur toEntity(UtilisateurDTO DTO) {

        if (DTO == null) return null;

        Utilisateur entity = new Utilisateur();

        entity.setId(DTO.getId());
        entity.setNom(DTO.getNom());
        entity.setPrenom(DTO.getPrenom());
        entity.setPseudo(DTO.getPseudo());
        entity.setEmail(DTO.getEmail());
        entity.setPassword(DTO.getPassword());
        entity.setTel(DTO.getTel());
        entity.setGsm(DTO.getGsm());
        entity.setRue(DTO.getRue());
        entity.setNum(DTO.getNum());
        entity.setBoite(DTO.getBoite());
        entity.setCp(DTO.getCp());
        entity.setLoc(DTO.getLoc());
        entity.setComplAdr(DTO.getComplAdr());
        entity.setDateNaiss(DTO.getDateNaiss());
        entity.setAdmin(DTO.isAdmin());
        entity.setInscrit(DTO.getInscrit());
        entity.setSupprime(DTO.getSupprime());
        if (DTO.getPlannings() != null)
            entity.setPlannings(DTO.getPlannings().stream()
                    .map(mapperPlanning::toEntity).collect(Collectors.toList()));
        if (DTO.getCommandes() != null)
            entity.setCommandes(DTO.getCommandes().stream()
                    .map(mapperCommande::toEntity).collect(Collectors.toList()));
        if (DTO.getCommentMassages() != null)
            entity.setCommentMassages(DTO.getCommentMassages().stream()
                    .map(mapperCommentMassage::toEntity).collect(Collectors.toList()));
        if (DTO.getCommentProduits() != null)
            entity.setCommentProduits(DTO.getCommentProduits().stream()
                    .map(mapperCommentProduit::toEntity).collect(Collectors.toList()));

        return entity;
    }
}
