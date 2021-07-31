package buildings;

import GUI.Toast;
import engine.City;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import units.Archer;
import units.Unit;

public class ArcheryRange extends MilitaryBuilding {
	
	Button archeryRangeButton = new Button();
	Button buildArcheryRange = new Button("Build \nCost: 1500");
	Button upgradeArcheryRange = new Button();
	Button recruitArcher = new Button();
	
	public ArcheryRange(Game game, City city, Stage window) {
		super(1500, 800,400, game, city, window);
		
		archeryRangeButton.setDisable(true);
		ImageView ivar = new ImageView(new Image("archeryRangeIcon.jpg"));
		ivar.setFitHeight(iconSize);
		ivar.setFitWidth(iconSize);
		archeryRangeButton.setGraphic(ivar);
		buildArcheryRange.setTextAlignment(TextAlignment.CENTER);
		getBuildingUI().getChildren().addAll(archeryRangeButton, buildArcheryRange);
		
		Tooltip archeryRangeInfo = new Tooltip();
		if(isCoolDown())
			archeryRangeInfo.setText("Level: "+getLevel()+"\n On Cooldown");
		else
			archeryRangeInfo.setText("Level: "+getLevel());
		archeryRangeButton.setTooltip(archeryRangeInfo);
		
		buildArcheryRange.setOnMouseClicked(me -> {
				try {
					game.getPlayer().build("archeryrange", city.getName());
				} catch (NotEnoughGoldException e) {
					String toastMsg = "Not Enough Gold";
					int toastMsgTime = 3500; //3.5 seconds
					int fadeInTime = 500; //0.5 seconds
					int fadeOutTime= 500; //0.5 seconds
					Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
					e.printStackTrace();
				}
				archeryRangeButton.setDisable(false);
				upgradeArcheryRange.setText("Upgrade \nCost: "+getUpgradeCost());
				upgradeArcheryRange.setTextAlignment(TextAlignment.CENTER);
				recruitArcher.setText("Recruit \nCost: "+getRecruitmentCost());
				recruitArcher.setTextAlignment(TextAlignment.CENTER);
				getBuildingUI().getChildren().clear();
				getBuildingUI().getChildren().addAll(archeryRangeButton, upgradeArcheryRange, recruitArcher);
		});
		upgradeArcheryRange.setOnMouseClicked(me -> {
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
		recruitArcher.setOnMouseClicked(me -> {
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
		setCurrentRecruit(getCurrentRecruit()+1);
		if(getLevel()==1)
			return new Archer(1, 60, 0.4, 0.5, 0.6);
		
	else if(getLevel()==2)
		return new Archer(2,60,0.4,0.5,0.6);
	else
		return new Archer(3,70,0.5,0.6,0.7);
		
	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if(getLevel()==1)
		{
			setLevel(2);
			setUpgradeCost(700);
			setRecruitmentCost(450);
		}
		else if(getLevel()==2)
		{
		setLevel(3);
		setRecruitmentCost(500);
		}
	}

	@Override
	public void onBuilt()
	{
		//this.getBuildingButton().setDisable(false);
	}
}
