package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;

public class EmailNotUniqueException extends InputNotUniqueException{

    private String email;

    public EmailNotUniqueException(String email) {
        super(email, UtilisateurDTO.class);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
