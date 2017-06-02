package asgn2Tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Michael Cartwright
 *
 */
public class PizzaTests {
	/**
	 * Test method for Pizza
	 * {@link asgn2Pizzas.Pizza#Pizza(int, java.time.LocalTime, java.time.LocalTime, java.lang.String, double)}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Meat lovers pizza test to identify if pizza works as intended using MeatLoversPizza
	@Test
	public void testMeatLoversPizzaSuccessful() throws PizzaException {
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getPizzaType() == "Meat Lovers" && newPizza.getQuantity() == quantity && 
		   newPizza.getCostPerPizza() == 5 && newPizza.getOrderCost() == 10 && 
		   newPizza.getOrderPrice() == 24 && newPizza.getOrderProfit() == 14 && newPizza.getPricePerPizza() == 12) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Pizza failed to be implemented correctly");
		}
	}
	
	// Vegetarian pizza test to identify if pizza works as intended using VegetarianPizza
	@Test
	public void testVegetarianPizzaSuccessful() throws PizzaException {
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new VegetarianPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getPizzaType() == "Vegetarian" && newPizza.getQuantity() == quantity && 
		   newPizza.getCostPerPizza() == 5.5 && newPizza.getOrderCost() == 11 && 
		   newPizza.getOrderPrice() == 20 && newPizza.getOrderProfit() == 9 && newPizza.getPricePerPizza() == 10) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Pizza failed to be implemented correctly");
		}
	}
	
	// Margherita pizza test to identify if pizza works as intended using MargheritaPizza
	@Test
	public void testMargheritaPizzaSuccessful() throws PizzaException {
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getPizzaType() == "Margherita" && newPizza.getQuantity() == quantity && 
		   newPizza.getCostPerPizza() == 1.5 && newPizza.getOrderCost() == 3.0 && 
		   newPizza.getOrderPrice() == 16 && newPizza.getOrderProfit() == 13 && newPizza.getPricePerPizza() == 8) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Pizza failed to be implemented correctly");
		}
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaQuantityZero() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(0, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaQuantityNegative() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(-1, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaHighQuantity() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaOrderTimeNull() throws PizzaException {
		//Create Pizza
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(11, null, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaDeliveryTimeNull() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, null);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaOrderTimeBeforeOpening() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("18:10:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaOrderTimeAfterClosed() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("23:10:00");
		LocalTime deliveryTime = LocalTime.parse("23:50:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaOrderTimeEqualsDeliveryTime() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("19:10:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaDeliveryOrderHourLessThanOrderTime() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("20:10:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaDeliveryOrderHourSameMinuteLessThanOrderTime() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("20:10:00");
		LocalTime deliveryTime = LocalTime.parse("20:09:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaDeliveryTimeLessThanCookingTime() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("20:10:00");
		LocalTime deliveryTime = LocalTime.parse("20:19:00");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaTimeExpired() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("20:10:00");
		LocalTime deliveryTime = LocalTime.parse("21:10:01");
		Pizza newPizza = new MargheritaPizza(11, orderTime, deliveryTime);
		fail("Exception Expected");
	}
	
	// Exception Expected
	@Test(expected=PizzaException.class)
	public void testPizzaPriceLessThanZero() throws PizzaException {
		//Create Pizza
		LocalTime orderTime = LocalTime.parse("20:10:00");
		LocalTime deliveryTime = LocalTime.parse("20:25:00");
		Pizza newPizza = new MargheritaPizza(-1, orderTime, deliveryTime);
		fail("Exception Expected");
	}

	/**
	 * Test method for calculateCostPerPizza
	 * {@link asgn2Pizzas.Pizza#calculateCostPerPizza()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for calcaluateCostPerPizza
	// @throws PizzaException due to Pizza
	@Test
	public void testCalculateCostPerPizza() throws PizzaException{
		//Create Pizza
		int quantity = 1;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getCostPerPizza() == 5) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to get toppings, or price of toppings");
		}
	}

	/**
	 * Test method for getCostPerPizza
	 * {@link asgn2Pizzas.Pizza#getCostPerPizza()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for getCostPerPizza
	// @throws PizzaException due to Pizza
	@Test
	public void testGetCostPerPizza() throws PizzaException{
		//Create Pizza
		int quantity = 1;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		// Change toppingList
		PizzaTopping toppingList[] = new PizzaTopping[]{PizzaTopping.CHEESE, PizzaTopping.TOMATO, 
										 PizzaTopping.EGGPLANT, PizzaTopping.MUSHROOM,
										 PizzaTopping.CAPSICUM};
		// Should be newPizza's toppings
		if(newPizza.getCostPerPizza() == 1.5) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to successfully run calculateCostPerPizza, or get toppings, or price of toppings");
		}
	}

	/**
	 * Test method for getPricePerPizza
	 * {@link asgn2Pizzas.Pizza#getPricePerPizza()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for getCostPerPizza
	// @throws PizzaException due to Pizza
	@Test
	public void testGetPricePerPizza() throws PizzaException{
		//Create Pizza
		int quantity = 1;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getPricePerPizza() == 8) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to get price of Margherita pizza");
		}
	}

	/**
	 * Test method for getOrderCost
	 * {@link asgn2Pizzas.Pizza#getOrderCost()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for getOrderCost
	// @throws PizzaException due to Pizza
	@Test
	public void testGetOrderCost() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getOrderCost() == 3) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to get cost of the Quantity x 2 Margherita pizza order");
		}
	}

	/**
	 * Test method for getOrderPrice
	 * {@link asgn2Pizzas.Pizza#getOrderPrice()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for getOrderPrice
	// @throws PizzaException due to Pizza
	@Test
	public void testGetOrderPrice() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getOrderPrice() == 16) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to get price of the Quantity x 2 Margherita pizza order");
		}
	}
	
	/**
	 * Test method for getOrderProfit
	 * {@link asgn2Pizzas.Pizza#getOrderProfit()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for getOrderProfit
	// @throws PizzaException due to Pizza
	@Test
	public void testGetOrderProfit() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getOrderProfit() == 13) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to get order profit");
		}
	}
	
	/**
	 * Test method for containsTopping
	 * {@link asgn2Pizzas.Pizza#containsTopping(asgn2Pizzas.PizzaTopping)}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for constainsTopping and MargheritaPizza
	// @throws PizzaException due to Pizza
	@Test
	public void testMargheritaPizzaContainsTopping() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.containsTopping(PizzaTopping.CHEESE) && newPizza.containsTopping(PizzaTopping.TOMATO)) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("One or more toppings are not on the Margherita pizza");
		}
	}
	
	// Specific test for constainsTopping and MargheritaPizza
	// @throws PizzaException due to Pizza
	@Test
	public void testVegetarianPizzaContainsTopping() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new VegetarianPizza(quantity, orderTime, deliveryTime);
		if(newPizza.containsTopping(PizzaTopping.CHEESE) && newPizza.containsTopping(PizzaTopping.TOMATO) && 
		   newPizza.containsTopping(PizzaTopping.CAPSICUM) && newPizza.containsTopping(PizzaTopping.MUSHROOM) &&
		   newPizza.containsTopping(PizzaTopping.EGGPLANT)) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("One or more toppings are not on the Vegetarian pizza");
		}
	}
	
	// Specific test for constainsTopping and Meat Lovers Pizza
	// @throws PizzaException due to Pizza
	@Test
	public void testMeatLoversPizzaContainsTopping() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		if(newPizza.containsTopping(PizzaTopping.CHEESE) && newPizza.containsTopping(PizzaTopping.TOMATO) &&
		   newPizza.containsTopping(PizzaTopping.BACON) && newPizza.containsTopping(PizzaTopping.SALAMI) && 
		   newPizza.containsTopping(PizzaTopping.PEPPERONI)) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("One or more toppings are not on the Meat Lovers pizza");
		}
	}
	
	// Specific test for constainsTopping and Meat Lovers Pizza
	// @throws PizzaException due to Pizza
	@Test
	public void testPizzaWrongToppings() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MeatLoversPizza(quantity, orderTime, deliveryTime);
		if(newPizza.containsTopping(PizzaTopping.CHEESE) && newPizza.containsTopping(PizzaTopping.TOMATO) &&
		   newPizza.containsTopping(PizzaTopping.BACON) && newPizza.containsTopping(PizzaTopping.SALAMI) && 
		   newPizza.containsTopping(PizzaTopping.PEPPERONI) && !newPizza.containsTopping(PizzaTopping.CAPSICUM) &&
		   !newPizza.containsTopping(PizzaTopping.MUSHROOM) && !newPizza.containsTopping(PizzaTopping.EGGPLANT)) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Extra toppings should not be on the Meat Lovers pizza but are being included");
		}
	}

	/**
	 * Test method for getQuantity
	 * {@link asgn2Pizzas.Pizza#getQuantity()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for getQuantity
	// @throws PizzaException due to Pizza
	@Test
	public void testGetQuantity() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getQuantity() == 2) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to get a quantity of 2");
		}
	}

	/**
	 * Test method for getPizzaType
	 * {@link asgn2Pizzas.Pizza#getPizzaType()}.
	 * @throws PizzaException if pizza details do not meet or fail the the pizza specifications 
	 */
	
	// Specific test for getPizzaType
	// @throws PizzaException due to Pizza
	@Test
	public void testGetPizzaType() throws PizzaException{
		//Create Pizza
		int quantity = 2;
		LocalTime orderTime = LocalTime.parse("19:00:00");
		LocalTime deliveryTime = LocalTime.parse("19:10:00");
		Pizza newPizza = new MargheritaPizza(quantity, orderTime, deliveryTime);
		if(newPizza.getPizzaType().equals("Margherita")) {
			assertTrue(true);
		} else{
			//Should never reach here
			fail("Failed to get correct pizzaType");
		}
	}

	/**
	 * Test method for {@link asgn2Pizzas.Pizza#equals(java.lang.Object)}.
	 * equals() does not need to be tested
	 */
}
