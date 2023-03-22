package game.agri.actions.random;
import game.*;
import game.agri.actions.FirstAction;
import game.agri.resources.Gold;
import game.agri.tiles.AgriTile;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
public class FirstActionRandom extends FirstAction{
	
	public FirstActionRandom(Player player,Game game) {
		super(null,player,game);
	}
	@Override
	public void convertResource() throws CanNotPlayMoreRoundsException, CanNotDoActionException {
		int remaining = player.payCharacters();
		int converted = 0;
		for (Map.Entry<Class, Resource> entry : player.getResources().entrySet()) {
			if (!(entry.getValue() instanceof Gold)) {
				int temp = player.convertResource(entry.getValue(), Resource.MAX,
						player.getResources().get(Gold.class));
				converted += temp > 0 ? temp : 0;
				if (converted >0 )
				System.out.println(entry.getValue().getClass().getSimpleName() + " -> Converted (" + temp + ")" + " , Remainning (" + ((remaining - converted) > 0 ? (remaining - converted) : 0 ) + ")");}
			if(new Random().nextInt(2)==1)
				break;
		}
		endOfAction();
	}
	@Override
	public void deployWorker() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		if(new Random().nextInt(2)==1) {
			System.out.println("Instead Of Deploying a worker, i will convert my resources :)");
			deploy = false;
			doAction();
			return;
		}
		deployWorker(board.getEmptyTiles().get(new Random().nextInt(board.getEmptyTiles().size())));
		endOfAction();
	}
	
	
}