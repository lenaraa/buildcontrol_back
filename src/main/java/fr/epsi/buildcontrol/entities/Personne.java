package fr.epsi.buildcontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personne")
    private Long id;

    private String nom;

    private String prenom;

    private String mail;

    @ManyToMany
    @JoinTable(name="posseder",
            joinColumns = {@JoinColumn(name = "id_personne")},
            inverseJoinColumns = {@JoinColumn(name = "id_corps_metier")})
    @JsonIgnoreProperties("lesPersonnes")
    private List<CorpsMetier> lesCorpsMetiers;

    @ManyToMany
    @JoinTable(name="beneficier",
            joinColumns = {@JoinColumn(name = "id_personne")},
            inverseJoinColumns = {@JoinColumn(name = "id_role")})
    @JsonIgnoreProperties("lesPersonnes")
    private List<Role> lesRoles;

    @OneToOne
    private Profil profil;


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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<CorpsMetier> getLesCorpsMetiers() {
        return lesCorpsMetiers;
    }

    public void setLesCorpsMetiers(List<CorpsMetier> lesCorpsMetiers) {
        this.lesCorpsMetiers = lesCorpsMetiers;
    }

    public List<Role> getLesRoles() {
        return lesRoles;
    }

    public void setLesRoles(List<Role> lesRoles) {
        this.lesRoles = lesRoles;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }


    @Override
    public String toString() {
        return "Personne{" +
                "n°" + id +
                ", " + nom +
                " " + prenom +
                ", de mail " + mail +
                " avec le nom d'utilisateur " + profil.getUsername() +
                '}';
    }

}
