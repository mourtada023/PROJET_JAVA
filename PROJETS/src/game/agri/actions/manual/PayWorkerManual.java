package game.agri.actions.manual;

import game.Action;
import game.Game;
import game.agri.Player;
import game.agri.Worker;
import game.agri.actions.PayWorker;
import game.Tile;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.war.actions.PayArmy;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PayWorkerManual extends PayWorker{
	public PayWorkerManual(Player player, Game game) {
		super(player, game);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void destroyWorker() {
		System.out.println("Click on one of your tiles to destroy the occupant army ...");
		for (Tile tile : player.getTiles()) {
			PayWorkerManual action = this;
			EventHandler<MouseEvent> object_clicked = new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					for(Tile tile :  player.getTiles())
        		        tile.getTileRep().removeEventFilter(MouseEvent.MOUSE_CLICKED,tile.getTileRep().getEvent());
					try {
						destroyWorker((Worker)tile.getOccupant());
					} catch (CanNotDoActionException | CanNotPlayMoreRoundsException e) {
						e.printStackTrace();
					}
				}
			};
			tile.getTileRep().setEvent(object_clicked);
			tile.getTileRep().addEventFilter(MouseEvent.MOUSE_CLICKED, object_clicked);
		}
	}

}
