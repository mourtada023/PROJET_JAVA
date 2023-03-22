package action;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import figure.Hero;
import maze.BinaryTreeMaze;
import maze.Maze;
import objet.Joyaux;


public class ActionTest {

   @Test
   public void testGetNbTurns(){
	    Maze m = new BinaryTreeMaze(6, 8);
	    Hero h = new Hero(m.getCell(3,2), 0);
	    Joyaux j1 = new Joyaux(m.getCell(3,2));
	    Ramasser p = new Ramasser();
	    p.PickJoyaux(h,j1);
	    assertEquals(1,p.getNbTurns());


	    }






}
