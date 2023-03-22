package game;

import game.exceptions.*;
import game.gui.GUIElement;

import java.util.ArrayList;

public abstract class Game {
	
	/**
	 * The board used by this game
	 */
	protected Board board;
	
	/**
	 * The list of the players present in this game
	 */
	protected ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * The number of round of this game
	 */
	protected final int rounds;
	
	/**
	 * The current round
	 */
	protected int round = 0;
	
	/**
	 * List of all gui elements related to the game
	 */
	protected ArrayList<GUIElement> guiElements = new ArrayList<>();		
	
	/**
	 * at the end of the game, this runnable will be executed
	 */
	protected Runnable onEndGame;									 
	
	/** Create a game with given board and number of rounds
	 * @param board the board used by the game
	 * @param rounds the number of rounds of the game
	 */
	public Game(Board board, int rounds) {
		this.board = board;
		this.rounds = rounds;
	}
	
	/** Return the board of this game
	 * @return the board of this game
	 */
	public Board getBoard() {
		return board;
	}

	/** Adds a player in the game
	 * @param player the player to be added
	 */
	public void addPlayer(Player player) {
		players.add(player);
		player.game = this;
	}
	
	/**  Plays a round
	 * @throws CanNotPlayMoreRoundsException if the number of rounds is exceeded
	 * @throws CanNotDoActionException if the action does not work
	 */
	public void playRound() throws CanNotPlayMoreRoundsException, CanNotDoActionException {
		round++;
		if(!hasNext())
			if (onEndGame!=null) {
				onEndGame.run();
				return;
			}
			else
				throw new CanNotPlayMoreRoundsException("End game reached with (" + round +") with no runnable to handle this event");
		
		System.out.println("\t\t     *** ROUND (" + (round) + ") STARTED ***" + "");
		
		nextPlayer(-1);

		
	}
	
	/** updates the ranking of all players and calls out for the player just after the index of the current player
	 * in case there are no more players in list, it starts a new round
	 * @param index
	 * @throws CanNotPlayMoreRoundsException
	 * @throws CanNotDoActionException
	 */
	public void nextPlayer(int index) throws CanNotPlayMoreRoundsException, CanNotDoActionException {		//DOC A FAIRE
		setRanking();
		if (!hasNext())
			if (onEndGame!=null) {
				onEndGame.run();
				return;
			}
			else if(index != -1)
				throw new CanNotDoActionException("End game reached in mid of round (" + round +") with no runnable to handle this event");
		if (index+1 == players.size()) {
			System.out.println("END OF ROUND");
			playRound();
			return;
		}
		Player nextPlayer = players.get(index+1);
		System.out.println((index >= 0 ? ((Player)getPlayers().get(index)).getName() : "beginning of game ") + " called out for " + nextPlayer.getName());
		
		System.out.println("\n< It is " + nextPlayer.getName() + " s' turn ! >\n");
		nextPlayer.play();
	}
	
	/** 
	 * same as nextPlayer(int index) but takes a player instead of an index
	 * @param player
	 * @throws CanNotPlayMoreRoundsException
	 * @throws CanNotDoActionException
	 */
	public void nextPlayer(Player player) throws CanNotPlayMoreRoundsException, CanNotDoActionException {	
		nextPlayer(players.indexOf(player));
	}
	
	/** Says if another round is possible or not
	 * @return true if there is a next round, false otherwise
	 */
	public boolean hasNext() {
		return !endGame();
	}

	/** Says if a game is end or not
	 * @return true if the game is end, false otherwise
	 */
	public abstract boolean endGame();

	/** Update the leaderboard
	 */
	public void setRanking() {
		for (Player player : (ArrayList<Player>) getPlayers()) {
			player.setRanking(players.size());
			for (Player playerToCompare : (ArrayList<Player>) getPlayers())
				if (player.getScore() >= playerToCompare.getScore() && !player.equals(playerToCompare))
					player.setRanking(player.getRanking() - 1);
		}
	}

	/** sets the runnable that will be exec uted at the end of the game
	 * @param onEndGame
	 */
	public void setOnEndGame(Runnable onEndGame) {															//DOC A FAIRE
		this.onEndGame = onEndGame;
	}

	/** Return the winner of the game
	 * @return the winner of the game
	 */
	public String getWinner() {
		ArrayList<Player> players = new ArrayList<>();
		String str = "";
		for (Player p : this.players) {
			if (p.getRanking() == 1) {
				players.add(p);
				str += ((players.size() > 1 ? " AND " : "") + p.getName());
			}
		}
		str += players.size() == 1 ? " HAS WON!" : " HAVE WON!";
		return str;
	}
	
	/** Return the list of the players
	 * @return the list of the players
	 */
	public ArrayList<?> getPlayers() {
		return players;
	}
	
	/** 
	 * returns a list of all related gui elements
	 * @return
	 */
	public ArrayList<GUIElement> getGuiElements() {													
		return guiElements;
	}

	/**
	 * updates all related gui elements
	 */
	public void updateGUI() {																				
		for(GUIElement guiElement: guiElements)
			guiElement.update();
	}
	
}
