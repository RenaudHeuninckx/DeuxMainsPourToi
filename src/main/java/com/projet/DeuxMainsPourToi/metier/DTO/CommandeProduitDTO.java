package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor
public class CommandeProduitDTO {

    private int id;
    private SmallCommandeDTO commande;
    private SmallProduitDTO produit;
    @NotNull
    private int qte;
}
