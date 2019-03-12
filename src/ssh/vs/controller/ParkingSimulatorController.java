package ssh.vs.controller;

import java.util.Scanner;

import ssh.vs.dao.CarParkDAO;
import ssh.vs.dao.VechileDAO;
import ssh.vs.entity.CarPark;
import ssh.vs.entity.Vechile;
import ssh.vs.view.ReportView;

public class ParkingSimulatorController {

	//Creation of the VechileSimulation Object
	private  CarPark cp;
	private Vechile car;
	private Vechile truck;
	private VechileDAO vechileDAO;
	private  CarParkDAO cpDAO;
	private ReportView reportView;
	
	
	public ParkingSimulatorController(CarPark cp, Vechile car, Vechile truck, VechileDAO vechileDAO, CarParkDAO cpDAO,
			ReportView reportView) {
		super();
		this.cp = cp;
		this.car = car;
		this.truck = truck;
		this.vechileDAO = vechileDAO;
		this.cpDAO = cpDAO;
		this.reportView = reportView;
	}


	public void calculate()
	{
		
		reportView.sendMessage("How many spaces does the car park have?");
        Scanner sc = new Scanner(System.in);
        int spaceNumber = sc.nextInt();
        cpDAO.setTotalSpace(cp, spaceNumber);
        
        
        
        if(cpDAO.getTotalSpace(cp) == 0)
        {
        	reportView.sendMessage("The car park has no space");
        }
        
        else
        {
            boolean run = true;
            String userInput;
            while(run)
            {
            	reportView.sendMessage("User: ");
                Scanner sc1 = new Scanner(System.in);	
                userInput = sc1.nextLine();
            switch(userInput.toUpperCase())
            {
                case "ENTER CAR":
                    if(cpDAO.getUsedSpace(cp) <= cpDAO.getTotalSpace(cp) - 1)
                    {
                        vechileDAO.addToParking(car);
                        cpDAO.addToAvailableSpace(cp, 1);
                        vechileDAO.addTotal(car);
                    }
                    else
                    {
                    	reportView.sendMessage("The car park is full");
                    }
                    break;
                    
                case "ENTER TRUCK":
                    if(cpDAO.getUsedSpace(cp) <= cpDAO.getTotalSpace(cp) - 2)
                    {
                    	vechileDAO.addToParking(truck);
                    	cpDAO.addToAvailableSpace(cp, 2);
                        vechileDAO.addTotal(truck);
                    }
                    else
                    {
                    	reportView.sendMessage("The car park is full");
                    }
                    break;
                case "REPORT":
                    	reportView.displayReport(cp, car, truck);
                    break;
                case "EXIT":
                    run = false;
                    sc1.close();
                    break;
                default:
                	if(userInput.toUpperCase().matches("EXIT CAR [0-24]"))
                	{
                		if(car.getTotalParking() > 0)
                        {
                			String[] data = userInput.split(" ");
                        	vechileDAO.removeFromParking(car); 
                        	cpDAO.removeFromSpace(cp, 1);
                            vechileDAO.addToExitAmount(car);
                            cpDAO.addCarTotal(cp,Integer.parseInt(data[2]));
                        }
                        else
                        {
                        	reportView.sendMessage("There is no car to exit");
                        }
                	}
                	else if(userInput.toUpperCase().matches("EXIT TRUCK [0-24]"))
                	{
                        if(truck.getTotalParking() > 0)
                        {
                        	String[] data = userInput.split(" ");
                        	vechileDAO.removeFromParking(truck); 
                            cpDAO.removeFromSpace(cp, 2);
                            vechileDAO.addToExitAmount(truck);
                            cpDAO.addTruckTotal(cp, Integer.parseInt(data[2]));;
                        }
                        else
                        {
                        	reportView.sendMessage("There is no truck to exit");
                        }
                	}
                	else
                	{
                		reportView.sendMessage("Wrong command");
                	}
                	
                    break;  
                }
            }
            sc.close(); 
            
        }  
    }

		
		
}

	
		

