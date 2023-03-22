package game.war;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import game.Board;
import game.Character;
import game.war.Player;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.gui.GUIElement;
import game.war.resources.Gold;

public class Game extends game.Game {


	/** Create a game/party for the war game
	 * @param board the board to use
	 */
	public Game(Board board) {
		super(board, 10);
	}

	/** Gives the list of all the players participating in the game
	 * @return the list of the players
	 */
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		for (game.Player p : this.players)
			players.add((Player) p);
		return players;
	}
	/** Tells if the game as ended or not
	 * @return True iff there is no more rounds to play or no more tiles available
	 */
	public boolean endGame() {
		return board.getEmptyTiles().isEmpty() || round > rounds;
	}

}
