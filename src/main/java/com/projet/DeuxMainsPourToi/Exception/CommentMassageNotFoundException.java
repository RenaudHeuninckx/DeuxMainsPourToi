package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommentMassageDTO;

public class CommentMassageNotFoundException extends ElementNotFoundException{

    private final int index;

    public CommentMassageNotFoundException(int id) {
        super(id, CommentMassageDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
