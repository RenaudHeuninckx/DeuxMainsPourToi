package com.projet.DeuxMainsPourToi.metier.DTO.Container;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class ElementContainer<DTO> {

    private final List<DTO> list;
    private final int count;
}
