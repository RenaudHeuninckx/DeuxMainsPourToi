package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter @Setter
@NoArgsConstructor
public class SmallMassageDTO {

    private int id;
    private String nom;
    private String type;
    private String description;
    private Time duree;
    private float prix;
}
