package asgn2Tests;

import asgn2Restaurant.PizzaRestaurant;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {

	PizzaRestaurant restaurant;
	
	@Before
	//test to see if both ArrayLists are initialised and no errors occur
	public void testPizzaRestaurant() {
		restaurant = new PizzaRestaurant();
	}
	
	@Test
	//test to see if both datasets are not null, false if any of them fail
	public void testProcessLog() throws URISyntaxException, CustomerException, PizzaException, LogHandlerException {
		Path path = Paths.get(LogHandlerCustomerTests.class.getResource(".").toURI());
		String logFilepath = path.getParent().getParent() + "\\" + "logs" + "\\" + "20170101.txt";
		
		assertEquals(true, restaurant.processLog(logFilepath));
	}

}
