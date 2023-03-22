package game.war;

import static org.junit.Assert.*;

import org.junit.Test;

import game.war.tiles.Ocean;

public class BoardTest {

	@Test
	public void oneThirdOrLessTilesAreGroundTest() {
		Board board = new Board(5,5);
		int cnt = 0;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (!(board.getTile(i, j) instanceof Ocean))
					cnt++;
			}
		}
		assertTrue(cnt<=board.getSize()/3);
	}
	
	@Test
	public void atleastOneAdjacentGroundTest() {
		Board board = new Board(5,5);
		boolean adjacent;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (!(board.getTile(i, j) instanceof Ocean)) {
					adjacent = false;
					for (int k=0; k<4; k++) {
						if (!(board.getAdjacentTiles(board.getTile(i, j))[k] instanceof Ocean))
							adjacent = true;
					}
					assertTrue(adjacent);
				}
			}
		}
	}
}
