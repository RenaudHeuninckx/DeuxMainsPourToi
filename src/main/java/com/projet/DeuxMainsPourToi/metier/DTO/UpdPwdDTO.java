package com.projet.DeuxMainsPourToi.metier.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UpdPwdDTO {
    private String email;
    private String newPwd;
    private String oldPwd;
}
