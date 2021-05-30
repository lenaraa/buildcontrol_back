package fr.epsi.buildcontrol.entities;

import javax.persistence.*;

@Entity
@Table(name = "Drone")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_drone")
    private Long id;

    private String libelle;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    @Override
    public String toString() {
        return "Drone{" +
                "n°" + id +
                ", " + libelle +
                '}';
    }

}
