package com.projet.DeuxMainsPourToi.Exception;

import com.projet.DeuxMainsPourToi.metier.DTO.PlanningDTO;

public class PlanningAlreadyExistException extends ElementAlreadyExistException{

    private final int index;

    public PlanningAlreadyExistException(int id) {
        super(id, PlanningDTO.class);
        this.index = id;
    }

    public int getIndex() { return index; }
}
