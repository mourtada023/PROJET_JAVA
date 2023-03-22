package game.agri.tiles;

import game.*;
import javafx.scene.paint.Color;

public class Ocean extends AgriTile{
	public Ocean(int pos,Board board) {
		super(pos,board, Color.BLUE,0,0);
	}
	
	/**
	 * Gives the resource
	 */
	@Override
	public Resource getRessource() {
		return null;
	}
}