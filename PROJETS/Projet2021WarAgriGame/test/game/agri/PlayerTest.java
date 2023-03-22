package game.agri;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import game.Resource;
import game.war.Army;
import game.war.Player;
import game.war.modes.Random;
import game.war.resources.Corn;


public class PlayerTest {
	
	
	@Test
	public void addResourcesOfThePlayer() {
		Player sam = new Player("Sam",new Random());
		Resource corn = new Corn(5);
		assertEquals(sam.getResources().size(),2);
		sam.addRessource(corn);
		assertEquals(sam.getResources().size(),3);
	}
	
	
	



}
