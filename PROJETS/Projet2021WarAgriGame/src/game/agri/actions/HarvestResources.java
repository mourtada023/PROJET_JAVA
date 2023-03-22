package game.agri.actions;
import game.*;
import game.agri.Worker;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.agri.Player;


public class HarvestResources extends Action {
	public HarvestResources(Player player,Game game) {
		super(player,game);
	}
	
	/**
	 * Do the action of harvesting the resources
	 */
	public void doAction() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		for(Worker worker : getPlayer().getCharacters()) {
			Tile pos = worker.getPos();
			Resource tileRessource = pos.getRessource();
			tileRessource.modifyQuantity(1);
			player.addRessource(tileRessource);
		}
		endOfAction();
	}
	public void init() {
		
	}
	
	/**
	 * Gives the Player
	 */
	
	public Player getPlayer() {
		return (Player) super.getPlayer();
	}
	
}
