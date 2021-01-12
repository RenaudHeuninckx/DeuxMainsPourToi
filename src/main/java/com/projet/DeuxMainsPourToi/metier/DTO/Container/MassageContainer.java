package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;

import java.util.List;

public class MassageContainer extends ElementContainer<MassageDTO> {
    public MassageContainer(List<MassageDTO> list, int count) {
        super(list, count);
    }
}
