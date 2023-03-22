package game.war.actions;

import game.Action;
import game.Game;
import game.Tile;
import game.war.Army;
import game.war.Player;
import game.war.resources.Gold;
import javafx.application.Platform;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;

public abstract class PayArmy extends Action {
	protected boolean cnvRes = true;
	/** Create the action that will pay the armies of a player
	 * @param player the player
	 * @param game the game
	 */
	public PayArmy(Player player, Game game) {
		super(player, game);
	}

	@Override
	public void doAction() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		int rem= player.payCharacters();
		if (rem==0) {
			endOfAction();
			return;
		}	
		System.out.println("You armies will starve ! ( " + rem + " ) Food units are needed to feed you armies !");
		System.out.println("Remainning : " + rem);
		if (cnvRes) 
			convertToGetResource();
		else
			destroyArmy();
	}
	/** Gives the player
	 * @return the player
	 */
	public Player getPlayer() {
		return (Player) super.getPlayer();
	}

	public abstract void convertToGetResource() throws CanNotDoActionException, CanNotPlayMoreRoundsException;
	public abstract void destroyArmy() throws CanNotDoActionException, CanNotPlayMoreRoundsException;
	
	/** Destroy the army on the tile
	 * @param tile the tile
	 * @throws CanNotDoActionException
	 * @throws CanNotPlayMoreRoundsException
	 */
	public void destroyThisArmy(Tile tile) throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		Army characterToRemove = (Army) tile.getOccupant();
		System.out.println("Destroying Army with a size of " + characterToRemove.getSize() + " soldiers in " + characterToRemove.getPos().getCoordinatesToString());
		Tile newEmptyTile = characterToRemove.getPos();
		game.getBoard().getEmptyTiles().add(newEmptyTile);
		newEmptyTile.setOccupant(null);
		player.removeCharacter(characterToRemove);
		player.addRessource(new Gold(1));
		Platform.runLater(new Runnable() {
			public void run() {
				game.updateGUI();
			}
		});
		doAction();
	}
}
