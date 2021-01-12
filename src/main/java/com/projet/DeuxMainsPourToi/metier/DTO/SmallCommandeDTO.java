package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SmallCommandeDTO {

    private int id;
    private Date date;
    private String moyenPaiement;
    private String statusPaiement;
    private String statusCommande;
}
