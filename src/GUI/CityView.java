//package GUI;
//
//import java.util.ArrayList;
//
//import buildings.ArcheryRange;
//import buildings.Barracks;
//import buildings.Building;
//import buildings.Farm;
//import buildings.Market;
//import buildings.Stable;
//import engine.Player;
//import exceptions.BuildingInCoolDownException;
//import exceptions.MaxLevelException;
//import exceptions.MaxRecruitedException;
//import exceptions.NotEnoughGoldException;
//import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.*;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BackgroundFill;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.CornerRadii;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.RowConstraints;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;
//
//public class CityView extends Application
//{
//	private ArcheryRange archeryRange = new ArcheryRange();
//	private Stable stable = new Stable();
//	private Barracks barracks = new Barracks();
//	private Farm farm = new Farm();
//	private Market market = new Market();
//	private Player player = new Player("Bassel");
//	private String cityName="Cairo";
//	
//	public static void main(String[] args)
//	{
//		launch(args);
//	}
//	
//	public void start(javafx.stage.Stage window) throws Exception
//	{
//		player.setTreasury(10000);
//		archeryRange.getBuildingButton().setDisable(true);
//		stable.getBuildingButton().setDisable(true);
//		barracks.getBuildingButton().setDisable(true);
//		farm.getBuildingButton().setDisable(true);
//		market.getBuildingButton().setDisable(true);
//		archeryRange.setCoolDown(false);
//		stable.setCoolDown(false);
//		barracks.setCoolDown(false);
//		farm.setCoolDown(false);
//		market.setCoolDown(false);
//		
//		VBox cityView = new VBox();
//		
//		StackPane buildUpgardeArcheryRange = new StackPane();
//		Button buildArcheryRange = new Button("Build \nCost: "+archeryRange.getCost());
//		buildArcheryRange.setTextAlignment(TextAlignment.CENTER);
//		Button upgradeArcheryRange = new Button("Upgrade \nCost: "+archeryRange.getUpgradeCost());
//		upgradeArcheryRange.setTextAlignment(TextAlignment.CENTER);
//		upgradeArcheryRange.setVisible(false);
//		buildUpgardeArcheryRange.getChildren().addAll(buildArcheryRange, upgradeArcheryRange);
//		
//		VBox archeryRangeStack = new VBox();
//		archeryRangeStack.setAlignment(Pos.BOTTOM_CENTER);
//		Button recruitArcher = new Button("Recruit \nCost: "+archeryRange.getRecruitmentCost());
//		recruitArcher.setVisible(false);
//		archeryRangeStack.getChildren().addAll(archeryRange.getBuildingButton(), 
//				buildUpgardeArcheryRange, recruitArcher);
//		
//		StackPane buildUpgardeStable = new StackPane();
//		Button buildStable = new Button("Build \nCost: "+stable.getCost());
//		buildStable.setTextAlignment(TextAlignment.CENTER);
//		Button upgradeStable = new Button("Upgrade \nCost: "+stable.getUpgradeCost());
//		upgradeStable.setTextAlignment(TextAlignment.CENTER);
//		upgradeStable.setVisible(false);
//		buildUpgardeStable.getChildren().addAll(buildStable, upgradeStable);
//		
//		VBox stableStack = new VBox();
//		stableStack.setAlignment(Pos.BOTTOM_CENTER);
//		Button recruitCavalry = new Button("Recruit \nCost: "+stable.getRecruitmentCost());
//		recruitCavalry.setVisible(false);
//		stableStack.getChildren().addAll(stable.getBuildingButton(), buildUpgardeStable, recruitCavalry);
//		
//		StackPane buildUpgradeBarracks = new StackPane();
//		Button buildBarracks = new Button("Build \nCost: "+barracks.getCost());
//		buildBarracks.setTextAlignment(TextAlignment.CENTER);
//		Button upgradeBarracks = new Button("Upgrade \nCost: "+barracks.getUpgradeCost());
//		upgradeBarracks.setTextAlignment(TextAlignment.CENTER);
//		upgradeBarracks.setVisible(false);
//		buildUpgradeBarracks.getChildren().addAll(buildBarracks, upgradeBarracks);
//		
//		VBox barracksStack = new VBox();
//		barracksStack.setAlignment(Pos.BOTTOM_CENTER);
//		Button recruitInfantary = new Button("Recruit \nCost: "+barracks.getRecruitmentCost());
//		recruitInfantary.setVisible(false);
//		barracksStack.getChildren().addAll(barracks.getBuildingButton(), buildUpgradeBarracks,
//				recruitInfantary);
//		
//		StackPane buildUpgradeFarm = new StackPane();
//		Button buildFarm = new Button("Build \nCost: "+farm.getCost());
//		buildArcheryRange.setTextAlignment(TextAlignment.CENTER);
//		Button upgradeFarm = new Button("Upgrade \nCost: "+farm.getUpgradeCost());
//		upgradeFarm.setTextAlignment(TextAlignment.CENTER);
//		upgradeFarm.setVisible(false);
//		buildUpgradeFarm.getChildren().addAll(buildFarm, upgradeFarm);
//		
//		VBox farmStack = new VBox();
//		farmStack.setAlignment(Pos.BOTTOM_CENTER);
//		Button harvestFarm = new Button("Harvest");
//		harvestFarm.setVisible(false);
//		farmStack.getChildren().addAll(farm.getBuildingButton(), buildUpgradeFarm, harvestFarm);
//		
//		StackPane buildUpgradeMarket = new StackPane();
//		Button buildMarket = new Button("Build \nCost: "+market.getCost());
//		buildMarket.setTextAlignment(TextAlignment.CENTER);
//		Button upgradeMarket = new Button("Upgrade \nCost: "+market.getUpgradeCost());
//		upgradeMarket.setTextAlignment(TextAlignment.CENTER);
//		upgradeMarket.setVisible(false);
//		buildUpgradeMarket.getChildren().addAll(buildMarket, upgradeMarket);
//		
//		VBox marketStack = new VBox();
//		marketStack.setAlignment(Pos.BOTTOM_CENTER);
//		Button harvestMarket = new Button("Harvest");
//		harvestMarket.setVisible(false);
//		marketStack.getChildren().addAll(market.getBuildingButton(), buildUpgradeMarket, harvestMarket);
//		
//		HBox militaryBuildings = new HBox();
//		militaryBuildings.setAlignment(Pos.BASELINE_CENTER);
//		militaryBuildings.getChildren().addAll(archeryRangeStack, stableStack, barracksStack);
//		buildArcheryRange.setTextAlignment(TextAlignment.CENTER);
//		cityView.getChildren().add(militaryBuildings);
//		
//		HBox economicalBuildings = new HBox();
//		economicalBuildings.setAlignment(Pos.BASELINE_CENTER);
//		economicalBuildings.getChildren().addAll(farmStack, marketStack);
//		buildArcheryRange.setTextAlignment(TextAlignment.CENTER);
//		cityView.getChildren().add(economicalBuildings);
//		
//		archeryRange.getBuildingButton().setOnMouseEntered(me -> {
//            archeryRange.displayInfo();
//        });
//		stable.getBuildingButton().setOnMouseEntered(me -> {
//            stable.displayInfo();
//        });
//		barracks.getBuildingButton().setOnMouseEntered(me -> {
//            barracks.displayInfo();
//        });
//		farm.getBuildingButton().setOnMouseEntered(me -> {
//            farm.displayInfo();
//        });
//		market.getBuildingButton().setOnMouseEntered(me -> {
//            market.displayInfo();
//        });
//		
//		buildArcheryRange.setOnMouseClicked(me -> {
//			try {
//				player.build("archeryrange", cityName);
//				archeryRange.getBuildingButton().setDisable(false);
//				recruitArcher.setVisible(true);
//				upgradeArcheryRange.setVisible(true);
//				buildArcheryRange.setVisible(false);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		buildStable.setOnMouseClicked(me -> {
//			try {
//				player.build("stable", cityName);
//				stable.getBuildingButton().setDisable(false);
//				recruitCavalry.setVisible(true);
//				upgradeStable.setVisible(true);
//				buildStable.setVisible(false);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		buildBarracks.setOnMouseClicked(me -> {
//			try {
//				player.build("barracks", cityName);
//				barracks.getBuildingButton().setDisable(false);
//				recruitInfantary.setVisible(true);
//				upgradeBarracks.setVisible(true);
//				buildBarracks.setVisible(false);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		buildFarm.setOnMouseClicked(me -> {
//			try {
//				player.build("farm", cityName);
//				farm.getBuildingButton().setDisable(false);
//				harvestFarm.setVisible(true);
//				upgradeFarm.setVisible(true);
//				buildFarm.setVisible(false);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		buildMarket.setOnMouseClicked(me -> {
//			try {
//				player.build("market", cityName);
//				market.getBuildingButton().setDisable(false);
//				harvestMarket.setVisible(true);
//				upgradeMarket.setVisible(true);
//				buildMarket.setVisible(false);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		
//		upgradeArcheryRange.setOnMouseClicked(me -> {
//			try {
//				player.upgradeBuilding(archeryRange);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxLevelException e) {
//				String toastMsg = "Maximum level Reached";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		upgradeStable.setOnMouseClicked(me -> {
//			try {
//				player.upgradeBuilding(stable);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxLevelException e) {
//				String toastMsg = "Maximum level Reached";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		upgradeBarracks.setOnMouseClicked(me -> {
//			try {
//				player.upgradeBuilding(barracks);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxLevelException e) {
//				String toastMsg = "Maximum level Reached";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		upgradeFarm.setOnMouseClicked(me -> {
//			try {
//				player.upgradeBuilding(farm);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxLevelException e) {
//				String toastMsg = "Maximum level Reached";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		upgradeMarket.setOnMouseClicked(me -> {
//			try {
//				player.upgradeBuilding(market);
//			} catch (NotEnoughGoldException e) {
//				String toastMsg = "Not Enough Gold";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxLevelException e) {
//				String toastMsg = "Maximum level Reached";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		
//		recruitArcher.setOnMouseClicked(me -> {
//			try {
//				archeryRange.recruit();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxRecruitedException e) {
//				String toastMsg = "You have recruited maximum number of archers";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		
//		recruitCavalry.setOnMouseClicked(me -> {
//			try {
//				stable.recruit();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxRecruitedException e) {
//				String toastMsg = "You have recruited maximum number of cavalries";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		
//		recruitInfantary.setOnMouseClicked(me -> {
//			try {
//				barracks.recruit();
//			} catch (BuildingInCoolDownException e) {
//				String toastMsg = "Building On Cooldown";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			} catch (MaxRecruitedException e) {
//				String toastMsg = "You have recruited maximum number of infantries";
//				int toastMsgTime = 3500; //3.5 seconds
//				int fadeInTime = 500; //0.5 seconds
//				int fadeOutTime= 500; //0.5 seconds
//				Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
//				e.printStackTrace();
//			}
//        });
//		
//		harvestFarm.setOnMouseClicked(me -> {
//			farm.harvest();
//        });
//		
//		harvestMarket.setOnMouseClicked(me -> {
//			market.harvest();
//        });
//		
////		HBox armyList = new HBox();
////		ImageView armyIcon = new ImageView(new Image("armyIcon.jpg"));
////		double iconSize = 200;
////		armyIcon.setFitHeight(iconSize);
////		armyIcon.setFitWidth(iconSize);
////		armyList.getChildren().add(armyIcon);
////		armyList.getChildren().add(armyIcon);
////		cityView.getChildren().add(armyList);
//		
//		Scene cityScene = new Scene(cityView);
//		window.setScene(cityScene);
//		window.setMaximized(true);
//		window.setResizable(false);
//		window.show();
//	}
//}