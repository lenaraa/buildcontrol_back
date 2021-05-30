package fr.epsi.buildcontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Capture")
public class Capture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_capture")
    private Long id;

    @Column(name = "date_capture")
    private LocalDate dateCapture;

    @Column(name = "heure_capture")
    private LocalTime heureCapture;

    @Column(name = "coordonnee_x")
    private String coordonneX;

    @Column(name = "coordonnee_y")
    private String coordonneeY;

    @Column(name = "jalon_gant")
    private String jalonGant;

    @Column(name = "etape_capture")
    private String etapeCapture;

    private String incident;

    private String lien;

    @ManyToOne
    private Drone drone;

    @ManyToOne
    private Interieur interieur;

    @ManyToOne
    private Chantier chantier;

    @ManyToOne
    private Projet projet;

    @ManyToMany
    @JoinTable(name="concerner",
            joinColumns = {@JoinColumn(name = "id_capture")},
            inverseJoinColumns = {@JoinColumn(name = "id_sous_traitant")})
    @JsonIgnoreProperties("lesCaptures")
    private List<SousTraitant> lesSousTraitants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCapture() {
        return dateCapture;
    }

    public void setDateCapture(LocalDate dateCapture) {
        this.dateCapture = dateCapture;
    }

    public LocalTime getHeureCapture() {
        return heureCapture;
    }

    public void setHeureCapture(LocalTime heureCapture) {
        this.heureCapture = heureCapture;
    }

    public String getCoordonneX() {
        return coordonneX;
    }

    public void setCoordonneX(String coordonneX) {
        this.coordonneX = coordonneX;
    }

    public String getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(String coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    public String getJalonGant() {
        return jalonGant;
    }

    public void setJalonGant(String jalonGant) {
        this.jalonGant = jalonGant;
    }

    public String getEtapeCapture() {
        return etapeCapture;
    }

    public void setEtapeCapture(String etapeCapture) {
        this.etapeCapture = etapeCapture;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public Interieur getInterieur() {
        return interieur;
    }

    public void setInterieur(Interieur interieur) {
        this.interieur = interieur;
    }

    public Chantier getChantier() {
        return chantier;
    }

    public void setChantier(Chantier chantier) {
        this.chantier = chantier;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<SousTraitant> getLesSousTraitants() {
        return lesSousTraitants;
    }

    public void setLesSousTraitants(List<SousTraitant> lesSousTraitants) {
        this.lesSousTraitants = lesSousTraitants;
    }

    @Override
    public String toString() {
        return "Capture{" +
                "id " + id +
                " du dateCapture " + dateCapture +
                " à " + heureCapture +
                " en " + coordonneX +
                ", " + coordonneeY +
                " , de jalon Gant " + jalonGant +
                ", d'etapeCapture " + etapeCapture +
                ", de l'incident " + incident +
                ", de lien " + lien +
                " et du chantier " + chantier.getNom() +
                " pour le projet " + projet.getNom() +
                '}';
    }

}
