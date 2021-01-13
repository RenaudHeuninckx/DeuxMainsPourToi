package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommandeDTO;

public class CommandeNotFoundException extends ElementNotFoundException{

    private final int index;

    public CommandeNotFoundException(int id) {
        super(id, CommandeDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
