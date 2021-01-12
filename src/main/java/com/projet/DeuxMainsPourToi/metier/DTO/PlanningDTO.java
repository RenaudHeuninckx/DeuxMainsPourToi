package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class PlanningDTO {

    private int id;
    private SmallUtilisateurDTO utilisateur;
    private SmallMassageDTO massage;
    @NotNull
    private Date rendezVous;
    @Size(max = 255)
    private String commentaire;
}
