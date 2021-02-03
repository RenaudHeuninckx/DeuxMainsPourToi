package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class InfoLoginDTO {

    private String Password;
    private boolean admin;
}
