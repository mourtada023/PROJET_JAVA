package goosegame.cells;
import goosegame.*;
import goosegame.boards.Board;

public class WaitCell extends Cell
{

	protected int waitingNumber; // the number of turns to wait

    /**
     * Constructor for a waiting cell
     * @param index the initial index
     * @param player the initial player
     */
    public WaitCell(int index, Player player)
    {
		super(index, player);
		this.waitingNumber = 2;
	}


    /**
     * Another constructor for a waiting cell
     * @param index the initial index
     * @param nbTunrs the number of turns
     */
    public WaitCell(int index, int nbTurns)
    {
		super(index);
		this.waitingNumber = nbTurns;
	}

	/** get the number of turns to wait
	 * @return returns the number
	 */
	public int getWaitingNumber(){
		return this.waitingNumber;
	}

	/** set the number of turns to wait
	 * @param number is the number to set
	 */
	public void setWaitingNumber(int number){
		this.waitingNumber = number;
	}

    @Override
    /**
     * returns  <code>true</code>  if the player in this cell can leave the cell,
     *  else he must wait for another player to reach this cell
	 *  or wait a given number of turns
	 * @return <code>true</code>  when the number of turns to wait is zero
	 */
    public boolean canBeLeft()
    {
        if(this.getWaitingNumber() == 0)
            return true;
        return false;
	}

    @Override
    /**
     * returns the index of the cell really reached by a player when the player reaches this cell.
     * @param result the result of the dice when the player reaches this cell after throwing the two dices
     * @return the index of the actual cell .
     */
    public int bounce(int result)
    {
		System.out.println("The Player reaches a waiting cell !");
		return this.getIndex();
	}


    @Override
	/**
     * apply the effect what happens when a player arrives in this cell
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
			                    + " takes his place and the player "+playerLeft.getName()
			                    + " has been moved to the cell number " + nextCell.getIndex() + ".");
		}
	}

    @Override
      /**
     * we apply the effect when it is a waiting.
     * Here we decrease the number of turns to wait for the player
     */
	public void applyEffect()
	{
		System.out.println(this.getPlayer().getName() +" has to wait "
				+ this.getWaitingNumber() + " turns before playing !");
		int update = this.getWaitingNumber() - 1;
		this.setWaitingNumber(update);
	}
}
