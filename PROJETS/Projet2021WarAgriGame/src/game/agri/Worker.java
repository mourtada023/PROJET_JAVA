package game.agri;
import game.Character;
import game.agri.tiles.AgriTile;
import game.exceptions.CanNotDoActionException;

/**
 * Represent the characters of worker
 */
public class Worker extends Character {
	
	
	private int gold = 0;
	/** Create the worker 
	 * @throws CanNotDoActionException 
	 */
	public Worker(Player player) throws CanNotDoActionException{
		super(player);
	}
	
	/**
	 * Gives the owner of this worker
	 * @return the Player
	 */
	
	public Player getOwner() {
		return (Player)super.getOwner();
	}
	 
	/**
	 * Gives the position of this worker
	 * @return the position
	 */
	@Override
	public AgriTile getPos() {
		return (AgriTile) pos;
	}
	
	/**
	 * it increases the amount of resource of a unit
	 */
	
	
	public void produit() {
		pos.getRessource().modifyQuantity(1);
	}
	
	/**
	 * Gives the due payment for this worker
	 * @return the due Payment
	 */
	public int getPayment() {
		return ((AgriTile)pos).getCost();
	}
	
	/**
	 * Modify by i gold(s) the gold of this worker
	 * @param i the gold(s) to add
	 */
	public void modifyGold(int i) {
		gold += i;
	}
	
	/**
	 * Gives the gold of this worker
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}
	@Override
	public String toString() {
		return super.toString() + " || neededGold : " + this.getPayment();
	}
}
