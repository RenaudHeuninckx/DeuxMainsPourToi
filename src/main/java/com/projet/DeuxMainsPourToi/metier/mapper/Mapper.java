package com.projet.DeuxMainsPourToi.metier.mapper;

public interface Mapper<DTO,Entity> {

    DTO toDTO(Entity entity);
    Entity toEntity(DTO dto);
}
