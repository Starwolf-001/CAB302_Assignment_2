package asgn2Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Michael Cartwright
 */
public class LogHandlerCustomerTests {

	/**
	 * Test method for populateCustomerDataset
	 * {@link asgn2Restaurant.LogHandler#populateCustomerDataset(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer specifications
	 */
	
	// Expecting a single Customer to be populated and created
	@Test
	public void testPopulateSingleCustomerDataset() throws CustomerException, LogHandlerException {
		String file = "logs/testPopulate.txt";
		ArrayList<Customer> resultCheck = new ArrayList<Customer>();
		resultCheck.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5, 5));
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		if(result.equals(resultCheck)){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to populate or create a single customer");
		}
	}
	
	// Expecting multiple Customers to be populated and created
	@Test
	public void testPopulateMultipleCustomerDataset() throws CustomerException, LogHandlerException {
		String file = "logs/testPopulateMultiple.txt";
		ArrayList<Customer> resultCheck = new ArrayList<Customer>();
		resultCheck.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5, 5));
		resultCheck.add(CustomerFactory.getCustomer("DNC", "April ONeal", "0487654321", 3, 4));
		resultCheck.add(CustomerFactory.getCustomer("PUC", "Oroku Saki", "0411222333", 0, 0));
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		if(result.get(0).equals(resultCheck.get(0)) && result.get(1).equals(resultCheck.get(1)) &&
		   result.get(2).equals(resultCheck.get(2))){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to populate or create multiple customers");
		}
	}
	
	// Expecting customers in 20170101.txt to be created
	@Test
	public void testFirstLogFile() throws CustomerException, LogHandlerException {
		String file = "logs/20170101.txt";
		ArrayList<Customer> resultCheck = new ArrayList<Customer>();
		resultCheck.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789", 5, 5));
		resultCheck.add(CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321", 3, 4));
		resultCheck.add(CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0));
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		if(result.get(0).equals(resultCheck.get(0)) && result.get(1).equals(resultCheck.get(1)) &&
		   result.get(2).equals(resultCheck.get(2))){
			assertTrue(true);
		} else {
				//Should never reach here
			fail("Failed to populate or create multiple customers");
		}
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerNoSuchFileName() throws CustomerException, LogHandlerException {
		String file = "logs/thisFileDoesNotExist.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerCodeInvalid() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerCode.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerNameInvalidSymbol() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerNameSymbol.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerNameEmpty() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerNameEmpty.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerNameLong() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerNameLong.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerNameDigits() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerNameDigits.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerMobileStartingWithOne() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerMobileStartingWithOne.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerMobileNonDigit() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerMobileNonDigit.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerMobileShort() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerMobileShort.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerMobileLong() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerMobileLong.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerMobileEmpty() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerMobileEmpty.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerInvalidPickUp() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerInvalidPickUp.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerInvalidDroneAtPizzaPalace() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerInvalidDroneAtPizzaPalace.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerInvalidDroneUpperXBound() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerInvalidDroneUpperXBound.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerInvalidDroneLowerXBound() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerInvalidDroneLowerXBound.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerInvalidDroneUpperYBound() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerInvalidDroneUpperYBound.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
		
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerInvalidDroneLowerYBound() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerInvalidDroneLowerYBound.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=LogHandlerException.class)
	public void testCustomerInvalidLocationXDoubleVariable() throws CustomerException, LogHandlerException {
		String file = "logs/failCustomerInvalidLocationXDoubleVariable.txt";
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		fail("Exception is expected");
	}

	/**
	 * Test method for createCustomer
	 * {@link asgn2Restaurant.LogHandler#createCustomer(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer specifications
	 */
	
	// Expecting Customer to be created
	@Test
	public void testCreateCustomer() throws CustomerException, LogHandlerException {
		String expected = "19:00:00,19:20:00,Casey Jones,0423456789,DVC,5,5,PZV,2";
		ArrayList<Customer> result = new ArrayList<Customer>();
		result.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5, 5));
		result.add(LogHandler.createCustomer(expected));
		if (result.get(0).equals(result.get(1))){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to create two customers or both customer are not identical");
		}
	}
}
