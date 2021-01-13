package com.projet.DeuxMainsPourToi.DAL.repository;

import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassageRepository extends JpaRepository<Massage, Integer> {
}
