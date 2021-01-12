package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class CommandeDTO {

    private int id;

    private SmallUtilisateurDTO utilisateur;

    private Collection<SmallCommandeProduitDTO> commandeProduits;

    @NotNull
    private Date date;

    @Size(max = 20)
    private String moyenPaiement;

    @Size(max = 20)
    private String statusPaiement;

    @Size(max = 20)
    private String statusCommande;
}
