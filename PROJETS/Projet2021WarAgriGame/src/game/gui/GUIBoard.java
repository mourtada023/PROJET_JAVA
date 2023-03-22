package game.gui;

import java.util.ArrayList;
import java.util.Collections;

import javax.print.DocFlavor.URL;

import game.Game;
import game.Tile;
import game.TileRepresentation;
import game.exceptions.CanNotPlayMoreRoundsException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIBoard extends GUIElement {
	public GUIBoard(Game game) {
		super(game,"Board");
	}
	public void init() {
		for (int i = 0; i < game.getBoard().getHeight(); i++) {
			for (int j = 0; j < game.getBoard().getWidth(); j++) {
				Tile tile = game.getBoard().getTile(j,i);
				tile.getTileRep().setLayoutX((j * TileRepresentation.width) + 5);
				tile.getTileRep().setLayoutY((i * TileRepresentation.height) + 5);
				root.getChildren().add(tile.getTileRep());
			}
		}
	}
	public void update() {
		for(Tile[] tiles : game.getBoard().getMap())
			for(Tile tile : tiles)
				tile.updateGUI();
	}
}