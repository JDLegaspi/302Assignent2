package asgn2Pizzas;
import java.time.LocalTime;



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
		// TO DO
		//TO FIX 
			int hour = orderTime.getHour();
			int dropHour = orderTime.getHour();
			if(quantity < 1 || quantity > 10 ){
				throw new PizzaException ("Too little or too many Pizza- Must be over 1 and under 10");
			}else if  (hour < 19 || hour > 23) {
				throw new PizzaException ("You are ordering when we are not open, please come back between 7-11pm");	
			}else if ((dropHour - hour)< 1){
				throw new PizzaException ("Pizza over an hour old, Thrown out. ");
				
			}
			
	}
}

		/*  Throw Exceptions when 
		 * The time is before 7 PM 
		 * The Time is after 11 PM 
		 * quantity under 1 
		 * quantity over 10
		 * if deliver time is over an hour 
		 * */ 
	

