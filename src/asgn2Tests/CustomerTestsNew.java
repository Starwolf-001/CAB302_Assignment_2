/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Customers.Customer;
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
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberEmpty() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Ryuuko Matoi", "", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberNull() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Ryuuko Matoi", null, 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberIncorrectStart() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Ryuuko Matoi", "1412345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberNonDigit() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Ryuuko Matoi", "04S0000000", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberShort() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Ryuuko Matoi", "041234567", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberLong() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Ryuuko Matoi", "04123456789", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileWhiteSpace() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Ryuuko Matoi", "04 2345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerXUpperBound() throws CustomerException {
		//Create Customer
		Customer newCustomer = new DroneDeliveryCustomer("Rebecca Lee", "0412345678", 11, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerYUpperBound() throws CustomerException {
		//Create Customer
		Customer newCustomer = new DroneDeliveryCustomer("Rebecca Lee", "0412345678", 0, 11);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerXLowerBound() throws CustomerException {
		//Create Customer
		Customer newCustomer = new DroneDeliveryCustomer("Rebecca Lee", "0412345678", -11, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerYLowerBound() throws CustomerException {
		//Create Customer
		Customer newCustomer = new DroneDeliveryCustomer("Rebecca Lee", "0412345678", 0, -11);
		fail("Exception Expected");
	}
	
	// Expecting PickUpCustomer to implement successfully
	@Test
	public void testCustomerPickUpLocationSuccess() throws CustomerException {
		//Create Customer
		int locationX = 0;
		int locationY = 0;
		Customer newCustomer = new PickUpCustomer("Seras Victoria", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getCustomerType() == "Pick Up" && newCustomer.getDeliveryDistance() == 0 &&
		   newCustomer.getLocationX() == locationX && newCustomer.getLocationY() == locationY) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to be implemented correctly as type 'Pick Up'");
		}
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerPickUpLocationXFail() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Edward Elric", "0412345678", 1, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerPickUpLocationYFail() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Edward Elric", "0412345678", 0, 1);
		fail("Exception Expected");
	}
	
	// Expecting DroneDeliveryCustomer to implement successfully
	@Test
	public void testCustomerDroneDeliveryLocationSuccess() throws CustomerException {
		//Create Customer
		int locationX = 5;
		int locationY = -5;
		Customer newCustomer = new DroneDeliveryCustomer("Lelouche", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getCustomerType() == "Drone Delivery" && newCustomer.getLocationX() == locationX 
		   && newCustomer.getLocationY() == locationY) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to be implemented correctly as type 'Drone Delivery'");
		}
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerDroneDeliveryLocationFail() throws CustomerException {
		//Create Customer
		Customer newCustomer = new DroneDeliveryCustomer("Light Yagami", "0412345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting DriverDeliveryCustomer to implement successfully
	@Test
	public void testCustomerDriverDeliveryLocationSuccess() throws CustomerException {
		//Create Customer
		int locationX = 5;
		int locationY = -5;
		Customer newCustomer = new DriverDeliveryCustomer("Lelouche", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getCustomerType() == "Driver Delivery" && newCustomer.getLocationX() == locationX 
		   && newCustomer.getLocationY() == locationY) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to be implemented correctly as type 'Driver Delivery' with ");
		}
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerDriverDeliveryLocationFail() throws CustomerException {
		//Create Customer
		Customer newCustomer = new DriverDeliveryCustomer("Ichigo Kurosaki", "0412345678", 0, 0);
		fail("Exception Expected");
	}

	/**
	 * Test method for getName
	 * {@link asgn2Customers.Customer#getName()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetName() throws CustomerException {
		//Create Customer
		String customerName = "Goku";
		Customer newCustomer = new PickUpCustomer(customerName, "0412345678", 0, 0);
		//Check 
		if(newCustomer.getName() == customerName) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to obtain the same customer name");
		}
	}

	/**
	 * Test method for getMobileNumber
	 * {@link asgn2Customers.Customer#getMobileNumber()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetMobileNumber() throws CustomerException {
		//Create Customer
		String mobileNumber = "0412345678";
		Customer newCustomer = new PickUpCustomer("Monkey D Luffy", mobileNumber, 0, 0);
		//Check 
		if(newCustomer.getMobileNumber() == mobileNumber) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to obtain the same customer mobile number");
		}
	}

	/**
	 * Test method for getCustomerType
	 * {@link asgn2Customers.Customer#getCustomerType()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetCustomerType() throws CustomerException {
		//Create Customer
		Customer newCustomer = new PickUpCustomer("Natsu Dragneel", "0412345678", 0, 0);
		//Check 
		if(newCustomer.getCustomerType() == "Pick Up") {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to obtain the same customer mobile number");
		}
	}

	/**
	 * Test method for getLocationX
	 * {@link asgn2Customers.Customer#getLocationX()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetLocationX() throws CustomerException {
		//Create Customer
		int locationX = 5;
		int locationY = -5;
		Customer newCustomer = new DriverDeliveryCustomer("Vegeta", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getLocationX() == locationX) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to obtain the same customer locationX");
		}
	}

	/**
	 * Test method for getLocationY
	 * {@link asgn2Customers.Customer#getLocationY()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetLocationY() throws CustomerException {
		//Create Customer
		int locationX = 5;
		int locationY = -5;
		Customer newCustomer = new DriverDeliveryCustomer("Roy Mustang", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getLocationY() == locationY) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to obtain the same customer locationY");
		}
	}

	/**
	 * Test method for getDeliveryDistance for Pick Up customer type
	 * Expecting a delivery distance of 0
	 * {@link asgn2Customers.Customer#getDeliveryDistance()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetDeliveryDistancePickUp() throws CustomerException {
		//Create Customer
		int locationX = 0;
		int locationY = 0;
		Customer newCustomer = new PickUpCustomer("CC loves her pizza", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getDeliveryDistance() == 0) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Customer failed to obtain the same customer locationY");
		}
	}
	
	/**
	 * Test method for getDeliveryDistance for Drone Delivery customer type
	 * Expecting a delivery distance of 7.071068
	 * {@link asgn2Customers.Customer#getDeliveryDistance()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetDeliveryDistanceDroneDelivery() throws CustomerException {
		//Create Customer
		int locationX = 5;
		int locationY = 5;
		double euclideanDistance = Math.sqrt(Math.pow(0 - locationX, 2) + Math.pow(0 - locationY, 2));
		Customer newCustomer = new DroneDeliveryCustomer("CC loves her pizza", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getDeliveryDistance() == euclideanDistance) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to obtain the same distance value. The euclideanDistance value should be 7.071068");
		}
	}
	
	/**
	 * Test method for getDeliveryDistance for Driver Delivery customer type
	 * Expecting a delivery distance of 10.0
	 * {@link asgn2Customers.Customer#getDeliveryDistance()}.
	 * @throws CustomerException
	 */
	@Test
	public void testGetDeliveryDistanceDriverDelivery() throws CustomerException {
		//Create Customer
		int locationX = 5;
		int locationY = 5;
		double manhattanDistance = Math.abs(0 - locationX) + Math.abs(0 - locationY);
		Customer newCustomer = new DriverDeliveryCustomer("CC loves her pizza", "0412345678", locationX, locationY);
		//Check 
		if(newCustomer.getDeliveryDistance() == manhattanDistance) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to obtain the same distance value");
		}
	}

	/**
	 * Test method for {@link asgn2Customers.Customer#equals(java.lang.Object)}.
	 * EqualsObject() does not need to be tested
	 **/
	

}
