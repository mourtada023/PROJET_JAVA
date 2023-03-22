package game.war;

import java.util.ArrayList;

import game.*;
import game.Character;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.war.actions.DeployArmy;
import game.war.actions.HarvestResources;
import game.war.actions.manual.DeployArmyManual;
import game.war.actions.random.DeployArmyAleatoire;
import game.war.actions.random.PayArmyAleatoire;
import game.war.resources.*;
import javafx.scene.control.TableColumn;

public class Player extends game.Player {
	int maxSoldiers;

	/** Create a player
	 * @param name the name of this player
	 * @param mode the mode this player will play
	 */
	public Player(String name,Mode mode) {
		super(name,mode);
		maxSoldiers = 35;
		addRessource(new Food(10));
		addRessource(new Gold(0));
		paymentResource = Food.class;
	}

	/** Gives the maximun of soldiers the player can play
	 * @return the maximun of soldiers
	 */
	public int getMaxSoldiers() {
		return maxSoldiers;
	}

	/**
	 * adds new character to the list of character of the player
	 * 
	 * @param army the army to add to his list of army
	 * @return void
	 */
	@Override
	public boolean addCharacter(Character army) {
		if (maxSoldiers < ((Army)army).getSize())
			return false;
		maxSoldiers -= ((Army)army).getSize();
		super.addCharacter(army);
		return true;
	}

	@Override
	public ArrayList<Army> getCharacters() {
		ArrayList<Army> armies = new ArrayList<>();
		for (Character c : characters) {
			armies.add((Army) c);
		}
		return armies;
	}

	/** Gives the actual score of this player
	 * @return the score
	 */
	public int getScore() {
		int points = getResources().get(Gold.class).getQuantity();
		for (Army a : getCharacters()) {
			points += (a.getGold() + a.getPos().getPoints());
		}
		return points += (getCharacters().size() >= 10 ? 5 : 0);
	}
	/** Gives the number of soldiers already deployed
	 * @return the number of soldiers deployed
	 */
	public int getDeployedSoldiers() {
		int sum=0;
		for(Army army : getCharacters())
			sum+=army.getSize();
		return sum;
	}

}
