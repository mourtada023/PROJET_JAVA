package game.war.tiles;
import game.war.resources.Sand;
import game.Character;

import javafx.scene.paint.Color;

import game.*;
import game.war.Army;
public class Desert extends WarTile{
	/** Create a tile of type desert
	 * @param pos the position of the tile on the board
	 * @param board the board
	 */
	public Desert(int pos,Board board) {
		super(pos,board,Color.YELLOW,0,2,4,3);
		res = new Sand(0);
	}
	@Override
	public Sand getRessource() {
		return  (Sand) super.getRessource();
	}
	@Override
	public int getExtraFood() {
		return getOccupant().getSize() * extraFood;
	}
	/** Says if this tile can host an army or not
	 * @param army the army we want to host
	 * @return true iff the tile can host the army
	 */
	public boolean canHost(Army army) {
		return super.canHost(army) && army.getSize() <= 3;
	}
}
