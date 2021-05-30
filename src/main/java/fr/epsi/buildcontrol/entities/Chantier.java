package fr.epsi.buildcontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Chantier")
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chantier")
    private Long id;

    private String nom;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    private String lieu;

    @ManyToMany
    @JoinTable(name="cibler",
            joinColumns = {@JoinColumn(name = "id_corps_metier")},
            inverseJoinColumns = {@JoinColumn(name = "id_chantier")})
    @JsonIgnoreProperties("lesChantiers")
    private List<SousTraitant> lesCorpsMetiers;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public List<SousTraitant> getLesCorpsMetiers() {
        return lesCorpsMetiers;
    }

    public void setLesCorpsMetiers(List<SousTraitant> lesCorpsMetiers) {
        this.lesCorpsMetiers = lesCorpsMetiers;
    }

    @Override
    public String toString() {
        return "Chantier{" +
                "n°" + id +
                ", " + nom +
                " du dateDebut " + dateDebut +
                " au dateFin " + dateFin +
                " à " + lieu +
                '}';
    }

}
