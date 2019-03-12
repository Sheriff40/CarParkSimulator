package ssh.vs.main;


import ssh.vs.controller.ParkingSimulatorController;
import ssh.vs.dao.CarParkDAO;
import ssh.vs.dao.CarParkDAOImpl;
import ssh.vs.dao.VechileDAO;
import ssh.vs.dao.VechileDAOImpl;
import ssh.vs.entity.CarPark;
import ssh.vs.entity.Vechile;
import ssh.vs.view.ReportView;

public class Simulation {
	
	public static void main(String[] args) {
		
		 
		
		 CarPark cp = new CarPark();
	     CarParkDAO cpDAO = new CarParkDAOImpl();
		 Vechile car = new Vechile();
	     Vechile truck = new Vechile();
	     VechileDAO vechileDAO = new VechileDAOImpl();
	     ReportView reportView = new ReportView();  
	    
	     ParkingSimulatorController psc = new ParkingSimulatorController(cp,car,truck,vechileDAO,cpDAO,reportView);
	     psc.calculate();
	       
    }

}


