package game.war;

import java.util.ArrayList;
import java.util.Map;

import game.Game;
import game.Player;
import game.Resource;
import game.gui.Leaderboard;
import game.war.resources.Food;
import game.war.resources.Gold;
import game.war.tiles.Desert;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import game.war.resources.*;
public class WarLeaderboard extends game.gui.Leaderboard {

	public WarLeaderboard(Game game) {
		super(game);
	}
	
	public ArrayList<TableColumn> ResColumns() {
		ArrayList<Class<?extends Resource>> resList = new ArrayList<>();
		resList.add(Food.class);
		resList.add(Corn.class);
		resList.add(Wood.class);
		resList.add(Sand.class);
		resList.add(Rock.class);
		resList.add(Gold.class);
		ArrayList<TableColumn> resCols = new ArrayList<>();
		for(Class<? extends Resource> myclass : resList) {
			TableColumn column = new TableColumn<>();
			column.setText(myclass.getSimpleName());
			column.setCellValueFactory(data -> {
				CellDataFeatures<Player,Integer> ref = (CellDataFeatures<Player,Integer>) data;
				if (ref.getValue().getResources().get(myclass)!=null)
					return new ReadOnlyIntegerWrapper(
							ref.getValue().getResources().get(myclass).getQuantity());
				return null;
			});
		    resCols.add(column);
		}
		return resCols;
	}
	@Override
	public ArrayList<TableColumn> getTableColumns(){
		ArrayList<TableColumn> cols = new ArrayList<TableColumn>();
		cols.addAll(super.getTableColumns());
		cols.add(createPropCol("Deployed Soldiers / 35","deployedSoldiers"));
		cols.addAll(ResColumns());
		return cols;
	}
}
