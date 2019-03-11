package ssh.vs.dao;

import ssh.vs.entity.CarPark;

public interface CarParkDAO {


		public void addToAvailableSpace(CarPark carPark, int i);
		public void removeFromSpace(CarPark carPark, int i);
		public void addTruckTotal(CarPark carPark, int hrs);
		public void addCarTotal(CarPark carPark, int hrs);
		public void setTotalSpace(CarPark carPark, int i);
		public int getTotalSpace(CarPark carPark);
		public int getUsedSpace(CarPark carPark);
		public double getTotalAmount(CarPark carPark);
}
