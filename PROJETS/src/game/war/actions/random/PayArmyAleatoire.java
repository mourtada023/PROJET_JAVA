package game.war.actions.random;

import game.Resource;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;

import java.util.Map;
import java.util.Random;

import game.Game;
import game.war.Player;
import game.war.actions.PayArmy;
import game.war.resources.Food;
import game.war.resources.Gold;
import game.war.Army;
import game.Character;

public class PayArmyAleatoire extends PayArmy {

	public PayArmyAleatoire(Player player, Game game) {
		super(player, game);
	}

	public void convertToGetResource() {
		int remainning = player.payCharacters();
		int converted = 0;
		for (Map.Entry<Class, Resource> entry : player.getResources().entrySet()) {
			if (converted >= remainning) 
				break;
			if (!(entry.getValue() instanceof Food)) {
				int temp = entry.getValue().convertRessource(Resource.MAX, player.getResources().get(Food.class));
				converted += temp > 0 ? temp : 0;
				if (temp >0 )
				System.out.println(entry.getValue().getClass().getSimpleName() + " -> Converted (" + temp + ")" + " , Remainning (" + ((remainning - converted) > 0 ? (remainning - converted) : 0 ) + ")");}
		}
		try {
			cnvRes = false;
			doAction();
		} catch (CanNotDoActionException | CanNotPlayMoreRoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroyArmy() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		Random rand = new Random();
		destroyThisArmy(player.getTiles()[rand.nextInt(player.getTiles().length)]);
	}

}
