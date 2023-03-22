package game;

import java.util.Collections;

import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TileRepresentation extends StackPane {
	/**
	*the tile that will be represented
	**/
	Tile tile;
	/**
	*the text node that will hold the text representation of the tile
	**/
	private Text text = new Text();
	/**
	* a rectangle used as a shadow half transparent to make the node text more readable
	**/
	private Rectangle shadow = new Rectangle();
	/**
	* width and height of the StackPane
	**/
	public final static int width = 100, height = 100;
	/**
	* opacity of the rectangle
	**/
	private double opacity;
	/**
	*the event that will run onClick of the StackPane
	**/
	private EventHandler event;
	
	/**
	*gets the event that will run onClick of the StackPane
	**/
	public EventHandler getEvent() {
		return event;
	}
	
	/**
	* sets the event that will run onClick of the StackPane
	**/
	public void setEvent(EventHandler event) {
		this.event = event;
	}
	
	/**
	*Constructs a new StackPane and puts it background as the png image that have the same name of the tile that we want to represent in /res
	*then we add a rectangle that will have the same size as the text node  that will represent the tile status
	*@param tile the param that will be represented
	*@param opacity the opacity of the shadow behind the text node 
	**/
	public TileRepresentation(Tile tile, double opacity) {
		this.tile = tile;
		this.opacity = opacity;
		this.setMinHeight(height);
		this.setMinWidth(width);
		this.setBackground(
				new Background(
						Collections
								.singletonList(new BackgroundFill(Color.rgb(255, 255, 255, 0.5), new CornerRadii(0),
										new Insets(0))),
						Collections
								.singletonList(
										new BackgroundImage(
												new Image( Thread.currentThread().getContextClassLoader().getResourceAsStream("res/"+tile.getClass().getSimpleName() +".png")
																	,
														100, 100, false, true),
												BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
												BackgroundPosition.DEFAULT,
												new BackgroundSize(1.0, 1.0, true, true, false, false)))

				));
		this.setOnMouseEntered(event -> {
			this.shadow.setOpacity(1);
		});
		this.setOnMouseExited(event -> {
			this.shadow.setOpacity(opacity);
		});
		this.getChildren().addAll(shadow, text);
		text.setFill(Color.WHITE);
		text.setFont(Font.font("Arial", 14));
		if (tile.board.inhabitableTile(tile))
			this.setCursor(Cursor.HAND);
	}	
	
	/**
	* changes the text content of the text node
	**/
	public void setText(String text) {
		this.text.setText(text);
		updateShadow();
	}
	/**
	* updates the shadow to have the same exact size as the text node
	**/
	private void updateShadow() {
		shadow.setWidth(text.getLayoutBounds().getWidth());
		shadow.setHeight(text.getLayoutBounds().getHeight());
		shadow.setFill(tile.getOccupant()!=null ?
				(tile.getOccupant().getOwner()!=null?tile.getOccupant().getOwner().getColor() : Color.BLACK) :
				Color.BLACK);
		shadow.setOpacity(opacity);
	}
	/**
	 * applies a simple animation that makes the shadow rectangle behind the text blinks (target) times
	 * @param target an integer that represent sthe number of blinks the shadow will make
	 */
	public void blink(final int target) {
		shadow.setWidth(width);
		shadow.setHeight(height);
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), shadow);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		fadeTransition.setCycleCount(target);
		fadeTransition.setOnFinished(event->{
			updateShadow();
		});
		fadeTransition.play();
		
	}
}
