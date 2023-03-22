package game.agri.tiles;

import game.agri.resources.Corn;
import javafx.scene.paint.Color;
import game.*;

public class Plain extends AgriTile{
	/** Create a tile of type plain
	 * @param pos the position of the tile on the board
	 * @param board the board
	 */
	public Plain(int pos,Board board) {
		super(pos,board,Color.rgb(pos, pos, pos),1,1);
		res = new Corn(0);
	}
	
	/**
	 * Gives the resource
	 */

	@Override
	public Corn getRessource() {
		return (Corn) super.getRessource();
	}
	
}
