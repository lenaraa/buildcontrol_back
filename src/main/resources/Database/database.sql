CREATE TABLE Drone(
   id_drone INT,
   libelle VARCHAR(50),
   PRIMARY KEY(id_drone)
);

CREATE TABLE Interieur(
   id_interieur INT,
   libelle VARCHAR(50),
   PRIMARY KEY(id_interieur)
);

CREATE TABLE Corps_metier(
   id_corps_metier INT,
   nom VARCHAR(50),
   PRIMARY KEY(id_corps_metier)
);

CREATE TABLE Sous_traitant(
   id_sous_traitant INT,
   nom VARCHAR(50),
   rue VARCHAR(50),
   code_postale VARCHAR(50),
   ville VARCHAR(50),
   id_corps_metier INT NOT NULL,
   PRIMARY KEY(id_sous_traitant),
   FOREIGN KEY(id_corps_metier) REFERENCES Corps_metier(id_corps_metier)
);

CREATE TABLE Personne(
   id_personne INT,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   mail VARCHAR(50),
   PRIMARY KEY(id_personne)
);

CREATE TABLE Projet(
   id_projet INT,
   nom VARCHAR(50),
   lieu VARCHAR(50),
   date_debut DATE,
   date_fin DATE,
   PRIMARY KEY(id_projet)
);

CREATE TABLE Chantier(
   id_chantier INT,
   nom VARCHAR(50),
   lieu VARCHAR(50),
   date_debut DATE,
   date_fin DATE,
   PRIMARY KEY(id_chantier)
);

CREATE TABLE Role(
   id_role INT,
   nom VARCHAR(50),
   privilege VARCHAR(50),
   PRIMARY KEY(id_role)
);

CREATE TABLE Profil(
   username VARCHAR(50),
   nom VARCHAR(50),
   mdp VARCHAR(50),
   date_modification VARCHAR(50),
   est_interne VARCHAR(50),
   id_personne INT NOT NULL,
   PRIMARY KEY(username),
   UNIQUE(id_personne),
   FOREIGN KEY(id_personne) REFERENCES Personne(id_personne)
);

CREATE TABLE Capture(
   id_capture INT,
   date_capture DATE,
   heure_capture VARCHAR(50),
   coordonnee_x VARCHAR(50),
   coordonnee_y VARCHAR(50),
   jalon_gant VARCHAR(50),
   etape_capture VARCHAR(50),
   incident VARCHAR(50),
   lien VARCHAR(50),
   id_chantier INT NOT NULL,
   id_projet INT NOT NULL,
   id_interieur INT,
   id_drone INT,
   PRIMARY KEY(id_capture),
   FOREIGN KEY(id_chantier) REFERENCES Chantier(id_chantier),
   FOREIGN KEY(id_projet) REFERENCES Projet(id_projet),
   FOREIGN KEY(id_interieur) REFERENCES Interieur(id_interieur),
   FOREIGN KEY(id_drone) REFERENCES Drone(id_drone)
);

CREATE TABLE Concerner(
   id_capture INT,
   id_sous_traitant INT,
   PRIMARY KEY(id_capture, id_sous_traitant),
   FOREIGN KEY(id_capture) REFERENCES Capture(id_capture),
   FOREIGN KEY(id_sous_traitant) REFERENCES Sous_traitant(id_sous_traitant)
);

CREATE TABLE Posseder(
   id_corps_metier INT,
   id_personne INT,
   PRIMARY KEY(id_corps_metier, id_personne),
   FOREIGN KEY(id_corps_metier) REFERENCES Corps_metier(id_corps_metier),
   FOREIGN KEY(id_personne) REFERENCES Personne(id_personne)
);

CREATE TABLE Beneficier(
   id_personne INT,
   id_role INT,
   PRIMARY KEY(id_personne, id_role),
   FOREIGN KEY(id_personne) REFERENCES Personne(id_personne),
   FOREIGN KEY(id_role) REFERENCES Role(id_role)
);

CREATE TABLE Cibler(
   id_corps_metier INT,
   id_chantier INT,
   PRIMARY KEY(id_corps_metier, id_chantier),
   FOREIGN KEY(id_corps_metier) REFERENCES Corps_metier(id_corps_metier),
   FOREIGN KEY(id_chantier) REFERENCES Chantier(id_chantier)
);