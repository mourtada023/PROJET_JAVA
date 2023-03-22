package game.agri.tiles;

import game.agri.resources.Sand;
import javafx.scene.paint.Color;
import game.*;

public class Desert extends AgriTile{
	public Desert(int pos,Board board) {
		/** Create a tile of type desert
		 * @param pos the position of the tile on the board
		 * @param board the board
		 */
		super(pos,board,Color.YELLOW,3,2);
		res = new Sand(0);
	}
	
	/**
	 * Gives the resource
	 */
	
	@Override
	public Sand getRessource() {
		return (Sand) super.getRessource();
	}
}
