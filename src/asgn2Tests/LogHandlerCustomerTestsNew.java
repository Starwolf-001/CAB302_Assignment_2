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
	 * Test method for populating, creating and validating customer(s)
	 * {@link asgn2Restaurant.LogHandler#populateCustomerDataset(java.lang.String)}.
	 * @throws CustomerException, LogHandlerException
	 */
	
	// Expecting Customer result to be equal to the resultCheck
	@Test
	public void testPopulateSingleCustomerDataset() throws CustomerException, LogHandlerException {
		String file = "logs/testPopulate.txt";
		ArrayList<Customer> resultCheck = new ArrayList<Customer>();
		resultCheck.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5,  5));
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		if(result.equals(resultCheck)){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to populate or create a single customer");
		}
	}
	
	// Expecting Customers results to be equal to the resultChecks
	@Test
	public void testPopulateMultipleCustomerDataset() throws CustomerException, LogHandlerException {
		String file = "logs/testPopulateMultiple.txt";
		ArrayList<Customer> resultCheck = new ArrayList<Customer>();
		resultCheck.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5,  5));
		resultCheck.add(CustomerFactory.getCustomer("DNC", "April ONeal", "0487654321", 3,  4));
		resultCheck.add(CustomerFactory.getCustomer("PUC", "Oroku Saki", "0411222333", 0,  0));
		ArrayList<Customer> result = LogHandler.populateCustomerDataset(file);
		if(result.get(0).equals(resultCheck.get(0)) && result.get(1).equals(resultCheck.get(1)) &&
		   result.get(2).equals(resultCheck.get(2))){
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
		ArrayList<Customer> result = new ArrayList<Customer>();
		result.add(CustomerFactory.getCustomer("DVC", "Casey Jones", "0423456789", 5,  5));
		result.add(LogHandler.createCustomer(expected));
		if (result.get(0).equals(result.get(1))){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to create two customers or both customer are not identical");
		}
	}

}
