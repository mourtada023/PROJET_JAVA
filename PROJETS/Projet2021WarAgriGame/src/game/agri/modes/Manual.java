package game.agri.modes;

import java.util.ArrayList;

import game.Game;
import game.Mode;
import game.Player;
import game.agri.actions.*;
import game.agri.actions.manual.FirstActionManual;
import game.agri.actions.manual.PayWorkerManual;
public class Manual extends Mode{
	
	
	@Override
	public void init(Player player,Game game) {
		actions = new ArrayList<>();
		bindToMode(new FirstActionManual(player,game));
		bindToMode(new HarvestResources((game.agri.Player)player,game));
		bindToMode(new PayWorkerManual( (game.agri.Player) player,game));
	}
}
