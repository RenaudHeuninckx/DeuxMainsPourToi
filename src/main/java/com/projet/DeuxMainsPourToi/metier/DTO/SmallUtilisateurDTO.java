package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SmallUtilisateurDTO {

    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String email;
    private byte[] password;
    private String tel;
    private String gsm;
    private String rue;
    private String num;
    private String boite;
    private String cp;
    private String loc;
    private String complAdr;
    private Date dateNaiss;
    private boolean admin;
    private Date inscrit;
    private Date supprime;
}
