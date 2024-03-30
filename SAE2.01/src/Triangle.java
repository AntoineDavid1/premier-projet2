import java.util.ArrayList;
import java.util.ListIterator;

import ardoise.*;

public class Triangle extends Forme {
	private ArrayList <PointPlan> coter;
	private String nom;
	
	public Triangle() {
		super("T");
		this.coter = new ArrayList<PointPlan>(3);
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Triangle(String nom,PointPlan x,PointPlan y,PointPlan z ) {
		super("T");
		this.nom = nom;
		try {
			if(x.getAbscisse()<0 && x.getOrdonnee()<0  
					&&x.getAbscisse()>200 &&   x.getAbscisse()>200
					&& y.getAbscisse()<0 && y.getOrdonnee()<0
					&& y.getOrdonnee()>200 && y.getAbscisse()>200
					&& z.getAbscisse()<0 && z.getOrdonnee()<0
					&& z.getOrdonnee()>200 && y.getAbscisse()>200 ) {
				throw new Exception();
			}
			this.coter = new ArrayList<PointPlan>(3);
			this.coter.add(x);
			this.coter.add(y);
			this.coter.add(z);
		}
		catch(Exception e){
			System.out.println("En dehord de l'ardoise");
			
		
		}
		
	}
	
	
	public ArrayList<Segment> dessiner()  {
		ArrayList<Segment> d = new ArrayList<Segment>(this.nbCoter());
		try {
			
			ListIterator<Segment> de = d.listIterator();

			
			for(int i = 0;i<this.coter.size()-1;i++) {
				Segment s = new Segment(this.coter.get(i),this.coter.get(i+1));
				de.add(s);
			}
			Segment s = new Segment(this.coter.get(this.coter.size()-1),this.coter.get(0));
			d.add(s);
			return d;
			
		}
		catch(Exception e) {
			System.out.println("Il n'ya pas de Segment");
			return null;
		}
		
		
	}
	public PointPlan getCoter(int i) {
		return this.coter.get(i);
	}
	
	
	public void setCoter(int i,PointPlan p) {
		this.coter.set(i, p);
	}
	
	public String toString() {
		String s = super.toString();
		for(int i=0;i<this.coter.size();i++) {
			s = s + this.getCoter(i).toString();
		}
		return s;
	}
	
	@Override
	public void deplacer(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
		try{
			for (int i =0;i<this.coter.size();i++) {
				if (this.getCoter(i).getAbscisse()+arg0<0 
						&& this.getCoter(i).getOrdonnee()+arg1<0 
						&& this.getCoter(i).getAbscisse()+arg0>200 
						&& this.getCoter(i).getOrdonnee()+arg1>200) {
					throw new Exception();
				}
				else {
					
				
				this.coter.get(i).setAbscisse(this.getCoter(i).getAbscisse()+arg0);
				this.coter.get(i).setOrdonnee(this.getCoter(i).getOrdonnee()+arg1);
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("point négative");
		}
		
		
		
		
	}
	@Override
	public String typeForme() {
		// TODO Auto-generated method stub
		return "T";
	}
	
	
	public int nbCoter() {
		return this.coter.size();
	}
	
		
	
	
		
		
	
}
