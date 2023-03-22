package objet;

import cell.Cell;
import figure.Hero;
import maze.Maze;

public class  Parchemin extends Objet {

 protected String indice;


  public Parchemin(Cell c) {
     super(c);


  }



   public void indice(Maze m, Hero h, Cell objectif) {
	   String indice = "La cellule objectif se trouve plus vers le nord";
     if(objectif.getX()> h.getCell().getX() && objectif.getY()> h.getCell().getY()) {
 	    indice =  "La cellule objectif se trouve plus vers le sud-est ";
 	}
   	if(objectif.getX()> h.getCell().getX() && objectif.getY() < h.getCell().getY()) {
   		indice = "La cellule objectif se trouve plus vers le sud-ouest ";
   	}
   	if(objectif.getX() < h.getCell().getX() && objectif.getY() < h.getCell().getY()) {
   		indice =  "La cellule objectif se trouve plus vers le nord-ouest ";
   	}
   	if(objectif.getX() < h.getCell().getX() && objectif.getY() > h.getCell().getY()) {
   		indice = "La cellule objectif se trouve plus vers le nord-est ";
   	}
   	if(objectif.getX() == h.getCell().getX() && objectif.getY() > h.getCell().getY()) {
   		indice =  "La cellule objectif se trouve plus vers l'est ";
   	}
   	if(objectif.getX() == h.getCell().getX() && objectif.getY() < h.getCell().getY()) {
   		indice =  "La cellule objectif se trouve plus vers le ouest ";
   	}
   	if(objectif.getX() > h.getCell().getX() && objectif.getY() == h.getCell().getY()) {
   		indice =  "La cellule objectif se trouve plus vers le sud ";
   	}

   System.out.println(indice);

   }


  @Override
  public void whatIAm() {
  	System.out.println("un parchemin\n");

  }


}
