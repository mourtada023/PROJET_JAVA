package game.agri.tiles;

import game.agri.resources.Wood;
import javafx.scene.paint.Color;
import game.*;

public class Forest extends AgriTile{
	/** Create a tile of type Forest
	* @param pos the position of the tile on the board
	* @param board the board
	*/
	public Forest(int pos,Board board) {
		super(pos,board,Color.BROWN,1,1);
		res = new Wood(0);
	}
	
	@Override
	public Wood getRessource() {
		return (Wood) super.getRessource();
	}
	
}
