package com.projet.DeuxMainsPourToi.Exception;

public class EmailNotFoundException extends Exception{
    private String email;

    public EmailNotFoundException(String email) {
        super("Email " + email + " n'a pas été trouvé dans la base de données.");
        this.email = email;
    }
}
