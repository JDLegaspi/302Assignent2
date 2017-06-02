package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	PizzaRestaurant restaurant;
	
	@Before
	//test to see if both ArrayLists are initialised and no errors occur
	//test to see if both datasets are not null, false if any of them fail
	public void testPizzaRestaurant() throws URISyntaxException, CustomerException, PizzaException, LogHandlerException {
		restaurant = new PizzaRestaurant();
		Path path = Paths.get(LogHandlerCustomerTests.class.getResource(".").toURI());
		String logFilepath = path.getParent().getParent() + "\\" + "logs" + "\\" + "20170101.txt";
		
		assertEquals(true, restaurant.processLog(logFilepath));
	}
	
	@Test
	public void testGetPizzaByIndex() throws PizzaException {
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
	}
	
	@Test (expected = PizzaException.class)
	//test getPizzaByIndex out of bounds
	public void testGetPizzaByIndexError() throws PizzaException {
		restaurant.getPizzaByIndex(12222220);
	}
	
	@Test
	//test getting delivery distance
	public void testGetTotalDeliveryDistance() throws PizzaException {
		Assert.assertEquals(15.0, restaurant.getTotalDeliveryDistance(), 0.00001);
	}
	
	@Test
	//test get total profit
	public void testGetProfit() {
		assertEquals(restaurant.getTotalProfit(), 151.50, 0.001);
	}
	
}
