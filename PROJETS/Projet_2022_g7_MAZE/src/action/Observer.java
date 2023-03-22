package action;

import cell.Cell;
import figure.Figure;
import figure.Hero;
import maze.Maze;
import objet.Joyaux;
import objet.Objet;
import objet.Parchemin;

import java.util.List;


public class Observer extends Action {

	public Observer() {
		super();
	}
// lorssque le hero decide d'observer il peut voir ce qu'il y a dans les cellules voisines comme figure ou objet avec lesquelles il n'y a pas de murs qui les separent
	public void voir(Hero h,Maze maze){
		Cell actualCell = h.getCell();
		List<Cell> listCell = maze.adjoiningCells(actualCell);
		for(Cell c : listCell){
			this.localiserCellVosine(actualCell, c);
			
			List<Figure> listFigure = c.getFigure();
			List<Parchemin> listParchemin = c.getParchemin();
			List<Joyaux> listJoyau = c.getJoyau();
			
			
			if(!(listFigure.isEmpty())) {
				for(Figure figure : listFigure ) {
				figure.whoIAm();
				}
			}
			
			if(!(listJoyau.isEmpty())) {
				for(Objet object: listJoyau) {
					object.whatIAm();}
			}
			
			if(!(listParchemin.isEmpty())) {
				for(Objet object: listParchemin) {
					object.whatIAm();}
			}
			
			if(listFigure.isEmpty() && listParchemin.isEmpty() && listJoyau.isEmpty()){
				System.out.println("aucun objet ou personnage ");
			}
	}
	}


	private void localiserCellVosine(Cell actual, Cell  next) {
		int xActual = actual.getX();
		int yActual = actual.getY();
		int xNext = next.getX();
		int yNext = next.getY();
		if(yActual == yNext) {
			if (xNext == xActual - 1) System.out.println("- Dans la cellule nord se trouve");
			if (xNext == xActual + 1) System.out.println("- Dans la cellule sud se trouve ");
		}else {
			if (yNext == yActual + 1) System.out.println("- Dans la cellule est se trouve");
			if (yNext == yActual - 1) System.out.println("- Dans la cellule ouest se trouve");


		}
	}
	
	

	
	public String toString(){
		return "je regarde ce qu'il y a autour de moi";
	}

}
