package game.war.tiles;
import game.war.resources.Wood;
import javafx.scene.paint.Color;
import game.*;
 public class Forest extends WarTile{
	/** Create a tile of type Forest
	* @param pos the position of the tile on the board
	* @param board the board
	*/
	public Forest(int pos,Board board) {
		super(pos,board,Color.BROWN,0,0,2);
		res = new Wood(0);
	}
	
	/**
	 * Gives the resource caster in wood
	 */
	@Override
	public 	Wood getRessource() {
		return  (Wood) super.getRessource();
	}
	
}
