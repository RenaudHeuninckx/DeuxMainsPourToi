package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.UtilisateurDTO;

import java.util.List;

public class UtilisateurContainer extends ElementContainer<UtilisateurDTO> {
    public UtilisateurContainer(List<UtilisateurDTO> list, int count) {
        super(list, count);
    }
}
