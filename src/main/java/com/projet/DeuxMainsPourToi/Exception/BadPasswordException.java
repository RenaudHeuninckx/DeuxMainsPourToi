package com.projet.DeuxMainsPourToi.Exception;

public class BadPasswordException extends Exception{
    public BadPasswordException() {
        super("Le mot de passe est incorrecte.");
    }
}
