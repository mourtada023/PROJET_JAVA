package game.agri.actions.manual;

import java.util.ArrayList;
import java.util.Scanner;

import game.Game;
import game.Player;
import game.Resource;
import game.Tile;
import game.agri.Worker;
import game.agri.actions.FirstAction;
import game.agri.resources.Gold;
import game.agri.tiles.AgriTile;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.war.actions.manual.DeployArmyManual;
import game.war.resources.Food;
import game.war.tiles.WarTile;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class FirstActionManual extends FirstAction {

	public FirstActionManual(Player player, Game game) {
		super(null, player, game);
		System.out.println("Please Enter Position of tile :...");

	}

	public void  convertResource() throws CanNotDoActionException, CanNotPlayMoreRoundsException {
		ArrayList<Class<? extends Resource>> resTypes = new ArrayList<>();
		for (Class type : player.getResources().keySet()) {
			if (type == Food.class)
				continue;
			resTypes.add(type);
			System.out.println(resTypes.indexOf(type) + " -> " + type.getSimpleName());
		}
		System.out.print("Do you want to convert your resources ? (y/*) : ");
		Scanner scanner = new Scanner(System.in);
		char ans = (char)scanner.next().charAt(0);
		if (ans != 'y' & ans != 'Y'){
			System.out.println("Not a problem, lets convert some of your resources :) ...");
			deploy = false;
			endOfAction();
			return;
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				char ans=0;
				do{
					boolean canConvert = false;
					for (Resource myres : player.getResources().values()) 
						if (myres.getQuantity() > 0 && !(myres instanceof Gold))
							canConvert = true;
					if (!canConvert) {
						System.out.println("No more Resources to be converted, sorry :( ");
						endOfActionOnUIThread();
						return;
					}
					System.out.println("Please Choose one of these resources to be converted ( resId , quantity ) resp. : ");
					int id = scanner.nextInt();
					if (id == -1) {
						System.out.println("You skipped, lets' continue");
						endOfActionOnUIThread();
						return;
					}
					int quantity = scanner.nextInt();
					if (id < 0 || id >= resTypes.size()) {
						System.out.println("BAD INPUT ! lets try again ..");
						continue;
					}
					Resource res = player.getResources().get(resTypes.get(id));
					int out = res.convertRessource(quantity, player.getResources().get(Gold.class));
					if (out == -1)
						System.out.println(
								"No Enough units of " + resTypes.get(id).getSimpleName() + ", please try again ..");
					else if (out == -2)
						System.out.println(
								resTypes.get(id).getSimpleName() + " can't be converted to Gold, please try again");
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							game.updateGUI(); // Update UI here
						}
					});
					System.out.print("Do you want to convert another resource ? If yes, enter (y/Y) otherwise type anything : ");
					 ans = (char)scanner.next().charAt(0);
					 System.out.println(ans == 'y' || ans=='Y');
				}while (ans == 'y' || ans=='Y') ;
				endOfActionOnUIThread();
			}
		}).start();
	}

	@Override
	public void deployWorker() throws CanNotDoActionException  {
		new Thread(new Runnable() {
			public void run() {
				System.out.print("Do you want to deploy a new worker ? (y/*) : ");
				Scanner scanner = new Scanner(System.in);
				char ans = (char)scanner.next().charAt(0);
				if (ans != 'y' & ans != 'Y'){
					System.out.println("Not a problem, lets convert some of your resources :) ...");
					deploy = false;
					doActionOnUIThread();
					return;
				}
		    	System.out.println("Please click on one of the habitable tiles to select it :) ");
		    	for(Tile tile : board.getEmptyTiles()) {
		    		EventHandler event = new EventHandler<MouseEvent>() {
		    		    @Override
		    		    public void handle(MouseEvent event) {
		    		    	for(Tile tile :  board.getEmptyTiles())
		        		        tile.getTileRep().removeEventFilter(MouseEvent.MOUSE_CLICKED,tile.getTileRep().getEvent());
		    		    	System.out.println("Tile in " +tile.getCoordinatesToString() + " was selected ! ");
		    		    	try {
								deployWorker(tile);
							} catch (CanNotDoActionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		    		    	try {
								endOfAction();
							} catch (CanNotPlayMoreRoundsException | CanNotDoActionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
		    		    }
		    		};
		    		tile.getTileRep().setEvent(event);
		    		tile.getTileRep().addEventFilter(MouseEvent.MOUSE_CLICKED, event);
		    	}
			}
		}).start();
	}

}
