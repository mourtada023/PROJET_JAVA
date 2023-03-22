package game.war;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Resource;
import game.exceptions.CanNotDoActionException;
import game.war.modes.Random;
import game.war.resources.Corn;
import game.war.resources.Food;
import game.war.resources.Wood;

public class PlayerTest {

	@Test
	public void addCharacterInSetOwnerOfThePlayer() throws CanNotDoActionException {
		Player sam = new Player("Sam",new Random());
		assertEquals(sam.getDeployedSoldiers(),0);
		new Army(sam,4);
		assertEquals(sam.getDeployedSoldiers(),4);
	}
	@Test
	public void removeCharacterOfThePlayer() throws CanNotDoActionException {
		Player sam = new Player("Sam",new Random());
		Army test = new Army(sam,4);
		assertEquals(sam.getDeployedSoldiers(),4);
		sam.removeCharacter(test);
		assertEquals(sam.getDeployedSoldiers(),0);
	}
	
	@Test
	public void addResourcesOfThePlayer() {
		Player sam = new Player("Sam",new Random());
		Resource corn = new Corn(5);
		assertEquals(sam.getResources().size(),2);
		sam.addRessource(corn);
		assertEquals(sam.getResources().size(),3);
	}
	@Test
	public void convertResourceFromWoodToFood() { /* Test similaire à tout dans ResourcesTest*/
		Player sam = new Player("Sam",new Random());
		Wood wood = new Wood(3);
		Food food =  new Food(0);
		assertEquals(wood.getQuantity(),3);
		int gained = sam.convertResource(wood,3,food);
		assertEquals(wood.getQuantity(),0);
		assertEquals(gained,3);
		assertEquals(gained,food.getQuantity());
	}

}
