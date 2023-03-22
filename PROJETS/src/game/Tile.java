package game;

import javafx.scene.paint.Color;

public class Tile implements Cloneable {
	
	/**
	 * Color of the tile
	 */
	private Color color = Color.ALICEBLUE;
	
	/**
	 * Occupant of the tile
	 */
	private Character occupant;
	
	/**
	 * Resource extracted by the tile
	 */
	protected Resource res;
	
	/**
	 * Board where this tile can be found
	 */
	protected Board board;
	
	/**
	 *	the StackPane that represents the current Tile
	 */
	protected TileRepresentation tileRep;
	
	/**
	 * Position of the tile (integer between 0 included and size of the board excluded)
	 */
	private int position;

	/** Create a tile with given position and board
	 * @param pos position of the tile
	 * @param board the board where the tile appears
	 */
	public Tile(int pos,Board board) {
		this.position = pos;
		this.board = board;
		tileRep = new TileRepresentation(this, 0.8);
	}

	/** Returns the StackPane that represents the current Tile
	 * @return
	 */
	public TileRepresentation getTileRep() {
		return tileRep;
	}
	
	/** 
	 * sets the StackPane that represents the tile in GUI BOARD
	 * @param tileRep
	 */
	public void setTileRep(TileRepresentation tileRep) {
		this.tileRep = tileRep;
	}
	
	/** Create a tile with given position, board and color
	 * @param pos position of the tile
	 * @param board the board where the tile appears
	 * @param color the color of the tile
	 */
	public Tile(int pos,Board board,Color color) {
		this(pos,board);
		this.color = color;
	}
	
	/** Return the occupant of this tile
	 * @return the occupant of this tile
	 */
	public Character getOccupant() {
		return occupant;
	}

	/** Return the resource given by this tile
	 * @return the resource given by this tile
	 */
	public Resource getRessource() {
		return res;
	}
	
	/** Set the resource of this tile by the entered one
	 * @param res the new resource of this tile
	 */
	public void setRessource(Resource res) {
		this.res = res;
	}
	
	/** Set the position of this tile by the given one
	 * @param pos new position of this resource
	 */
	public void setPos(int pos) {
		position = pos;
	}

	/** Return the position of this tile
	 * @return the position of this tile
	 */
	public int getPosition() {
		return this.position;
	}

	/** Return true if both tiles have the same position and false otherwise
	 * @param o object to be compared
	 * @return true if both tiles have the same position
	 */
	public boolean equals(Object o) {
		if (o instanceof Tile) {
			Tile other = (Tile) o;
			return this.position == other.getPosition();
		}
		return false;
	}
	
	/** Function that returns an exact clone of this tile object
	 * @return
	 */
	public Tile getClone() {
		try {
			return (Tile) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** Says if this tile can host the given character or not
	 * @param character the character to check
	 * @return true if the tile can host the character, false otherwise
	 */
	public boolean canHost(Character character) {
		return occupant == null;
	}
	
	/** Set the occupant to the given one
	 * @param occupant the new occupant
	 */
	public void setOccupant(Character occupant) {
		if  (occupant == null) {
			this.occupant = null;
			return;
		}
		if (!canHost(occupant))
			return;
		this.occupant = occupant;
		occupant.setPos(this);
	}
	
	/** returns the text that will appear on the tile representation on Board GUI
	 * @return
	 */
	public String strGUIRepresentation() {
		return Integer.toString(occupant.getOwner().getId());
	}
	
	/** Updates the text that appears on the tile representation on GUI Board 
	 */
	public void updateGUI() {
		tileRep.setText(strGUIRepresentation());
	}
	
	/** Return the (x,y)-coordinates of this tile as a table with a size of 2
	 * @return coordinates of this tile
	 */
	public int[] getCoordinates() {
		return new int[]{  (getPosition() % board.width) ,(getPosition() - (getPosition() % board.width)) / board.width };
	}
	
	/** Return the string representation of the coordinates of this tile
	 * @return the string representation of the coordinates of this tile
	 */
	public String getCoordinatesToString() {
		int[] a = getCoordinates();
		return "position ("+(a[0]+1)+","+(a[1]+1)+ ")";
	}
	
}