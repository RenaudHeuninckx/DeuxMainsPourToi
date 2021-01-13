package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;

public class MassageNotFoundException extends ElementNotFoundException{

    private final int index;

    public MassageNotFoundException(int id) {
        super(id, MassageDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
