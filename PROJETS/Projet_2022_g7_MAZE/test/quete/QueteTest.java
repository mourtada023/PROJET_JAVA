package quete;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import action.Ramasser;
import cell.Cell;
import figure.Hero;
import maze.BinaryTreeMaze;
import maze.Maze;
import objet.Joyaux;

public class QueteTest {
	  @Test
	    public void testEndOfTheGameWhenTheHeroHaveNotEnoughGold(){
	     	Maze m = new BinaryTreeMaze(6, 8);
	    	Hero h = new Hero(m.getCell(3,2), 0);
	    	Cell obj = new Cell(4,7);
	    	m.initMaze();
	    	Joyaux j1 = new Joyaux(m.getCell(3,2));
	    	Ramasser p = new Ramasser();
	    	Quete q = new Quete();
	    	p.PickJoyaux(h,j1);
	    	assertFalse(q.EndOfTheGame(h, m,obj)); 		
	    	 
	    }
	    
	    @Test
	    public void testEndOfTheGameWhenTheHeroDidNotReachTheObjectiveCell(){
	     	Maze m = new BinaryTreeMaze(6, 8);
	    	Hero h = new Hero(m.getCell(3,2), 5);
	    	Cell obj = new Cell(4,7);
	    	System.out.print("\n");
	    	Quete q = new Quete();
	    	assertFalse(q.EndOfTheGame(h, m, obj)); 
	    	
	    }
	    
	    @Test
	    public void testEndOfTheGameSuccessfull(){
	     	Maze m = new BinaryTreeMaze(6, 8);
	    	Hero h = new Hero(m.getCell(3,2), 5);
	    	Cell obj = m.getCell(3,2);
	    	System.out.print("\n");
	    	Quete q = new Quete();
	    	System.out.print("test3 : ");
	    	assertTrue(q.EndOfTheGame(h, m, obj)); 
	    	
	    }
	   
}
