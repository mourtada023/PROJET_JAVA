package game;

import java.util.ArrayList;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;

public abstract class Mode {
	
	/**
	 * count of all modes
	 */
	public static int ids = 0;
	
	/**
	 * id of the current mode
	 */
	public int id = ++ids;
	
	/**
	 * list of all related actions
	 */
	protected ArrayList<Action> actions;
	
	/** 
	 * initializes all actions related to the mode and bind them together
	 * @param player
	 * @param game
	 */
	public abstract void init(Player player,Game game);
	
	/** 
	 * sets the param action as the next action of the (last action in the ArrayList actions)
	 * @param action
	 */
	public void bindToMode(Action action) {
		if (actions.size()!=0)
			actions.get(actions.size() - 1).setNextAction(action);
		actions.add(action);
	}
	
	/** 
	 * @param player
	 * @param game
	 * @throws CanNotDoActionException
	 * @throws CanNotPlayMoreRoundsException
	 */
	public void apply(Player player,Game game) throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		init(player, game);
		actions.get(0).apply();
	}
	
}
