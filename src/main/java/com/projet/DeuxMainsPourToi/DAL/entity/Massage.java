package com.projet.DeuxMainsPourToi.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Massage implements Serializable {

    @Id
    @Column(name = "id_massage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Size(max = 50)
    private String nom;

    @Column(nullable = false)
    @Size(max = 20)
    private String type;

    @Column(nullable = false)
    @Size(max = 255)
    private String description;

    @Column(nullable = false)
    private Time duree;

    @Column(nullable = false, precision=5, scale=2)
    private double prix;

    @OneToMany(mappedBy = "massage")
    private Collection<Planning> plannings;

    @OneToMany(mappedBy = "massage")
    private Collection<CommentMassage> commentMassages;
}
