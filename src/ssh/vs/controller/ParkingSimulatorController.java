package ssh.vs.controller;

import ssh.vs.dao.CarParkDAO;
import ssh.vs.dao.VechileDAO;
import ssh.vs.entity.CarPark;
import ssh.vs.entity.Vechile;

public class ParkingSimulatorController {

	//Creation of the VechileSimulation Object
	private  CarPark cp;
	private Vechile car;
	private Vechile truck;
	private VechileDAO vechileDAO;
	private  CarParkDAO cpDAO;
	public ParkingSimulatorController(CarPark cp, Vechile car, Vechile truck, VechileDAO vechileDAO, CarParkDAO cpDAO) {
		
		this.cp = cp;
		this.car = car;
		this.truck = truck;
		this.vechileDAO = vechileDAO;
		this.cpDAO = cpDAO;
	}
	
	
		
}
