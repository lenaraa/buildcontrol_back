CREATE OR REPLACE TYPE  "PROJET_OBJ" is object (nomDuProjet VARCHAR2(50), lieu VARCHAR2(30), nomDuSousTraitant VARCHAR2(50), date_debut DATE, date_fin DATE)

CREATE OR REPLACE TYPE  "PROJET_TAB" is table of projet_obj

create or replace FUNCTION GetProjet(debut IN DATE, fin IN DATE)
 RETURN projet_tab IS
    l_projet_tab projet_tab := projet_tab();
    n integer := 0;

BEGIN
    FOR rec IN (SELECT Projet.nom AS nomDuProjet, Projet.lieu, Sous_traitant.nom AS nomDuSousTraitant, Projet.date_debut, Projet.date_fin
    FROM projet
    INNER JOIN capture ON capture.id_projet = projet.id_projet
    INNER JOIN concerner ON concerner.id_capture = capture.id_capture
    INNER JOIN sous_traitant ON concerner.id_sous_traitant = sous_traitant.id_sous_traitant
    WHERE date_debut>=debut AND date_fin<=fin
    ORDER BY nomDuProjet
    )
LOOP
    l_projet_tab.extend;
    n := n + 1;

    DBMS_OUTPUT.PUT_LINE ('---------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE ('Nom du Projet: ' || rec.nomDuProjet);
    DBMS_OUTPUT.PUT_LINE ('Coordonnee_x: ' || rec.lieu);
    DBMS_OUTPUT.PUT_LINE ('Nom du sous_traitants: ' || rec.nomDuSousTraitant);
    DBMS_OUTPUT.PUT_LINE ('Date début: ' || rec.date_debut);
    DBMS_OUTPUT.PUT_LINE ('Date fin: ' || rec.date_fin);
    DBMS_OUTPUT.PUT_LINE ('----------------------------------------------------');

    l_projet_tab(n) := projet_obj(rec.nomDuProjet, rec.lieu, rec.nomDuSousTraitant, rec.date_debut, rec.date_fin);
  END LOOP;
return l_projet_tab;

EXCEPTION 
    WHEN NO_DATA_FOUND THEN -- prend tous les erreurs 'no data found'
       DBMS_OUTPUT.PUT_LINE (' La collection est vide.');
    WHEN OTHERS THEN  -- s'occupe de toutes les autres erreurs
      DBMS_OUTPUT.PUT_LINE ('Une erreur est apparue:' || SQLCODE || ' : ' || SQLERRM);
END;


SELECT * FROM table(Getprojet('10/10/2000', '10/10/3000'));