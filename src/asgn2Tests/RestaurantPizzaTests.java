/**
 * 
 */
package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * @author Matthew Pike
 */
public class RestaurantPizzaTests {

	/**
	 * Test method for Restaurant Pizza aimed at testing Pizza
	 * {@link asgn2Restaurant.PizzaRestaurant#PizzaRestaurant()}.
	 * no throws
	 */
	// Test for ArrayList<Pizza> pizzas is empty.
	@Test
	public void testPizzaRestaurantPizza() {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		if(restaurant.getNumPizzaOrders() == 0) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("pizzas is not an empty ArrayList");
		}
	}

	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Successfully call processLog and prove that a customer was added in restaurant
	@Test
	public void testProcessLogSuccess() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/testPopulate.txt";
		restaurant.processLog(filename);
		if(restaurant.getNumPizzaOrders() == 1) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Pizzas is not an empty ArrayList");
		}
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogInvalidPizzaCode() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failCustomerCode.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogQuantityZero() throws CustomerException, LogHandlerException, PizzaException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityZero.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaQuantityNegative() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityNegative.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaQuantityHigh() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityHigh.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaQuantityEmpty() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityEmpty.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaQuantityDoubleVariable() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityDoubleVariable.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaQuantityNonDigit() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityNonDigit.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaQuantityGiantNumber() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityGiantNumber.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
		
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessPizzaQuantityGiantDoubleVariable() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityGiantDoubleVariable.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
		
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaOrderTimeEmpty() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaOrderTimeEmpty.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaDeliveryTimeEmpty() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaDeliveryTimeEmpty.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaTimeInvalidFormat() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaOrderTimeInvalidFormat.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaTimeNonDigits() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaOrderTimeNonDigits.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaOrderTimeBeforeOpening() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaOrderTimeBeforeOpening.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaOrderTimeAfterClose() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaOrderTimeAfterClose.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaDeliveryTimeInsideCookingTime() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaDeliveryTimeCookingTime.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaDeliveryTimeHourSinceOrderTime() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaDeliveryTimeHourSinceOrderTime.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaDeliveryTimeEqualOrderTime() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaDeliveryTimeEqualOrderTime.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaDeliveryTimeHourLessOrderTime() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaDeliveryTimeHourLess.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#processLog(java.lang.String)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected since the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Expecting exception
	@Test(expected=LogHandlerException.class)
	public void testProcessLogPizzaDeliveryTimeHourSameMinuteLessOrderTime() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaDeliveryTimeHourSameMinuteLess.txt";
		restaurant.processLog(filename);
		fail("Exception Expected");
	}
		
	/**
	 * Test method for getPizzaByIndex
	 * {@link asgn2Restaurant.PizzaRestaurant#getPizzaByIndex(int)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
		
	// Identifies if the first customer has the correct values found by method
	// Note: CustomerException and LogHandlerException added due to processLog()
	@Test
	public void testGetPizzaByIndexSuccess() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/testPopulate.txt";
		restaurant.processLog(filename);		
		if(restaurant.getPizzaByIndex(0).getPizzaType().equals("Vegetarian") && 
		   restaurant.getPizzaByIndex(0).getQuantity() == 10 &&
		   restaurant.getPizzaByIndex(0).getCostPerPizza() == 5.5 &&
		   restaurant.getPizzaByIndex(0).getOrderPrice() == 100 &&
		   restaurant.getPizzaByIndex(0).getOrderCost() == 55 &&
		   restaurant.getPizzaByIndex(0).getOrderProfit() == 45 &&
		   restaurant.getPizzaByIndex(0).getPricePerPizza() == 10) {
			assertTrue(true);
		} else {
			//Should never reach here
			fail("Pizza type, quantitiy, order time and delivery time did not match"
				 + " testPopulate");
		}
	}
	
	/**
	 * Test method for getPizzaByIndex
	 * {@link asgn2Restaurant.PizzaRestaurant#getPizzaByIndex(int)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications
	 */
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testGetPizzaByIndexNoPizzas() throws PizzaException{
		PizzaRestaurant restaurant = new PizzaRestaurant();
		restaurant.getPizzaByIndex(0);
		fail("Exception expected");
	}
		
	/**
	 * Test method for getPizzaByIndex
	 * {@link asgn2Restaurant.PizzaRestaurant#getPizzaByIndex(int)}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
		// Exception Expected
		// Note: CustomerException and LogHandlerException added due to processLog()
		@Test(expected=PizzaException.class)
		public void testGetPizzaByIndexNegative() throws CustomerException, PizzaException, LogHandlerException{
			PizzaRestaurant restaurant = new PizzaRestaurant();
			String filename = "logs/testPopulate.txt";
			restaurant.processLog(filename);
			if(restaurant.getPizzaByIndex(1).getPizzaType().equals("PZV")) {
				// Should not occur when customer Index is negative
			} else {
				fail("Exception expected");
			}
		}
		
		/**
		 * Test method for getPizzaByIndex
		 * {@link asgn2Restaurant.PizzaRestaurant#getPizzaByIndex(int)}.
		 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
		 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications
		 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer or pizza specifications
		 */
		
		// Exception Expected
		// Note: CustomerException and LogHandlerException added due to processLog()
		@Test(expected=PizzaException.class)
		public void testGetPizzaByIndexGreaterThanPizzaSize() throws CustomerException, PizzaException, LogHandlerException{
			PizzaRestaurant restaurant = new PizzaRestaurant();
			String filename = "logs/testPopulate.txt";
			restaurant.processLog(filename);
			if(!restaurant.getPizzaByIndex(1).getPizzaType().equals("PZV")) {
				// Should not occur when customer Index is locating a pizza that is outside the size of 
				// <ArrayList> Pizza pizzas
			} else {
				fail("Exception expected");
			}
		}
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#getNumPizzaOrders()}.
	 * no throws
	 */
		
	// Validates is the size of customers in zero using getNumCustomerOrders()
	@Test
	public void testGetNumPizzaOrders() {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		if(restaurant.getNumPizzaOrders() == 0) {
			assertTrue(true);
		} else {
			fail("Exception expected");
		}
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#getTotalProfit()}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	@Test
	public void testGetTotalProfitSuccess() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/20170101.txt";
		restaurant.processLog(filename);
		double totalOrderCost = 1.5 + 11 + 15;
		double totalOrderPrice = 8 + 20 + 36;
		double totalProfitTest = totalOrderPrice - totalOrderCost;
		
		if(restaurant.getTotalProfit() == totalProfitTest) {
			assertTrue(true);
		} else {
			//Both are not equal
			fail("getTotalProfit was not equal to totalProfitTest");
		}
	}
	
	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#getTotalProfit()}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException as expected for the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Exception Expected
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test(expected=LogHandlerException.class)
	public void testGetTotalProfitQuantityNegative() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/failPizzaQuantityNegative.txt";
		restaurant.processLog(filename);
		fail("Exception expected");
	}

	/**
	 * Test method for 
	 * {@link asgn2Restaurant.PizzaRestaurant#resetDetails()}.
	 * @throws CustomerException if customer details do not meet or fail the the customer specifications 
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications
	 * @throws LogHandlerException if the file cannot be read, missing parts, or not to customer or pizza specifications
	 */
	
	// Resets customers and pizzas
	// Note: CustomerException, PizzaException and LogHandlerException added due to processLog()
	@Test
	public void testResetDetailsSuccess() throws CustomerException, PizzaException, LogHandlerException {
		PizzaRestaurant restaurant = new PizzaRestaurant();
		String filename = "logs/20170101.txt";
		restaurant.processLog(filename);
		if(restaurant.getNumPizzaOrders() == 3) {
			restaurant.resetDetails();
			if(restaurant.getNumPizzaOrders() == 0) {
				assertTrue(true);
			} else {
				// Should not reach here
				fail("Pizzas were not reset");	
			}
		} else {
			// Should not reach here
			fail("Pizzas were not successfully added");	
		}
	}

}
