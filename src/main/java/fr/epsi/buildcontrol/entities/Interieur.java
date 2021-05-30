package fr.epsi.buildcontrol.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Interieur")
public class Interieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interieur")
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
        return "Interieur{" +
                "n°" + id +
                ", " + libelle +
                '}';
    }

}
