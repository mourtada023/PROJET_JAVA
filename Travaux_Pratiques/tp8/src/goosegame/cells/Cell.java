package goosegame.cells;
import goosegame.*;
import goosegame.boards.Board;
public class Cell
{

	// attributs
	protected int index;
	protected Player player;

    // constructor
    /**
     * Constructor for a noraml cell
     * @param index the initial index
     * @param player the initial player
     */
	public Cell(int index, Player player) {
		this.index = index;
		this.player = player;
	}

	 /**
     * Constructor for a teleport cell
     * @param index the initial index
     */
	public Cell(int index) {
		this.index = index;
		this.player = null;
	}

	/**
     * returns  <code>true</code>  if the player in the player can leave the cell,
     *  else he must wait for another player to reach this cell
	 *  or wait a given number of turns
	 * @return <code>true</code>  if the player in this cell can leave the cell
	 */
	public boolean canBeLeft(){
		return true;
	}

	/**
     * returns the index of this cell
	 * @return the index of the cell
	 */
	public int getIndex() {
		return this.index;
	}

	/**
     * returns <code>true</code> if a player is in this cell
     * @return <code>true</code> if a player is in this cell
     */
	public boolean isBusy() {
		return this.player != null;
	}

	 /**
     * returns the index of the cell really reached by a player when the player reaches this cell.
     * @param result the result of the dice when the player reaches this cell after throwing the two dices
     * @return the index of the actual cell .
     */
	public int bounce(int result)
	{

		return this.getIndex();
	}



    /**
     * Get the player of this cell
     * @return returns the player of this cell
     */
	public Player getPlayer() {
		return this.player;
	}

	/** sets the player in this cell
	 * @param player is the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
     * Apply the effect what happens when a player arrives in this cell
     * @param player the new player in the cell
     */
    public void movePlayer(Player player)
    {
		if (this.isBusy())
		{

			System.out.print(this.getPlayer().getName() + " is already here !");
			Player playerLeft = this.getPlayer();
			Cell nextCell = player.getCell();
			playerLeft.setCell(nextCell);

			System.out.println(player.getName()
                                + " takes "+playerLeft.getName()+"'s place and "+playerLeft.getName()
                                + " has been moved to the cell number " + nextCell.getIndex() + ".");
		}
	}

	/**
    * We apply the effect when it is a teleport.
    */
    public void applyEffect(){
		System.out.println(this.getPlayer().getName() +" is in a normal cell!");
	}

}
