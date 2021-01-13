package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;

import java.util.List;

public interface CrudService<DTO,ID> {

    void create(DTO toCreate) throws ElementAlreadyExistException;
    DTO getOne(ID id) throws ElementNotFoundException;
    List<DTO> getAll();
    void update(DTO toUpdate) throws ElementNotFoundException;
    void delete(ID toDelete) throws ElementNotFoundException;
}
