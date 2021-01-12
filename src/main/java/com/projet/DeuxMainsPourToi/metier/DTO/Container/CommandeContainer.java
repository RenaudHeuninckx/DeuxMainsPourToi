package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.CommandeDTO;

import java.util.List;

public class CommandeContainer extends ElementContainer<CommandeDTO> {
    public CommandeContainer(List<CommandeDTO> list, int count) {
        super(list, count);
    }
}
