package com.projet.DeuxMainsPourToi.metier.service;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentMassage;
import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import com.projet.DeuxMainsPourToi.DAL.repository.CommentMassageRepository;
import com.projet.DeuxMainsPourToi.DAL.repository.MassageRepository;
import com.projet.DeuxMainsPourToi.Exception.*;
import com.projet.DeuxMainsPourToi.metier.DTO.CommentMassageDTO;
import com.projet.DeuxMainsPourToi.metier.DTO.MassageDTO;
import com.projet.DeuxMainsPourToi.metier.mapper.CommentMassageMapper;
import com.projet.DeuxMainsPourToi.metier.mapper.MassageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentMassageService implements CrudService<CommentMassageDTO,Integer> {

    @Autowired
    private CommentMassageMapper mapperCommentMassage;

    @Autowired
    private MassageMapper mapperMassage;

    @Autowired
    private CommentMassageRepository repoCommentMassage;

    @Autowired
    private MassageRepository repoMassage;

    @Override
    public void create(@Valid CommentMassageDTO toCreate) throws ElementAlreadyExistException {
        if (repoCommentMassage.existsById(toCreate.getId()))
            throw new CommentMassageAlreadyExistException(toCreate.getId());
        repoCommentMassage.save(mapperCommentMassage.toEntity(toCreate));
    }

    @Override
    public CommentMassageDTO getOne(Integer id) throws ElementNotFoundException {
        CommentMassage commentMassage = repoCommentMassage.findById(id)
                .orElseThrow(() -> new CommentMassageNotFoundException(id));
        return mapperCommentMassage.toDTO(commentMassage);
    }

    @Override
    public List<CommentMassageDTO> getAll() {
        return repoCommentMassage.findAll()
                .stream()
                .map(mapperCommentMassage::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid CommentMassageDTO toUpdate) throws ElementNotFoundException {
        if (!repoCommentMassage.existsById(toUpdate.getId()))
            throw new CommentMassageNotFoundException(toUpdate.getId());
        repoCommentMassage.save(mapperCommentMassage.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoCommentMassage.existsById(toDelete))
            throw new CommandeProduitNotFoundException(toDelete);
        repoCommentMassage.deleteById(toDelete);
    }

    public List<CommentMassageDTO> getAllByMassageIdMassage(int id){
        return repoCommentMassage.getAllByMassageId(id)
                .stream()
                .map(mapperCommentMassage::toDTO)
                .collect(Collectors.toList());
    }
}
