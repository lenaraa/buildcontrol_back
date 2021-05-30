package fr.epsi.buildcontrol.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Corps_metier")
public class CorpsMetier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_corps_metier")
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "lesCorpsMetiers")
    private List<Chantier> lesChantiers;

    @OneToMany
    private List<SousTraitant> lesSousTraitants;

    @ManyToMany(mappedBy = "lesCorpsMetiers")
    private List<Personne> lesPersonnes;


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

    public List<Chantier> getLesChantiers() {
        return lesChantiers;
    }

    public void setLesChantiers(List<Chantier> lesChantiers) {
        this.lesChantiers = lesChantiers;
    }

    public List<SousTraitant> getLesSousTraitants() {
        return lesSousTraitants;
    }

    public void setLesSousTraitants(List<SousTraitant> lesSousTraitants) {
        this.lesSousTraitants = lesSousTraitants;
    }

    public List<Personne> getLesPersonnes() {
        return lesPersonnes;
    }

    public void setLesPersonnes(List<Personne> lesPersonnes) {
        this.lesPersonnes = lesPersonnes;
    }


    @Override
    public String toString() {
        return "CorpsMetier{" +
                "n°" + id +
                ", " + nom +
                '}';
    }

}
