package game.war.actions;

import game.Tile;
import game.war.exceptions.*;
import game.Action;
import game.exceptions.*;
import game.war.Army;
import game.war.Player;
import game.war.tiles.WarTile;

public abstract class DeployArmy extends Action {
	WarTile tile;
	int armySize;

	/** Create the action that will deploy the army
	 * @param tile the position of the army
	 * @param player the player owning the army
	 * @param game the type of the game
	 * @param armySize the size of the army
	 */
	public DeployArmy(WarTile tile, game.Player player, game.Game game, int armySize) {
		super(player, game);
		this.tile = tile;
		this.armySize = armySize;
	}
	/** Create the way to deploy the army
	 * @param player the player owning the army
	 * @param game the type of the game
	 * @param armySize the size of the army
	 */
	public DeployArmy(game.Player player, game.Game game, int armySize) {
		super(player, game);
		this.armySize = armySize;
	}
	private void occupantEnemyIsSmaller(Army army, Army occupant) {
		if (army.getFicSize() > occupant.getFicSize()) {
			if (occupant.getSize() == 1) {
				occupant.getOwner().removeCharacter(occupant);

				army.modifyGold(2);
				System.out.println(occupant.getOwner().getName() + " s' Army in " + occupant.getPos().getCoordinatesToString() + " became yours " );
				occupant.setOwner(player);
			} else {
				occupant.setSize(occupant.getSize() / 2);
				System.out.println("You attacked " + occupant.getOwner().getName() + " s' army in " + occupant.getPos().getCoordinatesToString());
			}
		}
	}

	private void occupantAllyIsSmaller(Army army, Army occupant) {
		if (occupant.getSize() >= army.getSize())
			return;
		occupant.setSize(occupant.getSize() + 1);
		army.modifyGold(1);
		System.out.println("Your Army in " + occupant.getPos().getCoordinatesToString() + " has been buffed ( Size increased by 1 soldier )" );
		return;
	}

	@Override
	public void doAction() throws CanNotDoActionException,CanNotPlayMoreRoundsException {
		if (tile.getOccupant() != null)
			throw new TileAlreadyOccupiedException("");
		if (getPlayer().getMaxSoldiers() < armySize)
			throw new SoldiersWillExceedMaxException("Army Size will exceed Soldiers limit for this player");
		Army army = new Army(getPlayer(), armySize);
		if (!tile.canHost(army))
			throw new CanNotDeployCharacterException("Can't HOST");
		tile.setOccupant(army);
		Tile adjacentTiles[] = board.getAdjacentTiles(tile);
		for (Tile adjTile : adjacentTiles) {
			if (adjTile == null)
				continue;
			Army occupant = (Army) adjTile.getOccupant();
			if (occupant == null)
				continue;
			Player occupantOwner = (Player) occupant.getOwner();
			if (occupant.getFicSize() >= army.getFicSize())
				continue;
			if (!player.equals(occupantOwner))
				occupantEnemyIsSmaller(army, occupant);
			else
				occupantAllyIsSmaller(army, occupant);
		}
		tile.getTileRep().blink(4);
		board.getEmptyTiles().remove(tile);
		endOfAction();
	}

	/** Gives the player
	 * @return the player
	 */
	public Player getPlayer() {
		return (Player) super.getPlayer();
	}
	public String toString() {
		return "Deployed a (" + armySize + ") soldiers army in " + tile.getCoordinatesToString() ;
	}
	/** Gives the size of the army
	 * @return the size of the army
	 */
	public int getArmySize() {
		return armySize;
	}
	/** Gives the tile
	 * @return the tile
	 */
	public WarTile getTile() {
		return tile;
	}
	/** Sets the new position
	 * @param tile the new position
	 */
	public void setTile(WarTile tile) {
		this.tile = tile;
	}
	/** Sets the new size of the army
	 * @param armySize the new size of the army
	 */
	public void setArmySize(int armySize) {
		this.armySize = armySize;
	}
}
/*

*/