import java.util.ArrayList;

import ardoise.*;



 /**
28 * Classe TestArdoise
29 * @author Bouchaib
30 * @version 2013
31 *
32 * Validation de l’ intgration de la librairie ardoise.jar au projet Eclipse
33 */
 public class TestArdoise {

 public static void main(String []args ) throws InterruptedException{

 Ardoise ardoise = new Ardoise();
 PointPlan o = new PointPlan(50,5);
 PointPlan i = new PointPlan(4,15);
 PointPlan a = new PointPlan(115,15);
 
 Forme tr = new Triangle(o,i,a);
 ArrayList <Segment> triangle = tr.dessiner();
 
 ardoise.ajouterForme(tr);

 
 PointPlan o2 = new PointPlan(150,4);
 PointPlan i2 = new PointPlan(156,7);
 PointPlan a2 = new PointPlan(140,7);
 
 Forme tr2 = new Triangle(o2,i2,a2);
 ArrayList <Segment> triangle2 = tr2.dessiner();
 ardoise.ajouterForme(tr2);
 
 PointPlan o3 = new PointPlan(120,14);
 PointPlan i3 = new PointPlan(125,21);
 PointPlan a3 = new PointPlan(130,14);
 Forme c = new Chapeaux("Oiseau 1",o3,i3,a3);
 ArrayList <Segment> chapeau = c.dessiner();
 ardoise.ajouterForme(c);
 
 PointPlan o4 = new PointPlan(135,30);
 PointPlan i4 = new PointPlan(137,32);
 PointPlan a4 = new PointPlan(139,30);
 Forme c2 = new Chapeaux("Oiseau 2",o4,i4,a4);
 ArrayList <Segment> chapeau2 = c2.dessiner();
 ardoise.ajouterForme(c2);
 
 PointPlan o5 = new PointPlan(138,13);
 PointPlan i5 = new PointPlan(140,15);
 PointPlan a5 = new PointPlan(143,13);
 Forme c3 = new Chapeaux("Oiseau 3",o5,i5,a5);
 ArrayList <Segment> chapeau3 = c3.dessiner();
 ardoise.ajouterForme(c3);

 PointPlan o6 = new PointPlan(155,55);
 PointPlan i6 = new PointPlan(160,65);
 PointPlan a6 = new PointPlan(165,55);
 Forme c4 = new Chapeaux("Etoile",o6,i6,a6);
 ArrayList <Segment> chapeau4 = c4.dessiner();
 //ardoise.ajouterForme(c4);
 
 PointPlan o7 = new PointPlan(165,55);
 PointPlan i7 = new PointPlan(175,50);
 PointPlan a7 = new PointPlan(165,45);
 Forme c5 = new Chapeaux("Etoile2",o7,i7,a7);
 ArrayList <Segment> chapeau5 = c5.dessiner();
 //ardoise.ajouterForme(c5);
 
 PointPlan o8 = new PointPlan(165,45);
 PointPlan i8 = new PointPlan(160,35);
 PointPlan a8 = new PointPlan(155,45);
 Forme c6 = new Chapeaux("Etoile3",o8,i8,a8);
 ArrayList <Segment> chapeau6 = c6.dessiner();
 //ardoise.ajouterForme(c6);
 
 PointPlan o9 = new PointPlan(155,45);
 PointPlan i9 = new PointPlan(145,50);
 PointPlan a9 = new PointPlan(155,55);
 Forme c7 = new Chapeaux("Etoile4",o9,i9,a9);
 ArrayList <Segment> chapeau7 = c7.dessiner();
 //ardoise.ajouterForme(c7);
 
 PointPlan m = new PointPlan(80,140);
 PointPlan ai = new PointPlan(130,100);
 PointPlan s = new PointPlan(180,140);
 Forme c8 = new Chapeaux("Toit",m,ai,s);
 ArrayList <Segment> chapeau8 = c8.dessiner();
 //ardoise.ajouterForme(c8);
 
 FormeComposer etoile= new FormeComposer("etoile");
 etoile.ajouterForme(c4);
 etoile.ajouterForme(c5);
 etoile.ajouterForme(c6);
 etoile.ajouterForme(c7);
 ardoise.ajouterForme(etoile);
 PointPlan x = new PointPlan(10,100);
 PointPlan z = new PointPlan(20,197);
 Forme q = new Quadrilateres(x,z);
 ArrayList <Segment> quadrilateres = q.dessiner();
 ardoise.ajouterForme(q);
 
 
 
 PointPlan x2 = new PointPlan(80,140);
 PointPlan z2 = new PointPlan(180,197);
 Forme q2 = new Quadrilateres(x2,z2);
 ArrayList <Segment> quadrilateres2 = q2.dessiner();
 //ardoise.ajouterForme(q2);
 
 PointPlan x3 = new PointPlan(120,167);
 PointPlan z3 = new PointPlan(140,197);
 Forme q3 = new Quadrilateres(x3,z3);
 //ArrayList <Segment> quadrilateres3 = q3.dessiner();
 Forme maison = new FormeComposer("maison");
 ((FormeComposer) maison).ajouterForme(c8);
 ((FormeComposer) maison).ajouterForme(q2);
 ((FormeComposer) maison).ajouterForme(q3);
 Forme p = ((FormeComposer)maison).getF(0);
 ArrayList <Segment> quadrilateres3 = p.dessiner();
 ArrayList <Segment> quadrilateres35 = ((FormeComposer)maison).dessiner();
 System.out.println(quadrilateres35.size());
 
 for(int v=0;v<quadrilateres35.size();v++) {
	 System.out.println(quadrilateres35.get(v));
 }
 ardoise.ajouterForme(maison);
 ardoise.dessinerGraphique();
 
 while (true) {
	 Thread.sleep(1000);
	 ardoise.deplacer("C", 10, 20);
 }
 
 
 

 }
 }
