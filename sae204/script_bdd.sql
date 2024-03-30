create table Etudiant ( id_etudiant serial primary key,nom_etu varchar(50), prenom_etu varchar(50));

create table Enseignant ( id_enseignant serial primary key, nom_ens varchar(50), prenom_ens varchar(50));

create table Module ( id_module int primary key, nom_module varchar(50), id_responsable int references Enseignant(id_enseignant));

create table Controle ( id_controle serial primary key, nom_controle varchar(50), id_module int references Module(id_module));

create table Notes ( id_etudiant int references Etudiant(id_etudiant), id_controle int references Controle(id_controle), note decimal(4,2), primary key (id_etudiant, id_controle));

create table Groupe ( Nom_grp varchar(10) primary key, effectif int, MoyGrp int, id_etudiant int references Etudiant(id_etudiant));