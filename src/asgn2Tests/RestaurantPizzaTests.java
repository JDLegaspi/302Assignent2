package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	
}
