package buildings;

import java.time.Duration;

import GUI.BuildingListener;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public abstract class Building implements BuildingListener
{
	private int cost;
	private int level;
	private int upgradeCost;
	private boolean coolDown;
	private boolean isBuilt=false;
	private VBox buildingUI=new VBox();
	public double iconSize = 250;

	public Building(int cost,int upgradeCost) {
		this.cost=cost;
		this.upgradeCost=upgradeCost;
		this.level=1;
		coolDown=true;
	}
	
	public void setBuildingUI(VBox vbox) {
		this.buildingUI = vbox;
	}

	public VBox getBuildingUI() {
		return buildingUI;
	}

	public  void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{
		if(coolDown)
			throw new BuildingInCoolDownException("Building is in cool down. Wait for the next turn ");
		if(level==3)
			throw new MaxLevelException("Maximum level reached!!");
		coolDown=true;
	}

	public int getCost() {
		return cost;
	}

	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}

	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

	public boolean isCoolDown() {
		return coolDown;
	}

	public void setCoolDown(boolean inCooldown) {
		this.coolDown = inCooldown;
	}

	public boolean isBuilt() {
		return isBuilt;
	}

	public void setBuilt(boolean isBuilt) {
		this.isBuilt = isBuilt;
	}
	
//	public void displayInfo()
//	{
//		Tooltip buildingInfo = new Tooltip();
//		if(coolDown)
//			buildingInfo.setText("Level: "+this.level+"\n On Cooldown");
//		else
//			buildingInfo.setText("Level: "+this.level);
//		buildingButton.setTooltip(buildingInfo);
//	}
}
