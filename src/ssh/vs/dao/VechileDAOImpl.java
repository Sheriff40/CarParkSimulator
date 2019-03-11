package ssh.vs.dao;

import ssh.vs.entity.Vechile;

public class VechileDAOImpl implements VechileDAO {

	
	@Override
	public void addToParking(Vechile vechile) {
		
		vechile.setTotalParking(vechile.getTotalParking() + 1);
	}

	@Override
	public void removeFromParking(Vechile vechile) {
		vechile.setTotalParking(vechile.getTotalParking() - 1);
	}

	@Override
	public void addTotal(Vechile vechile) {
		vechile.setTotalEntered(vechile.getTotalEntered() + 1);
	}

	@Override
	public void addToExitAmount(Vechile vechile) {
		vechile.setTotalExit(vechile.getTotalExit() + 1);
		
	}

	@Override
	public void removeFromExitAmount(Vechile vechile) {
		vechile.setTotalExit(vechile.getTotalExit() - 1);
		
	}

	@Override
	public int getTotalParking(Vechile vechile) {
		return vechile.getTotalParking();
	}

	@Override
	public int getTotalEntered(Vechile vechile) {
		return vechile.getTotalEntered();
	}

	@Override
	public int getTotalExitAmount(Vechile vechile) {
		return vechile.getTotalExit();
	}

}
