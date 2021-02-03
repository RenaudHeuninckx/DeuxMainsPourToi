package com.projet.DeuxMainsPourToi.presentation.Adviser;

import com.projet.DeuxMainsPourToi.Exception.*;
import com.projet.DeuxMainsPourToi.presentation.UtilisateurController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = {UtilisateurController.class})
public class UtilisateurAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PseudoNotUniqueException.class)
    public ResponseEntity<String> pseudoNotUniqueExceptionHandler(){
        return ResponseEntity.badRequest().body("Pseudo déjà utilisé");
    }

    @ExceptionHandler(EmailNotUniqueException.class)
    public ResponseEntity<String> emailNotUniqueExceptionHandler() {
        return ResponseEntity.badRequest().body("Email déjà utilisé");
    }

    @ExceptionHandler(UtilisateurAlreadyExistException.class)
    public ResponseEntity<String> utilisateurAlreadyExistExceptionHandler(){
        return ResponseEntity.badRequest().body("Utilisateur déjà enregistré");
    }

    @ExceptionHandler(BadPasswordException.class)
    public ResponseEntity<String> badPasswordExceptionHandler(){
        return ResponseEntity.badRequest().body("Mot de passe érroné.");
    }

    @ExceptionHandler(UtilisateurNotFoundException.class)
    public ResponseEntity<String> utilisateurNotFoundExceptionHandler(){
        return ResponseEntity.badRequest().body("Utilisateur inconnu.");
    }
}
