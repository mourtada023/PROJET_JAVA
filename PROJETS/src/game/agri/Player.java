package game.agri;

import java.util.ArrayList;

import game.*;
import game.Character;
import game.agri.resources.*;

public class Player extends game.Player {
	public Player(String name,Mode mode) {
		super(name,mode);
		addRessource(new Gold(15));
		paymentResource = Gold.class;
	}
	
	/**
	 * Gives the list Workers
	 * @return the list of workers
	 */

	@Override
	public ArrayList<Worker> getCharacters() {
		ArrayList<Worker> workers = new ArrayList<>();
		for (Character c : characters) {
			workers.add((Worker) c);
		}
		return workers;
	}
	@Override
	public int payCharacters() {
		int res = super.payCharacters();
		if (res==0) 
			for(Worker worker : getCharacters())
				worker.modifyGold(worker.getPayment());
		return res;
	}
	/**
	 * Gives the score obtained by a chacacter 
	 * @return point the points obtained by the character
	 */
	public int getScore() {
		int points=0;
		for (Worker w : getCharacters()) 
			points += w.getGold();
		return points;
	}

}





