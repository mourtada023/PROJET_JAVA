package game.war.modes;

import java.util.ArrayList;

import game.Game;
import game.Mode;
import game.Player;
import game.war.actions.*;
import game.war.actions.manual.DeployArmyManual;
import game.war.actions.manual.PayArmyManual;

public class Manual extends Mode{
	@Override
	public void init(Player player,Game game) {
		actions = new ArrayList<>();
		bindToMode(new DeployArmyManual(player,game));
		bindToMode(new HarvestResources((game.war.Player)player,game));
		bindToMode(new PayArmyManual((game.war.Player) player,game));
	}
}
