package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;

public class PseudoNotUniqueException extends InputNotUniqueException{

    private String pseudo;

    public PseudoNotUniqueException(String pseudo) {
        super(pseudo, UtilisateurDTO.class);
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }
}
