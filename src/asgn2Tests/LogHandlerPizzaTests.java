package asgn2Tests;

import asgn2Pizzas.PizzaFactory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Restaurant.LogHandler;
import asgn2Pizzas.Pizza;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	
	Pizza pizza;
	
	@Before
	public void createClass() throws PizzaException {
		try {
			pizza = LogHandler.createPizza("21:00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3");
		} catch (LogHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//tests to see if pizza type is correct
	public void getPizzaType() throws CustomerException {
		assertEquals("Meat Lovers", pizza.getPizzaType());
	}
}
