create or replace function consulter_notes_etudiant(pid_etudiant INT)
  returns table (id_etudiant INT, notes NUMERIC)
as $$
begin
  return query
  select n.id_etudiant, n.notes
  from note n
  where n.id_etudiant = p_id_etudiant;

  return;
end;
$$ language plpgsql
	security definer;