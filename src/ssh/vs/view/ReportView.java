package ssh.vs.view;

import ssh.vs.dao.CarParkDAO;
import ssh.vs.dao.CarParkDAOImpl;
import ssh.vs.dao.VechileDAO;
import ssh.vs.dao.VechileDAOImpl;
import ssh.vs.entity.CarPark;
import ssh.vs.entity.Vechile;

public class ReportView {

	 CarParkDAO cpDAO = new CarParkDAOImpl();
	 VechileDAO vechileDAO = new VechileDAOImpl();
	
	 
	public void sendMessage(String message)
	{
		System.out.println(message);
	}
	 
	 
	public void displayReport(CarPark cp, Vechile car, Vechile truck)
	
	{
		 System.out.println("Report: \n"
                 + " Car Entered: " + vechileDAO.getTotalEntered(car)
                 + "\n Truck Entered: " + vechileDAO.getTotalEntered(truck)
                 + "\n Car Exited: " + vechileDAO.getTotalExitAmount(car)
                 + "\n Truck Exited: " + vechileDAO.getTotalExitAmount(truck)
                 + "\n Total space: " + cpDAO.getTotalSpace(cp)
                 + "\n Parking Cars: " + vechileDAO.getTotalParking(car)
                 + "\n Praking Trucks: " + vechileDAO.getTotalParking(truck)
                 + "\n Space Available: " + (cpDAO.getTotalSpace(cp) - cpDAO.getUsedSpace(cp))
                 + "\n Fees Paid: " + cpDAO.getTotalAmount(cp));
		
	}
	
}
