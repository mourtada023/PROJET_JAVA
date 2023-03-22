package goosegame.cells;
import goosegame.*;
import goosegame.boards.Board;

public class GooseCell extends Cell
{

	/**
     * Constructor for a goose  cell
     * @param index the initial index
     * @param player the initial player
     */
	public GooseCell(int index, Player player)
	{
		super(index, player);
	}

	/**
     * Another constructor for a goose cell
     * @param index the initial index
     */
	public GooseCell(int index)
	{
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
		System.out.print("The cell " + this.getIndex()+ " is a goose cell !");
		int newIndex =  this.getIndex() + result;
		System.out.println("The player will reach the cell number " +newIndex +".");
		return newIndex;
	}

    @Override
    /**
    * we apply the effect when it is a goose cell.
    */
    public void applyEffect(){
		System.out.println("The player is in a goose cell! ");
	}


}
