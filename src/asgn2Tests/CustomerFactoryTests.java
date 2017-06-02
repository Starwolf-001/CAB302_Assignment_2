package asgn2Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Michael Cartwright
 */
public class CustomerFactoryTests {

	/**
	 * Test methods for the CustomerFactory
	 * {@link asgn2Customers.CustomerFactory#getCustomer(java.lang.String, java.lang.String, java.lang.String, int, int)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 */
	
	// Expecting correct customerCodes for three customers
	@Test
	public void testCustomerFactoryCorrectCodes() throws CustomerException {
		//Create CustomerFactory
		String pucName = "Michael Cartwright";
		String dncName = "Matthew Pike";
		String dvcName = "Alan Woodley";
		Customer newCustomerPUC = CustomerFactory.getCustomer("PUC", pucName, "0412345678", 0, 0);
		Customer newCustomerDNC = CustomerFactory.getCustomer("DNC", dncName, "0412345678", 5, 5);
		Customer newCustomerDVC = CustomerFactory.getCustomer("DVC", dvcName, "0412345678", 5, 5);
		if(newCustomerPUC.getName() == pucName && newCustomerDNC.getName() == dncName && newCustomerDVC.getName() == dvcName){
			assertTrue(true);
		} else{
			//Should never reach here
			fail("All three customers should have correct customer codes");
		}
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerFactoryInvalidCode() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("TES", "Michael Cartwright", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerFactoryEmptyCode() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("", "Michael Cartwright", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerFactoryNullCode() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer(null, "Michael Cartwright", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerFactoryLowerCaseCode() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("puc", "Michael Cartwright", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerUpperXLocationBounds() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("DVC", "Michael Cartwright", "0412345678", 12, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerUpperYLocationBounds() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("DVC", "Michael Cartwright", "0412345678", 0, 12);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerLowerXLocationBounds() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("DVC", "Michael Cartwright", "0412345678", -12, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerLowerYLocationBounds() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("DVC", "Michael Cartwright", "0412345678", 0, -12);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerSmallMobileNumber() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "Michael Cartwright", "041234567", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerLargeMobileNumber() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "Michael Cartwright", "04123456789", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberIncorrectBeginning() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "Michael Cartwright", "1412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberIncorrectBeginningAlphabet() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "Michael Cartwright", "S412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileNumberWithAlphabet() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "Michael Cartwright", "0ABCDEFGHI", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting the mobileNumber to be correct
	@Test
	public void testCustomerMobileNumberCorrect() throws CustomerException {
		//Create CustomerFactory
		String testMobileNumber = "0498765432";
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "Michael Cartwright", testMobileNumber, 0, 0);
		if(newCustomer.getMobileNumber() == testMobileNumber){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Mobile number is not correct");
		}
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameEmpty() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
		
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameNull() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", null, "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameDigits() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "B055M4N", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameLong() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "This name is way to long to bne 18 characters long", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameSymbol() throws CustomerException {
		//Create CustomerFactory
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "!", "0412345678", 0, 0);
		//Should never reach here
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerNameWhiteSpace() throws CustomerException {
		//Create Customer
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "     ", "0412345678", 0, 0);
		fail("Exception Expected");
	}
	
	// Expecting an exception
	@Test(expected=CustomerException.class)
	public void testCustomerMobileWhiteSpace() throws CustomerException {
		//Create Customer
		Customer newCustomer = CustomerFactory.getCustomer("PUC", "Ryuuko Matoi", "04 2345678", 0, 0);
		fail("Exception Expected");
	}
}
