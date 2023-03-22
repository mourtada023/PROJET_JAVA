package goosegame.cells;
import goosegame.*;
import goosegame.boards.Board;

public class TeleportCell extends Cell
{

	/**
     * Constructor for a teleport cell
     * @param index the initial index
     * @param player the initial player
     */
	public TeleportCell(int index, Player player) {
		super(index, player);
	}

	 /**
     * Another constructor for a teleport cell
     * @param index the initial index
     */
	public TeleportCell(int index) {
		super(index);
	}

    @Override
    /**
     * returns the index of the cell really reached by a player when the player reaches this cell.
     * @param result the result of the dice when the player reaches this cell after throwing the two dices
     * @return the index of the actual cell .
     */
    public int bounce(int result)
    {
		int reachedIndex = 0;
        if(this.getIndex() == 6)
        {
            reachedIndex = 12;
        }
		if(this.getIndex() == 42){
            reachedIndex = 30;
        }
		if(this.getIndex() == 58) {
            reachedIndex = 1;
        }
		System.out.println("The player reaches a Teleport cell !" +
						" He is now in cell " + reachedIndex);
		return reachedIndex;
	}

    @Override
    /**
    * we apply the effect when it is a teleport.
    */
    public void applyEffect(){
		System.out.println(this.getPlayer().getName() +" is in a teleport cell!");
	}

}
