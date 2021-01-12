package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Collection;

@Getter @Setter
@NoArgsConstructor
public class MassageDTO {

    private int id;
    @NotNull
    @Size(max = 50)
    private String nom;
    @NotNull
    @Size(max = 20)
    private String type;
    @NotNull
    @Size(max = 255)
    private String description;
    @NotNull
    private Time duree;
    @NotNull
    private float prix;
    private Collection<SmallPlanningDTO> plannings;
    private Collection<SmallCommentMassageDTO> commentMassages;
}
