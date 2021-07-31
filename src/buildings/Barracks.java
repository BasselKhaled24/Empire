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
import units.Infantry;
import units.Unit;

public class Barracks extends MilitaryBuilding {

	Button barracksButton = new Button();
	Button buildBarracks = new Button("Build \nCost: 1500");
	Button upgradeBarracks = new Button();
	Button recruitInfantry = new Button();
	
	public Barracks(Game game, City city, Stage window) {
		super(2000, 1000,500, game, city, window);
		
		barracksButton.setDisable(true);
		ImageView ivar = new ImageView(new Image("barracksIcon.png"));
		ivar.setFitHeight(iconSize);
		ivar.setFitWidth(iconSize);
		barracksButton.setGraphic(ivar);
		buildBarracks.setTextAlignment(TextAlignment.CENTER);
		getBuildingUI().getChildren().addAll(barracksButton, buildBarracks);
		
		Tooltip stableInfo = new Tooltip();
		if(isCoolDown())
			stableInfo.setText("Level: "+getLevel()+"\n On Cooldown");
		else
			stableInfo.setText("Level: "+getLevel());
		barracksButton.setTooltip(stableInfo);
		
		buildBarracks.setOnMouseClicked(me -> {
				try {
					game.getPlayer().build("barracks", city.getName());
				} catch (NotEnoughGoldException e) {
					String toastMsg = "Not Enough Gold";
					int toastMsgTime = 3500; //3.5 seconds
					int fadeInTime = 500; //0.5 seconds
					int fadeOutTime= 500; //0.5 seconds
					Toast.makeText(window, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
					e.printStackTrace();
				}
				barracksButton.setDisable(false);
				upgradeBarracks.setText("Upgrade \nCost: "+getUpgradeCost());
				upgradeBarracks.setTextAlignment(TextAlignment.CENTER);
				recruitInfantry.setText("Recruit \nCost: "+getRecruitmentCost());
				recruitInfantry.setTextAlignment(TextAlignment.CENTER);
				getBuildingUI().getChildren().clear();
				getBuildingUI().getChildren().addAll(barracksButton, upgradeBarracks, recruitInfantry);
		});
		upgradeBarracks.setOnMouseClicked(me -> {
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
		recruitInfantry.setOnMouseClicked(me -> {
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
			return new Infantry(1, 50, 0.5, 0.6, 0.7);
		
	else if(getLevel()==2)
		return new Infantry(2,50,0.5,0.6,0.7);
	else
		return new Infantry(3,60,0.6,0.7,0.8);
		
	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if(getLevel()==1)
		{
			setLevel(2);
			setUpgradeCost(1500);
			setRecruitmentCost(550);
		}
		else if(getLevel()==2)
		{
		setLevel(3);
		setRecruitmentCost(600);
		}
		
	}

	@Override
	public void onBuilt()
	{
		//this.getBuildingButton().setDisable(false);
	}
}
