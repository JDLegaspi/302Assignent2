package asgn2Pizzas;

import java.time.LocalTime;

import asgn2Exceptions.PizzaException;

/**
 * 
 *  A class that represents a meat lovers pizza made at the Pizza Palace restaurant. 
 *  The meat lovers pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author PersonA
 *
 */
public class MeatLoversPizza extends Pizza {
	// setting the price of the pizza and assigning it a human recognizable name
	private static final double PRICE = 12.00; 
	private static final String IDENTITY = "Meat Lovers";

	/**
	 * 
	 *  This class represents a meat lovers pizza made at the  Pizza Palace restaurant. The meat lovers pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
 	 * <P> PRE: TRUE
 	 * <P> POST: All field values including the cost per pizza are set
     *
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public MeatLoversPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {
		super(quantity, orderTime, deliveryTime, IDENTITY, PRICE );
		//Setting the  pizza toppings. 
		listOfToppings.add(PizzaTopping.TOMATO);
		listOfToppings.add(PizzaTopping.CHEESE);
		listOfToppings.add(PizzaTopping.BACON);
		listOfToppings.add(PizzaTopping.SALAMI);
		listOfToppings.add(PizzaTopping.PEPPERONI);
		// This is going though and getting the cost of the pizzas if there are multiple
		for (int i = 0; i < quantity; i++) {
			price += 12.00;
			for (PizzaTopping topping : listOfToppings) {
				cost += topping.getCost();
			}
		}
		
	}
}

