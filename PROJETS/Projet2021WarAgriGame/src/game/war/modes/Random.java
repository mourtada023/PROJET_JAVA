package game.war.modes;

import java.util.ArrayList;

import game.Game;
import game.Mode;
import game.Player;
import game.Tile;
import game.war.actions.*;
import game.war.actions.random.DeployArmyAleatoire;
import game.war.actions.random.PayArmyAleatoire;

public class Random extends Mode{
	protected boolean autoStart = false;
	@Override
	public void init(Player player,Game game) {
		actions = new ArrayList<>();
		bindToMode(new DeployArmyAleatoire(player,game));
		bindToMode(new HarvestResources((game.war.Player)player,game));
		bindToMode(new PayArmyAleatoire((game.war.Player) player,game));
	}
}
