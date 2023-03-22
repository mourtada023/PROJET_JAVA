package figure;





import cell.Cell;
import maze.Maze;

public class  Marchand extends Figure {

  

  
  public Marchand(Cell c) {
     super(c);
  }

  

	public void answer (Maze m, Hero h,Cell objectif) {
		//Le marchand donne un indice au hero si il a assez d'or pour le payer
		if (h.getOr() >= 2) {
			setNbTurns();
			h.setOr(h.getOr()-2);
			indice(m, h,objectif);
			}
		else {
			System.out.println("Vous n'avez pas assez d'or\n");
			
		}
}
	

	  public void whoIAm() {
		  System.out.println("un marchand\n");
	  }



	
	  
  
  
}