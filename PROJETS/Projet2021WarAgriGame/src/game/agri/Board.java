package game.agri;

import game.Tile;
import game.agri.tiles.*;

public class Board extends game.Board {

	public Board(int length, int height) {
		super(length, height);
		diffTypeOfTiles.add(new Desert(0,this));
		diffTypeOfTiles.add(new Ocean(0,this));
		diffTypeOfTiles.add(new Forest(0,this));
		diffTypeOfTiles.add(new Plain(0,this));
		diffTypeOfTiles.add(new Mountain(0,this));
		makeBoard();
	}

	/**
	 * Create the board
	 */

	public void makeBoard() {
		int i = 0, ran = 0, posx = 0, posy = 0;
		int size = height * width;
		while (i < size / 3 - 1) { // on remplit moins de 1 tier des cases avec des tuiles terrestres adjacentes
			ran = this.random.nextInt(1); // sélection pour savoir si les 2 tuiles sont horizontales ou verticales
			if (ran == 0) { // cas où les 2 tuiles sont adjacentes horizontalement
				posx = random.nextInt(width - 1);
				posy = random.nextInt(height);
				this.map[posx + 1][posy] = generateTileExcept(posy * width + posx + 1, "Ocean");
			} else { // cas où les 2 tuiles sont adjacentes verticalement
				posy = random.nextInt(height - 1);
				posx = random.nextInt(width);
				this.map[posx][posy + 1] = generateTileExcept(posy * width + posx + width, "Ocean");
			}
			this.map[posx][posy] = generateTileExcept(posy * width + posx, "Ocean");
			i = i + 2;
		}
		for (i = 0; i < width; i++) { // on remplit les autres cases avec des océans
			for (int j = 0; j < height; j++) {
				if (this.map[i][j] == null)
					this.map[i][j] = generateTile(i * width * j, "Ocean");
			}
		}
		super.makeBoard();
	}
	
	/** Get the tile locate at (x,y)
	 * @param x the x axis coordinate
	 * @param y the y axis coordinate
	 * @return the tile at those coordinates
	 */
	public AgriTile getTile(int x, int y) {
		return (AgriTile) super.getTile(x, y);
	}

	@Override
	public String toString() {
		// TODO
		return null;
	}
	
	/** Verify if the tile is inhabitable or not
	 * @param tile the tile to verify
	 * @return true iff the tile is empty
	 */
	public boolean inhabitableTile(Tile tile) {
		return !(tile instanceof Ocean);
	}
}
