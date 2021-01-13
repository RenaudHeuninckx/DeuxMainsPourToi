package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommentProduitDTO;

public class CommentProduitAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public CommentProduitAlreadyExistException(int id) {
        super(id, CommentProduitDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
