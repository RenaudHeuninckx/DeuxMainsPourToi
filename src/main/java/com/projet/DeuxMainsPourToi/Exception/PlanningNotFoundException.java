package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.PlanningDTO;

public class PlanningNotFoundException extends ElementNotFoundException{

    private final int index;

    public PlanningNotFoundException(int id) {
        super(id, PlanningDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
