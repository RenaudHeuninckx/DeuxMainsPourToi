package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;

public class CommandeProduitAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public CommandeProduitAlreadyExistException(int id) {
        super(id, CommandeProduitDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
