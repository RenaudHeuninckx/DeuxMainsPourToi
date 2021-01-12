package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;

import java.util.List;

public class CommandeProduitContainer extends ElementContainer<CommandeProduitDTO> {
    public CommandeProduitContainer(List<CommandeProduitDTO> list, int count) {
        super(list, count);
    }
}
