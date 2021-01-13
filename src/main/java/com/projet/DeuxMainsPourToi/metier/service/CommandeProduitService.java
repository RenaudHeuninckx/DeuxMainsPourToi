package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.CommandeProduit;
import com.projet.DeuxMainsPourToi.DAL.repository.CommandeProduitRepository;
import com.projet.DeuxMainsPourToi.Exception.*;
import com.projet.DeuxMainsPourToi.metier.DTO.CommandeProduitDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.CommandeProduitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeProduitService implements CrudService<CommandeProduitDTO, Integer> {

    @Autowired
    private CommandeProduitMapper mapperCommandeProduit;

    @Autowired
    private CommandeProduitRepository repoCommandeProduit;

    @Override
    public void create(@Valid CommandeProduitDTO toCreate) throws ElementAlreadyExistException {
        if (repoCommandeProduit.existsById(toCreate.getId()))
            throw new CommandeAlreadyExistException(toCreate.getId());
        repoCommandeProduit.save(mapperCommandeProduit.toEntity(toCreate));
    }

    @Override
    public CommandeProduitDTO getOne(Integer id) throws ElementNotFoundException {
        CommandeProduit commandeProduit = repoCommandeProduit.findById(id)
                .orElseThrow(() -> new CommandeNotFoundException(id));
        return mapperCommandeProduit.toDTO(commandeProduit);
    }

    @Override
    public List<CommandeProduitDTO> getAll() {
        return repoCommandeProduit.findAll()
                .stream()
                .map(mapperCommandeProduit::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid CommandeProduitDTO toUpdate) throws ElementNotFoundException {
        if (!repoCommandeProduit.existsById(toUpdate.getId()))
            throw new CommandeProduitNotFoundException(toUpdate.getId());
        repoCommandeProduit.save(mapperCommandeProduit.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoCommandeProduit.existsById(toDelete))
            throw new CommandeProduitNotFoundException(toDelete);
        repoCommandeProduit.deleteById(toDelete);
    }
}
