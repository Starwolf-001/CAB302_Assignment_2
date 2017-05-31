/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

import org.junit.Test;

/**
 * @author Michael Cartwright
 *
 */
public class LogHandlerCustomerTestsNew {

	/**
	 * Test method for populating customers
	 * {@link asgn2Restaurant.LogHandler#populateCustomerDataset(java.lang.String)}.
	 * @throws CustomerException, LogHandlerException
	 */
	@Test
	public void testPopulateSingleCustomerDataset() throws CustomerException, LogHandlerException {
		String file = "logs/testPopulate.txt";
		String expected = "19:00:00,19:20:00,Casey Jones,0423456789,DVC,5,5,PZV,2";
		ArrayList<Customer> resultcheck = new ArrayList<Customer>();
		resultcheck.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5,  5));
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		if (result.equals(resultcheck)){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to populate or create a single customer");
		}
	}

	/**
	 * Test method for creating customer
	 * {@link asgn2Restaurant.LogHandler#createCustomer(java.lang.String)}.
	 * @throws CustomerException, LogHandlerException
	 * @throws LogHandlerException 
	 */
	@Test
	public void testCreateCustomer() throws CustomerException, LogHandlerException {
		String expected = "19:00:00,19:20:00,Casey Jones,0423456789,DVC,5,5,PZV,2";
		ArrayList<Customer> resultcheck = new ArrayList<Customer>();
		resultcheck.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5,  5));
		resultcheck.add(LogHandler.createCustomer(expected));
		if (resultcheck.get(0).equals(resultcheck.get(1))){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to create two customers or both customer are not identical");
		}
	}

}
