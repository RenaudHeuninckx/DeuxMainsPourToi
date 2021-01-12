package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class CommentMassageDTO {

    private int id;
    private SmallMassageDTO massage;
    private SmallUtilisateurDTO utilisateur;
    @NotNull
    private String description;
    @NotNull
    private Date date;
}
