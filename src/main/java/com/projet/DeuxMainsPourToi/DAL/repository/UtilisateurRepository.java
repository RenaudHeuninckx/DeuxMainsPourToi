package com.projet.DeuxMainsPourToi.DAL.repository;

import com.projet.DeuxMainsPourToi.DAL.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}
