package com.projet.DeuxMainsPourToi.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AuthenticationBean {

    private String message;

    @Override
    public String toString(){
        return String.format("Bean [message=%s]", message);
    }

}
