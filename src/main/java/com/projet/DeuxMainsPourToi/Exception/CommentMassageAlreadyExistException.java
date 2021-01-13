package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.CommentMassageDTO;

public class CommentMassageAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public CommentMassageAlreadyExistException(int id) {
        super(id, CommentMassageDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
