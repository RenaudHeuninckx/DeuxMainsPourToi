package com.projet.DeuxMainsPourToi.DAL.repository;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentMassage;
import com.projet.DeuxMainsPourToi.DAL.entity.Massage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentMassageRepository extends JpaRepository<CommentMassage, Integer> {

    List<CommentMassage> getAllByMassageId(int id);
}
