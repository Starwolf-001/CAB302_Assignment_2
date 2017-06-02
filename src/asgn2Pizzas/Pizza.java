package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Michael Cartwright
 *
 */
public abstract class Pizza  {
	
	private int pizzaQuantity;
	private LocalTime pizzaOrderTime;
	private LocalTime pizzaDeliveryTime;
	private String pizzaType;
	private Double perPizzaPrice;
	private Double totalOrderCost;
	private Double perPizzaCost;
	private Double totalOrderPrice;
	private Double totalOrderProfit;
	private PizzaTopping toppingList[] = new PizzaTopping[]{};
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		this.pizzaQuantity = quantity;
		this.pizzaOrderTime = orderTime;
		this.pizzaDeliveryTime = deliveryTime;
		this.pizzaType = type;
		this.perPizzaPrice = price;
		
		// Checks if pizzaQuantity meets the specifications
		if(pizzaQuantity <= 0) {
			throw new PizzaException("Pizza quantity cannot be less than or equal to 0");
		}
		if(pizzaQuantity > 10) {
			throw new PizzaException("Pizza quantity cannot be more than 10");
		}
		// Checks if pizza orderTime and deliverTime meet the specifications
		if(pizzaOrderTime == null || pizzaOrderTime.equals("")) {
			throw new PizzaException("Order time cannot be NULL");
		}
		if(pizzaDeliveryTime == null || pizzaDeliveryTime.equals("")) {
			throw new PizzaException("Delivery time cannot be NULL");
		}
		if(pizzaOrderTime.getHour() < 19) {
			throw new PizzaException("Pizza cannot be ordered before Pizza Palace has opened");
		}
		if(pizzaOrderTime.getHour() >= 23) {
			throw new PizzaException("Pizza cannot be ordered after Pizza Palace has closed");
		}
		if(pizzaDeliveryTime == pizzaOrderTime) {
			throw new PizzaException("Delivery Time cannot be the same time as pizzaOrderTime");
		}
		if(pizzaDeliveryTime.getHour() < pizzaOrderTime.getHour()) {
			throw new PizzaException("Delivery Time cannot be the earlier than pizzaOrderTime");
		}
		if(pizzaDeliveryTime.getHour() == pizzaOrderTime.getHour() && pizzaDeliveryTime.getMinute() < pizzaOrderTime.getMinute()) {
			throw new PizzaException("Delivery Time cannot be the earlier than pizzaOrderTime");
		}
		int minuteSet = pizzaOrderTime.getMinute() + 10;
		if(minuteSet >= 60) {
			minuteSet = minuteSet - 60;
		}
		if(pizzaDeliveryTime.getMinute() < minuteSet) {
			if(pizzaDeliveryTime.getHour() <= pizzaOrderTime.getHour()) {
				throw new PizzaException("Delivery Time must be at least 10 minutes more than orderTime due to 10 minute"
				                         + " cooking time");
			}
		}
		if(pizzaDeliveryTime.getHour() > pizzaOrderTime.getHour() && pizzaDeliveryTime.getMinute() >= 
		   pizzaOrderTime.getMinute() && pizzaDeliveryTime.getSecond() > pizzaOrderTime.getSecond()) {
			throw new PizzaException("Pizza's deliveryTime indicates pizza was not delivered or pickup"
					                 + " up more than 1 hour since orderTime");
		}
		// Checks if pizzaType returned correctly
		if(pizzaType == "" || pizzaType == null) {
			throw new PizzaException("Pizza type cannot be an empty string or NULL");
		}
		// Checks if the pizzaPrice (per) is not negative
		if(perPizzaPrice < 0) {
			throw new PizzaException("Pizza price cannot be less than $0.00");
		}
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 * @param inToppingList - toppingList take from the "pizzaType"Pizza.java 
	 */
	public final void calculateCostPerPizza(PizzaTopping inToppingList[]){
		perPizzaCost = 0.0;
		// Takes toppings from "specified"Pizza.java
		this.toppingList = inToppingList;
		for(PizzaTopping element: this.toppingList) {
			if(containsTopping(element)){
				perPizzaCost += (Double)element.getCost();
			}
		}
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		return this.perPizzaCost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		return this.perPizzaPrice;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		this.totalOrderCost = this.getQuantity() * this.getCostPerPizza();
		return this.totalOrderCost;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		this.totalOrderPrice = this.getQuantity() * this.getPricePerPizza();
		return this.totalOrderPrice;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		this.totalOrderProfit = this.getOrderPrice() - this.getOrderCost();
		return this.totalOrderProfit;
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		for (PizzaTopping element: this.toppingList) {
			if(topping.equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		return this.pizzaQuantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		return this.pizzaType;
	}

	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}	
}
