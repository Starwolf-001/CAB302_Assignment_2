/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;

/**
 * @author Michael Cartwright
 */
public class RestaurantCustomerTestsNew {

	/**
	 * Test method for PizzaRestaurant
	 * {@link asgn2Restaurant.PizzaRestaurant#PizzaRestaurant()}.
	 * no exceptions
	 */
	// Test for ArrayList<Customer> customers is empty.
	@Test
	public void testPizzaRestaurantCustomer() {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		if(restaurant.getNumCustomerOrders() == 0) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("customers is not an empty ArrayList");
		}
	}
	
	/**
	 * Test method for ProcessLog
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException, LogHandlerException, PizzaException 
	 * Also throws PizzaException but for RestaurantCustomerTests only Customers are the focus
	 */
	
	// Successfully call processLog and prove that a customer was added in restaurant
	@Test
	public void testProcessLogSuccess() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/testPopulate.txt";
		restaurant.processLog(filename);
		if(restaurant.getNumCustomerOrders() == 1) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("customers is not an empty ArrayList");
		}
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogInvalidCustomerCode() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerCode.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerInvalidDroneAtPizzaPalace() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneAtPizzaPalace.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerInvalidDroneLowerXBound() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneLowerXBound.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerInvalidDroneLowerYBound() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneLowerYBound.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerInvalidDroneUpperXBound() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneUpperXBound.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerInvalidDroneUpperYBound() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneUpperYBound.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerInvalidLocationXDoubleVariable() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidLocationXDoubleVariable.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerInvalidPickUp() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidPickUp.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerMobileEmpty() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerMobileEmpty.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerMobileLong() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerMobileLong.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerMobileNonDigit() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerMobileNonDigit.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerMobileShort() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerMobileShort.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerMobileStartingWithOne() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerMobileStartingWithOne.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerNameDigits() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerNameDigits.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerNameEmpty() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerNameEmpty.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerNameLong() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerNameLong.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogCustomerNameSymbol() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerNameSymbol.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	//Exception expected
	@Test(expected=LogHandlerException.class)
	public void testProcessLogNoFile() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/ThisFileDoesNotExist.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}

	/**
	 * Test method for getCustomerIndex
	 * {@link asgn2Restaurant.PizzaRestaurant#getCustomerByIndex(int)}.
	 * @throws CustomerException
	 */
	
	// Identifies if the first customer has the correct values found by method
	// Note: PizzaException and LogHandlerException added due to processLog()
	@Test
	public void testGetCustomerByIndexSuccess() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/testPopulate.txt";
		restaurant.processLog(filename);
		if(restaurant.getCustomerByIndex(0).getName().equals("Casey Jones") && 
		   restaurant.getCustomerByIndex(0).getMobileNumber().equals("0423456789") &&
		   restaurant.getCustomerByIndex(0).getCustomerType().equals("Driver Delivery") &&
		   restaurant.getCustomerByIndex(0).getLocationX() == 5 &&
		   restaurant.getCustomerByIndex(0).getLocationY() == 5 && 
		   restaurant.getCustomerByIndex(0).getDeliveryDistance() == 10) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer name, mobile number, type, location x, location y and delivery distance did not match"
				 + " testPopulate");
		}
	}
	
	// Exception Expected
	@Test(expected=CustomerException.class)
	public void testGetCustomerByIndexNoCustomers() throws CustomerException{
		PizzaRestaurant restaurant = new PizzaRestaurant();
		restaurant.getCustomerByIndex(0);
		fail("Exception expected");
	}
	
	// Exception Expected
	// Note: PizzaException and LogHandlerException added due to processLog()
	@Test(expected=CustomerException.class)
	public void testGetCustomerByIndexNegative() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/testPopulate.txt";
		restaurant.processLog(filename);
		if(restaurant.getCustomerByIndex(-1).getName().equals("Casey Jones")) {
			// Should not occur when customer Index is negative
		} else {
			fail("Exception expected");
		}
	}
	
	// Exception Expected
	// Note: PizzaException and LogHandlerException added due to processLog()
	@Test(expected=CustomerException.class)
	public void testGetCustomerByIndexGreaterThanCustomerSize() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/testPopulate.txt";
		restaurant.processLog(filename);
		if(!restaurant.getCustomerByIndex(1).getName().equals("Casey Jones")) {
			// Should not occur when customer Index is locating a customer that is outside the size of 
			// <ArrayList> Customer customers
		} else {
			fail("Exception expected");
		}
	}

	/**
	 * Test method for getNumCustomerOrders
	 * {@link asgn2Restaurant.PizzaRestaurant#getNumCustomerOrders()}.
	 * no exceptions
	 */
	
	// Validates is the size of customers in zero using getNumCustomerOrders()
	@Test
	public void testGetNumCustomerOrders() {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		if(restaurant.getNumCustomerOrders() == 0) {
			assertTrue(true);
		} else {
			fail("Exception expected");
		}
	}

	/**
	 * Test method for getTotalDeliveryDistance
	 * {@link asgn2Restaurant.PizzaRestaurant#getTotalDeliveryDistance()}.
	 * no exceptions
	 */
	
	// Takes the total distance travel for all three customers
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test
	public void testGetTotalDeliveryDistanceSuccess() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/20170101.txt";
		restaurant.processLog(filename);
		double distancePickUp = 0;
		double distanceDrone = Math.sqrt(Math.pow(0 - 3, 2) + Math.pow(0 - 4, 2));
		double distanceDriver = Math.abs(0 - 5) + Math.abs(0 - 5);
		double totalDistanceTest = distancePickUp + distanceDrone + distanceDriver;
		if(restaurant.getTotalDeliveryDistance() == totalDistanceTest) {
			assertTrue(true);
		} else {
			//Should not meet here
			fail("getTotalDeliveryDistance was not equal to totalDistanceTest");
		}
	}
	
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalDeliveryDistanceInvalidPickUp() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidPickUp.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}
	
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalDeliveryDistanceInvalidDrone() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneAtPizzaPalace.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}
	
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalDeliveryDistanceInvalidDroneXLowerBound() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneLowerXBound.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}
	
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalDeliveryDistanceInvalidDroneYLowerBound() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneLowerYBound.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}
	
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalDeliveryDistanceInvalidDroneXUpperBound() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneUpperXBound.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}
		
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalDeliveryDistanceInvalidDroneYUpperBound() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidDroneUpperYBound.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}
	
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalDeliveryDistanceDoubleLocationVariable() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerInvalidLocationXDoubleVariable.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}

	/**
	 * Test method for resetDetails
	 * {@link asgn2Restaurant.PizzaRestaurant#resetDetails()}.
	 * no exceptions
	 */
	
	// Resets customers and pizzas
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test
	public void testResetDetailsSuccess() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/20170101.txt";
		restaurant.processLog(filename);
		if(restaurant.getNumCustomerOrders() == 3) {
			restaurant.resetDetails();
			if(restaurant.getNumCustomerOrders() == 0) {
				assertTrue(true);
			} else {
				// Should not reach here
				fail("Customers were not reset");	
			}
		} else {
			// Should not reach here
			fail("Customers were not successfully added");	
		}
	}

}
