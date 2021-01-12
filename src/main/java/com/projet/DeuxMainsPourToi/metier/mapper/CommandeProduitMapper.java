package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Commande;
import com.projet.DeuxMainsPourToi.DAL.entity.CommandeProduit;
import com.projet.DeuxMainsPourToi.DAL.entity.Produit;
import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommandeDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallProduitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandeProduitMapper implements Mapper<CommandeProduitDTO, CommandeProduit> {

    @Autowired
    private Mapper<SmallCommandeDTO, Commande> mapperCommande;

    @Autowired
    private Mapper<SmallProduitDTO, Produit> mapperProduit;

    @Override
    public CommandeProduitDTO toDTO(CommandeProduit entity) {

        if (entity == null) return null;

        CommandeProduitDTO DTO = new CommandeProduitDTO();

        DTO.setId(entity.getId());
        DTO.setCommande(mapperCommande.toDTO(entity.getCommande()));
        DTO.setProduit(mapperProduit.toDTO(entity.getProduit()));
        DTO.setQte(entity.getQte());

        return DTO;
    }

    @Override
    public CommandeProduit toEntity(CommandeProduitDTO DTO) {

        if (DTO == null) return null;

        CommandeProduit entity = new CommandeProduit();

        entity.setId(DTO.getId());
        entity.setCommande(mapperCommande.toEntity(DTO.getCommande()));
        entity.setProduit(mapperProduit.toEntity(DTO.getProduit()));
        entity.setQte(DTO.getQte());

        return entity;
    }
}
