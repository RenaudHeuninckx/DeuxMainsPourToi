package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.ProduitDTO;

public class ProduitAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public ProduitAlreadyExistException(int id) {
        super(id, ProduitDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
