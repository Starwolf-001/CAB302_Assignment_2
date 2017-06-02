package asgn2Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Michael Cartwright
 * 
 */
public class PizzaFactoryTests {
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting correct pizzaCodes for three pizza orders
	@Test
	public void testPizzaFactoryCorrectCodes() throws PizzaException {
		//Create PizzaFactory
		int pzmQuantity = 1;
		int pzvQuantity = 2;
		int pzlQuantity = 3;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", pzmQuantity, orderTime, deliveryTime);
		Pizza newPizzaPZV = PizzaFactory.getPizza("PZV", pzvQuantity, orderTime, deliveryTime);
		Pizza newPizzaPZL = PizzaFactory.getPizza("PZL", pzlQuantity, orderTime, deliveryTime);
		if(newPizzaPZM.getQuantity() == pzmQuantity && newPizzaPZV.getQuantity() == pzvQuantity && 
		   newPizzaPZL.getQuantity() == pzlQuantity && newPizzaPZM.getPizzaType().equals("Margherita") &&
		   newPizzaPZV.getPizzaType().equals("Vegetarian") && newPizzaPZL.getPizzaType().equals("Meat Lovers")){
			assertTrue(true);
		} else{
			//Should never reach here
			fail("All three pizza orders should have correct pizza codes");
		}
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting correct pizza price for each pizza type
	@Test
	public void testPizzaFactoryPizzaTypePrice() throws PizzaException {
		//Create PizzaFactory
		int pzmQuantity = 2;
		int pzvQuantity = 4;
		int pzlQuantity = 6;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", pzmQuantity, orderTime, deliveryTime);
		Pizza newPizzaPZV = PizzaFactory.getPizza("PZV", pzvQuantity, orderTime, deliveryTime);
		Pizza newPizzaPZL = PizzaFactory.getPizza("PZL", pzlQuantity, orderTime, deliveryTime);
		if(newPizzaPZM.getPricePerPizza() == 8 && newPizzaPZV.getPricePerPizza() == 10 && 
		   newPizzaPZL.getPricePerPizza() == 12) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("At least one pizza did not have the correct price of each type of pizza");
		}
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryInvalidCode() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("FAL", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryEmptyCode() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryCodeNull() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza(null, 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryLowerCaseCode() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("pzm", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryQuantityValueZero() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 0, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryQuantityValueHigh() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 11, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryQuantityNegative() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", -1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryOrderTimeNull() throws PizzaException {
		//Create PizzaFactory
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, null, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryDeliveryTimeNull() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, null);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryOrderTimeBeforeOpening() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("18:59:59");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryOrderTimeAfterClose() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("23:00:00");
		LocalTime deliveryTime = LocalTime.parse("23:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryOrderTimeEqualDeliveryTime() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("19:20:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryDeliveryTimeHourBeforeOrderTime() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("20:20:00");
		LocalTime deliveryTime = LocalTime.parse("19:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryDeliveryTimeHourSameMinutesBeforeOrderTime() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("20:20:00");
		LocalTime deliveryTime = LocalTime.parse("20:19:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryDeliveryTimeHourSameMinutesSameSecondsBeforeOrderTime() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("20:20:01");
		LocalTime deliveryTime = LocalTime.parse("20:20:00");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
	
	/**
	 * Test method for getPizza
	 * {@link asgn2Pizzas.PizzaFactory#getPizza(java.lang.String, int, java.time.LocalTime, java.time.LocalTime)}.
	 * @throws PizzaException as expected since pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Expecting an exception
	@Test(expected=PizzaException.class)
	public void testPizzaFactoryDeliveryTimeBeforeCooking() throws PizzaException {
		//Create PizzaFactory
		LocalTime orderTime = LocalTime.parse("20:20:00");
		LocalTime deliveryTime = LocalTime.parse("20:29:59");
		Pizza newPizzaPZM = PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
		//Expecting exception
		fail("Exception is expected");
	}
}
