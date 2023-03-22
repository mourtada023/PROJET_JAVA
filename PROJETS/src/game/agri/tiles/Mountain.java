package game.agri.tiles;

import game.agri.resources.Rock;
import javafx.scene.paint.Color;
import game.*;

public class Mountain extends AgriTile{
	/** Create a tile of type Mountain
	 * @param pos the position of the tile on the board
	 * @param board the board
	 */
	public Mountain(int pos,Board board) {
		super(pos,board,Color.BEIGE,5,0);
		res = new Rock(0);
	}
	
	/**
	 * Gives the resource
	 */
	@Override
	public Rock getRessource() {
		return (Rock) super.getRessource();
	}
}
