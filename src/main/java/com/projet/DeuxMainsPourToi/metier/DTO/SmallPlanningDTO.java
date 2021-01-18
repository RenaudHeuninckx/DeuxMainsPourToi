package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class SmallPlanningDTO {

    private int id;
    private Date rendezVousDate;
    private Date rendezVousHeure;
    private String commentaire;
}
