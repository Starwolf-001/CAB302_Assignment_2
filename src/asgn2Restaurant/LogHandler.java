package asgn2Restaurant;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Matthew Pike and Michael Cartwright
 *
 */
public class LogHandler {


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		ArrayList<Customer> result = new ArrayList<Customer>();
        File file = new File(filename);
		try{
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				result.add(createCustomer(line));
			}
		} 
		catch (Exception e){
			throw new LogHandlerException(e);
		}
		return result;
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		ArrayList<Pizza> result = new ArrayList<Pizza>();
		
		File file = new File(filename);
		try{
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				result.add(createPizza(line));
			}
		} 
		catch (Exception e){
			throw new LogHandlerException(e);
		}
		return result;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		
		String string = line;
		String [] parts = string.split(",");
		
		String customerCode = parts[4];
		String name = parts[2];
		String mobileNumber = parts[3];
		int locationX = Integer.parseInt(parts[5]);
		int locationY = Integer.parseInt(parts[6]);
		
		Customer newCustomer = CustomerFactory.getCustomer(customerCode, name, mobileNumber, locationX,  locationY);

		return newCustomer;
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		
		String string = line;
		String [] parts = string.split(",");
		
		String pizzaCode = parts[7];
		int quantity = Integer.parseInt(parts[8]);
		LocalTime orderTime = LocalTime.parse(parts[0]);
		LocalTime deliveryTime= LocalTime.parse(parts[1]);
		
		Pizza newPizza = PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);

		return newPizza;
	}
}
