import java.util.ArrayList;


import ardoise.*;

public class Quadrilateres extends Forme{
	private ArrayList <PointPlan> coin;
	private String nom;
	public Quadrilateres() {
		super("Q");
		this.coin = new ArrayList<PointPlan>(2);
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Quadrilateres(String nom,PointPlan x,PointPlan y ) {
		super("Q");
		this.nom= nom;
		try {
			if(x.getAbscisse()<0 && x.getOrdonnee()<0  
					&&x.getAbscisse()>200 &&   x.getAbscisse()>200
					&& y.getAbscisse()<0 && y.getOrdonnee()<0
					&& y.getOrdonnee()>200 && y.getAbscisse()>200
					) {
				throw new Exception();
			}
			this.coin = new ArrayList<PointPlan>(3);
			this.coin.add(x);
			this.coin.add(y);
		}
		catch(Exception e){
			System.out.println("En dehord de l'ardoise");
			
		
		}
	}
	public PointPlan getCoin(int i) {
		return this.coin.get(i);
	}
	public void setCoin(int i,PointPlan p) {
		this.coin.set(i, p);
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
	public ArrayList<Segment> dessiner() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Segment> d = new ArrayList<Segment>(4);
			PointPlan r = new PointPlan(this.coin.get(1).getAbscisse(),this.coin.get(0).getOrdonnee());
			PointPlan t = new PointPlan(this.coin.get(0).getAbscisse(),this.coin.get(1).getOrdonnee()); 
			Segment s1 = new Segment(this.coin.get(0),r);
			d.add(s1);
			Segment s2 = new Segment(r,this.coin.get(1));
			d.add(s2);
			Segment s3 = new Segment(this.coin.get(1),t);
			d.add(s3);
			Segment s4 = new Segment(t,this.coin.get(0));
			d.add(s4);
			
			
			
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
		return "Q";
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
