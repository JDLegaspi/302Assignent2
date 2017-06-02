package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Pizzas.Pizza;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	
	Pizza pizza;
	
	@Test
	//tests to see if customer name is correct
	public void testPizzaCreation() throws LogHandlerException, PizzaException {
		pizza = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
		assertEquals("Vegetarian", pizza.getPizzaType());
		assertEquals(2, pizza.getQuantity());
	}
	
	@Test
	//test accepting log file
	public void testAcceptFile() throws URISyntaxException, PizzaException, LogHandlerException {
		ArrayList<Pizza> pizzaArrayList = new ArrayList<Pizza>();
		Path path = Paths.get(LogHandlerPizzaTests.class.getResource(".").toURI());
		String logFilepath = path.getParent().getParent() + "\\" + "logs" + "\\" + "20170101.txt";
		pizzaArrayList = LogHandler.populatePizzaDataset(logFilepath);
		assertEquals("Vegetarian", pizzaArrayList.get(0).getPizzaType());
		assertEquals(2, pizzaArrayList.get(0).getQuantity());
	}
	
	@Test
	//test accepting log file once more
	public void testAcceptFile2() throws URISyntaxException, PizzaException, LogHandlerException {
		ArrayList<Pizza> pizzaArrayList = new ArrayList<Pizza>();
		Path path = Paths.get(LogHandlerPizzaTests.class.getResource(".").toURI());
		String logFilepath = path.getParent().getParent() + "\\" + "logs" + "\\" + "20170101.txt";
		pizzaArrayList = LogHandler.populatePizzaDataset(logFilepath);
		assertEquals("Meat Lovers", pizzaArrayList.get(2).getPizzaType());
		assertEquals(3, pizzaArrayList.get(2).getQuantity());
	}
	
	@Test (expected = LogHandlerException.class)
	//test Log Handler Exception for semantic error
	public void textLogHandlerException() throws LogHandlerException, PizzaException {
		pizza = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones 0123456789,DVC,5,5,PZV,2");
	}
	
	@Test (expected = PizzaException.class)
	//tests to see if customer exception is thrown from incorrect data
	public void testPizzaException() throws LogHandlerException, PizzaException {
		pizza = LogHandler.createPizza("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,wefwefwefwefwefwefwefwefwef,2");
	}
	
	@Test (expected = LogHandlerException.class)
	//tests to see if customer exception is thrown from incorrect data
	public void textLogHandlerException2() throws LogHandlerException, PizzaException {
		pizza = LogHandler.createPizza("sdifuhsiodurfho873e4yto837rgfhoduhf");
	}
}
