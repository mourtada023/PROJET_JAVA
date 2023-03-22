package game.war;
import game.Character;
import game.war.tiles.WarTile;
import game.exceptions.CanNotDoActionException;

/**
 * Represent the characters of army
 */
public class Army extends Character {
	
	/**
	 * The size of the army/number of soldiers
	 */
	private int size;
	
	/**
	 * The number of gold of the army
	 */
	private int gold = 0;
	/** Create the army with given position and size
	 * @param pos the given position
	 * @param size the given size
	 * @throws CanNotDoActionException 
	 */
	public Army(Player player,int size) throws CanNotDoActionException{
		super(player);
		this.size = size;
	}
	
	/** Gives the size of this army
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/** Gives the owner of this army
	 * @return the player
	 */
	public Player getOwner() {
		return (Player)super.getOwner();
	}

	/** Gives the position of this army
	 * @return the position
	 */
	@Override
	public WarTile getPos() {
		return (WarTile) pos;
	}
	
	/** Set/changes the size of this army
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;

		pos.updateGUI();
	}
	/**
	 * 
	 */
	public void produit() {
		pos.getRessource().modifyQuantity(1);
	}
	/** Gives the fictional/additional size of this army
	 * @return the fictional/additional size
	 */
	public int getFicSize() {
		return ((WarTile)pos).getExtraSize();
	}
	/** Gives the due payment for this army
	 * @return the due payment
	 */
	public int getPayment() {
		return ((WarTile)pos).getExtraFood();
	}
	/** Modify by i gold(s) the gold of this army
	 * @param i the gold(s) to add
	 */
	public void modifyGold(int i) {
		gold += i;
	}
	/** Gives the gold of this army
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}
	
	@Override
	public String toString() {
		return super.toString() + " || neededFood : " + this.getPayment() + " || size : " + this.getSize() ;
	}
}
