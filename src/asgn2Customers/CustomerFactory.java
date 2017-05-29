package asgn2Customers;


import java.time.LocalTime;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;

/**
 * A class that instantiates the subclasses of asgn2Customers.Customer using the Factory Method pattern. 
 * The classes are instantiated from one of the three valid customer codes outlined in
 * Section 5.3 of the Assignment Specification. Any other code will throw a CustomerException.   
 *     
 * @author Michael Cartwright
 *
 */

public class CustomerFactory {

	/**
	 * A method that uses the Factory Method pattern to produce an instance of one of the asgn2Customers.Customer subclasses. 
	 * Subclasses are created using the customerCode. All valid customer codes are listed in Section 5.3 of the Assignment Specification.
	 * A CustomerException should be thrown if an invalid customer code is used as a parameter. 
	 * 
	 * @param customerCode - A code indicating the subclass of asgn2Customers.Customer to instantiate. The valid codes are listed in Section 5.3 of the Assignment Specification. 
	 * @param name - The customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @return A valid PickUpCustomer, DriverDeliveryCustomer or DroneDeliveryCustomer depending on the customerCode.
	 * @throws CustomerException if the customerCode is not one of the three valid codes listed in Section 5.3 of the Assignment Specification. 
	 */
	public static Customer getCustomer(String customerCode, String name, String mobileNumber, int locationX,  int locationY) throws CustomerException{
		if(customerCode == "PUC") {
			// TODO
			return new PickUpCustomer(name, mobileNumber, locationX, locationY);
		}
		if(customerCode == "DNC") {
			// TODO
			return new DroneDeliveryCustomer(name, mobileNumber, locationX, locationY);
		}
		if(customerCode == "DVC") {
			// TODO
			return new DriverDeliveryCustomer(name, mobileNumber, locationX, locationY);
		}
		else {
			throw new CustomerException("Not a valid customer");
		}
	}
}
