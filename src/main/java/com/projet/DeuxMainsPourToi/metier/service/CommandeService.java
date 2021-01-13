package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.Commande;
import com.projet.DeuxMainsPourToi.DAL.repository.CommandeRepository;
import com.projet.DeuxMainsPourToi.Exception.CommandeAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.CommandeNotFoundException;
import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.CommandeDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.CommandeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService implements CrudService<CommandeDTO, Integer> {

    @Autowired
    private CommandeMapper mapperCommande;

    @Autowired
    private CommandeRepository repoCommande;

    @Override
    public void create(@Valid CommandeDTO toCreate) throws ElementAlreadyExistException {
        if (repoCommande.existsById(toCreate.getId()))
            throw new CommandeAlreadyExistException(toCreate.getId());
        repoCommande.save(mapperCommande.toEntity(toCreate));
    }

    @Override
    public CommandeDTO getOne(Integer id) throws ElementNotFoundException {
        Commande commande = repoCommande.findById(id)
                .orElseThrow(() -> new CommandeNotFoundException(id));
        return mapperCommande.toDTO(commande);
    }

    @Override
    public List<CommandeDTO> getAll() {
        return repoCommande.findAll()
                .stream()
                .map(mapperCommande::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid CommandeDTO toUpdate) throws ElementNotFoundException {
        if (!repoCommande.existsById(toUpdate.getId()))
            throw new CommandeNotFoundException(toUpdate.getId());
        repoCommande.save(mapperCommande.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoCommande.existsById(toDelete))
            throw new CommandeNotFoundException(toDelete);
        repoCommande.deleteById(toDelete);
    }
}
