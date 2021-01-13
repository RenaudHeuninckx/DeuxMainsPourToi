package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;

public class UtilisateurAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public UtilisateurAlreadyExistException(int id) {
        super(id, UtilisateurDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
