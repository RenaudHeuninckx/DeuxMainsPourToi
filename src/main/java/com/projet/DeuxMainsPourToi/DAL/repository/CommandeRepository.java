package com.projet.DeuxMainsPourToi.DAL.repository;

import com.projet.DeuxMainsPourToi.DAL.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
