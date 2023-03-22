package game.war.resources;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourcesTest {

	@Test
	public void convertCornToFood() {
		Corn corn = new Corn(3);
		Food food =  new Food(0);
		assertEquals(corn.getQuantity(),3);
		int gained = corn.convertRessource(3,food);
		assertEquals(corn.getQuantity(),0);
		assertEquals(gained,15);
	}
	
	@Test
	public void convertBase0ToFood() {
		Rock rock = new Rock(3);
		Food food =  new Food(0);
		assertEquals(rock.getQuantity(),3);
		int gained = rock.convertRessource(3,food);
		assertEquals(rock.getQuantity(),0);
		assertEquals(gained,0);
	}
	
	@Test
	public void convertNotConvertibleToFood() {
		Gold gold = new Gold(3);
		Food food =  new Food(0);
		assertEquals(gold.getQuantity(),3);
		int gained = gold.convertRessource(3,food);
		assertEquals(gold.getQuantity(),3);
		assertEquals(gained,-2);
	}
	
	@Test
	public void convertWoodToFood() {
		Wood wood = new Wood(3);
		Food food =  new Food(0);
		assertEquals(wood.getQuantity(),3);
		int gained = wood.convertRessource(3,food);
		assertEquals(wood.getQuantity(),0);
		assertEquals(gained,3);
		assertEquals(gained,food.getQuantity());
	}
	
	@Test
	public void convertTooManyResourcesToFood() {
		Wood wood = new Wood(3);
		Food food =  new Food(0);
		assertEquals(wood.getQuantity(),3);
		int gained = wood.convertRessource(5,food);
		assertEquals(wood.getQuantity(),3);
		assertEquals(gained,-1);
	}
	
	@Test
	public void modifyQuantityByAdding() {
		Corn corn = new Corn(3);
		assertEquals(corn.getQuantity(),3);
		corn.modifyQuantity(3);
		assertEquals(corn.getQuantity(),6);
	}
	
	@Test
	public void modifyQuantityBySubstracting() {
		Corn corn = new Corn(3);
		assertEquals(corn.getQuantity(),3);
		corn.modifyQuantity(-3);
		assertEquals(corn.getQuantity(),0);
	}
	
	@Test
	public void toBaseCorn() {
		Corn corn = new Corn(3);
		assertEquals(corn.getQuantity(),3);
		assertEquals(corn.toBase(3),15);
	}
	
	@Test
	public void toBaseWood() {
		Wood wood = new Wood(3);
		assertEquals(wood.getQuantity(),3);
		assertEquals(wood.toBase(3),3);
	}
	
	@Test
	public void toBaseSand() {
		Sand sand = new Sand(3);
		assertEquals(sand.getQuantity(),3);
		assertEquals(sand.toBase(3),0);
	}
	
	@Test
	public void toBaseRock() {
		Rock rock = new Rock(3);
		assertEquals(rock.getQuantity(),3);
		assertEquals(rock.toBase(3),0);
	}

}
