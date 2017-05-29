package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.CustomerException;
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
		
		if(pizzaQuantity <= 0) {
			throw new PizzaException("Pizza quantity cannot be less than or equal to 0");
		}
		if(pizzaQuantity > 10) {
			throw new PizzaException("Pizza quantity cannot be more than 10");
		}
		if(pizzaOrderTime.getHour() < 19) {
			throw new PizzaException("Pizza cannot be ordered before Pizza Palace has opened");
		}
		if(pizzaOrderTime.getHour() >= 23) {
			throw new PizzaException("Pizza cannot be ordered after Pizza Palace has closed");
		}
		if(pizzaOrderTime == null) {
			throw new PizzaException("Order time cannot be NULL");
		}
		// TODO need to further investigate
		if(pizzaDeliveryTime == null) {
			throw new PizzaException("Delivery Time cannot be NULL");
		}
		if(pizzaDeliveryTime == pizzaOrderTime) {
			throw new PizzaException("Delivery Time cannot be the same tiem as pizzaOrderTime");
		}
		if(pizzaType == "" || pizzaType == null) {
			throw new PizzaException("Pizza type cannot be an empty string or NULL");
		}
		if(perPizzaPrice < 0) {
			throw new PizzaException("Pizza quantity cannot be less than $0.00");
		}
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		perPizzaCost = 0.0;
		for(PizzaTopping element: toppingList) {
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
		return perPizzaCost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		return perPizzaPrice;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		return totalOrderCost;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		// TODO foreach pizza the price times the quantity
		//      Sum of total foreach pizza
		//      Sum of combined total
		
		// double currentPizzaPrice = pizza.getPricePerPizza();
		// int currentPizzaQuantity = pizza.getQuantity();
		// double total = currentPizzaPrice * currentPizzaQuantity;
		// totalCombinedPrice = currentPizza.total + otherPizza.total;
		return totalOrderPrice;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		// TODO What is the profit per pizza?
		//      Does profit change with different quantity ratios?
		return totalOrderProfit;
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		for (PizzaTopping element: toppingList) {
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
		return pizzaQuantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		return pizzaType;
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
