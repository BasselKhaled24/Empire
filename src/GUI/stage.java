package GUI;




import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import engine.Game;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyFireException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Unit;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class stage extends Application
{
	Game game;
	TextField PlayerName;
	
//	static ArcheryRange archeryRangeCairo = new ArcheryRange();
//	static Barracks barracksCairo = new Barracks();
//	static Stable stableCairo = new Stable();
//	static Farm FarmCairo = new Farm();
//	static Market marketCairo = new Market();
//	
//	static ArcheryRange archeryRangeRome = new ArcheryRange();
//	static Barracks barracksRome = new Barracks();
//	static Stable stableRome = new Stable();
//	static Farm FarmRome = new Farm();
//	static Market marketRome = new Market();
//	
//	static ArcheryRange archeryRangeSparta = new ArcheryRange();
//	static Barracks barracksSparta = new Barracks();
//	static Stable stableSparta = new Stable();
//	static Farm FarmSparta = new Farm();
//	static Market marketSparta = new Market();
	
	public static void main(String[] args) {
		/*
		//playing musik
	        String uriString = new File("ELKBEER.wav").toURI().toString();
	        MediaPlayer Player = new MediaPlayer(new Media(uriString));
	        Player.play();
*/
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Stage window = new Stage();
		stage = window;
		window.setTitle("The Revolution");

		//CitySelectionScene(window);
		StartUpScene(window);
		//MapViewScene(window);
		//window.setResizable(true);
		window.show();		
		window.setMaximized(true);
		
	}
	public void StartUpScene(Stage stage)
	{
		
		StackPane root = new StackPane();
		//adding the icon image 
		Image icon = new Image("intropic.jpg");
		stage.getIcons().add(icon);
		
		 //TextTitle
		Text text = new Text();
		text.setText("The Revolution");
		StackPane.setAlignment(text, Pos.TOP_CENTER);
		text.setFont(new Font("Times New Roman", 50));
		//text.setUnderline(true);
		text.setFill(Color.RED);
		root.getChildren().add(text);
		//setting the scene
		Scene scene = new Scene(root );
		stage.setScene(scene);

		//BackgroundImage
		BackgroundImage bg = new BackgroundImage(new Image("menu.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		root.setBackground(new Background(bg));
		
    	//adding Buttons
		Button startButton = new Button("PLAY");
		startButton.setMaxHeight(50);
		startButton.setMaxWidth(125);
		startButton.setStyle("-fx-font: 40 Times New Roman; -fx-base: #b6e7c9;");
		root.getChildren().add(startButton);
		startButton.setOnAction(e -> GetNameView(stage));
		
	}
	public void GetNameView(Stage stage)
	{		
		
		VBox v = new VBox();
		v.setAlignment(Pos.CENTER);
		v.setSpacing(25);
		
		
		//Title
		BorderPane border = new BorderPane();
		/*Text text = new Text("WELCOME CHIEF !!!");
		text.setFont(new Font("Times New Roman", 25));
		//text.setUnderline(true);
		text.setFill(Color.RED);
		border.setAlignment(text, Pos.CENTER);
		v.getChildren().add(text);*/
		
		//get name TextField
	    PlayerName = new TextField();
		PlayerName.setPromptText("Enter Your Name    ");
		PlayerName.setMaxSize(300, 150);
		v.getChildren().add(PlayerName);
		PlayerName.setAlignment(Pos.CENTER);
		
		//next Button
		Button next = new Button("Next");
		next.setAlignment(Pos.BOTTOM_CENTER);
		next.setMaxHeight(50);
		next.setMaxWidth(140);
		next.setStyle("-fx-font: 25 arial; -fx-base: #b6e7c9;");
		v.getChildren().add(next);
		
		//Background Image
		BackgroundImage bg = new BackgroundImage(new Image("intropic.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
		border.setBackground(new Background(bg));
		border.setCenter(v);
		//border.setTop(text);
		
		
		stage.setMaximized(true);
		Scene scene = new Scene(border , 1800 , 1800);		
		stage.setScene(scene);
		
		
		
		//next button on action
		next.setOnAction(e ->
		{
			if (PlayerName.getText().isEmpty())
			{
				String toastMsg = "Ooooops , add your name chief !";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
			}
			else
			{
				CitySelectionScene(stage);
			}
		}
		);	
		stage.setResizable(false);
		stage.setFullScreen(true);
	}
	
	public void CitySelectionScene(Stage stage)
	{
		String Name = PlayerName.getText().trim().toString();
		//BorderPane layout = new BorderPane();
		StackPane root = new StackPane();
		HBox box = new HBox(13);
		box.setAlignment(Pos.BOTTOM_CENTER);
		root.setPadding(new Insets(30));
		
		Font font = Font.font("CHLAKH", FontWeight.BOLD, 120);
		//creating the scene
		
        Text text = new Text("Choose your city, Chief "  + Name + "\n" +
        		" EveryOne is Waiting for you !");
        text.setFont(font);
        text.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(text);
        StackPane.setAlignment(text, Pos.TOP_CENTER);
        
		
		BackgroundImage bg = new BackgroundImage(new Image("horse.jpg"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1, 1, true,
						true, false, false));
		root.setBackground(new Background(bg));
		
		// CairoImage
		ImageView CairoImg = new ImageView( new Image("Cairo1.png"));
		CairoImg.setFitHeight(300);
		CairoImg.setFitWidth(300);
		CairoImg.setTranslateX(-400);
		CairoImg.setOnMouseClicked(e -> 
		{
			try {
				game = new Game( Name, "Cairo");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			MapViewScene(stage);
		}); 
		//RomeImage
		ImageView RomeImg = new ImageView( new Image("Rome1.png"));
		RomeImg.setFitHeight(300);
		RomeImg.setFitWidth(300);
		RomeImg.setOnMouseClicked(e ->
		{
			try {
				game = new Game( Name, "Rome");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			MapViewScene(stage);
		}); 
		//SpartaImage
		ImageView SpartaImg = new ImageView( new Image("Sparta1.png"));
		SpartaImg.setFitHeight(300);
		SpartaImg.setFitWidth(300);
		SpartaImg.setTranslateX(400);
		SpartaImg.setOnMouseClicked(e -> 
		{
			try {
				game = new Game( Name, "Sparta");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			MapViewScene(stage);
		}
		); 
		
		box.getChildren().addAll(CairoImg ,RomeImg , SpartaImg);
		

		root.getChildren().add(box);
		stage.setMaximized(true);
        Scene scene = new Scene(root , 1800 , 1800 );
		stage.setScene(scene);

		stage.setResizable(false);
		stage.setFullScreen(true);
		
	}
	
	public void MapViewScene(Stage stage)
	{
		StackPane root = new StackPane();
		BackgroundImage bg = new BackgroundImage(new Image("view.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1, 1, true,
						true, false, false));
		root.setBackground(new Background(bg));
		
		BorderPane grid = new BorderPane();
		//TopLabel
		String Name = PlayerName.getText().trim().toString();
		Font font = Font.font("CHLAKH", FontWeight.BOLD, 30);
		

		HBox box = new HBox();
		box.setSpacing(100);
		box.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		box.setAlignment(Pos.TOP_CENTER);
		grid.setTop(box);
		
		Text PlayerName = new Text("Chief Name : " + Name);
		PlayerName.setFont(font);
		PlayerName.setFill(Color.GOLD);
		box.getChildren().add(PlayerName);
		
		Text food = new Text("Food : " + game.getPlayer().getFood());
		food.setFont(font);
		food.setFill(Color.GOLD);
		box.getChildren().add(food);
		
		Text Gold = new Text(" Gold : " + game.getPlayer().getTreasury() );
		Gold.setFont(font);
		Gold.setFill(Color.GOLD);
		box.getChildren().add(Gold);
		
			
		Text NumTurns = new Text( " Number of Turns  : " + game.getCurrentTurnCount()+ "/" +game.getMaxTurnCount() );
		NumTurns.setFont(font);
		NumTurns.setFill(Color.GOLD);
		box.getChildren().add(NumTurns);
		
		//Creating the army menue
	
		VBox vbox = new VBox();
		
		Text idle = new Text("Idle Controlled Armies : ");
		idle.setFont(font);
		idle.setTranslateY(50);
		
		Tooltip tip = new Tooltip();
		Hyperlink army = new Hyperlink();
		ImageView armyImg = new ImageView( new Image("Army.png"));
		army.setGraphic(armyImg);
		armyImg.setFitHeight(200);
		armyImg.setFitWidth(200);
		army.setTranslateY(50);
		army.setTooltip(tip);
		if (game.getPlayer().getControlledArmies().isEmpty() )
		{
			army.setVisible(true);
			tip.setText("SABA7 EL FOL");
		}
		else
		{
			army.setVisible(true);
			tip.setText("SABA7 EL FOL");
		}
		
		
		Text marching = new Text("Your Marching Army : ");
		marching.setFont(font);
		marching.setTranslateY(100);
		
		Text Beseiging = new Text("Besieging Armies : ");
		Beseiging.setFont(font);
		Beseiging.setTranslateY(100);
		
		
		Button Rome = new Button("Rome");
		Rome.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 100px; " +
                "-fx-max-height: 100px;"
        );
		vbox.getChildren().addAll(idle , army ,marching,Beseiging , Rome);
		vbox.setSpacing(50);
		grid.setLeft(vbox);
		//root.getChildren().add(grid);
		
        Button Cairo = new Button("Cairo");
		grid.setBottom(Cairo);
		Cairo.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 100px; " +
                "-fx-max-height: 100px;"
        );
		BorderPane.setAlignment(Cairo, Pos.CENTER);
		
		//BorderPane.setAlignment(Rome, Pos.CENTER);
		Button Sparta = new Button("Sparta");
		grid.setCenter(Sparta);
		Sparta.setStyle(
                "-fx-background-radius: 5em; " +
                "-fx-min-width: 100px; " +
                "-fx-min-height: 100px; " +
                "-fx-max-width: 100px; " +
                "-fx-max-height: 100px;"
        );

		Button endTurn = new Button("ENDTURN");
		grid.setRight(endTurn);
		endTurn.setMaxHeight(300);
		endTurn.setMaxWidth(300);
		root.getChildren().add(grid);
			
		//Cities Buttons
		Cairo.setOnMouseClicked(e -> 
		{
			City city = null;
            for(City c:game.getAvailableCities())
            {
                if(c.getName().toLowerCase().equals("cairo"))
                {
                    city=c;
                }
            }

            if (!game.getPlayer().getControlledCities().contains(city))
            {
                String toastMsg = "Sorry chief , this city is not under your command ..... yet!";
                int toastMsgTime = 3500; //3.5 seconds
                int fadeInTime = 500; //0.5 seconds
                int fadeOutTime= 500; //0.5 seconds
                Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
            }
            else
            {
                CityView(stage, city);
            }
		});
		Rome.setOnMouseClicked(e -> 
		{
			City city = null;
            for(City c:game.getAvailableCities())
            {
                if(c.getName().toLowerCase().equals("rome"))
                    city=c;
            }

            if (!game.getPlayer().getControlledCities().contains(city))
            {
                String toastMsg = "Sorry chief , this city is not under your command ..... yet!";
                int toastMsgTime = 3500; //3.5 seconds
                int fadeInTime = 500; //0.5 seconds
                int fadeOutTime= 500; //0.5 seconds
                Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
            }
            else
            {
                CityView(stage, city);
            }
		});
		Sparta.setOnMouseClicked(e -> 
		{
			City city = null;
            for(City c:game.getAvailableCities())
            {
                if(c.getName().toLowerCase().equals("sparta"))
                    city=c;
            }

            if (!game.getPlayer().getControlledCities().contains(city))
            {
                String toastMsg = "Sorry chief , this city is not under your command ..... yet!";
                int toastMsgTime = 3500; //3.5 seconds
                int fadeInTime = 500; //0.5 seconds
                int fadeOutTime= 500; //0.5 seconds
                Toast.makeText(stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
            }
            else
            {
                CityView(stage, city);
            }
		});
		endTurn.setOnMouseClicked(e ->
		{
			game.endTurn();
		});
			
		Scene scene = new Scene(root, 1800 , 1800);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setFullScreen(true);
	}
	public Boolean containsCity(String name)
	{
		for ( City c : game.getPlayer().getControlledCities() )
		{
			if (c.getName().toLowerCase().equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	public ArcheryRange getArcheryRange(City city)
	{
		for(MilitaryBuilding mb:city.getMilitaryBuildings())
		{
			if(mb instanceof ArcheryRange)
				return (ArcheryRange) mb;
		}
		return null;
	}
	
	public Stable getStable(City city)
	{
		for(MilitaryBuilding mb:city.getMilitaryBuildings())
		{
			if(mb instanceof Stable)
				return (Stable) mb;
		}
		return null;
	}
	
	public Barracks getBarracks(City city)
	{
		for(MilitaryBuilding mb:city.getMilitaryBuildings())
		{
			if(mb instanceof Barracks)
				return (Barracks) mb;
		}
		return null;
	}
	
	public Farm getFarm(City city)
	{
		for(EconomicBuilding eb:city.getEconomicalBuildings())
		{
			if(eb instanceof Farm)
				return (Farm) eb;
		}
		return null;
	}
	
	public Market getMarket(City city)
	{
		for(EconomicBuilding eb:city.getEconomicalBuildings())
		{
			if(eb instanceof Market)
				return (Market) eb;
		}
		return null;
	}
	
	public void CityView(Stage window, City city)
	{
		double iconSize = 250;
		
		VBox archeryRangeUI=new VBox();
		archeryRangeUI.setAlignment(Pos.CENTER);
		Button archeryRangeButton = new Button();
		ImageView ivar = new ImageView(new Image("archeryRangeIcon.jpg"));
		ivar.setFitHeight(iconSize);
		ivar.setFitWidth(iconSize);
		archeryRangeButton.setGraphic(ivar);
		archeryRangeButton.setOnMouseClicked(me -> {
			String toastMsg;
			if(getArcheryRange(city).isCoolDown())
				toastMsg ="Level: "+getArcheryRange(city).getLevel()+"\n On Cooldown";
			else
				toastMsg="Level: "+getArcheryRange(city).getLevel();
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		});
		
		Button buildArcheryRange = new Button("Build \nCost: 1500");
		buildArcheryRange.setTextAlignment(TextAlignment.CENTER);
		buildArcheryRange.setOnMouseClicked(me -> {
			try {
				game.getPlayer().build("archeryrange", city.getName());
				CityView(window, city);
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
		});
		Button upgradeArcheryRange = new Button();
		upgradeArcheryRange.setOnMouseClicked(me -> {
			try {
				game.getPlayer().upgradeBuilding(getArcheryRange(city));
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (BuildingInCoolDownException e) {
				String toastMsg = "Building On Cooldown";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (MaxLevelException e) {
				String toastMsg = "Maximum level Reached";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		Button recruitArcher = new Button();
		recruitArcher.setOnMouseClicked(me -> {
			try {
				city.getDefendingArmy().getUnits().add(getArcheryRange(city).recruit());
			} catch (BuildingInCoolDownException e) {
				String toastMsg = "Building On Cooldown";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (MaxRecruitedException e) {
				String toastMsg = "You have recruited maximum number of archers";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		
		if(getArcheryRange(city)==null)
		{
			archeryRangeButton.setDisable(true);
			archeryRangeUI.getChildren().addAll(archeryRangeButton, buildArcheryRange);
		}
		else
		{
			archeryRangeButton.setDisable(false);
			upgradeArcheryRange.setText("Upgrade \nCost: "+getArcheryRange(city).getUpgradeCost());
			upgradeArcheryRange.setTextAlignment(TextAlignment.CENTER);
			recruitArcher.setText("Recruit \nCost: "+getArcheryRange(city).getUpgradeCost());
			recruitArcher.setTextAlignment(TextAlignment.CENTER);
			archeryRangeUI.getChildren().clear();
			archeryRangeUI.getChildren().addAll(archeryRangeButton, upgradeArcheryRange, recruitArcher);
		}
		
		VBox stableUI=new VBox();
		stableUI.setAlignment(Pos.CENTER);
		Button stableButton = new Button();
		ImageView ivst = new ImageView(new Image("stableIcon.png"));
		ivst.setFitHeight(iconSize);
		ivst.setFitWidth(iconSize);
		stableButton.setGraphic(ivst);
		stableButton.setOnMouseClicked(me -> {
			String toastMsg;
			if(getStable(city).isCoolDown())
				toastMsg ="Level: "+getStable(city).getLevel()+"\n On Cooldown";
			else
				toastMsg="Level: "+getStable(city).getLevel();
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		});
		
		Button buildStable = new Button("Build \nCost: 1500");
		buildStable.setTextAlignment(TextAlignment.CENTER);
		buildStable.setOnMouseClicked(me -> {
			try {
				game.getPlayer().build("stable", city.getName());
				CityView(window, city);
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
		});
		
		Button upgradeStable = new Button();
		upgradeStable.setOnMouseClicked(me -> {
			try {
				game.getPlayer().upgradeBuilding(getStable(city));
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (BuildingInCoolDownException e) {
				String toastMsg = "Building On Cooldown";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (MaxLevelException e) {
				String toastMsg = "Maximum level Reached";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		
		Button recruitCavalry = new Button();
		recruitCavalry.setOnMouseClicked(me -> {
			try {
				city.getDefendingArmy().getUnits().add(getStable(city).recruit());
			} catch (BuildingInCoolDownException e) {
				String toastMsg = "Building On Cooldown";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (MaxRecruitedException e) {
				String toastMsg = "You have recruited maximum number of cavalries";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		
		if(getStable(city)==null)
		{
			stableButton.setDisable(true);
			stableUI.getChildren().addAll(stableButton, buildStable);
		}
		else
		{
			stableButton.setDisable(false);
			upgradeStable.setText("Upgrade \nCost: "+getStable(city).getUpgradeCost());
			upgradeStable.setTextAlignment(TextAlignment.CENTER);
			recruitCavalry.setText("Recruit \nCost: "+getStable(city).getUpgradeCost());
			recruitCavalry.setTextAlignment(TextAlignment.CENTER);
			stableUI.getChildren().clear();
			stableUI.getChildren().addAll(stableButton, upgradeStable, recruitCavalry);
		}
		
		VBox barracksUI=new VBox();
		barracksUI.setAlignment(Pos.CENTER);
		Button barracksButton = new Button();
		ImageView ivbr = new ImageView(new Image("barracksIcon.png"));
		ivbr.setFitHeight(iconSize);
		ivbr.setFitWidth(iconSize);
		barracksButton.setGraphic(ivbr);
		barracksButton.setOnMouseClicked(me -> {
			String toastMsg;
			if(getBarracks(city).isCoolDown())
				toastMsg ="Level: "+getBarracks(city).getLevel()+"\n On Cooldown";
			else
				toastMsg="Level: "+getBarracks(city).getLevel();
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		});
		
		Button buildBarracks = new Button("Build \nCost: 1500");
		buildBarracks.setTextAlignment(TextAlignment.CENTER);
		buildBarracks.setOnMouseClicked(me -> {
			try {
				game.getPlayer().build("barracks", city.getName());
				CityView(window, city);
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
		});
		
		Button upgradeBarracks = new Button();
		upgradeBarracks.setOnMouseClicked(me -> {
			try {
				game.getPlayer().upgradeBuilding(getBarracks(city));
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (BuildingInCoolDownException e) {
				String toastMsg = "Building On Cooldown";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (MaxLevelException e) {
				String toastMsg = "Maximum level Reached";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		
		Button recruitInfantry = new Button();
		recruitInfantry.setOnMouseClicked(me -> {
			try {
				city.getDefendingArmy().getUnits().add(getBarracks(city).recruit());
			} catch (BuildingInCoolDownException e) {
				String toastMsg = "Building On Cooldown";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (MaxRecruitedException e) {
				String toastMsg = "You have recruited maximum number of infantries";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		
		if(getBarracks(city)==null)
		{
			barracksButton.setDisable(true);
			barracksUI.getChildren().addAll(barracksButton, buildBarracks);
		}
		else
		{
			barracksButton.setDisable(false);
			upgradeBarracks.setText("Upgrade \nCost: "+getBarracks(city).getUpgradeCost());
			upgradeBarracks.setTextAlignment(TextAlignment.CENTER);
			recruitInfantry.setText("Recruit \nCost: "+getBarracks(city).getUpgradeCost());
			recruitInfantry.setTextAlignment(TextAlignment.CENTER);
			barracksUI.getChildren().clear();
			barracksUI.getChildren().addAll(barracksButton, upgradeBarracks, recruitInfantry);
		}
		
		VBox farmUI = new VBox();
		farmUI.setAlignment(Pos.CENTER);
		Button farmButton = new Button();
		ImageView ivf = new ImageView(new Image("farmIcon.png"));
		ivf.setFitHeight(iconSize);
		ivf.setFitWidth(iconSize);
		farmButton.setGraphic(ivf);
		farmButton.setOnMouseClicked(me -> {
			String toastMsg;
			if(getFarm(city).isCoolDown())
				toastMsg ="Level: "+getFarm(city).getLevel()+"\n On Cooldown";
			else
				toastMsg="Level: "+getFarm(city).getLevel();
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		});
		
		Button buildFarm = new Button("Build \nCost: 1000");
		buildFarm.setTextAlignment(TextAlignment.CENTER);
		buildFarm.setOnMouseClicked(me -> {
			try {
				game.getPlayer().build("farm", city.getName());
				CityView(window, city);
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		
		Button upgradeFarm = new Button();
		upgradeFarm.setOnMouseClicked(me -> {
			try {
				game.getPlayer().upgradeBuilding(getFarm(city));
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (BuildingInCoolDownException e) {
				String toastMsg = "Building On Cooldown";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			} catch (MaxLevelException e) {
				String toastMsg = "Maximum level Reached";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		if(getFarm(city)==null)
		{
			farmButton.setDisable(true);
			farmUI.getChildren().addAll(farmButton, buildFarm);
		}
		else
		{
			farmButton.setDisable(false);
			upgradeFarm.setText("Upgrade \nCost: "+getFarm(city).getUpgradeCost());
			upgradeFarm.setTextAlignment(TextAlignment.CENTER);
			farmUI.getChildren().clear();
			farmUI.getChildren().addAll(farmButton, upgradeFarm);
		}
		
		VBox marketUI = new VBox();
		marketUI.setAlignment(Pos.CENTER);
		Button marketButton = new Button();
		marketButton.setDisable(true);
		ImageView ivm = new ImageView(new Image("marketIcon.png"));
		ivm.setFitHeight(iconSize);
		ivm.setFitWidth(iconSize);
		marketButton.setGraphic(ivm);
		marketButton.setOnMouseClicked(me -> {
			String toastMsg;
			if(getMarket(city).isCoolDown())
				toastMsg ="Level: "+getMarket(city).getLevel()+"\n On Cooldown";
			else
				toastMsg="Level: "+getMarket(city).getLevel();
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
		});
		
		Button buildMarket = new Button("Build \nCost: 1500");
		buildMarket.setTextAlignment(TextAlignment.CENTER);
		buildMarket.setOnMouseClicked(me -> {
			try {
				game.getPlayer().build("market", city.getName());
				CityView(window, city);
			} catch (NotEnoughGoldException e) {
				String toastMsg = "Not Enough Gold";
				int toastMsgTime = 3500; //3.5 seconds
				int fadeInTime = 500; //0.5 seconds
				int fadeOutTime= 500; //0.5 seconds
				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
				e.printStackTrace();
			}
        });
		Button upgradeMarket = new Button();
		upgradeMarket.setOnMouseClicked(me -> {
		try {
			game.getPlayer().upgradeBuilding(getMarket(city));
		} catch (NotEnoughGoldException e) {
			String toastMsg = "Not Enough Gold";
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
			e.printStackTrace();
		} catch (BuildingInCoolDownException e) {
			String toastMsg = "Building On Cooldown";
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
			e.printStackTrace();
		} catch (MaxLevelException e) {
			String toastMsg = "Maximum level Reached";
			int toastMsgTime = 3500; //3.5 seconds
			int fadeInTime = 500; //0.5 seconds
			int fadeOutTime= 500; //0.5 seconds
			Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
			e.printStackTrace();
		}
		});
		if(getMarket(city)==null)
		{
			marketButton.setDisable(true);
			marketUI.getChildren().addAll(marketButton, buildMarket);
		}
		else
		{
			marketButton.setDisable(false);
			upgradeMarket.setText("Upgrade \nCost: "+getMarket(city).getUpgradeCost());
			upgradeMarket.setTextAlignment(TextAlignment.CENTER);
			marketUI.getChildren().clear();
			marketUI.getChildren().addAll(marketButton, upgradeMarket);
		}
		
		VBox cityView = new VBox();
		
		String Name = PlayerName.getText().trim().toString();
		Font font = Font.font("CHLAKH", FontWeight.BOLD, 30);
		
		HBox box = new HBox();
		box.setSpacing(100);
		box.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		box.setAlignment(Pos.TOP_CENTER);
		cityView.getChildren().add(box);
		
		Button exitCity = new Button("Exit City");
		box.getChildren().add(exitCity);
		exitCity.setOnMouseClicked(me ->{
			MapViewScene(window);
		});
		
		Text PlayerName = new Text("Chief Name : " + Name);
		PlayerName.setFont(font);
		PlayerName.setFill(Color.GOLD);
		box.getChildren().add(PlayerName);
		
		Text food = new Text("Food : " + game.getPlayer().getFood());
		food.setFont(font);
		food.setFill(Color.GOLD);
		box.getChildren().add(food);
		
		Text Gold = new Text(" Gold : " + game.getPlayer().getTreasury() );
		Gold.setFont(font);
		Gold.setFill(Color.GOLD);
		box.getChildren().add(Gold);
			
		Text NumTurns = new Text( " Number of Turns  : " + game.getCurrentTurnCount()+ "/" +game.getMaxTurnCount() );
		NumTurns.setFont(font);
		NumTurns.setFill(Color.GOLD);
		box.getChildren().add(NumTurns);
		
		HBox militaryBuildings = new HBox();
		militaryBuildings.setAlignment(Pos.BASELINE_CENTER);
		militaryBuildings.getChildren().addAll(archeryRangeUI,
				stableUI, barracksUI);
		cityView.getChildren().add(militaryBuildings);
		
		HBox economicalBuildings = new HBox();
		economicalBuildings.setAlignment(Pos.BASELINE_CENTER);
		economicalBuildings.getChildren().addAll(farmUI, marketUI);
		cityView.getChildren().add(economicalBuildings);
		
		HBox armyList = new HBox();
		ImageView armyIcon = new ImageView(new Image("armyIcon.jpg"));
		armyIcon.setFitHeight(iconSize/2);
		armyIcon.setFitWidth(iconSize/2);
		armyList.getChildren().add(armyIcon);
		cityView.getChildren().add(armyList);
		
		Scene cityScene = new Scene(cityView);
//		BackgroundImage bg = new BackgroundImage(new Image("horse.jpg"),
//                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.CENTER, new BackgroundSize(1.0 ,1.0,true,true, false, false) );
//        cityView.setBackground(new Background(bg));
		window.setScene(cityScene);
		window.setFullScreen(true);
		window.setResizable(false);
		window.show();
	}
	
	public void BattleView( Stage stage /*, Army attacking , Army defending*/)
	{
		Font font = Font.font("CHLAKH", FontWeight.BOLD, 30);
		String name = PlayerName.getText().trim().toString();
		Unit u1 = new Archer(1, 30, 0.5, 0.5, 0.5);
		Unit u2 = new Infantry(2, 30, 0.5, 0.5, 0.5);
		Unit u3 = new Cavalry(1, 30, 0.5, 0.5, 0.5);
		Unit u4 = new Archer(2, 30, 0.5, 0.5, 0.5);
		Unit u5 = new Infantry(3, 30, 0.5, 0.5, 0.5);
		Unit u6 = new Cavalry(2, 30, 0.5, 0.5, 0.5);
		Unit u7 = new Archer(2, 30, 0.5, 0.5, 0.5);
		Unit u8 = new Infantry(1, 30, 0.5, 0.5, 0.5);
		Unit u9 = new Cavalry(2, 30, 0.5, 0.5, 0.5);
		Unit u10 = new Archer(3, 30, 0.5, 0.5, 0.5);
		Unit u11 = new Infantry(1, 30, 0.5, 0.5, 0.5);
		Unit u12 = new Cavalry(3, 30, 0.5, 0.5, 0.5);
		Unit u13 = new Archer(1, 30, 0.5, 0.5, 0.5);
		Unit u14 = new Infantry(2, 30, 0.5, 0.5, 0.5);
		Unit u15 = new Cavalry(2, 30, 0.5, 0.5, 0.5);

		Army defending = new Army("shalaby");
		Army attacking = new Army("medhat");
		defending.getUnits().add(u1);
		defending.getUnits().add(u2);
		defending.getUnits().add(u3);
		defending.getUnits().add(u4);
		defending.getUnits().add(u5);
		defending.getUnits().add(u6);
		defending.getUnits().add(u7);
		attacking.getUnits().add(u8);
		attacking.getUnits().add(u9);
		attacking.getUnits().add(u10);
		attacking.getUnits().add(u11);
		attacking.getUnits().add(u12);
		attacking.getUnits().add(u13);
		attacking.getUnits().add(u14);
		attacking.getUnits().add(u15);
		u1.setParentArmy(defending);
		u2.setParentArmy(defending);
		u3.setParentArmy(defending);
		u4.setParentArmy(defending);
		u5.setParentArmy(defending);
		u6.setParentArmy(defending);
		u7.setParentArmy(defending);
		u8.setParentArmy(attacking);
		u9.setParentArmy(attacking);
		u10.setParentArmy(attacking);
		u11.setParentArmy(attacking);
		u12.setParentArmy(attacking);
		u13.setParentArmy(attacking);
		u14.setParentArmy(attacking);
		u15.setParentArmy(attacking);

		BorderPane root = new BorderPane();

		BackgroundImage bg = new BackgroundImage(new Image("BattleGround.jpg"), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(1.0, 1.0, true, true, false, false));
		root.setBackground(new Background(bg));

		Text Title = new Text("Player Army");
		Title.setStyle("-fx-font: 30 arial;");
		Title.setTextAlignment(TextAlignment.CENTER);

		Image arch = new Image("archer.png");
		ImageView archers = new ImageView(arch);
		archers.setFitHeight(150);
		archers.setFitWidth(150);

		Image inf = new Image("Infantry.png");
		ImageView infantry = new ImageView(inf);
		infantry.setFitHeight(150);
		infantry.setFitWidth(150);

		Image cav = new Image("Cavalry.png");
		ImageView cavlary = new ImageView(cav);
		cavlary.setFitHeight(150);
		cavlary.setFitWidth(150);

		VBox vboxleft = new VBox(Title, archers, cavlary, infantry);
		root.setLeft(vboxleft);

		Text TitleE = new Text("Enemy Army");
		TitleE.setStyle("-fx-font: 30 arial;");
		TitleE.setTextAlignment(TextAlignment.CENTER);

		Image archE = new Image("archerE.png");
		ImageView archersE = new ImageView(archE);
		archersE.setFitHeight(150);
		archersE.setFitWidth(150);

		Image infE = new Image("barbarian.png");
		ImageView infantryE = new ImageView(infE);
		infantryE.setFitHeight(150);
		infantryE.setFitWidth(150);

		Image cavE = new Image("hogrider.png");
		ImageView cavlaryE = new ImageView(cavE);
		cavlaryE.setFitHeight(150);
		cavlaryE.setFitWidth(150);

		VBox vboxright = new VBox(TitleE, archersE, cavlaryE, infantryE);
		root.setRight(vboxright);

		Text text = new Text();
		text.setStyle("-fx-font: 30 arial;");
		text.setFill(Color.WHITE);
		text.setVisible(false);
		VBox vboxtop=new VBox();
		HBox box = new HBox();
		box.setSpacing(100);
		box.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		box.setAlignment(Pos.TOP_CENTER);
		
		Text PlayerName = new Text("Chief Name : " + name);
		PlayerName.setFont(font);
		PlayerName.setFill(Color.GOLD);
		box.getChildren().add(PlayerName);
		
		Text food = new Text("Food : " + game.getPlayer().getFood());
		food.setFont(font);
		food.setFill(Color.GOLD);
		box.getChildren().add(food);
		
		Text Gold = new Text(" Gold : " + game.getPlayer().getTreasury() );
		Gold.setFont(font);
		Gold.setFill(Color.GOLD);
		box.getChildren().add(Gold);
		
			
		Text NumTurns = new Text( " Number of Turns  : " + game.getCurrentTurnCount()+ "/" +game.getMaxTurnCount() );
		NumTurns.setFont(font);
		NumTurns.setFill(Color.GOLD);
		box.getChildren().add(NumTurns);
		HBox hboxtop = new HBox();
		
		vboxtop.getChildren().add(box);
		vboxtop.getChildren().add(hboxtop);

		Button attackbutton = new Button();
		attackbutton.setMinHeight(125);
		attackbutton.setMinWidth(125);
		attackbutton.setText("ATTACK");
		Text t = new Text();
		t.setText("                                          ");
		Text z = new Text();
		z.setText("CHOOSE THE UNIT YOU WANT TO ATTACK WITH " + "\n" + "AND THE OPPOSING UNIT");
		z.setTextAlignment(TextAlignment.CENTER);
		z.setStyle("-fx-font: 30 arial;");
		z.setFill(Color.WHITE);
		hboxtop.setSpacing(20);
		Button autoresolvebutton = new Button();
		autoresolvebutton.setMinHeight(125);
		autoresolvebutton.setMinWidth(125);
		autoresolvebutton.setText("AUTORESOLVE");
		hboxtop.getChildren().add(t);
		hboxtop.getChildren().add(attackbutton);
		hboxtop.getChildren().add(z);
		hboxtop.getChildren().add(autoresolvebutton);
		root.setTop(vboxtop);

		HBox hboxcenter = new HBox();
		hboxcenter.setAlignment(Pos.CENTER);
		VBox vboxcenterleft = new VBox();
		VBox vboxcenter = new VBox();
		Button exitbutton = new Button("LEAVE BATTLE VIEW");
		exitbutton.setMinHeight(150);
		exitbutton.setMinWidth(150);
		exitbutton.setAlignment(Pos.CENTER);
		exitbutton.setVisible(false);
		vboxcenter.setAlignment(Pos.CENTER);
		vboxcenter.getChildren().add(exitbutton);
		vboxcenter.getChildren().add(text);
		VBox vboxcenterright = new VBox();
		vboxcenterleft.setAlignment(Pos.CENTER);
		vboxcenterright.setAlignment(Pos.CENTER);
		hboxcenter.getChildren().add(vboxcenterleft);
		hboxcenter.getChildren().add(vboxcenter);
		hboxcenter.getChildren().add(vboxcenterright);
		root.setCenter(hboxcenter);

		ArrayList<String> combo = new ArrayList<String>();
		ComboBox<String> comboboxA = new ComboBox<String>(FXCollections.observableArrayList(combo));
		ComboBox<String> comboboxAE = new ComboBox<String>(FXCollections.observableArrayList(combo));
		ComboBox<String> comboboxC = new ComboBox<String>(FXCollections.observableArrayList(combo));
		ComboBox<String> comboboxCE = new ComboBox<String>(FXCollections.observableArrayList(combo));
		ComboBox<String> comboboxI = new ComboBox<String>(FXCollections.observableArrayList(combo));
		ComboBox<String> comboboxIE = new ComboBox<String>(FXCollections.observableArrayList(combo));
		comboboxA.setVisible(false);
		comboboxAE.setVisible(false);
		comboboxC.setVisible(false);
		comboboxCE.setVisible(false);
		comboboxI.setVisible(false);
		comboboxIE.setVisible(false);
		TextArea log = new TextArea();
		log.setMaxHeight(100);
		log.setVisible(true);
		log.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		root.setBottom(log);
		vboxcenterleft.getChildren().add(comboboxA);
		vboxcenterright.getChildren().add(comboboxAE);
		vboxcenterleft.getChildren().add(comboboxC);
		vboxcenterright.getChildren().add(comboboxCE);
		vboxcenterleft.getChildren().add(comboboxI);
		vboxcenterright.getChildren().add(comboboxIE);

		attackbutton.setOnMouseClicked(event -> {
			Unit unit = null;
			Boolean attacked=false;

			if (comboboxAE.getItems().indexOf(comboboxAE.getValue()) == -1 && comboboxAE.isVisible()) {
				String logtext = new String();
				logtext = "NO MORE ARCHERY UNITS TO ATTACK \n";
				log.setText(log.getText() + logtext);
				log.appendText("");
				return;
			}
			if (comboboxCE.getItems().indexOf(comboboxCE.getValue()) == -1 && comboboxCE.isVisible()) {
				String logtext = new String();
				logtext = "NO MORE CAVLARY UNITS TO ATTACK \n";
				log.setText(log.getText() + logtext);
				log.appendText("");
				return;
			}

			if (comboboxIE.getItems().indexOf(comboboxIE.getValue()) == -1 && comboboxIE.isVisible()) {
				String logtext = new String();
				logtext = "NO MORE INFANTRY UNITS TO ATTACK \n";
				log.setText(log.getText() + logtext);
				log.appendText("");
				return;
			}

			if (comboboxAE.getValue() != null && comboboxAE.isVisible())
				unit = ArcherToArmy(defending).get(comboboxAE.getItems().indexOf(comboboxAE.getValue()));

			if (comboboxIE.getValue() != null && comboboxIE.isVisible()
					&& comboboxIE.getItems().indexOf(comboboxIE.getValue()) != -1)
				unit = InfantryToArmy(defending).get(comboboxIE.getItems().indexOf(comboboxIE.getValue()));

			if (comboboxCE.getValue() != null && comboboxCE.isVisible()
					&& comboboxCE.getItems().indexOf(comboboxCE.getValue()) != -1)
				unit = CavalryToArmy(defending).get(comboboxCE.getItems().indexOf(comboboxCE.getValue()));

			if (comboboxA.getValue() != null && comboboxA.isVisible()) {

				int x = unit.getCurrentSoldierCount();
				int y = 0;
				try {
					ArcherToArmy(attacking).get(comboboxA.getItems().indexOf(comboboxA.getValue())).attack(unit);
				} catch (FriendlyFireException e) {
					e.printStackTrace();
				}
				y = unit.getCurrentSoldierCount();
				String logtext = new String();
				if (unit instanceof Archer) {
					if (y != 0)
						logtext = "ENEMY ARCHER UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY ARCHER UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < ArcherToArmy(defending).size(); i++) {
						combo.add(ArcherToArmy(defending).get(i).toString());
					}

					comboboxAE.getItems().setAll(combo);
					attacked=true;
				}
				if (unit instanceof Infantry) {
					if (y != 0)
						logtext = "ENEMY INFANTRY UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY INFANTRY UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < InfantryToArmy(defending).size(); i++) {
						combo.add(InfantryToArmy(defending).get(i).toString());
					}

					comboboxIE.getItems().setAll(combo);
					attacked=true;
				}
				if (unit instanceof Cavalry) {
					if (y != 0)
						logtext = "ENEMY CAVLARY UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY CAVLARY UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < CavalryToArmy(defending).size(); i++) {
						combo.add(CavalryToArmy(defending).get(i).toString());
					}

					comboboxCE.getItems().setAll(combo);
					attacked=true;
				}
				log.setText(log.getText() + logtext);
				log.appendText("");

			}

			if (comboboxC.getValue() != null && comboboxC.isVisible()) {
				int x = unit.getCurrentSoldierCount();
				int y = 0;
				try {
					CavalryToArmy(attacking).get(comboboxC.getItems().indexOf(comboboxC.getValue())).attack(unit);
				} catch (FriendlyFireException e) {
					e.printStackTrace();
				}
				y = unit.getCurrentSoldierCount();
				String logtext = new String();
				if (unit instanceof Archer) {
					if (y != 0)
						logtext = "ENEMY ARCHER UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY ARCHER UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < ArcherToArmy(defending).size(); i++) {
						combo.add(ArcherToArmy(defending).get(i).toString());
					}

					comboboxAE.getItems().setAll(combo);
					attacked=true;
				}
				if (unit instanceof Infantry) {
					if (y != 0)
						logtext = "ENEMY INFANTRY UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY INFANTRY UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < InfantryToArmy(defending).size(); i++) {
						combo.add(InfantryToArmy(defending).get(i).toString());
					}

					comboboxIE.getItems().setAll(combo);
					attacked=true;
				}
				if (unit instanceof Cavalry) {
					if (y != 0)
						logtext = "ENEMY CAVLARY UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY CAVLARY UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < CavalryToArmy(defending).size(); i++) {
						combo.add(CavalryToArmy(defending).get(i).toString());
					}

					comboboxCE.getItems().setAll(combo);
					attacked=true;
				}
				log.setText(log.getText() + logtext);
				log.appendText("");
			}

			if (comboboxI.getValue() != null && comboboxI.isVisible()) {
				int x = unit.getCurrentSoldierCount();
				int y = 0;
				try {
					InfantryToArmy(attacking).get(comboboxI.getItems().indexOf(comboboxI.getValue())).attack(unit);
				} catch (FriendlyFireException e) {

					e.printStackTrace();
				}
				y = unit.getCurrentSoldierCount();
				String logtext = new String();
				if (unit instanceof Archer) {
					if (y != 0)
						logtext = "ENEMY ARCHER UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY ARCHER UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < ArcherToArmy(defending).size(); i++) {
						combo.add(ArcherToArmy(defending).get(i).toString());
					}

					comboboxAE.getItems().setAll(combo);
					attacked=true;
				}
				if (unit instanceof Infantry) {
					if (y != 0)
						logtext = "ENEMY INFANTRY UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY INFANTRY UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < InfantryToArmy(defending).size(); i++) {
						combo.add(InfantryToArmy(defending).get(i).toString());
					}

					comboboxIE.getItems().setAll(combo);
					attacked=true;
				}
				if (unit instanceof Cavalry) {
					if (y != 0)
						logtext = "ENEMY CAVLARY UNIT JUST LOST " + (x - y) + " SOLDIERS GOOD JOB!!! \n";
					else
						logtext = "ENEMY CAVLARY UNIT JUST GOT DESTROYED WAY TO GO CHEIF!!! \n";
					combo.clear();
					for (int i = 0; i < CavalryToArmy(defending).size(); i++) {
						combo.add(CavalryToArmy(defending).get(i).toString());
					}

					comboboxCE.getItems().setAll(combo);
					attacked=true;
				}
				log.setText(log.getText() + logtext);
				log.appendText("");

			}
			if (attacking.getUnits().size() == 0 || defending.getUnits().size() == 0) {
				String logtext = new String();
				if (attacking.getUnits().size() != 0) {
					logtext = "YOU WON THIS BATTLE CHIEF!!! \n CONGRATULATIONS!!!!!";
				} else if (defending.getUnits().size() != 0) {
					logtext = "YOU LOST THIS BATTLE CHIEF :( \n BETTER LUCK NEXT TIME";
				}
				log.setText(log.getText() + logtext);
				log.appendText("");
				exitbutton.setVisible(true);

			}

			if(attacked)
			{Unit a = null;
			Unit b = null;
			a = attacking.getUnits().get((int) (Math.random() * attacking.getUnits().size()));
			b = defending.getUnits().get((int) (Math.random() * defending.getUnits().size()));
			int c = a.getCurrentSoldierCount();
			try {
				b.attack(a);
			} catch (FriendlyFireException e) {
				e.printStackTrace();
			}
			int d = a.getCurrentSoldierCount();

			String logtext = null;
			if (a instanceof Archer) {
				if (d != 0) {
					logtext = "CHEIF THEY COUNTER ATTACKED AND WE LOST " + (c - d)
							+ " SOLDIERS FROM OUR ARCHER UNIT \n";
				} else {
					logtext = "CHEIF THEY DESTROYED ONE OF OUR ARCHER UNITS!! \n";
					
				}
			}

			if (a instanceof Cavalry) {
				if (d != 0) {
					logtext = "CHEIF THEY COUNTER ATTACKED AND WE LOST " + (c - d)
							+ " SOLDIERS FROM OUR CAVLARY UNIT \n";
				} else {
					logtext = "CHEIF THEY DESTROYED ONE OF OUR CAVLARY UNITS!! \n";
					
				}
			}

			if (a instanceof Infantry) {
				if (d != 0) {
					logtext = "CHEIF THEY COUNTER ATTACKED AND WE LOST " + (c - d)
							+ " SOLDIERS FROM OUR INFANTRY UNIT \n";
				} else {
					logtext = "CHEIF THEY DESTROYED ONE OF OUR INFANTRY UNITS!! \n";
					
				}

			}
			log.setText(log.getText() + logtext);
			log.appendText("");}
			
			combo.clear();
			for (int i = 0; i < ArcherToArmy(attacking).size(); i++) {
				combo.add(ArcherToArmy(attacking).get(i).toString());
			}

			comboboxA.getItems().setAll(combo);
			
			combo.clear();
			for (int i = 0; i < CavalryToArmy(attacking).size(); i++) {
				combo.add(CavalryToArmy(attacking).get(i).toString());
			}

			comboboxC.getItems().setAll(combo);
			
			combo.clear();
			for (int i = 0; i < InfantryToArmy(attacking).size(); i++) {
				combo.add(InfantryToArmy(attacking).get(i).toString());
			}

			comboboxI.getItems().setAll(combo);
			
			
		});

		exitbutton.setOnMouseClicked(event -> {
			//stage.close(); // switch scene here
			MapViewScene(stage);
		});

		autoresolvebutton.setOnMouseClicked(event -> {
			try {
				Game.autoResolve(attacking, defending);
				if (attacking.getUnits().size() == 0 || defending.getUnits().size() == 0) {
					String logtext = new String();
					if (attacking.getUnits().size() != 0) {
						logtext = "YOU WON THIS BATTLE CHIEF!!! \n CONGRATULATIONS!!!!!";
					} else if (defending.getUnits().size() != 0) {
						logtext = "YOU LOST THIS BATTLE CHIEF :( \n BETTER LUCK NEXT TIME";
					}
					log.setText(log.getText() + logtext);
					log.appendText("");
					exitbutton.setVisible(true);
				}
			} catch (FriendlyFireException e) {
				e.printStackTrace();
			}
		});

		archers.setOnMouseEntered(event -> {

			String textbox = new String();
			for (Unit u : ArcherToArmy(attacking)) {
				textbox += u.toString();
			}
			text.setText(textbox);
			if (textbox.length() == 0) {
				text.setText("NO UNITS");
			}
			text.setVisible(true);

		});

		archers.setOnMouseClicked(event -> {
			comboboxA.setVisible(true);
			comboboxC.setVisible(false);
			comboboxI.setVisible(false);

			combo.clear();
			for (int i = 0; i < ArcherToArmy(attacking).size(); i++) {
				combo.add(ArcherToArmy(attacking).get(i).toString());
			}

			comboboxA.getItems().setAll(combo);

		});

		infantry.setOnMouseClicked(event -> {
			comboboxA.setVisible(false);
			comboboxC.setVisible(false);
			comboboxI.setVisible(true);

			combo.clear();
			for (int i = 0; i < InfantryToArmy(attacking).size(); i++) {
				combo.add(InfantryToArmy(attacking).get(i).toString());
			}

			comboboxI.getItems().setAll(combo);

		});

		cavlary.setOnMouseClicked(event -> {
			comboboxA.setVisible(false);
			comboboxC.setVisible(true);
			comboboxI.setVisible(false);

			combo.clear();
			for (int i = 0; i < CavalryToArmy(attacking).size(); i++) {
				combo.add(CavalryToArmy(attacking).get(i).toString());
			}

			comboboxC.getItems().setAll(combo);

		});

		archersE.setOnMouseClicked(event -> {

			comboboxAE.setVisible(true);
			comboboxCE.setVisible(false);
			comboboxIE.setVisible(false);
			combo.clear();
			for (int i = 0; i < ArcherToArmy(defending).size(); i++) {
				combo.add(ArcherToArmy(defending).get(i).toString());
			}

			comboboxAE.getItems().setAll(combo);

		});

		infantryE.setOnMouseClicked(event -> {
			comboboxAE.setVisible(false);
			comboboxCE.setVisible(false);
			comboboxIE.setVisible(true);
			combo.clear();
			for (int i = 0; i < InfantryToArmy(defending).size(); i++) {
				combo.add(InfantryToArmy(defending).get(i).toString());
			}

			comboboxIE.getItems().setAll(combo);

		});

		cavlaryE.setOnMouseClicked(event -> {
			comboboxAE.setVisible(false);
			comboboxCE.setVisible(true);
			comboboxIE.setVisible(false);
			combo.clear();
			for (int i = 0; i < CavalryToArmy(defending).size(); i++) {
				combo.add(CavalryToArmy(defending).get(i).toString());
			}

			comboboxCE.getItems().setAll(combo);

		});

		archers.setOnMouseExited(event -> {
			text.setVisible(false);
		});

		archersE.setOnMouseEntered(event -> {
			String textbox = new String();
			for (Unit u : ArcherToArmy(defending)) {
				textbox += u.toString();
			}
			text.setText(textbox);
			if (textbox.length() == 0) {
				text.setText("NO UNITS");
			}
			text.setVisible(true);

		});

		archersE.setOnMouseExited(event -> {
			text.setVisible(false);
		});

		infantry.setOnMouseEntered(event -> {
			String textbox = new String();
			for (Unit u : InfantryToArmy(attacking)) {
				textbox += u.toString();
			}
			text.setText(textbox);
			if (textbox.length() == 0) {
				text.setText("NO UNITS");
			}
			text.setVisible(true);

		});

		infantry.setOnMouseExited(event -> {
			text.setVisible(false);
		});

		infantryE.setOnMouseEntered(event -> {

			String textbox = new String();
			for (Unit u : InfantryToArmy(defending)) {
				textbox += u.toString();
			}
			text.setText(textbox);
			if (textbox.length() == 0) {
				text.setText("NO UNITS");
			}
			text.setVisible(true);

		});

		infantryE.setOnMouseExited(event -> {
			text.setVisible(false);
		});

		cavlary.setOnMouseEntered(event -> {
			String textbox = new String();
			for (Unit u : CavalryToArmy(attacking)) {
				textbox += u.toString();
			}
			text.setText(textbox);
			if (textbox.length() == 0) {
				text.setText("NO UNITS");
			}
			text.setVisible(true);

		});

		cavlary.setOnMouseExited(event -> {
			text.setVisible(false);
		});

		cavlaryE.setOnMouseEntered(event -> {
			String textbox = new String();
			for (Unit u : CavalryToArmy(defending)) {
				textbox += u.toString();
			}
			text.setText(textbox);
			if (textbox.length() == 0) {
				text.setText("NO UNITS");
			}
			text.setVisible(true);

		});

		cavlaryE.setOnMouseExited(event -> {
			text.setVisible(false);
		});

		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setResizable(false);
		stage.show();

	}
	public ArrayList<Unit> ArcherToArmy(Army army) {

		ArrayList<Unit> output = new ArrayList<Unit>();

		for (Unit u : army.getUnits()) {

			if (u instanceof Archer) {
				output.add(u);
			}
		}
		return output;
	}
	public ArrayList<Unit> InfantryToArmy(Army army) {

		ArrayList<Unit> output = new ArrayList<Unit>();

		for (Unit u : army.getUnits()) {

			if (u instanceof Infantry) {
				output.add(u);
			}
		}
		return output;
	}
	public ArrayList<Unit> CavalryToArmy(Army army) {

		ArrayList<Unit> output = new ArrayList<Unit>();

		for (Unit u : army.getUnits()) {

			if (u instanceof Cavalry) {
				output.add(u);
			}
		}
		return output;
	}
	public int getNumArmy()
	{
		int count =0 ;
		for ( Army a : game.getPlayer().getControlledArmies())
		{
			count++;
		}
		return count;
	}
	
	
}
