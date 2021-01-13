package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.Planning;
import com.projet.DeuxMainsPourToi.DAL.repository.PlanningRepository;
import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.Exception.PlanningAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.PlanningNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.PlanningDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.PlanningMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanningService implements CrudService<PlanningDTO,Integer> {

    @Autowired
    private PlanningMapper mapperPlanning;

    @Autowired
    private PlanningRepository repoPlanning;

    @Override
    public void create(@Valid PlanningDTO toCreate) throws ElementAlreadyExistException {
        if (repoPlanning.existsById(toCreate.getId()))
            throw new PlanningAlreadyExistException(toCreate.getId());
        repoPlanning.save(mapperPlanning.toEntity(toCreate));
    }

    @Override
    public PlanningDTO getOne(Integer id) throws ElementNotFoundException {
        Planning planning = repoPlanning.findById(id)
                .orElseThrow(() -> new PlanningNotFoundException(id));
        return mapperPlanning.toDTO(planning);
    }

    @Override
    public List<PlanningDTO> getAll() {
        return repoPlanning
                .findAll()
                .stream()
                .map(mapperPlanning::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid PlanningDTO toUpdate) throws ElementNotFoundException {
        if (!repoPlanning.existsById(toUpdate.getId()))
            throw new PlanningNotFoundException(toUpdate.getId());
        repoPlanning.save(mapperPlanning.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoPlanning.existsById(toDelete))
            throw new PlanningNotFoundException(toDelete);
        repoPlanning.deleteById(toDelete);
    }
}
