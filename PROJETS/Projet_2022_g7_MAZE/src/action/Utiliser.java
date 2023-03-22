package action;

import cell.Cell;
import figure.Hero;
import maze.Maze;
import objet.Joyaux;
import objet.Parchemin;

public class Utiliser extends Action{
	

	 public Utiliser() {
			super();
			 }
	

	   public void OpenParchemin(Parchemin p, Hero h, Maze m, Cell c) {
		   if (h.getParcheminPickedUp().contains(p) && !h.getParcheminPickedUp().isEmpty()) {// une fois un parchemin ramasser il peut etre ouvrir 
			     h.getParcheminPickedUp().remove(p); //on supprime le parchemin vu qu'il a deja ete utilise
			     getNbTurns();
	             p.indice(m, h, c);  //lorsque on decide d'ouvrir un parchemin on a un indice
		   }else{
			   System.out.print("Vous n'avez aucun parchemin\n ");   
		   }
	   }

	   public void UseJoyaux(Joyaux j, Hero h) {
		   if (h.getJoyauxPickedUp().contains(j) && !h.getJoyauxPickedUp().isEmpty()) {
			   h.setOr(h.getOr()+2); // une fois le bijou ramasser il sera converti en 2 pieces d'or 
			   h.getJoyauxPickedUp().remove(j);// on supprime le joyau il a ete converti
			   setNbTurns();
      	}
		   else {
			   System.out.print("Vous n'avez aucun joyau \n");
   			}
	   }
	   
	   public String toString(){
		return "j'ai utilise un des objets ramasse";
	}

}
