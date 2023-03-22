package game.agri.actions.random;

import java.util.Random;
import game.Game;
import game.agri.Player;
import game.agri.resources.Gold;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.agri.Worker;
import game.agri.actions.PayWorker;

public class PayWorkerRandom extends PayWorker {

	public PayWorkerRandom(Player player, Game game) {
		super(player, game);
	}

	public void destroyWorker() throws CanNotPlayMoreRoundsException, CanNotDoActionException {
		Random rand = new Random();
		Worker characterToRemove = getPlayer().getCharacters().get(rand.nextInt(getPlayer().getCharacters().size()));
		destroyWorker(characterToRemove);
		endOfAction();
	}
}
