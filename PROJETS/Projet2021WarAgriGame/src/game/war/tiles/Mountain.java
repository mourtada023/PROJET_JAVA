package game.war.tiles;
import game.war.Army;
import game.war.resources.*;
import javafx.scene.paint.Color;
import game.*;
import game.Character;
public class Mountain extends WarTile{
	/** Create a tile of type Mountain
	 * @param pos the position of the tile on the board
	 * @param board the board
	 */
	public Mountain(int pos,Board board) {
		super(pos,board,Color.BEIGE,2,0,4,3);
		res = new Rock(0);
	}
	@Override
	public Rock getRessource() {
		return  (Rock) super.getRessource();
	}
	public boolean canHost(Army army) {
		return super.canHost(army) && army.getSize() <= 3;
	}
}
