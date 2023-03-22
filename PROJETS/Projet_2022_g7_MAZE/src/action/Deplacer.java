package action;


import figure.Hero;
import maze.Maze;

public class Deplacer extends Action {

	 public Deplacer() {
		super();
		 }
	

	   public void goToTheTop(Hero f, Maze m) {
		   if (f.getCell().getWalls()[0] == false){
			   f.setCell(m.getTop(f.getCell()));
			   setNbTurns();
	      }
		   else {
			   System.out.print("Vous ne pouvez pas passer a travers les murs\n");
		   }
	   }
	    


	   public void goToTheRight(Hero f, Maze m) {
		   if (f.getCell().getWalls()[2] == false){
			   f.setCell(m.getRight(f.getCell()));
			   setNbTurns();
	      }
		   else {
			   System.out.print("Vous ne pouvez pas passer a travers les murs\n");
		   }
		}
	    

	   /**
	   * changes the figure's position
	   * @param the figure's who will change his position
	   */
	   public void goToTheBottom(Hero f, Maze m) {
		 if ( f.getCell().getWalls()[1] == false){
			 f.setCell(m.getBottom(f.getCell()));
			 setNbTurns();
			}
		 else {
			   System.out.print("Vous ne pouvez pas passer a travers les murs\n");
		   }
	}
	    
	 
	   /**
	   * changes the figure's position
	   * @param the figure's who will change his position
	   */
	   public void goToTheLeft(Hero f, Maze m) {
		 if (f.getCell().getWalls()[3] == false){
	 		f.setCell(m.getLeft(f.getCell()));
	 		setNbTurns();
	}
		 else {
			   System.out.print("Vous ne pouvez pas passer a travers les murs\n");
		   }
		}
		public String toString(){
			return "je me suis deplace";
		}

}
