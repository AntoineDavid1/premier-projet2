import java.util.ArrayList;
import java.util.ListIterator;

import ardoise.*;
public class FormeComposer extends Forme{
	private String nom;
	private ArrayList<Forme> f;
	
	public FormeComposer() {
		super("GF");
		this.f = new ArrayList<Forme>();
	}
	public FormeComposer(String nom) {
		super("GF");
		this.nom = nom;
		this.f = new ArrayList<Forme>();
	}
	public void ajouterForme(Forme f) {
		this.f.add(f);
	}
	@Override
	public void deplacer(int arg0, int arg1) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.f.size();i++) {
			this.f.get(i).deplacer(arg0, arg1);
		}
	}

	@Override
	public ArrayList<Segment> dessiner() {
		// TODO Auto-generated method stub
		ArrayList<Segment> d = new ArrayList<Segment>(this.nbForme());
		ListIterator<Segment> ite = d.listIterator();
		
		for(int i = 0;i<this.nbForme();i++) {
			
			ArrayList<Segment> de = this.getF(i).dessiner();
			for(int v=0;v<de.size();v++) {
				ite.add(de.get(v));
			}
			
		}
		return d;
	}

	@Override
	public String typeForme() {
		// TODO Auto-generated method stub
		return "GF";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Forme getF(int i) {
		return this.f.get(i);
	}

	public void setF(ArrayList<Forme> f) {
		this.f = f;
	}
	public int nbForme() {
		return this.f.size();
	}
	
	public String toString() {
		String s = super.toString();
		for(int i=0;i<this.f.size();i++) {
			s = s + this.getF(i).toString();
		}
		return s;
	}

}
