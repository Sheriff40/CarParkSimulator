package ssh.vs.dao;

import ssh.vs.entity.CarPark;

public class CarParkDAOImpl implements CarParkDAO {


	@Override
	public void addToAvailableSpace(CarPark carPark, int i) {
		carPark.setUsedSpace(carPark.getUsedSpace() + i);
		
	}

	@Override
	public void removeFromSpace(CarPark carPark, int i) {
		carPark.setUsedSpace(carPark.getUsedSpace() - i);
		
	}

	@Override
	public void addTruckTotal(CarPark carPark, int hrs) {
		carPark.setTotalAmount(carPark.getTotalAmount() + (hrs * 3));
		
	}
	
	@Override
	public void addCarTotal(CarPark carPark, int hrs) {
		carPark.setTotalAmount(carPark.getTotalAmount() + (hrs * 2));
		
	}

	@Override
	public void setTotalSpace(CarPark carPark, int i) {
		carPark.setTotalSpace(i);
		
	}

	@Override
	public int getTotalSpace(CarPark carPark) {
		return carPark.getTotalSpace();
	}

	@Override
	public int getUsedSpace(CarPark carPark) {
		return carPark.getUsedSpace();
	}

	@Override
	public double getTotalAmount(CarPark carPark) {
		return carPark.getTotalAmount();
	}

	

	

}
