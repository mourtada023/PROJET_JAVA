package game;

/**
 * Represent the character
 */
public abstract class Character {
	
	/**
	 * Position of the character on the board
	 */
	protected Tile pos;
	
	/**
	 * Player who owns this character
	 */
	protected Player owner;

	/** Create the Character with a given player
	 * @param player the player who owns this character
	 */
	public Character(Player player) {
		setOwner(player);
	}

	/** Replace the owner of this character by the entered character
	 * @param owner the new owner of this character
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
		owner.addCharacter(this);
	}

	/** Return the owner of this character
	 * @return the owner of this character
	 */
	public Player getOwner() {
		return owner;
	}

	/** Gives the position of this character
	 * @return the position
	 */
	public Tile getPos() {
		return pos;
	}

	/** Return the needed amount of money needed by this character
	 * @return the needed amount of money needed by this character
	 */
	public abstract int getPayment();

	/** Set/change the position of this character
	 * @param pos the new position
	 */
	public void setPos(Tile pos) {
		this.pos = pos;
	}

	/** Convert to string this character
	 * @return the string associated to this character
	 */
	public String toString() {
		return "Tile : " + getPos().getClass().getSimpleName();
	}

}
