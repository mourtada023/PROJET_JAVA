package action;

import org.junit.Test;

import figure.*;
import maze.*;

public class ObserverTest {


	 @Test
	    public void testObserver(){
	     	Maze m = new BinaryTreeMaze(6, 8);
	    	Hero h = new Hero(m.getCell(3,2), 0);
	    	m.initMaze();
	    	Sphynx a = new Sphynx(m.getCell(2,2));
	    	Fou s = new Fou(m.getCell(3,3));
	    	Marchand p = new Marchand(m.getCell(4,2));
	    	Marchand p2 = new Marchand(m.getCell(4,2));
	    	Sphynx s2 = new Sphynx(m.getCell(3,1));
	    	m.getCell(2,2).addFigure(a);
	    	m.getCell(3,3).addFigure(s);
	    	m.getCell(4,2).addFigure(p);
	    	m.getCell(3,1).addFigure(s2);
	    	m.getCell(4,2).addFigure(p2);
	    	Observer o = new Observer();
	    	o.voir(h, m);

	    }

}
