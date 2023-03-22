package game.gui;

import game.Game;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class GUIElement extends Stage {
	protected Game game;
	protected Pane root = new Pane();
	protected Scene scene = new Scene(root);
	public final static int margin = 5;
	
	public GUIElement(Game game,String title) {
		this.game = game;
		this.setTitle(title);
		this.setScene(scene);
		init();
	}
	
	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	public abstract void init();
	public abstract void update();
}
