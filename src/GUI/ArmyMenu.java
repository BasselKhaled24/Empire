package GUI;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class ArmyMenu
{
	static Stage window;
	final static Button attack = new Button("Attack"); 
	final  static Button LaySeige = new Button("LaySeige");
	public static void ShowMenu(Army army) 
	{
		window  = new Stage();
		
		window.setTitle("Army Menue");
		BorderPane box = new BorderPane();
		BackgroundImage bg = new BackgroundImage(new Image("BloodWall.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		box.setBackground(new Background(bg));
		TilePane tile = new TilePane();
		for (Unit a : army.getUnits())
		{
			if ( a instanceof Archer)
			{
				Hyperlink hyp =  ((Archer) a).getHyperlink();
				tile.getChildren().add(hyp);
			}
			else if ( a instanceof Infantry)
			{
				Hyperlink hyp = ((Infantry) a).getHyperlink();
				tile.getChildren().add(hyp);
			}
			else if ( a instanceof Cavalry)
			{
				Hyperlink hyp = ((Cavalry) a).getHyperlink();
				tile.getChildren().add(hyp);
			}
		}
		box.setTop(tile);
		Text TurnsTillTarget = new Text();
		Font font = Font.font("CHLAKH", FontWeight.BOLD, 40);
		if (army.getCurrentStatus() == Status.IDLE)
		{
			TurnsTillTarget.setText( "This army is Idle"  +" in Current Location " +  army.getCurrentLocation() );
			TurnsTillTarget.setFont(font);;
		}
		else if ( army.getCurrentStatus() == Status.MARCHING)
		{
			TurnsTillTarget.setText("This army is Marching to " + army.getTarget() + "\n" +
		     "and there is " + army.getDistancetoTarget() + "turns left to reach it" );
			TurnsTillTarget.setFont(font);
		}
		else if( army.getCurrentStatus() == Status.BESIEGING)
		{
			TurnsTillTarget.setText( "This army is currently BESIEGING " + army.getTarget() + "\n"
					+"The city was under your seige for " );
			TurnsTillTarget.setFont(font);;
		}
		box.setCenter(TurnsTillTarget);
		

		VBox vbox = new VBox();
		
		if ( army.getCurrentStatus() == Status.IDLE || army.getCurrentStatus() == Status.MARCHING)
		{
			attack.setVisible(false);	
			LaySeige.setVisible(false);
		}
		else
		{
			attack.setVisible(true);	
			LaySeige.setVisible(true);
		}
		attack.setMaxHeight(50);
		LaySeige.setMaxHeight(50);
		vbox.getChildren().addAll(attack,LaySeige);
		vbox.setSpacing(50);
		vbox.setAlignment(Pos.CENTER);
		box.setRight(vbox);
		
		Button close = new Button("Done");
		close.setOnMouseClicked( e ->
		{
			window.close();
		});
		close.setMaxHeight(1000);

		box.setBottom(close);
		close.setAlignment(Pos.CENTER);
		close.setMaxWidth(1000);
		//close.setGraphic(new ImageView(new Image("design1.png")));
		//box.getChildren().addAll(tile , TurnsTillTarget , vbox , close);
		Scene scene = new Scene(box ,1000 ,600);
		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}
		
	}
	
	
	//Scene scene = new Scene(new Group() , 500 , 500 );