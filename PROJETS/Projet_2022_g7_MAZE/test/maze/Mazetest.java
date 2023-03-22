package maze;
import cell.Cell;

import static org.junit.Assert.*;

import org.junit.Test;



public class Mazetest {



	@Test
	public void testGets() {
		Maze maze = new BinaryTreeMaze(4,6);
		assertEquals(4,maze.getnx());
		assertEquals(6,maze.getny());
		assertEquals(24,maze.getTotalNumberOfCells());
	}

	@Test
	public void testCelluleVoisines() {
		Maze maze = new BinaryTreeMaze(4,6);
		Cell c1=maze.getCell(2, 2);
		Cell c2=maze.getTop(c1);
		Cell c3=maze.getBottom(c1);
		Cell c4=maze.getLeft(c1);
		Cell c5=maze.getRight(c1);
		assertEquals(maze.getCell(1, 2),c2);
		assertEquals(maze.getCell(3, 2),c3);
		assertEquals(maze.getCell(2, 1),c4);
		assertEquals(maze.getCell(2, 3),c5);
	}




	@Test
	public void testRemoveWall() {
		Maze maze = new BinaryTreeMaze(4,6);
		maze.removeWall(maze.getCell(1, 1), maze.getBottom(maze.getCell(1, 1)));
		assertFalse(maze.getCell(1, 1).getWalls()[1]);
		assertFalse( maze.getBottom(maze.getCell(1, 1)).getWalls()[0]);

	}


}
