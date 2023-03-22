package game.war.tiles;

import static org.junit.Assert.*;

import org.junit.Test;

import game.exceptions.CanNotDoActionException;
import game.war.Army;
import game.war.Board;
import game.war.Player;
import game.war.modes.Random;

public class WarTileTest {

	@Test
	public void canHostTrueOnForest() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player p1 = new Player("sam", new Random());
		WarTile forest = new Forest(5,board);
		Army a1 = new Army(p1,5);
		assertTrue(forest.canHost(a1));
	}
	
	@Test
	public void canHostFalseOnOcean() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player p1 = new Player("sam", new Random());
		WarTile ocean = new Ocean(5,board);
		Army a1 = new Army(p1,5);
		assertFalse(ocean.canHost(a1));
	}
	
	@Test
	public void canHostTrueOnPlain() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player p1 = new Player("sam", new Random());
		WarTile plain = new Plain(5,board);
		Army a1 = new Army(p1,5);
		assertTrue(plain.canHost(a1));
	}
	@Test
	public void canHostTrueOnMontain() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player p1 = new Player("sam", new Random());
		WarTile mountain = new Mountain(5,board);
		Army a1 = new Army(p1,3);
		assertTrue(mountain.canHost(a1));
	}
	@Test
	public void canHostTrueOnDesert() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player p1 = new Player("sam", new Random());
		WarTile desert = new Desert(5,board);
		Army a1 = new Army(p1,3);
		assertTrue(desert.canHost(a1));
	}
	@Test
	public void canHostFalseOnMontain() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player p1 = new Player("sam", new Random());
		WarTile mountain = new Mountain(5,board);
		Army a1 = new Army(p1,4);
		assertTrue(mountain.canHost(a1));
	}
	@Test
	public void canHostFalseOnDesert() throws CanNotDoActionException {
		Board board = new Board(5,5);
		Player p1 = new Player("sam", new Random());
		WarTile desert = new Desert(5,board);
		Army a1 = new Army(p1,4);
		assertTrue(desert.canHost(a1));
	}

}
