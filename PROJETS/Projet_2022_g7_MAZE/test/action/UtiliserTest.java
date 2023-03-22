package action;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import cell.Cell;
import figure.Hero;
import maze.*;
import objet.Joyaux;
import objet.Parchemin;

public class UtiliserTest {

	
	@Test
    public void testOpenParchemin(){
    	Maze m = new SidewinderMaze(6, 8);
    	Hero h = new Hero(m.getCell(3,2), 0);
    	Parchemin p1 = new Parchemin(m.getCell(3,2));
    	m.getCell(3,2).addParchemin(p1);
    	Cell obj = new Cell(4,7);
    	Utiliser p = new Utiliser();
    	Ramasser r = new Ramasser();
    	r.PickParchemin(h, p1);
    	p.OpenParchemin(p1, h, m, obj);
    	assertFalse(h.getParcheminPickedUp().contains(p1));//si le parchemin n'est plus dans la liste des parchemins une fois ramasser c'est qu'il a ete ouvert
    }    
   

	

    @Test
    public void testUseJoyaux(){
    	Maze m = new SidewinderMaze(6, 8);
    	Hero h = new Hero(m.getCell(3,2), 4);
    	Joyaux j1 = new Joyaux(m.getCell(3,2));
    	m.getCell(3,2).addJoyau(j1);
    	Utiliser p = new Utiliser();
    	Ramasser r = new Ramasser();
    	r.PickJoyaux(h, j1);
    	p.UseJoyaux(j1, h);
    	
    }
}
