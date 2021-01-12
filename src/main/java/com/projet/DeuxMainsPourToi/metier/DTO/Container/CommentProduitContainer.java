package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.CommentProduitDTO;

import java.util.List;

public class CommentProduitContainer extends ElementContainer<CommentProduitDTO> {
    public CommentProduitContainer(List<CommentProduitDTO> list, int count) {
        super(list, count);
    }
}
