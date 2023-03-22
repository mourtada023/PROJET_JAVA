package game;

public abstract class Resource implements Cloneable {
	
	/**
	 * Quantity of the resource
	 */
	protected int quantity = 0;
	
	/**
	 * Value of the resource
	 */
	protected int toBase;
	
	/**
	 * True if convertible
	 */
	protected boolean convertable;
	
	/**
	 * Constant value which indicates that we want to use all resources
	 */
	public static final int MAX = -3;

	/** Create a Resource with given quantity and value of the base
	 * @param quantity the initial quantity
	 * @param toBase the value of the resource
	 */
	public Resource(int quantity, int toBase) {
		this.quantity = quantity;
		this.toBase = toBase;
		convertable = true;
	}

	/** Return the value of this resource with the entered quantity
	 * @param quantity the number of resource we want to check
	 * @return the total value
	 */
	public int toBase(int quantity) {
		return toBase * quantity;
	}

	/** Convert this resource to the given one with given quantity
	 * @param quantity the quantity of resource to convert
	 * @param res the resource we want to get
	 * @return -2 if the resource is not convertible, -1 if there are not enough resource, the gained amount of resource otherwise
	 */
	public int convertRessource(int quantity, Resource res) {
		if (!convertable)
			return -2;
		if (this.toBase == 0) {
			this.quantity = 0;
			return 0;
		}
		if (quantity > this.quantity)
			return -1;
		if (quantity == MAX)
			quantity = this.quantity;
		int gainedQuantity = toBase(quantity) / res.toBase;
		res.modifyQuantity(gainedQuantity);
		modifyQuantity(-quantity);
		return gainedQuantity;
	}
	
	/** Return the total quantity
	 * @return the total quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/** Modify this quantity by adding the given quantity (subtracting if negative)
	 * @param quantity the quantity to add or subtract 
	 */
	public void modifyQuantity(int quantity) {
		if (quantity + this.quantity < 0)
			return;
		this.quantity += quantity;
		return;
	}
	
	/** 
	 * @return
	 */
	public Resource getClone() {										//DOC A FAIRE
		try {
			return (Resource) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** Return the string value of this resource
	 * @return the string value of this resource
	 */
	public String toString() {
		return this.getClass().getSimpleName() + " : " + quantity;
	}
}