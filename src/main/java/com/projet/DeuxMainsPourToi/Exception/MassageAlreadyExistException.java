package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;

public class MassageAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public MassageAlreadyExistException(int id) {
        super(id, MassageDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
