package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;
import asgn2Restaurant.PizzaRestaurant;
import asgn2Customers.Customer;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
		
		Customer customer;
		
		@Test
		//tests to see if customer name is correct
		public void getCustomerName() throws CustomerException, LogHandlerException {
			customer = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
			assertEquals("Casey Jones", customer.getName());
		}
}
