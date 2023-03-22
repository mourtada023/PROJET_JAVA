package figure;

import cell.Cell;
import maze.Maze;

public class  Fou extends Figure {



  public Fou(Cell c) {
     super(c);

  }



	public void answer(Maze m, Hero h, Cell objectif) {
		String answer = "La cellule objectif est a une distance de " + m.distance(h.getCell() , objectif) + " cellules, enfin je crois";
		System.out.println(answer);
	}

  public void whoIAm() {
	  System.out.println("un fou\n");
  }

}
