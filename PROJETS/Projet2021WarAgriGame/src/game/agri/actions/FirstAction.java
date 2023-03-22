package game.agri.actions;

import game.Action;
import game.Tile;
import game.exceptions.*;
import game.war.tiles.WarTile;
import game.agri.Player;
import game.agri.Worker;
import game.agri.tiles.AgriTile;

public abstract class FirstAction extends Action {
	protected AgriTile tile;
	protected boolean deploy=true;
	
	/** Create the action that will deploy the worker
	 * @param tile the position of the worker
	 * @param player the player owning the worker
	 * @param game the type of the game
	 */
	public FirstAction(AgriTile tile, game.Player player, game.Game game) {
		super(player, game);
		this.tile = tile;
	}
	
	/**
	 * Gives the tile 
	 * @return the tile
	 */
	public AgriTile getTile() {
		return tile;
	}
	
	/** Sets the new tile
	 * @param tile the new tile
	 */
	public void setTile(AgriTile tile) {
		this.tile = tile;
	}
	
	
	/**
	 * Do the action of harvesting the resources
	 */
	@Override
	public void doAction() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		if (deploy)
			deployWorker();
		else
			convertResource();
	}
	
	/** Create the action that will deploy the Worker
	 * @param tile the position of the Worker
	 */

	public void deployWorker(Tile tile) throws CanNotDoActionException {
		System.out.println("Deploying a worker in pos" + tile.getCoordinatesToString());
		if (tile.getOccupant() != null)
			throw new TileAlreadyOccupiedException("");
		tile.setOccupant(new Worker(getPlayer()));
		board.getEmptyTiles().remove(tile);
	}
	
	public abstract void deployWorker() throws CanNotDoActionException, CanNotPlayMoreRoundsException ;
	public abstract void convertResource()throws CanNotDoActionException, CanNotPlayMoreRoundsException ; 
	
	/** Gives the player
	 * @return the player
	 */
	public Player getPlayer() {
		return (Player) super.getPlayer();
	}
	
	public String toString() {
		return "Deployed a worker in " + tile.getCoordinatesToString();
	}
}
/*

*/