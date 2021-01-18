package com.projet.DeuxMainsPourToi.DAL.repository;

import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    List<Utilisateur> findByInscrit(Date date);
    List<Utilisateur> getAllByInscrit(Date date);
}
