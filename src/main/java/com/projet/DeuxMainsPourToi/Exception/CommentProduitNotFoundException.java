package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;

public class CommentProduitNotFoundException extends ElementNotFoundException{

    private final int index;

    public CommentProduitNotFoundException(int id) {
        super(id, CommandeProduitDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
