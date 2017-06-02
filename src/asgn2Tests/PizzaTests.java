package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MeatLoversPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	// CONSTRAINT ERRORS
	@Test (expected=PizzaException.class)
	 public  void TestQuantityLower () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(0, LocalTime.of(21, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestQuantityhigher () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(11, LocalTime.of(21, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestOrderTimeUnder () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(5, LocalTime.of(16, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestOrderTimeover () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(5, LocalTime.of(23, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestDeliveryTimeover () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(5, LocalTime.of(19, 30, 00), LocalTime.of(18, 40, 59, 11001)); 
	}

}
