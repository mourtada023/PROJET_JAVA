package game.war.actions.manual;

import java.util.Scanner;

import game.Action;
import game.Game;
import game.Player;
import game.Tile;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import game.war.Board;
import game.war.actions.DeployArmy;
import game.war.tiles.WarTile;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DeployArmyManual extends DeployArmy {

	public DeployArmyManual(Player player, Game game) {
		super(player, game, -1);
		autoStart = false;
	}
	
	@Override
	public void init() {
		final DeployArmyManual action = this;
		new Thread(new Runnable() {
			public void run() {
		    	System.out.println("Please click on one of the habitable tiles to select it :) ");
		    	for(Tile tile : board.getEmptyTiles()) {
		    		EventHandler event = new EventHandler<MouseEvent>() {
		    		    @Override
		    		    public void handle(MouseEvent event) {
		    		    	setTile((WarTile) tile);
		    		    	for(Tile tile :  board.getEmptyTiles())
		        		        tile.getTileRep().removeEventFilter(MouseEvent.MOUSE_CLICKED,tile.getTileRep().getEvent());
		    		    	System.out.println("Tile in " +tile.getCoordinatesToString() + " was selected ! ");
							new Thread(new Runnable() {
								@Override
								public void run() {
									Scanner scan = new Scanner(System.in);
									while(getArmySize() == -1) {
										System.out.print("Enter the size of the army you want to deploy : ");
							    		int input = scan.nextInt();
							    		if (input > 5) {
							    			System.out.println("Max allowed Army size is 5 ! do not cheat, lets' try again ;)");
							    			continue;
							    		}else if(input>getTile().getMaxSize()){
							    			System.out.println("Max allowed Army size for " + getTile().getClass().getSimpleName() +"  is " + getTile().getMaxSize() + " ! do not cheat, lets' try again ;)");
							    			continue;
							    		}
							    		if (input > getPlayer().getMaxSoldiers()) {
							        		setArmySize(-1);
							        		System.out.println("No enough soldiers, please try again ..");
							    		}else
							    			setArmySize(input);
							    	}
									doActionOnUIThread();
								}
							}).start();  	
		    		    }
		    		};
		    		tile.getTileRep().setEvent(event);
		    		tile.getTileRep().addEventFilter(MouseEvent.MOUSE_CLICKED, event);
		    	}
			}
		}).start();
	}

}
