package game.war;

import static org.junit.Assert.*;

import org.junit.Test;

import game.exceptions.CanNotDoActionException;
import game.war.modes.Random;
import game.war.tiles.Plain;

public class ArmyTest {

	@Test
	public void modifyGoldIfWeAdd() throws CanNotDoActionException {
		Player sam = new Player("Sam",new Random());
		Army a1 = new Army(sam,4);
		assertEquals(a1.getGold(),0);
		a1.modifyGold(2);
		assertEquals(a1.getGold(),2);
	}
	
	@Test
	public void modifyGoldIfWeSubstract() throws CanNotDoActionException {
		Player sam = new Player("Sam",new Random());
		Army a1 = new Army(sam,4);
		assertEquals(a1.getGold(),0);
		a1.modifyGold(-6);
		assertEquals(a1.getGold(),-6);
	}
	
	@Test
	public void produitResourcesFromPosition() throws CanNotDoActionException {
		Board board = new Board(4,4);
		Player sam = new Player("Sam",new Random());
		Army a1 = new Army(sam,4);
		Plain plain = new Plain(1,board);
		a1.setPos(plain);
		assertEquals(plain.getRessource().getQuantity(),0);
		a1.produit();
		assertEquals(plain.getRessource().getQuantity(),1);
	}

}
