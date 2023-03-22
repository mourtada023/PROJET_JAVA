package game.war.tiles;

import game.Board;
import game.Tile;
import game.war.Army;
import game.war.Player;
import javafx.scene.paint.Color;

public abstract class WarTile extends Tile{
	protected int extraSize;
	protected int extraFood;
	protected int maxSize;
	protected int points;
	
	/** Create a tile for the game war
	 * @param pos the position on the board
	 * @param board the board
	 * @param color the color
	 * @param extraSize the extra size for the army
	 * @param extraFood the extra food needed for the army
	 * @param points the points/score
	 * @param maxSize the max size of the army
	 */
	public WarTile(int pos,Board board,Color color,int extraSize,int extraFood,int points,int maxSize) {
		this(pos,board,color,extraSize,extraFood,points);
		this.maxSize = maxSize;
	}
	/** Create a tile for the game war
	 * @param pos the position on the board
	 * @param board the board
	 * @param color the color
	 * @param extraSize the extra size for the army
	 * @param extraFood the extra food needed for the army
	 * @param points the points/score
	 */
	public WarTile(int pos,Board board,Color color,int extraSize,int extraFood,int points) {
		super(pos,board,color);
		this.extraSize = extraSize;
		this.extraFood = extraFood;
		this.points = points;
		this.maxSize = 5;
	}
	/** Gives the occupant of this tile
	 * @return the army or null
	 */
	public Army getOccupant() {
		return (Army)super.getOccupant();
	}
	/** Gives the extra size added to the army
	 * @return the new size
	 */
	public int getExtraSize() {
		return extraSize + getOccupant().getSize();
	}
	/** Gives the extra food needed
	 * @return the overall food needed for this army
	 */
	public int getExtraFood() {
		return extraFood + getOccupant().getSize();
	}
	/** Gives the max size for the army
	 * @return the max size
	 */
	public int getMaxSize() {
		return maxSize;
	}
	/** Gives the points
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	public String toString() {
		if(getOccupant() == null)
    		return this.getClass().getSimpleName().charAt(0) + "[.,.]";
    	return this.getClass().getSimpleName().charAt(0) +
    			"[" + getOccupant().getOwner().getId() + "," + 
    			getOccupant().getSize() + "]" ;
	}
	@Override
	public String strGUIRepresentation() {
		if(getOccupant() == null)
			return "Empty";
		return  getOccupant().getOwner().getName() + "\nArmy Size : " + getOccupant().getSize() ;
	}
} 