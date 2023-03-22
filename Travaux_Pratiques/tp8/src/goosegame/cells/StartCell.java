package goosegame.cells;
import goosegame.*;
import goosegame.boards.Board;
import java.util.*;

public class StartCell extends Cell
{


	protected List<Player> thePlayers;

	/**
     * Constructor for a depart cell
     * @param index
     * @param player
     */
	public StartCell(int index, Player player)
	{
		super(index, player);
		this.thePlayers.add(player) ;
	}

	/**
     * Another Constructor for a regular cell
     * @param index
     */
	public StartCell(int index) {
		super(index);
		this.thePlayers = new ArrayList<>();
	}


	@Override
	 /**
     * returns the index of the cell really reached by a player when the player reaches this cell.
     * @param result the result of the dice when the player reaches this cell after throwing the two dices
     * @return Returns 0 which is the index of the depart cell  .
     */
    public int bounce(int result){
		return 0 ;
	}

     /**
     * Get the players of this cell
     * @return returns the players of this cell
     */
	public List<Player> getPlayers() {
		return this.thePlayers;
    }

	@Override
     /**
     * Get the player of this cell
     * @return returns the player of this cell or null if none
     */
	public Player getPlayer() {
        if(this.getPlayers().size() == 0)
            return null;
		return this.getPlayers().get(0);
	}

	@Override
	/**
     * sets the player in this cell
	 * @param player is the player to set
	 */
	public void setPlayer(Player player) {
        if(!this.getPlayers().contains(player))
        {
			this.getPlayers().add(player);
			player.setCell(this);
		}
	}


	public Player getPlayerIndexed(int i){
		return this.thePlayers.get(i);
	}

	@Override
    /**
    * we apply the effect when it is a teleport.
    */
    public void applyEffect(){
		System.out.println("The player is in a depart cell!");
	}

}
