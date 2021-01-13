package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import com.projet.DeuxMainsPourToi.DAL.repository.MassageRepository;
import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.Exception.MassageAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.MassageNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.MassageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MassageService implements CrudService<MassageDTO, Integer> {

    @Autowired
    private MassageMapper mapperMassage;

    @Autowired
    private MassageRepository repoMassage;

    @Override
    public void create(@Valid MassageDTO toCreate) throws ElementAlreadyExistException {
        if (repoMassage.existsById(toCreate.getId()))
            throw new MassageAlreadyExistException(toCreate.getId());
        repoMassage.save(mapperMassage.toEntity(toCreate));
    }

    @Override
    public MassageDTO getOne(Integer id) throws ElementNotFoundException {
        Massage massage = repoMassage.findById(id)
                .orElseThrow(() -> new MassageNotFoundException(id));
        return mapperMassage.toDTO(massage);
    }

    @Override
    public List<MassageDTO> getAll() {
        return repoMassage.findAll()
                .stream()
                .map(mapperMassage::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid MassageDTO toUpdate) throws ElementNotFoundException {
        if (!repoMassage.existsById(toUpdate.getId()))
            throw new MassageNotFoundException(toUpdate.getId());
        repoMassage.save(mapperMassage.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoMassage.existsById(toDelete))
            throw new MassageNotFoundException(toDelete);
        repoMassage.deleteById(toDelete);
    }
}
