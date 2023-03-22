package action ;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;




import figure.*;
import maze.BinaryTreeMaze;
import maze.Maze;
import objet.*;

public class RamasserTest{


    @Test
    public void testHeroCanNotPickParcheminWhoIsInAnotherCell(){
    	Maze m = new BinaryTreeMaze(5,8);
    	Hero h = new Hero(m.getCell(4, 2), 0);
    	Parchemin p1 = new Parchemin(m.getCell(3, 2));    	
    	Ramasser p = new Ramasser();
    	p.PickParchemin(h, p1);
    	assertFalse(h.getParcheminPickedUp().contains(p1));
    	
    }

    @Test
    public void testHeroCanNotPickJoyauWhoIsInAnotherCell(){
    	Maze m = new BinaryTreeMaze(5,8);
    	Hero h = new Hero(m.getCell(4, 2), 0);
    	Joyaux j1 = new Joyaux(m.getCell(3, 2));
    	Ramasser p = new Ramasser();
    	p.PickJoyaux(h, j1);
    	assertFalse(h.getJoyauxPickedUp().contains(j1));
    }
    
    @Test
    public void testpickJoyau(){
    	Maze m = new BinaryTreeMaze(5,8);
    	Hero h = new Hero(m.getCell(2, 2), 0);
    	Joyaux j1 = new Joyaux(m.getCell(2, 2));
    	Ramasser p = new Ramasser();
    	p.PickJoyaux(h, j1);
    	
    }
    
    @Test
    public void testpickParchemin(){
    	Maze m = new BinaryTreeMaze(5,8);
    	Hero h = new Hero(m.getCell(4, 2), 0);
    	Parchemin p1 = new Parchemin(m.getCell(4, 2));
    	Ramasser p = new Ramasser();
    	p.PickParchemin(h, p1);
    
    }
    
 
    
    
    
   

    

 
}