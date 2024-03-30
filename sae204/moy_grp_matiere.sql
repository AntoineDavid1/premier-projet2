create view moyen_mat_group as
	select e.id_etudiant, nom_etu, prenom_etu, m.id_module, g.Nom_grp, avg(note) as moyenne
		from Etudiant e, Module m, Controle c, Notes n, Groupe g
			where m. id_matiere = c.id_module
				and c. id_controle = n. id_controle
				and n. id_etudiant = e. id_etudiant
				and e.id_etudiant = g.id_etudiant
		group by e.id_etudiant, nom_etu, prenom_etu, m. id_module, g. Nom_Grp;