package game.agri.actions;

import game.Action;
import game.Game;
import game.Tile;
import game.agri.Player;
import game.agri.Worker;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.war.Army;
import game.war.resources.Gold;
import javafx.application.Platform;

public abstract class PayWorker extends Action {
	
	/**
	 * Create the action that will pay the workers of a player
	 * @param player the player
	 * @param game the game
	 */
	public PayWorker(Player player, Game game) {
		super(player, game);
	}

	
	/**
	 * Pay the character otherwise a message and indicate the needs
	 */
	@Override
	public void doAction() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		int rem= player.payCharacters();
		if (rem==0) {
			endOfAction() ;
			return;
		}
		System.out.println("You don't have enough money and your workers are preparing a stoppage :o ! ( " + rem + " ) gold units are needed to pay your workers !");
		destroyWorker();
	}

	/**
	 * Gives the Player
	 */
	
	public Player getPlayer() {
		return (Player) super.getPlayer();
	}
	public abstract void destroyWorker() throws CanNotPlayMoreRoundsException, CanNotDoActionException ;
	
	/** Destroy the worker on the tile
	 * @throws CanNotDoActionException
	 * @throws CanNotPlayMoreRoundsException
	 */
	public void destroyWorker(Worker worker) throws CanNotPlayMoreRoundsException, CanNotDoActionException {
		Tile newEmptyTile = worker.getPos();
		System.out.println("Firing worker working in " + newEmptyTile.getCoordinatesToString());
		game.getBoard().getEmptyTiles().add(newEmptyTile);
		newEmptyTile.setOccupant(null);
		player.removeCharacter(worker);
		Platform.runLater(new Runnable() {
			public void run() {
				game.updateGUI();
			}
		});
		doAction();
	}
}
