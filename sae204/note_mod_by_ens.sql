--un Enseignant ne peut consulter seulement les notes des modules dont il est responsable
CREATE or Replace function note_mod_by_ens(in id_enseignant int,in modules varchar) returns numeric

as


$$
    select note from Notes Natural join Controle Natural join module Natural join Enseignant 
	where id_enseignant = $1 and nom_module = $2;


$$ language SQL

--Un Enseignant ne peut consulter seulement les notes des Élève qui sont inscrit aux modules de l'enseignant
