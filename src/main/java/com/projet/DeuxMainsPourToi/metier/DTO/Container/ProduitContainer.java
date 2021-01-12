package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.ProduitDTO;

import java.util.List;

public class ProduitContainer extends ElementContainer<ProduitDTO> {
    public ProduitContainer(List<ProduitDTO> list, int count) {
        super(list, count);
    }
}
