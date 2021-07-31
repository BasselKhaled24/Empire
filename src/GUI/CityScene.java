package GUI;

import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CityScene extends Scene
{
	public CityScene(Group root, double Height, double Width, Paint color)
	{
		super(root, color);
		GridPane grid = new GridPane();
		grid.setMaxHeight(Double.MAX_VALUE);
		grid.setMaxWidth(Double.MAX_VALUE);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(8);
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Text cityName = new Text("Cairo");
		cityName.setFill(Color.BEIGE);
		Button b = new Button();

		GridPane.setConstraints(cityName, 1, 0);
		GridPane.setConstraints(cityName, 0, 0);
		grid.getChildren().addAll(cityName,b);
		
		root.getChildren().add(grid);
	}
}
