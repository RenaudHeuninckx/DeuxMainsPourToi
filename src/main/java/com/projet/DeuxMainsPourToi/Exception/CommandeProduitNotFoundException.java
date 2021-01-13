package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;

public class CommandeProduitNotFoundException extends ElementNotFoundException{

    private final int index;

    public CommandeProduitNotFoundException(int id) {
        super(id, CommandeProduitDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
