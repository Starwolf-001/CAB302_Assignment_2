package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** An abstract class to represent a customer at the Pizza Palace restaurant.
 *  The Customer class is used as a base class of PickUpCustomer, 
 *  DriverDeliveryCustomer and DroneDeliverCustomer. Each of these subclasses overwrites
 *  the abstract method getDeliveryDistance. A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.  
 * 
 * @author Michael Cartwright
*/
public abstract class Customer {
	
	private String customerName;
	private String customerMobileNumber;
	private int customerLocationX;
	private int customerLocationY;
	private String customerType;
	private String whiteSpaceString = "";

	/**
	 *  This class represents a customer of the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.2. 
	 *  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment Specification
	 *  are violated. 
	 *  
	 *  Assumption 1: English US or UK characters are used for people's names.
	 *  Assumption 2: Valid characters in customer name are capital letters, lower case letters, spaces, hyphens or apostrophes.
	 *  Assumption 3: Any other character is considered invalid.
	 *  
  	 * <P> PRE: True
  	 * <P> POST: All field values are set
  	 * 
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY - The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param type - A human understandable description of this Customer type
	 * @throws CustomerException if supplied parameters are invalid 
	 * 
	 */
	public Customer(String name, String mobileNumber, int locationX, int locationY, String type) throws CustomerException{
		this.customerName = name;
		this.customerMobileNumber = mobileNumber;
		this.customerLocationX = locationX;
		this.customerLocationY = locationY;
		this.customerType = type;
		
		if(customerName == "" || customerName == null) {
			throw new CustomerException("customerName is an empty string or is null");
		}
		if(customerName.length() < 1 || customerName.length() > 18) {
			throw new CustomerException("customerName requires between 1 to 18 characters");
		}
		for(int indexLength = 0; indexLength <= customerName.length(); indexLength++) {
			if(indexLength == customerName.length()) {
				if(customerName.matches(whiteSpaceString)) {
					throw new CustomerException("customerName cannot be filled with only white spaces");
				} else {
					whiteSpaceString = "";
				}
			} else {
				whiteSpaceString = whiteSpaceString + " ";
			}
		}
		for(int indexLetter = 0; indexLetter < customerName.length(); indexLetter++) {
			// Checks to for a valid letter, space, hyphen or apostrophe(ANSI value of 39) character.
			if(Character.isLetter(customerName.charAt(indexLetter)) || customerName.charAt(indexLetter) == ' ' ||
			   customerName.charAt(indexLetter) == '-' || customerName.charAt(indexLetter) == 39) {
				// Do nothing as character is a letter or space
			} else {
				throw new CustomerException("customerName cannot contain numeric digits or invalid symbol character"
										    + " was used");
			}
		}
		if(customerMobileNumber == "" || customerMobileNumber == null) {
			throw new CustomerException("customerMobileNumber is an empty string or is null");
		}
		if(customerMobileNumber.length() != 10) {
			throw new CustomerException("customerMobileNumber must be 10 digits long");
		}
		if(customerMobileNumber.charAt(0) != '0') {
			throw new CustomerException("customerMobileNumber must start with a 0");
		}
		for(int indexDigit = 0; indexDigit < 10; indexDigit++) {
			if(Character.isDigit(customerMobileNumber.charAt(indexDigit))) {
				// Do nothing as character is a digit
			} else {
				throw new CustomerException("customerMobileNumber must only contain numbers from, and including, 0 to 9");
			}
		}
		if(customerLocationX < -10 || customerLocationX > 10) {
			throw new CustomerException("customerLocationX is either greater than 10 or less than -10");
		}
		if(customerLocationY < -10 || customerLocationY > 10) {
			throw new CustomerException("customerLocationY is either greater than 10 or less than -10");
		}
		if(customerType != "Pick Up" && customerType != "Drone Delivery" && customerType != "Driver Delivery") {
			throw new CustomerException("customerType is an empty string or is null");
		}
	}
	
	/**
	 * Returns the Customer's name.
	 * @return The Customer's name.
	 */
	public final String getName(){
		return this.customerName;
	}
	
	/**
	 * Returns the Customer's mobile number.
	 * @return The Customer's mobile number.
	 */
	public final String getMobileNumber(){
		return this.customerMobileNumber;
	}

	/**
	 * Returns a human understandable description of the Customer's type. 
	 * The valid alternatives are listed in Section 5.2 of the Assignment Specification. 
	 * @return A human understandable description of the Customer's type.
	 */
	public final String getCustomerType(){
		return this.customerType;
	}
	
	/**
	 * Returns the Customer's X location which is the number of blocks East or West 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's X location
	 */
	public final int getLocationX(){
		return this.customerLocationX;
	}

	/**
	 * Returns the Customer's Y location which is the number of blocks North or South 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's Y location
	 */
	public final int getLocationY(){
		return this.customerLocationY;
	}

	/**
	 * An abstract method that returns the distance between the Customer and 
	 * the restaurant depending on the mode of delivery. 
	 * @return The distance between the restaurant and the Customer depending on the mode of delivery.
	 */
	public abstract double getDeliveryDistance();
	
	/**
	 * Compares *this* Customer object with an instance of an *other* Customer object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 *  You do not need to test this method.
	 * 
	 * @return true if *this* Customer object and the *other* Customer object have the same values returned for 	
	 * getName(),getMobileNumber(),getLocationX(),getLocationY(),getCustomerType().
	 */
	@Override
	public boolean equals(Object other){
		Customer otherCustomer = (Customer) other;

		return ( (this.getName().equals(otherCustomer.getName()))  &&
			(this.getMobileNumber().equals(otherCustomer.getMobileNumber())) && 
			(this.getLocationX() == otherCustomer.getLocationX()) && 
			(this.getLocationY() == otherCustomer.getLocationY()) && 
			(this.getCustomerType().equals(otherCustomer.getCustomerType())) );			
	}

}
