package game.war.actions.random;
import game.*;
import game.Character;
import game.exceptions.*;
import game.war.Army;
import game.war.actions.DeployArmy;
import game.war.tiles.Desert;
import game.war.tiles.Mountain;
import game.war.tiles.WarTile;

import java.util.ArrayList;
import java.util.Random;
public class DeployArmyAleatoire extends DeployArmy{
	
	public DeployArmyAleatoire(Player player,Game game) {
		super(player,game, 0);	
	}
	public void init() {
		ArrayList<Tile> emptyTiles = board.getEmptyTiles();
		Random rand = new Random();
		setTile((WarTile) emptyTiles.get(rand.nextInt(emptyTiles.size())));
		getTile().getTileRep().blink(10);
		int maxSoldiers = ((game.war.Player)player).getMaxSoldiers() ;
		setArmySize(rand.nextInt(maxSoldiers > getTile().getMaxSize() ? getTile().getMaxSize() : maxSoldiers)+1);
		System.out.println("Deployed Randomly an army of (" + getArmySize() +") in " + getTile().getCoordinatesToString());
	}
	
}
/*

*/