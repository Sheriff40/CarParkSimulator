package ssh.vs.main;

import java.util.Scanner;


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
	        
	        
	       
	        
	       
	        
        
		
        //Get the total parking space input from the user
        System.out.println("How many spaces does the car park have?");
        Scanner sc = new Scanner(System.in);
        int spaceNumber = sc.nextInt();
        cpDAO.setTotalSpace(cp, spaceNumber);
        
        
        
        if(cpDAO.getTotalSpace(cp) == 0)
        {
            System.out.println("The car park has no space");
        }
        
        else
        {
            boolean run = true;
            String userInput;
            while(run)
            {
                System.out.print("User: ");
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
                        System.out.println("The car park is full");
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
                        System.out.println("The car park is full");
                    }
                    break;
                case "EXIT CAR":
                    if(car.getTotalParking() > 0)
                    {
                    	vechileDAO.removeFromParking(car); 
                    	cpDAO.removeFromSpace(cp, 1);
                        vechileDAO.addToExitAmount(car);
                        System.out.println("Total parking hours of the car?");
                        int hrs = sc1.nextInt();
                        cpDAO.addCarTotal(cp,hrs);
                    }
                    else
                    {
                        System.out.println("There is no car to exit");
                    }
                    break;
                case "EXIT TRUCK":
                    
                    if(truck.getTotalParking() > 0)
                    {
                    	vechileDAO.removeFromParking(truck); 
                        cpDAO.removeFromSpace(cp, 2);
                        vechileDAO.addToExitAmount(truck);
                        System.out.println("Total parking hours of the truck?");
                        int hrs = sc1.nextInt();
                        cpDAO.addTruckTotal(cp,hrs);;
                    }
                    else
                    {
                        System.out.println("There is no truck to exit");
                    }
                    break;
                case "REPORT":
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
                    break;
                case "EXIT":
                    run = false;
                    sc1.close();
                    break;
                default:
                    System.out.println("Wrong command");
                    break;  
                }
            }
            sc.close(); 
            
        }  
    }

}


