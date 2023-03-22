package goosegame;
import goosegame.boards.Board;
import goosegame.boards.ClassicalBoard;
import goosegame.util.io.Input;

public class MainGame
{
    public static void main(String[] args)
    {

		Board classicalBoard = new ClassicalBoard();

		Game game = new Game (classicalBoard);
		game.getBoard().initBoard();
		int n = 1;
		try {

			System.out.println("Enter the number of turns you want to play : ?");
			n = Input.readInt();
		} catch (java.io.IOException e) {

			System.out.println(e.getMessage());
		}
		game.playTurns(n);

    }



}
