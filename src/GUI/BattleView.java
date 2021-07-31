package GUI;

import java.util.ArrayList;
import java.util.List;

import exceptions.FriendlyFireException;
import javafx.animation.PauseTransition;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import javafx.util.Duration;
import units.*;
import engine.*;

public class BattleView extends Application {

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

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
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

		Stage stage = new Stage();
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
		HBox hboxtop = new HBox();
		
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
			stage.close(); // switch scene here

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

	
	/*  public String toString() { String output= new String();
	  output="Current Soldier Count:"+ this.currentSoldierCount + "  Level:" +
	  this.level +"\n" ; return output;
	  
	  }*/
	
	
	// add above method to units class
	 

}
