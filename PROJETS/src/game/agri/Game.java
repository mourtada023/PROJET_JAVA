package game.agri;

import java.util.ArrayList;
import game.Board;

public class Game extends game.Game {

	
	/**
	 * Create a game/party for the agri game
	 * @param board the board to use
	 */
	public Game(Board board) {
		super(board, 6);
	}
	
	/**
	 * Gives the list of all players participating in the game
	 * @return The list of the players
	 */
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		for (game.Player p : this.players)
			players.add((Player) p);
		return players;
	}
	
	/**
	 * Tells if the game has ended or not
	 * @return True iff there is o more round to play or no tiles available
	 */
	public boolean endGame() {
		return board.getEmptyTiles().isEmpty() || round > rounds;
	}

}
