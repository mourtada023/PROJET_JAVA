package game;

import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import javafx.application.Platform;

public abstract class Action {
	
	/**
	 * Player doing the action
	 */
	protected Player player;
	
	/**
	 * true if endOfAction was called once
	 */
	protected boolean ended = false;
	
	/**
	 * Game in which the action is done
	 */
	protected Game game;
	
	/**
	 * Board in which the action is done
	 */
	protected Board board;
	
	/**
	 * holds reference to the nextAction that will be applied after this action ends
	 */
	protected Action nextAction;
	
	/**
	 * to precise if this action should start automatically without external invocation
	 */
	protected boolean autoStart = true;
	
	/** Create an action with given Player and Game
	 * @param player the player who does the action
	 * @param game the game in which the action is done
	 */
	public Action(Player player, Game game) {
		this.player = player;
		this.game = game;
		this.board = game.getBoard();
	}

	/** Do the action designed to the class (ex: deploy a unit)
	 * @throws CanNotDoActionException
	 * @throws CanNotPlayMoreRoundsException
	 */
	public abstract void doAction() throws CanNotDoActionException,CanNotPlayMoreRoundsException;

	/**returns the nextActiont that will be applied when the current action ends
	 * @return
	 */
	public Action getNextAction() {
		return nextAction;
	}

	/**Sets the nextAction that will be applied when the current action ends
	 * @param nextAction
	 */
	public void setNextAction(Action nextAction) {
		this.nextAction = nextAction;
	}

	/**	Initializes the action and starts it if it autoStart equals true
	 * @throws CanNotDoActionException
	 * @throws CanNotPlayMoreRoundsException
	 */
	public void apply() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		init();
		if (autoStart)
			doAction();
	}
	
	/** Return the player who does the action
	 * @return the player who does the action
	 */
	public Player getPlayer() {
		return player;
	}
	
	/** handles the end of the action, applies the nextAction and in case there is no nextAction,
	 *  it passes the turn to the next player in game and finally updates All GUI Elements attached to the game
	 * @throws CanNotDoActionException
	 * @throws CanNotPlayMoreRoundsException
	 */
	public void endOfAction() throws CanNotDoActionException, CanNotPlayMoreRoundsException{
		if (ended)
			return;
		ended = true;
		if (nextAction !=null)
				nextAction.apply();
		else
			game.nextPlayer(player);
		game.updateGUI();
	}
	
	/**
	 * calls endOfAction() from UI Thread
	 * should be called from other threads than javafx ui thread
	 */
	public void endOfActionOnUIThread() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					endOfAction();
				} catch (CanNotDoActionException | CanNotPlayMoreRoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Update UI here
			}});
	}
	/**
	 * initialize the action to be ready before calling doAction
	 */
	public  void init() {}

	/**
	 * calls doAction() from UI Thread
	 * should be called from other threads than javafx ui thread
	 */
	public void doActionOnUIThread() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					doAction();
				} catch (CanNotDoActionException | CanNotPlayMoreRoundsException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
