package asgn2Tests;

import asgn2Restaurant.PizzaRestaurant;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
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
	//test to see if both datasets are not null, false if any of them fail
	public void testPizzaRestaurant() throws CustomerException, PizzaException, LogHandlerException, URISyntaxException {
		restaurant = new PizzaRestaurant();
		Path path = Paths.get(LogHandlerCustomerTests.class.getResource(".").toURI());
		String logFilepath = path.getParent().getParent() + "\\" + "logs" + "\\" + "20170101.txt";
		
		assertEquals(true, restaurant.processLog(logFilepath));
	}
	
	@Test
	//test to see if all expected objects have been made
	public void testGetNumCustomers() {
		assertEquals(3, restaurant.getNumCustomerOrders());
	}
	
	@Test
	//test if customerArrayList has been populated
	public void testGetCustomerByIndex() throws CustomerException {
		Customer customer = restaurant.getCustomerByIndex(0);
		assertEquals("Casey Jones", customer.getName());
	}
	
	@Test (expected = CustomerException.class)
	//test if getCustomerByIndex throws out of bounds error
	public void testGetCustomerByIndexError() throws CustomerException {
		Customer customer = restaurant.getCustomerByIndex(900000);
		assertEquals("Casey Jones", customer.getName());
	}


}
