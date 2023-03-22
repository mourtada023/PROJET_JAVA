package game;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

public abstract class Board {

	/**
	 * List of tiles which compose the Board
	 */
	protected ArrayList<Tile> diffTypeOfTiles;
	
	/**
	 * width of the board
	 */
	protected final int width;
	
	/**
	 * height of the board
	 */
	protected final int height;
	
	/**
	 * tile composition of the board
	 */
	protected Tile[][] map;

	/**
	 * tiles where units can be deployed
	 */
	protected ArrayList<Tile> EmptyTiles;

	/**
	 * to implement random
	 */
	protected Random random = new Random();

	/** Creates needed elements to make a board
	 * @param height height of the board
	 * @param width width of the board
	 */
	public Board(int width, int height) {
		this.height = height;
		this.width = width;
		map = new Tile[width][height];
		EmptyTiles = new ArrayList<Tile>();
		diffTypeOfTiles = new ArrayList<Tile>();
	}
	
	/** 
	 * @param pos
	 * @param nom
	 * @return
	 */
	public Tile generateTileExcept(int pos, String nom) { 						//DOC A FAIRE
		Random rand = new Random();
		Tile temp;
		int num;
		do {
			num = rand.nextInt(diffTypeOfTiles.size());
			temp = diffTypeOfTiles.get(num);
		} while (temp.getClass().getSimpleName().equals(nom));
		temp = generate(temp);
		temp.setPos(pos);
		return temp;
	}

	/**Generates an instance 
	 * @param pos
	 * @param nom
	 * @return
	 */
	public Tile generateTile(int pos, String nom) { 							//DOC A FAIRE
		for (Tile tile : diffTypeOfTiles)
			if (tile.getClass().getSimpleName().equals(nom)) {
				Tile temp = generate(tile);
				temp.setPos(pos);
				return temp;
			}
		return null;
	}

	/** Create the board composed randomly with tiles
	 */
	public void makeBoard() {
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				if (inhabitableTile(map[i][j]))
					EmptyTiles.add(map[i][j]);
	}

	/** Return the list of tiles where units can be deployed
	 * @return the list of tiles where units can be deployed
	 */
	public ArrayList<Tile> getEmptyTiles() {
		return EmptyTiles;
	}

	/** Return the tiles which are adjacent to the entered tile
	 * @param tile the studied tile 
	 * @return the adjacent tiles
	 */
	public Tile[] getAdjacentTiles(Tile tile) {
		int pos = tile.getPosition();
		int x = pos % width;
		int y = (pos - x) / width;
		Tile tiles[] = new Tile[4];
		if (y - 1 >= 0)
			tiles[0] = getTile(x, y - 1);
		if (y + 1 < height)
			tiles[1] = getTile(x, y + 1);
		if (x + 1 < width)
			tiles[2] = getTile(x + 1, y);
		if (x - 1 >= 0)
			tiles[3] = getTile(x - 1, y);
		return tiles;
	}

	/** Print the board in the output
	 */
	public void printBoard() {
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				System.out.print(map[i][j].toString() + " | ");
			}
			System.out.println();
		}
	}

	/** Return the height of the board
	 * @return the height of the board
	 */
	public int getHeight() {
		return height;
	}

	/** Return the length of the board
	 * @return the length of the board
	 */
	public int getWidth() {
		return width;
	}

	/** Return the size of the board
	 * @return the size of the board
	 */
	public int getSize() {
		return width * height;
	}

	/** Return the disposition of the tiles of the board
	 * @return the disposition of the tiles of the board
	 */
	public Tile[][] getMap() {
		return map;
	}

	/** Return the tile with given coordinate
	 * @return the tile with given coordinate
	 * @exception IndexOutOfBoundsException (x,y) must be a valid coordinate
	 */
	public Tile getTile(int x, int y) {
		return x>width ||y>height? null : map[x][y];
	}
	
	/** Says if a unit can be deployed or not in the entered tile
	 * @return true if the tile is valid, false otherwise
	 */
	public abstract boolean inhabitableTile(Tile tile);

	/**Function to return a new instance from the same class of the argument
	 * @param d
	 * @return
	 */
	public Tile generate(Tile d) {											//DOC A FAIRE
		String myClassName = d.getClass().getName();
		Class<?> myClass;
		Constructor<?> ctr;
		try {
			myClass = Class.forName(myClassName);
			ctr = myClass.getConstructor(int.class,Board.class);
			Object object;
			object = ctr.newInstance(new Object[] { 11,this });
			Tile d2 = (Tile) object;
			return d2;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}