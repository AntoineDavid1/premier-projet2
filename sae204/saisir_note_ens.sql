create or replace function saisir_note_ens(id_ens int,id_etudiant int, id_controle int, note int) 
	returns void as
$$
begin 
if exists (select $1 from controle c 
	inner join module m on c.id_module = m.id_module where c.id_controle = id_controle
	and m.id_responsable = id_ens) then
		insert into notes(id_etudiant,id_controle,note)
		values(id_etudiant,id_controle,note);
end if;
end;
$$ language plpgsql
	security definer;