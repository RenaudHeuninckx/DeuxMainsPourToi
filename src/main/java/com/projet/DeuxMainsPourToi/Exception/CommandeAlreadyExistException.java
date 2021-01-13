package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommandeDTO;

public class CommandeAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public CommandeAlreadyExistException(int id) {
        super(id, CommandeDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
