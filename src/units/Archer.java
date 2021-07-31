package units;

import exceptions.FriendlyFireException;
import javafx.scene.control.Hyperlink;

public class Archer extends Unit{

	private Hyperlink hyperLink;

	public Hyperlink getHyperlink() {
		return hyperLink;
	}

	public void setHyperlink(Hyperlink hyperLink) {
		this.hyperLink = hyperLink;
	}

	public Archer(int level, int maxSoldierConunt, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierConunt, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}

	@Override
	public void attack(Unit target) throws FriendlyFireException {
		super.attack(target);
		double factor=0;
		if(target instanceof Archer)
		{
			if(getLevel()==1)
				factor=0.3;
			else if(getLevel()==2)
				factor=0.4;
			else 
				factor=0.5;
		}
		else if(target instanceof Infantry)
		{
			if(getLevel()==1)
				factor=0.2;
			else if(getLevel()==2)
				factor=0.3;
			else
				factor=0.4;
		}
		else if(target instanceof Cavalry)
		{
			if(getLevel()==1 || getLevel()==2)
				factor=0.1;
			
			else
				factor=0.2;
		}
		
		target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(factor*getCurrentSoldierCount()));
		
			target.getParentArmy().handleAttackedUnit(target);
	}

	

}
