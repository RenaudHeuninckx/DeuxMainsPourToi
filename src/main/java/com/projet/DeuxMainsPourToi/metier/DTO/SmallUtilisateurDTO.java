package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    private String password;
    private String tel;
    private String gsm;
    private String adresse;
    private String cp;
    private String loc;
    private String complAdr;
    private Date dateNaiss;
    private boolean admin;
    private Date inscrit;
    private Date supprime;
}
