package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import com.projet.DeuxMainsPourToi.metier.DTO.PlanningDTO;

import java.util.List;

public class PlanningContainer extends ElementContainer<PlanningDTO> {
    public PlanningContainer(List<PlanningDTO> list, int count) {
        super(list, count);
    }
}
