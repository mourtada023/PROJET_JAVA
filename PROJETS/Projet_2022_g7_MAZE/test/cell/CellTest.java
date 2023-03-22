package cell;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import figure.Marchand;
import objet.Joyaux;
import objet.Parchemin;

public class CellTest {

	@Test
	public void testGet() {
	Cell cell = new Cell(0, 1);
	assertEquals(0,cell.getX());
	assertEquals(1,cell.getY());
		
	}
	
	@Test
	public void testAddFigure() {
	Cell cell = new Cell(0, 1);
	Marchand m = new Marchand(cell);
	cell.addFigure(m);
	assertTrue(cell.getFigure().contains(m));	
	}
	
	@Test
	public void testAddParchemin() {
	Cell cell = new Cell(0, 1);
	Parchemin p = new Parchemin(cell);
	cell.addParchemin(p);
	assertTrue(cell.getParchemin().contains(p));			
	}
	
	@Test
	public void testAddJoyau() {
	Cell cell = new Cell(0, 1);
	Joyaux p = new Joyaux(cell);
	cell.addJoyau(p);
	assertTrue(cell.getJoyau().contains(p));			
	}
	
	@Test
	public void testgetWalls() {
		Cell cell = new Cell(0, 1);
		assertTrue(cell.getWalls()[0]);
		assertTrue(cell.getWalls()[1]);
		assertTrue(cell.getWalls()[2]);
		assertTrue(cell.getWalls()[3]);
	}
	
	@Test
	public void testsetWalls() {
		Cell cell = new Cell(0, 1);
		boolean[] walls = {true, false, true, false};
		cell.setWalls(walls);
		assertTrue(cell.getWalls()[0]);
		assertFalse(cell.getWalls()[1]);
		assertTrue(cell.getWalls()[2]);
		assertFalse(cell.getWalls()[3]);
	}

}

