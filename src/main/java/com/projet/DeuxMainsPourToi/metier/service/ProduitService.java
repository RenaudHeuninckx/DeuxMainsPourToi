package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.Produit;
import com.projet.DeuxMainsPourToi.DAL.repository.ProduitRepository;
import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.Exception.ProduitAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ProduitNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.ProduitDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.ProduitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService implements CrudService<ProduitDTO, Integer> {

    @Autowired
    private ProduitMapper mapperProduit;

    @Autowired
    private ProduitRepository repoProduit;

    @Override
    public void create(@Valid ProduitDTO toCreate) throws ElementAlreadyExistException {
        if (repoProduit.existsById(toCreate.getId()))
            throw new ProduitAlreadyExistException(toCreate.getId());
        repoProduit.save(mapperProduit.toEntity(toCreate));
    }

    @Override
    public ProduitDTO getOne(Integer id) throws ElementNotFoundException {
        Produit produit = repoProduit.findById(id)
                .orElseThrow( () -> new ProduitNotFoundException(id));
        return mapperProduit.toDTO(produit);
    }

    @Override
    public List<ProduitDTO> getAll() {
        return repoProduit.findAll()
                .stream()
                .map(mapperProduit::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid ProduitDTO toUpdate) throws ElementNotFoundException {
        if (!repoProduit.existsById(toUpdate.getId()))
            throw new ProduitNotFoundException(toUpdate.getId());
        repoProduit.save(mapperProduit.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoProduit.existsById(toDelete))
            throw new ProduitNotFoundException(toDelete);
        repoProduit.deleteById(toDelete);
    }
}
