create function moy_etudiant(in id_etudiant int, out moy int)
	returns int 
as
$$
declare
moy int;
begin
select avg(n.notes)
into moy
from note n
where n.id_etudiant = id_etudiant;

end;
$$ language plpgsql;