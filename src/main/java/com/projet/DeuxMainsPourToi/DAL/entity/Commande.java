package com.projet.DeuxMainsPourToi.DAL.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Commande implements Serializable {

    @Id
    @Column(name = "id_commande")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande")
    private Collection<CommandeProduit> commandeProduits;

    @Column(nullable = false)
    private Date date;

    @Column(name = "moyen_paiement")
    @Size(max = 20)
    private String moyenPaiement;

    @Column(name = "status_paiement")
    @Size(max = 20)
    private String statusPaiement;

    @Column(name = "status_commande")
    @Size(max = 20)
    private String statusCommande;

}
