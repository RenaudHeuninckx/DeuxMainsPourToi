package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentProduit;
import com.projet.DeuxMainsPourToi.DAL.repository.CommentProduitRepository;
import com.projet.DeuxMainsPourToi.Exception.CommentProduitAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.CommentProduitNotFoundException;
import com.projet.DeuxMainsPourToi.Exception.ElementAlreadyExistException;
import com.projet.DeuxMainsPourToi.Exception.ElementNotFoundException;
import com.projet.DeuxMainsPourToi.metier.DTO.CommentProduitDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.CommentProduitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentProduitService implements CrudService<CommentProduitDTO,Integer> {

    @Autowired
    private CommentProduitMapper mapperCommentProduit;

    @Autowired
    private CommentProduitRepository repoCommentProduit;

    @Override
    public void create(@Valid CommentProduitDTO toCreate) throws ElementAlreadyExistException {
        if (repoCommentProduit.existsById(toCreate.getId()))
            throw new CommentProduitAlreadyExistException(toCreate.getId());
        repoCommentProduit.save(mapperCommentProduit.toEntity(toCreate));
    }

    @Override
    public CommentProduitDTO getOne(Integer id) throws ElementNotFoundException {
        CommentProduit commentProduit = repoCommentProduit.findById(id)
                .orElseThrow(() -> new CommentProduitNotFoundException(id));
        return mapperCommentProduit.toDTO(commentProduit);
    }

    @Override
    public List<CommentProduitDTO> getAll() {
        return repoCommentProduit.findAll()
                .stream()
                .map(mapperCommentProduit::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid CommentProduitDTO toUpdate) throws ElementNotFoundException {
        if (!repoCommentProduit.existsById(toUpdate.getId()))
            throw new CommentProduitNotFoundException(toUpdate.getId());
        repoCommentProduit.save(mapperCommentProduit.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if(!repoCommentProduit.existsById(toDelete))
            throw new CommentProduitNotFoundException(toDelete);
        repoCommentProduit.deleteById(toDelete);
    }
}
