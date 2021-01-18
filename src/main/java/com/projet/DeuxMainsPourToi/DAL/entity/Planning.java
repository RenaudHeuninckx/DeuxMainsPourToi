package com.projet.DeuxMainsPourToi.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Planning implements Serializable {

    @Id
    @Column(name = "id_rendez_vous")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_massage", nullable = false)
    private Massage massage;

    @Column(name = "rendez_vous_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date rendezVousDate;

    @Column(name = "rendez_vous_heure", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date rendezVousHeure;

    @Column
    @Size(max = 255)
    private String commentaire;

}
