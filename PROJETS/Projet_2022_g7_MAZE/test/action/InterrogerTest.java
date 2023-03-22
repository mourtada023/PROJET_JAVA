package action;

import org.junit.Test;

import cell.Cell;
import figure.*;
import maze.*;


public class InterrogerTest {

	 @Test
	    public void testInterrogateFigure(){
	     	Maze m = new BinaryTreeMaze(6, 8);
	     	m.initMaze();
	    	Hero h = new Hero(m.getCell(3,2), 0);
	    	Fou a = new Fou(m.getCell(3,2));
	    	Sphynx s = new Sphynx(m.getCell(3,2));
	    	Marchand m1 = new Marchand(m.getCell(3,2));
	    	Cell obj = m.getCell(4,7);
	    	m.getCell(3,2).addFigure(a);
	    	m.getCell(3,2).addFigure(s);
	    	m.getCell(3,2).addFigure(m1);
	    	Interroger i = new Interroger();
	    	i.interogateFigure(h, m, obj);		
	    	
	    }
}
