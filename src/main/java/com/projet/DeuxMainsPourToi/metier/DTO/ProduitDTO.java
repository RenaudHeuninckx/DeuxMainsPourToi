package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter @Setter
@NoArgsConstructor
public class ProduitDTO {

    private int id;
    @NotNull
    @Size(max = 50)
    private String type;
    @NotNull
    @Size(max = 255)
    private String description;
    @NotNull
    private float prix;
    private Collection<SmallCommandeProduitDTO> commandeProduits;
    private Collection<SmallCommentProduitDTO> commentProduits;
}
