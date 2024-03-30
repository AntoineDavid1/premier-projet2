import java.util.ArrayList;
import java.util.ListIterator;

import ardoise.*;
public class Chapeaux extends Forme{
	private ArrayList <PointPlan> coin;
	private String nom;
	
	public Chapeaux() {
		super("C");
		this.coin = new ArrayList<PointPlan>(3);
	}
	
	public Chapeaux(String s , PointPlan x,PointPlan y,PointPlan z ) {
		super("C");
		try {
			if(x.getAbscisse()<0 && x.getOrdonnee()<0  
					&&x.getAbscisse()>200 &&   x.getAbscisse()>200
					&& y.getAbscisse()<0 && y.getOrdonnee()<0
					&& y.getOrdonnee()>200 && y.getAbscisse()>200
					&& z.getAbscisse()<0 && z.getOrdonnee()<0
					&& z.getOrdonnee()>200 && y.getAbscisse()>200 ) {
				throw new Exception();
			}
			this.coin = new ArrayList<PointPlan>(3);
			this.coin.add(x);
			this.coin.add(y);
			this.coin.add(z);
		}
		catch(Exception e){
			System.out.println("En dehord de l'ardoise");
			
		
		}	
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public PointPlan getCoin(int i) {
		return this.coin.get(i);
	}
	

	@Override
	public void deplacer(int arg0, int arg1) {
		// TODO Auto-generated method stub
		for (int i =0;i<this.coin.size();i++) {
			this.coin.get(i).setAbscisse(this.getCoin(i).getAbscisse()+arg0);
			this.coin.get(i).setOrdonnee(this.getCoin(i).getOrdonnee()+arg1);
		}
		}

	@Override
	public ArrayList<Segment> dessiner(){
		ArrayList<Segment> d = new ArrayList<Segment>(2);
		try{
			ListIterator<Segment> de = d.listIterator();

			
			for(int i = 0;i<this.coin.size()-1;i++) {
				Segment s = new Segment(this.coin.get(i),this.coin.get(i+1));
				de.add(s);
			}
			
			return d;
			
		}
		catch(Exception e) {
			System.out.println("Il n'ya pas de Segment");
			return null;
		}
		
		
	}

	@Override
	public String typeForme() {
		// TODO Auto-generated method stub
		return "C";
	}
	public int nbCoter() {
		return this.coin.size();
	}
	public String toString() {
		String s = super.toString();
		for(int i=0;i<this.coin.size();i++) {
			s = s + this.getCoin(i).toString();
		}
		return s;
	}

}
