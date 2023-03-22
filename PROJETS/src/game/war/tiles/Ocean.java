package game.war.tiles;
import game.Board;
import game.Character;
import game.Resource;
import javafx.scene.paint.Color;

public class Ocean extends WarTile{
	/** Create a tile of type ocean
	 * @param pos the position of the tile on the board
	 * @param board the board
	 */
	public Ocean(int pos,Board board) {
		super(pos,board, Color.BLUE,0,0,0);
	}
	@Override
	public Resource getRessource() {
		return  null;
	}
	@Override
	public boolean canHost(Character character) {
		return false;
	}
}