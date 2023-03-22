package game.agri.tiles;

import game.Board;
import game.Tile;
import game.agri.Worker;
import game.agri.Player;
import javafx.scene.paint.Color;

public abstract class AgriTile extends Tile{
	private int bonus =0;
	protected int cost;
	
	/** Create a tile for the game agri
	 * @param pos the position on the board
	 * @param board the board
	 * @param color the color
	 * @param cost worker payment
	 * @bonus bonus according to the territory
	 */
	public AgriTile(int pos,Board board,Color color,int cost,int bonus) {
		super(pos,board,color);
		this.bonus = bonus;
		this.cost = cost;
	}

	/**
	 * Gives the character caster as a worker
	 * some tiles affects the size of army and make it stronger in front of enemies
	 * ex: Mountain adds power of 2 soldiers to occupant army
	 * @return the worker
	 */
	public Worker getOccupant() {
		return (Worker)super.getOccupant();
	}
	
	/**
	 * Gives the cost of payment of the worker on the tile
	 * @return payment worker
	 */
	
	public int getCost() {
		return cost;
	}
	public String toString() {
		if(getOccupant() == null)
    		return this.getClass().getSimpleName().charAt(0) + "[.]";
    	return this.getClass().getSimpleName().charAt(0) +
    			"[" + getOccupant().getOwner().getId() + "]" ;
	}
	
	/**
	 * Gives the according bonus to the player
	 * @return bonus according to the territory
	 */
	public int getBonus() {
		return bonus;
	}
	
	
	@Override
	public String strGUIRepresentation() {
		if(getOccupant() == null)
			return "Empty";
		return  getOccupant().getOwner().getName();
	}
	
} 