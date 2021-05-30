package fr.epsi.buildcontrol.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Profil")
public class Profil {

    @Id
    private String username;

    private String nom;

    private String mdp;

    @Column(name = "date-modification")
    private LocalDate dateModification;

    @Column(name = "est_interne")
    Boolean estInterne;

    @OneToOne
    private Personne personne;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public Boolean getEstInterne() {
        return estInterne;
    }

    public void setEstInterne(Boolean estInterne) {
        this.estInterne = estInterne;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }


    @Override
    public String toString() {
        return "Profil{" +
                "nom d'utilisateur " + username +
                ", de nom " + nom +
                ", modifié le " + dateModification +
                '}';
    }

}
