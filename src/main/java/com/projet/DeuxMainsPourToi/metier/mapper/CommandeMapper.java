package com.projet.DeuxMainsPourToi.metier.mapper;

import com.projet.DeuxMainsPourToi.DAL.entity.Commande;
import com.projet.DeuxMainsPourToi.DAL.entity.CommandeProduit;
import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import com.projet.DeuxMainsPourToi.metier.DTO.CommandeDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallCommandeProduitDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.SmallUtilisateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CommandeMapper implements Mapper<CommandeDTO, Commande> {

    @Autowired
    private Mapper<SmallUtilisateurDTO, Utilisateur> mapperUtilisateur;

    @Autowired
    private Mapper<SmallCommandeProduitDTO, CommandeProduit> mapperCommandeProduit;

    @Override
    public CommandeDTO toDTO(Commande entity) {

        if (entity == null) return null;

        CommandeDTO DTO = new CommandeDTO();

        DTO.setId(entity.getId());
        DTO.setUtilisateur(mapperUtilisateur.toDTO(entity.getUtilisateur()));
        if (entity.getCommandeProduits() != null)
            DTO.setCommandeProduits(entity.getCommandeProduits().stream()
                    .map(mapperCommandeProduit::toDTO).collect(Collectors.toList()));
        DTO.setDate(entity.getDate());
        DTO.setMoyenPaiement(entity.getMoyenPaiement());
        DTO.setStatusPaiement(entity.getStatusPaiement());
        DTO.setStatusCommande(entity.getStatusCommande());

        return DTO;
    }

    @Override
    public Commande toEntity(CommandeDTO DTO) {

        if (DTO == null) return null;

        Commande entity = new Commande();

        entity.setId(DTO.getId());
        entity.setUtilisateur(mapperUtilisateur.toEntity(DTO.getUtilisateur()));
        if (DTO.getCommandeProduits() != null)
            entity.setCommandeProduits(DTO.getCommandeProduits().stream()
                    .map(mapperCommandeProduit::toEntity).collect(Collectors.toList()));
        entity.setDate(DTO.getDate());
        entity.setMoyenPaiement(DTO.getMoyenPaiement());
        entity.setStatusPaiement(DTO.getStatusPaiement());
        entity.setStatusCommande(DTO.getStatusCommande());

        return entity;
    }
}
