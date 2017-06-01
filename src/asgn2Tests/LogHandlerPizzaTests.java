package asgn2Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Michael Cartwright
* 
*/
public class LogHandlerPizzaTests {

	/**
	 * Test method for populatePizzaDataset
	 * {@link asgn2Restaurant.LogHandler#populatePizzaDataset(java.lang.String)}.
	 * @throws PizzaException, LogHandlerException
	 */
	
	// Expecting a single Pizza to be populated and created
	@Test
	public void testPopulateSinglePizzaDataset() throws PizzaException, LogHandlerException {
		String file = "logs/testPopulate.txt";
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		ArrayList<Pizza> resultCheck = new ArrayList<Pizza>();
		resultCheck.add(PizzaFactory.getPizza("PZV", 10, orderTime, deliveryTime));
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		if(result.equals(resultCheck)){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to populate or create a single pizza");
		}
	}
	
	// Expecting multiple Pizzas to be populated and created
	@Test
	public void testFirstLogFileMultiplePizzas() throws PizzaException, LogHandlerException {
		String file = "logs/20170101.txt";
		LocalTime orderTimeOne = LocalTime.parse("19:00:00");
		LocalTime deliveryTimeOne = LocalTime.parse("19:20:00");
		LocalTime orderTimeTwo = LocalTime.parse("20:00:00");
		LocalTime deliveryTimeTwo = LocalTime.parse("20:25:00");
		LocalTime orderTimeThree = LocalTime.parse("21:00:00");
		LocalTime deliveryTimeThree = LocalTime.parse("21:35:00");
		ArrayList<Pizza> resultCheck = new ArrayList<Pizza>();
		resultCheck.add(PizzaFactory.getPizza("PZV", 2, orderTimeOne, deliveryTimeOne));
		resultCheck.add(PizzaFactory.getPizza("PZM", 1, orderTimeTwo, deliveryTimeTwo));
		resultCheck.add(PizzaFactory.getPizza("PZL", 3, orderTimeThree, deliveryTimeThree));
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		if(result.get(0).equals(resultCheck.get(0)) && result.get(1).equals(resultCheck.get(1)) &&
		   result.get(2).equals(resultCheck.get(2))){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to populate or create multiple pizzas");
		}
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaNoSuchFileName() throws PizzaException, LogHandlerException {
		String file = "logs/NoSuchFileName.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaCodeInvalid() throws PizzaException, LogHandlerException {
		String file = "logs/failCustomerCode.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityZero() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityZero.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityNegative() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityNegative.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityHigh() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityHigh.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityEmpty() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityEmpty.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityDoubleVariable() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityDoubleVariable.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityNonDigit() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityNonDigit.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityGiantNumber() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityGiantNumber.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaQuantityGiantDoubleVariable() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaQuantityGiantDoubleVariable.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaOrderTimeEmpty() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaOrderTimeEmpty.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaDeliveryTimeEmpty() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaDeliveryTimeEmpty.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaTimeInvalidFormat() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaOrderTimeInvalidFormat.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaTimeNonDigits() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaOrderTimeNonDigits.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaOrderTimeBeforeOpening() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaOrderTimeBeforeOpening.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaOrderTimeAfterClose() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaOrderTimeAfterClose.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaDeliveryTimeInsideCookingTime() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaDeliveryTimeCookingTime.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaDeliveryTimeHourSinceOrderTime() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaDeliveryTimeHourSinceOrderTime.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaDeliveryTimeEqualOrderTime() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaDeliveryTimeEqualOrderTime.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaDeliveryTimeHourLessOrderTime() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaDeliveryTimeHourLess.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testPizzaDeliveryTimeHourSameMinuteLessOrderTime() throws PizzaException, LogHandlerException {
		String file = "logs/failPizzaDeliveryTimeHourSameMinuteLess.txt";
		ArrayList<Pizza> result = LogHandler.populatePizzaDataset(file);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for createPizza
	 * {@link asgn2Restaurant.LogHandler#createPizza(java.lang.String)}.
	 * @throws PizzaException, LogHandlerException
	 */
	
	// Expecting Pizza to be created
	@Test
	public void testCreatePizza() throws PizzaException, LogHandlerException{
		String expected = "19:00:00,19:20:00,Casey Jones,0423456789,DVC,5,5,PZV,2";
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		ArrayList<Pizza> result = new ArrayList<Pizza>();
		result.add(PizzaFactory.getPizza("PZV", 2, orderTime, deliveryTime));
		result.add(LogHandler.createPizza(expected));
		if (result.get(0).equals(result.get(1))){
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Failed to create two pizzas or both pizzas are not identical");
		}
	}
}
