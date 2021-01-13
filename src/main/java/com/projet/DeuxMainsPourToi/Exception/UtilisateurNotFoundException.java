package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;

public class UtilisateurNotFoundException extends ElementNotFoundException{

    private final int index;

    public UtilisateurNotFoundException(int id) {
        super(id, UtilisateurDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
