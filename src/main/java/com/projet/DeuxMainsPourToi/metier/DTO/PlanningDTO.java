package com.projet.DeuxMainsPourToi.metier.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date rendezVousDate;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date rendezVousHeure;
    @Size(max = 255)
    private String commentaire;
}
