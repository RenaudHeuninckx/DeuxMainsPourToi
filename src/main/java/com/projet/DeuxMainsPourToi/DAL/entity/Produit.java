package com.projet.DeuxMainsPourToi.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Produit implements Serializable {

    @Id
    @Column(name = "id_produit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(max = 50)
    private String type;

    @Column(nullable = false)
    @Size(max = 255)
    private String description;

    @Column(nullable = false, precision=5, scale=2)
    private float prix;

    @OneToMany(mappedBy = "produit")
    private Collection<CommandeProduit> commandeProduits;

    @OneToMany(mappedBy = "produit")
    private Collection<CommentProduit> commentProduits;

}
