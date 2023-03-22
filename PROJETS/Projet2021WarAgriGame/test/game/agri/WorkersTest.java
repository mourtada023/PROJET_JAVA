
package game.agri;


import static org.junit.Assert.*;

import org.junit.Test;

import game.agri.tiles.Desert;
import game.exceptions.CanNotDoActionException;

public class WorkersTest{
	
	
	@Test
	public void modifyGoldIfWeAdd() throws CanNotDoActionException {
		
		Player sam = new Player("Sam", null);
		Worker a1 = new Worker(sam);
		assertTrue(a1.getOwner()==sam);
		assertTrue(a1.getGold()==0);
		a1.modifyGold(2);
		assertTrue(a1.getGold()==2);
	}
	
	@Test
	public void modifyGoldIfWeSubstract() throws CanNotDoActionException {
		Player sam = new Player("Sam", null);
		Worker a1 = new Worker(sam);
		assertTrue(a1.getGold()==0);
		a1.modifyGold(-6);
		assertTrue(a1.getGold()==-6);
	}
	
	@Test
	public void produitTestAFaire() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player sam = new Player("Sam",null);
		Worker a1 = new Worker(sam);
		Desert des = new Desert(0,board);
		des.setOccupant(a1);
		assertEquals(des.getRessource().getQuantity(),0);
		a1.produit();
		assertEquals(des.getRessource().getQuantity(),1);
	}
	
}