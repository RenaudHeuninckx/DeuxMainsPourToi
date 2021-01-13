package com.projet.DeuxMainsPourToi.metier.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class CommentProduitDTO {

    private int id;
    private SmallProduitDTO produit;
    private SmallUtilisateurDTO utilisateur;
    @NotNull
    private String description;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
}
