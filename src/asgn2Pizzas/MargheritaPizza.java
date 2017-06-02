package asgn2Pizzas;
import java.time.LocalTime;

import asgn2Exceptions.PizzaException;



/**
 * 
 *  A class that represents a margherita pizza made at the Pizza Palace restaurant. 
 *  The margherita pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author Person A
 *
 */
public class MargheritaPizza extends Pizza {
	
	// this is setting the cost of the pizza 
	private static final double PRICE = 8.00; 
	// this is assigning a human understanding of the identity to the pizza. 
	private static final String IDENTITY = "Margherita";

	
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
		super(quantity, orderTime, deliveryTime, IDENTITY, PRICE );
		// this is getting the pice of the opttings
		listOfToppings.add(PizzaTopping.TOMATO);
		listOfToppings.add(PizzaTopping.CHEESE);
		// This is going though and getting the cost of the pizzas if there are multiple
		for (int i = 0; i < quantity; i++) {
			price += 8.00;
			for (PizzaTopping topping : listOfToppings) {
				cost += topping.getCost();
			}
		}
		
	}	
}

	

