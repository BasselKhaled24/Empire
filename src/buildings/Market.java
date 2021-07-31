package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Market extends EconomicBuilding {

	public Market() {
		super(1500, 700);
//		Button b = new Button();
//		ImageView iv = new ImageView(new Image("marketIcon.png"));
//		iv.setFitHeight(iconSize);
//		iv.setFitWidth(iconSize);
//		b.setGraphic(iv);
//		this.setBuildingButton(b);
	}

	@Override
	public int harvest() {
		if(getLevel()==1)
			return 1000;
		else if(getLevel()==2)
			return 1500;
		else
			return 2000;
	}

	@Override
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		super.upgrade();
		if(getLevel()==1)
		{
			setLevel(2);
			setUpgradeCost(1000);
		}
		else if(getLevel()==2)
		setLevel(3);
	}

	@Override
	public void onBuilt()
	{
		//this.getBuildingButton().setDisable(false);
	}
}
