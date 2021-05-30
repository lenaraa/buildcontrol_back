
/*
Chercher les demandes qui ont été faites après une date donnée.
*/

SELECT * 
FROM Capture
WHERE date_capture > '04/12/2021'

/*
Pour une demande donnée, afficher la date et le nom du chantier, les équipes et corps de métiers présents sur le chantier, les vidéos de contrôles et les liens vers les visites 3D Matterport
*/

SELECT Chantier.nom, Chantier.date_debut, Corps_metier.nom, Capture.lien 
FROM Chantier
INNER JOIN Capture ON Chantier.id_chantier = Capture.id_chantier
INNER JOIN Cibler ON Chantier.id_chantier=Cibler.id_chantier
INNER JOIN Corps_metier ON Corps_metier.id_corps_metier = Cibler.id_corps_metier
WHERE id_capture = 1;

/*
Afficher le nombre de projets réalisés selon un filtre mois/année/exercice
*/

SELECT COUNT(id_projet) AS nb_projets, extract(month from date_debut) AS mois, extract(year from date_debut) AS annees
FROM Projet 
GROUP BY extract(month from date_debut), extract(year from date_debut) ;

/*
Afficher le nombre de sous-traitants employés pour les différents projets réalisés par corps de métiers
*/

SELECT COUNT(sous_traitant.id_sous_traitant), Projet.nom, Corps_metier.nom
FROM Projet
JOIN Capture ON Projet.id_projet=Capture.id_projet
JOIN Concerner ON Capture.id_capture = Concerner.id_capture
JOIN Sous_traitant ON Concerner.id_sous_traitant = Sous_traitant.id_sous_traitant
JOIN Corps_metier ON Sous_traitant.id_corps_metier = Corps_metier.id_corps_metier
GROUP BY  Projet.nom, Corps_metier.nom;
