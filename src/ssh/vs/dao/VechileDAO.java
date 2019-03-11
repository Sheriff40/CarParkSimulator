package ssh.vs.dao;

import ssh.vs.entity.Vechile;

public interface VechileDAO {

	public int getTotalParking(Vechile vechile);
	public int getTotalEntered(Vechile vechile);
	public int getTotalExitAmount(Vechile vechile);
	public void addToParking(Vechile vechile);
	public void removeFromParking(Vechile vechile);
	public void addTotal(Vechile vechile);
	public void addToExitAmount(Vechile vechile);
	public void removeFromExitAmount(Vechile vechile);
	
}
