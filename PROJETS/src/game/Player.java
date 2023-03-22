package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import javafx.scene.paint.Color;

import java.lang.Class;

public abstract class Player {
	
	/**
	 * Name of the player
	 */
	protected String name;
	
	/**
	 * Game in which the player plays
	 */
	protected Game game;
	
	/**
	 * Game mode of the player
	 */
	protected Mode mode;
	
	/**
	 * Characters owned by the player
	 */
	protected ArrayList<Character> characters;
	
	/**
	 * ID of the player
	 */
	protected static int ids = 1;
	
	/**
	 * 
	 */
	public int id = ids;													//DOC A FAIRE
	
	/**
	 * Ranking of the player (0 when initialized)
	 */
	protected int ranking = 0;
	
	/**
	 * Resources of the player
	 */
	protected HashMap<Class, Resource> resources;
	
	/**
	 * Resource used to pay units
	 */
	protected Class paymentResource;
	
	/**
	 * Score of the player
	 */
	protected int score = 0;
	
	/**
	 * Color which represent the player
	 */
	protected Color color = Color.rgb(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));

	/** Create a player with given name
	 * @param name the name of the player
	 */
	public Player(String name) {
		characters = new ArrayList<Character>();
		resources = new HashMap<Class, Resource>();
		this.name = name;
		ids++;
	}
	
	/** Create a player with given name and game mode
	 * @param name the name of the player
	 * @param mode the game mode used by the player
	 */
	public Player(String name,Mode mode) {
		this(name);
		this.mode  =mode;
	}
	
	/** Remove the entered character from this player's character list
	 * @param character the character to remove
	 * @return true if the character is correctly removed
	 */
	public boolean removeCharacter(Character character) {
		return characters.remove(character);
	}

	/** Add a resource to the resource list of the player. If the player has resource
	 * of the same type the quantity of the resource in parameter will be added to
	 * the existing resource object in the list
	 * @param the resource we want to add to the Resource List
	 */
	public void addRessource(Resource res) {
		if (resources.containsKey(res.getClass())) {
			resources.get(res.getClass()).modifyQuantity(res.getQuantity());
			res.modifyQuantity(-1);
			return;
		}
		resources.put(res.getClass(), res.getClone());
		res.modifyQuantity(-1);
	}

	/** Return the resources owned by this player
	 * @return HashMap containing all resources that the player have and their quantities
	 */
	public HashMap<Class, Resource> getResources() {
		return resources;
	}

	/** Convert the entered resource with entered quantity to the entered resource
	 * @param res resource to convert
	 * @param quantity the quantity to convert
	 * @param dest resource to get
	 * @return -2 if the resource is not convertible, -1 if there are not enough resource, the gained amount of resource otherwise
	 */
	public int convertResource(Resource res, int quantity, Resource dest) {
		return res.convertRessource(quantity, dest);
	}

	/** Adds new character to the list of character of the player
	 * @param tile the tile where the new character will be positioned
	 */
	public boolean addCharacter(Character character) {
		characters.add(character);
		return true;
	}

	/** Pay all characters
	 * @return the remaining of units that should be paid to characters
	 */
	public int payCharacters() {
		int sum = 0;
		for (Character character : characters)
			sum += character.getPayment();
		int quantity = getResources().get(paymentResource).getQuantity();
		if (sum > quantity)
			return sum - quantity;
		getResources().get(paymentResource).modifyQuantity(-sum);
		return 0;
	}

	/** Return the list of position of all characters
	 * @return the list of position of all characters
	 */
	public Tile[] getTiles() {
		Tile[] tiles = new Tile[this.characters.size()];
		for (Character c : this.characters)
			tiles[this.characters.indexOf(c)] = c.getPos();
		return tiles;
	}

	@Override
	public String toString() {
		return getName() + "\n" + resourcesListToString();
	}

	/** Return the string representation of the list of resources
	 * @return the string representation of the list of resources
	 */
	public String resourcesListToString() {
		String resourceString = "Different kind of Resources : " + this.resources.size() + "\n";
		int resCount = 0;
		for (Entry<Class, Resource> pair : this.resources.entrySet()) {
			resourceString += pair.getValue().toString() + "\n";
			resCount += pair.getValue().getQuantity();
		}
		resourceString += "All resources count : " + resCount;
		return resourceString;
	}

	/** Let the player play his round
	 * @throws CanNotDoActionException if the action does not work
	 * @throws CanNotPlayMoreRoundsException if there is not another round
	 */
	public void play() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		score = getScore();
		System.out.println("Using " + mode.getClass().getSimpleName() + " mode");
		mode.apply(this, game);
		game.updateGUI();
	} 
	
	/** Return the name of this player
	 * @return the name of this player
	 */
	public String getName() {
		return this.name;
	}
	
	/** Return the list of characters of the player
	 * @return the list of characters of the player
	 */

	public ArrayList<?> getCharacters() {
		return this.characters;
	}
	
	/** Set the game played by this player to the entered one
	 * @param game to let the player play
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/** Returns the ranking of this player
	 * @return the ranking of this player
	 */
	public int getRanking() {
		return ranking;
	}

	/** Set the ranking of this player to the entered one
	 * @param ranking the new ranking of this player
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	/** Return the ID of this player
	 * @return the ID of this player
	 */
	public int getId() {
		return id;
	}
	
	/** Return the color which represents this player
	 * @return the color which represents this player
	 */
	public Color getColor() {
		return color;
	}

	/** Set the color of this player to the entered one
	 * @param color new color of this player
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/** Return the score of this player
	 * @return the score of this player
	 */
	public abstract int getScore();


}