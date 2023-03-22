package game.war.actions;
import game.*;
import game.Character;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.war.Army;
import game.war.Player;

public class HarvestResources extends Action {
	/** Create the action that will harvest the resources
	 * @param player the player
	 * @param game the game
	 */
	public HarvestResources(Player player,Game game) {
		super(player,game);
	}
	/**
	 * Do the action of harvesting the resources
	 */
	public void doAction() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		for(Army army : getPlayer().getCharacters()) {
			Tile pos = army.getPos();
			Resource tileRessource = pos.getRessource();
			tileRessource.modifyQuantity(1);
			player.addRessource(tileRessource);
		}
		endOfAction();
	}
	public void init() {
		
	}
	
	/** Gives the player
	 * @return the player
	 */
	public Player getPlayer() {
		return (Player) super.getPlayer();
	}
	
}
