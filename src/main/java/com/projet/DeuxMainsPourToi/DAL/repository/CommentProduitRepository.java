package com.projet.DeuxMainsPourToi.DAL.repository;

import com.projet.DeuxMainsPourToi.DAL.entity.CommentProduit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentProduitRepository extends JpaRepository<CommentProduit, Integer> {

    List<CommentProduit> getAllByProduitId(int id);
}
