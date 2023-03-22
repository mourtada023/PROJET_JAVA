package figure;

import cell.Cell;
import maze.Maze;


public abstract class Figure {


	protected Cell cell;
	protected int nbTurns ;


  public Figure(Cell c) {
     this.cell = c;
     this.nbTurns = 0;


  }


  public Cell getCell() {
    return this.cell;
  }


  public void setCell(Cell c) {
    this.cell = c;
  }


   public int getNbTurns(){
	 return this.nbTurns;
}


   public void setNbTurns(){
	this.nbTurns = this.nbTurns + 1;
}



   public void indice(Maze m, Hero h,Cell objectif) {
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


   public abstract void answer(Maze m, Hero h,Cell c);
   public abstract void whoIAm();





}
