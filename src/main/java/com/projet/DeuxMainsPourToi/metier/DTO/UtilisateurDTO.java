package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class UtilisateurDTO {

    private int id;
    @NotNull
    @Size(max = 50)
    private String nom;
    @NotNull
    @Size(max = 50)
    private String prenom;
    @NotNull
    @Size(max = 50)
    private String pseudo;
    @NotNull
    @Size(max = 100)
    @Email
    private String email;
    @NotNull
    private byte[] password;
    @Size(max = 20)
    private String tel;
    @Size(max = 20)
    private String gsm;
    @NotNull
    @Size(max = 50)
    private String rue;
    @Size(max = 20)
    private String num;
    @Size(max = 20)
    private String boite;
    @NotNull
    @Size(max = 20)
    private String cp;
    @NotNull
    @Size(max = 50)
    private String loc;
    @Size(max = 100)
    private String complAdr;
    @Past
    private Date dateNaiss;
    private boolean admin;
    @NotNull
    private Date inscrit;
    private Date supprime;
    private Collection<SmallPlanningDTO> plannings;
    private Collection<SmallCommandeDTO> commandes;
    private Collection<SmallCommentMassageDTO> commentMassages;
    private Collection<SmallCommentProduitDTO> commentProduits;
}
