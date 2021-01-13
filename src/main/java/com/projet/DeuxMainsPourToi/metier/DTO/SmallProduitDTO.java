package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SmallProduitDTO {

    private int id;
    private String type;
    private String description;
    private double prix;
}
