
package game.war;

import java.util.Scanner;
import game.gui.GUIBoard;
import game.war.modes.Random;
import game.war.Board;
import game.exceptions.CanNotDoActionException;
import game.exceptions.CanNotPlayMoreRoundsException;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class WarGameApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		System.out.println("Heyo Welcome to WarGame");
        Board board = new Board(10,10);
		board.printBoard();
		Parameters args = getParameters();
		Game game = new Game(board);
		for (String name : args.getRaw()) {
			Player player = new Player(name, new Random());
			game.addPlayer(player);
		}
		board.printBoard();
		GUIBoard guiBoard = new GUIBoard(game);
		guiBoard.show();
		game.getGuiElements().add(guiBoard);
		WarLeaderboard lb = new WarLeaderboard(game);
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