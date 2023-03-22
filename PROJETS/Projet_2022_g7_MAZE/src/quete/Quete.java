package quete;

import cell.Cell;
import figure.Hero;
import maze.Maze;

public class Quete {
	 //le jeu se termine lorsque le hero a au moins 5 pieces d'or et a atteint la cellule objectif
	 public Boolean EndOfTheGame(Hero h, Maze m,Cell objectif) {
		 if (h.getOr() >= 5 &&  h.getCell().equals(objectif)) {
			  System.out.print("Vous avez reussi votre mission felicitations");
			  return true;
			  
		 }
		 else {
			return false;
		 }
	 }
}
