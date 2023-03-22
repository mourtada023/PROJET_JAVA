package game.agri.modes;

import java.util.ArrayList;

import game.Game;
import game.Mode;
import game.Player;
import game.agri.actions.HarvestResources;
import game.agri.actions.random.*;

public class Random  extends Mode{
	@Override
	public void init(Player player,Game game) {
		actions = new ArrayList<>();
		bindToMode(new FirstActionRandom(player,game));
		bindToMode(new HarvestResources((game.agri.Player)player,game));
		bindToMode(new PayWorkerRandom( (game.agri.Player) player,game));
	}
}