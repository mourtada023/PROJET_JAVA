package game.war;

import static org.junit.Assert.*;

import org.junit.Test;

import game.war.modes.Random;

public class GameTest {

	@Test
	public void addPlayerToTheList() {
		Board board = new Board(4,4);
		Game game = new Game(board);
		Player p1 = new Player("sam",new Random());
		assertEquals(game.getPlayers().size(),0);
		game.addPlayer(p1);
		assertEquals(game.getPlayers().size(),1);
	}
}
