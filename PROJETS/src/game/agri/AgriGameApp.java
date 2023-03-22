package game.agri;
import java.util.Scanner;
import game.agri.modes.*;
import game.gui.GUIBoard;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.stage.Stage;
 
public class AgriGameApp extends Application {

    @Override
    public void start(Stage primaryStage) {
    	System.out.println("Heyo Welcome to AgriGame");
        Board board = new Board(10,10);
        Parameters args = getParameters();
		Game game = new Game(board);
        for(String name : args.getRaw()) {
        	Player player = new Player(name,new Random());
        	game.addPlayer(player);
        }
		board.printBoard();
		GUIBoard guiBoard = new GUIBoard(game);
		guiBoard.show();
		game.getGuiElements().add(guiBoard);
		AgriLeaderboard lb = new AgriLeaderboard(game);
		lb.show();
		game.getGuiElements().add(lb);
		game.setOnEndGame(new Runnable() {
			public void run() {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText(game.getWinner());
				alert.setTitle("Game Over");
				alert.show();
			}
		});
		try {
			game.playRound();
		} catch (CanNotPlayMoreRoundsException | CanNotDoActionException e) {
			e.printStackTrace();
		}
				
			
    }
 public static void main(String[] args) {
	 	
        launch(args);
    }
 
}