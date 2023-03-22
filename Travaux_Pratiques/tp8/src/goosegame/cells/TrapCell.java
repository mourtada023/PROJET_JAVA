package goosegame.cells;
import goosegame.*;
import goosegame.boards.Board;

public class TrapCell extends Cell
{
   /**
     * Constructor for a trap cell
     * @param index the initial index
     * @param player the initial player
     */
	public TrapCell(int index, Player player) {
		super(index, player);
	}

	/**
     * Another constructor for a trap cell
     * @param index the initial index
     */
    public TrapCell(int index)
    {
		super(index);
	}


    @Override
    /**
     * returns  <code>true</code>  if the player in this cell can leave the cell,
     *  else he must wait for another player to reach this cell
	 *  or wait a given number of turns
	 * @return <code>false</code>  when the player is locked down
	 */
	public boolean canBeLeft(){
		return false;
	}

    @Override
    /**
     * returns the index of the cell really reached by a player when the player reaches this cell.
     * @param result the result of the dices when the player reaches this cell after throwing the two dices
     * @return the index of the actual cell .
     */
    public int bounce(int result)
    {
		System.out.println("The player reaches a trap cell !");
		return this.getIndex();
	}

    @Override
    /**
     * We display a message when it is a trap cell.
     */
  	public void applyEffect(){
		System.out.println(this.getPlayer().getName() +" is in a trap cell! "
				+ "He has to wait until someone comes in !");
	}


}
