package buildings;

import GUI.Toast;
import engine.City;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import units.Cavalry;
import units.Unit;

public class Stable extends MilitaryBuilding {

	Button stableButton = new Button();
	Button buildStable = new Button("Build \nCost: 1500");
	Button upgradeStable = new Button();
	Button recruitCavalry = new Button();
	
	public Stable(Game game, City city, Stage window) {
		super(2500, 1500, 600, game, city, window);
		
		stableButton.setDisable(true);
		ImageView ivar = new ImageView(new Image("stableIcon.png"));
		ivar.setFitHeight(iconSize);
		ivar.setFitWidth(iconSize);
		stableButton.setGraphic(ivar);
		buildStable.setTextAlignment(TextAlignment.CENTER);
		getBuildingUI().getChildren().addAll(stableButton, buildStable);
		
		Tooltip stableInfo = new Tooltip();
		if(isCoolDown())
			stableInfo.setText("Level: "+getLevel()+"\n On Cooldown");
		else
			stableInfo.setText("Level: "+getLevel());
		stableButton.setTooltip(stableInfo);
		
		buildStable.setOnMouseClicked(me -> {
				try {
					game.getPlayer().build("stable", city.getName());
				} catch (NotEnoughGoldException e) {
					String toastMsg = "Not Enough Gold";
					int toastMsgTime = 3500; //3.5 seconds
					int fadeInTime = 500; //0.5 seconds
					int fadeOutTime= 500; //0.5 seconds
					Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
					e.printStackTrace();
				}
				stableButton.setDisable(false);
				upgradeStable.setText("Upgrade \nCost: "+getUpgradeCost());
				upgradeStable.setTextAlignment(TextAlignment.CENTER);
				recruitCavalry.setText("Recruit \nCost: "+getRecruitmentCost());
				recruitCavalry.setTextAlignment(TextAlignment.CENTER);
				getBuildingUI().getChildren().clear();
				getBuildingUI().getChildren().addAll(stableButton, upgradeStable, recruitCavalry);
		});
		upgradeStable.setOnMouseClicked(me -> {
			try {
				game.getPlayer().upgradeBuilding(this);
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
		recruitCavalry.setOnMouseClicked(me -> {
			try {
				recruit();
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
	}

	@Override
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
		if(isCoolDown())
			throw new BuildingInCoolDownException("Building is cooling down, please wait for the next turn");
		if(getCurrentRecruit()==getMaxRecruit())
			throw new MaxRecruitedException("Max recruited units reached, please wait till next turn. ");
		setCurrentRecruit(getCurrentRecruit() + 1);
		if (getLevel() == 1)
			return new Cavalry(1, 40, 0.6, 0.7, 0.75);

		else if (getLevel() == 2)
			return new Cavalry(2, 40, 0.6, 0.7, 0.75);
		else
			return new Cavalry(3, 60, 0.7, 0.8, 0.9);

	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if (getLevel() == 1) {
			setLevel(2);
			setUpgradeCost(2000);
			setRecruitmentCost(650);
		} else if (getLevel() == 2) {
			setLevel(3);
			setRecruitmentCost(700);
		}
	}

	@Override
	public void onBuilt()
	{
		//this.getBuildingButton().setDisable(false);
	}
}
