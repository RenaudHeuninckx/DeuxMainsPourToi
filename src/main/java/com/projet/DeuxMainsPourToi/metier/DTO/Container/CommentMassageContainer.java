package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.CommentMassageDTO;

import java.util.List;

public class CommentMassageContainer extends ElementContainer<CommentMassageDTO> {
    public CommentMassageContainer(List<CommentMassageDTO> list, int count) {
        super(list, count);
    }
}
