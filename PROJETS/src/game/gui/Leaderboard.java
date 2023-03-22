package game.gui;

import java.util.ArrayList;

import game.Game;
import game.Player;
import game.TileRepresentation;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Leaderboard extends GUIElement {

	public final static int margin = 5;
	public final static int controlsWidth = 300;
	protected TableView leaderBoard;
	
	public Leaderboard(Game game) {
		super(game,"Leaderboard");
	}
	protected TableColumn createPropCol(String headerText,String name) {
		TableColumn<Player, String> column = new TableColumn<>(headerText);
		column.setCellValueFactory(new PropertyValueFactory<>(name));
		return column;
	}
	public ArrayList<TableColumn> getTableColumns(){
		ArrayList<TableColumn> list = new ArrayList<>();
		list.add(createPropCol("Ranking","ranking"));
		list.add(createPropCol("Name","name"));
		list.add(createPropCol("Score","score"));
		list.add(createPropCol("ID","id"));
		return list;
	}
	public void init() {
		leaderBoard = new TableView<>();
		leaderBoard.getColumns().addAll(getTableColumns());
		root.getChildren().add(leaderBoard);
		update();
	}
	public void update() {
		leaderBoard.getItems().clear();
		leaderBoard.getItems().addAll(game.getPlayers());
		leaderBoard.getSortOrder().add(leaderBoard.getColumns().get(0));
	}
}
