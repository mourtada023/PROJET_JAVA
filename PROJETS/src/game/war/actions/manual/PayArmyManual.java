package game.war.actions.manual;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import game.Game;
import game.Resource;
import game.Tile;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.war.Army;
import game.war.Player;
import game.war.actions.PayArmy;
import game.war.resources.Food;
import game.war.resources.Gold;
import game.war.tiles.WarTile;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PayArmyManual extends PayArmy {

	public PayArmyManual(Player player, Game game) {
		super(player, game);
	}

	public void convertToGetResource() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		int remainning = player.payCharacters();
		ArrayList<Class<? extends Resource>> resTypes = new ArrayList<>();
		for (Class type : player.getResources().keySet()) {
			if (type == Food.class)
				continue;
			resTypes.add(type);
			System.out.println(resTypes.indexOf(type) + " -> " + type.getSimpleName());
		}
		final PayArmy me = this;
		new Thread(new Runnable() {
			@Override
			public void run() {
				int converted = 0;
				Scanner scanner = new Scanner(System.in);
				while (converted < remainning) {
					boolean canConvert = false;
					for (Resource myres : player.getResources().values()) 
						if (myres.getQuantity() > 0 && !(myres instanceof Food))
							canConvert = true;
					if (!canConvert) {
						cnvRes = false;
						System.out.println("No more Resources to be converted, you should destroy one of your armies :( ");
						doActionOnUIThread();
						return;
					}
					System.out.println("Please Chose one of these resources to be converted ( resId , quantity ) resp. (-1 if you want to skip) : ");
					int id = scanner.nextInt();
					if (id == -1) {
						System.out.println("You skipped, you should now destroy some of your armies to continue :(");
						cnvRes = false;
						doActionOnUIThread();
						return;
					}
					int quantity = scanner.nextInt();
					if (id < 0 || id >= resTypes.size()) {
						System.out.println("BAD INPUT !");
						continue;
					}
					Resource res = player.getResources().get(resTypes.get(id));
					int out = res.convertRessource(quantity, player.getResources().get(Food.class));
					if (out == -1)
						System.out.println(
								"No Enough units of " + resTypes.get(id).getSimpleName() + ", please try again ..");
					else if (out == -2)
						System.out.println(
								resTypes.get(id).getSimpleName() + " can't be converted to food, please try again");
					converted += out;
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							game.updateGUI(); // Update UI here
						}
					});
				}
				doActionOnUIThread();
			}
		}).start();
	}

	public void destroyArmy() {
		System.out.println("Click on one of your tiles to destroy the occupant army ...");
		for (Tile tile : player.getTiles()) {
			PayArmy action = this;
			EventHandler<MouseEvent> object_clicked = new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					for(Tile tile :  player.getTiles())
        		        tile.getTileRep().removeEventFilter(MouseEvent.MOUSE_CLICKED,tile.getTileRep().getEvent());
					try {
						action.destroyThisArmy(tile);
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