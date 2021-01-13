package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.ProduitDTO;

public class ProduitNotFoundException extends ElementNotFoundException{

    private final int index;

    public ProduitNotFoundException(int id) {
        super(id, ProduitDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
