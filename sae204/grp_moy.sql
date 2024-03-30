create view moy_groupe as 
	select e.id_etudiant, g.Nom_grp, avg(note) as moyenne
	from Etudiant e, Controle c, Notes n, Groupe g
		where c.id_controle = n.id_controle
		and n. id_etudiant = e. id_etudiant
		and e.id_etudiant = g.id_etudiant
	group by e. id_etudiant, Nom_Grp;