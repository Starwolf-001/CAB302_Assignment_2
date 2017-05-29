package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;



/**
 * 
 *  A class that represents a margherita pizza made at the Pizza Palace restaurant. 
 *  The margherita pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Michael Cartwright
 *
 */
public class MargheritaPizza extends Pizza {
	
	private int pizzaQuantity;
	private LocalTime pizzaOrderTime;
	private LocalTime pizzaDeliveryTime;
	private PizzaTopping toppingList[] = new PizzaTopping[]{PizzaTopping.CHEESE, PizzaTopping.TOMATO};
	
	/**
	 * 
	 *  This class represents a margherita pizza made at the  Pizza Palace restaurant.   The margherita pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
	 * <P>PRE: TRUE
	 * <P>POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MargheritaPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		super(quantity, orderTime, deliveryTime, "Margherita", 8);
		
		if(pizzaQuantity <= 0) {
			throw new PizzaException("Pizza quantity cannot be less than or equal to 0.");
		}
		if(pizzaQuantity > 10) {
			throw new PizzaException("Pizza quantity cannot be more than 10.");
		}
		if(pizzaOrderTime.getHour() < 19) {
			throw new PizzaException("Pizza cannot be ordered before Pizza Palace has opened.");
		}
		if(pizzaOrderTime.getHour() >= 23) {
			throw new PizzaException("Pizza cannot be ordered after Pizza Palace has closed.");
		}
		if(pizzaOrderTime == null) {
			throw new PizzaException("Order time cannot be NULL.");
		}
		// TODO need to further investigate
		if(pizzaDeliveryTime == null) {
			throw new PizzaException("Delivery Time cannot be NULL.");
		}
	}

}
