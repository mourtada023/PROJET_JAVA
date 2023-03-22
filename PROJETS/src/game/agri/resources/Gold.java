package game.agri.resources;

import game.Resource;

public class Gold extends Resource{
	/** Create the resource gold
	 * @param quantity the quantity
	 */
	public Gold(int quantity) {
		super(quantity, 1);
		convertable = false;
	}

}
