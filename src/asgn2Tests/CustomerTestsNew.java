/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * @author Michael Cartwright
 */
public class CustomerTestsNew {

	/**
	 * Test method for Customer
	 * {@link asgn2Customers.Customer#Customer(java.lang.String, java.lang.String, int, int, java.lang.String)}.
	 * @throws CustomerException
	 */
	
	// Expecting customer, of type Pick Up, to be successfully implemented
	@Test()
	public void testCustomerSuccessful() throws CustomerException {
		//Create Customer
		String name = "Michael Cartwright";
		String number = "0412345678";
		int x = 0;
		int y = 0;
		Customer newCustomer = new PickUpCustomer(name, number, x, y);
		if(newCustomer.getCustomerType() == "Pick Up" && newCustomer.getDeliveryDistance() == 0 &&
		   newCustomer.getLocationX() == x && newCustomer.getLocationY() == y && 
		   newCustomer.getMobileNumber() == number) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Customer failed to be immplemented correctly");
		}
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameEmpty() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("", "0412345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameNull() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer(null, "0412345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameLong() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Viktoriya Ivanovna Serebryakova", "0412345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameSymbols() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Kiss-Shot Ace...", "0412345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameWhiteSpace() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("     ", "0412345678", 0, 0);
		fail("Exception Expected");
	}

	/**
	 * Test method for {@link asgn2Customers.Customer#getName()}.
	 */
	//@Test
	//public void testGetName() {
	//	fail("Not yet implemented");
	//}

	/**
	 * Test method for {@link asgn2Customers.Customer#getMobileNumber()}.
	 */
	//@Test
	//public void testGetMobileNumber() {
	//	fail("Not yet implemented");
	//}

	/**
	 * Test method for {@link asgn2Customers.Customer#getCustomerType()}.
	 */
	//@Test
	//public void testGetCustomerType() {
	//	fail("Not yet implemented");
	//}

	/**
	 * Test method for {@link asgn2Customers.Customer#getLocationX()}.
	 */
	//@Test
	//public void testGetLocationX() {
	//	fail("Not yet implemented");
	//}

	/**
	 * Test method for {@link asgn2Customers.Customer#getLocationY()}.
	 */
	//@Test
	//public void testGetLocationY() {
	//	fail("Not yet implemented");
	//}

	/**
	 * Test method for {@link asgn2Customers.Customer#getDeliveryDistance()}.
	 */
	//@Test
	//public void testGetDeliveryDistance() {
	//	fail("Not yet implemented");
	//}

	/**
	 * Test method for {@link asgn2Customers.Customer#equals(java.lang.Object)}.
	 */
	//@Test
	//public void testEqualsObject() {
	//	fail("Not yet implemented");
	//}

}
