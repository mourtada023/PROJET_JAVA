package game.war.tiles;
import game.war.resources.Corn;
import game.war.resources.Sand;
import javafx.scene.paint.Color;
import game.*;
public class Plain extends WarTile{
	/** Create a tile of type plain
	 * @param pos the position of the tile on the board
	 * @param board the board
	 */
	public Plain(int pos,Board board) {
		super(pos,board,Color.rgb(pos, pos, pos),0,0,1);
		res = new Corn(0);
	}
	@Override
	public Corn getRessource() {
		return  (Corn) super.getRessource();
	}
	
}
