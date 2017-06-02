package asgn2Tests;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;
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
		public void testGetCustomerName() throws CustomerException, LogHandlerException {
			customer = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2");
			assertEquals("Casey Jones", customer.getName());
			assertEquals("0123456789", customer.getMobileNumber());
		}
		
		@Test
		//test accepting log file
		public void testAcceptFile() throws URISyntaxException, LogHandlerException, CustomerException {
			ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
			Path path = Paths.get(LogHandlerCustomerTests.class.getResource(".").toURI());
			String logFilepath = path.getParent().getParent() + "\\" + "logs" + "\\" + "20170101.txt";
			customerArrayList = LogHandler.populateCustomerDataset(logFilepath);
			assertEquals("Casey Jones", customerArrayList.get(0).getName());
			assertEquals("0123456789", customerArrayList.get(0).getMobileNumber());
		}
		
		@Test
		//test accepting log file once more
		public void testAcceptFile2() throws URISyntaxException, LogHandlerException, CustomerException {
			ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
			Path path = Paths.get(LogHandlerCustomerTests.class.getResource(".").toURI());
			String logFilepath = path.getParent().getParent() + "\\" + "logs" + "\\" + "20170101.txt";
			customerArrayList = LogHandler.populateCustomerDataset(logFilepath);
			assertEquals("Oroku Saki", customerArrayList.get(2).getName());
			assertEquals("0111222333", customerArrayList.get(2).getMobileNumber());
		}
		
		@Test (expected = LogHandlerException.class)
		//test Log Handler Exception for semantic error
		public void textLogHandlerException() throws CustomerException, LogHandlerException {
			customer = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones 0123456789,DVC,5,5,PZV,2");
		}
		
		@Test (expected = CustomerException.class)
		//tests to see if customer exception is thrown from incorrect data
		public void testCustomerException() throws CustomerException, LogHandlerException {
			customer = LogHandler.createCustomer("19:00:00,19:20:00,Casey Jones,0123456789,wefwefwefwefwefwefwefwefwef,5,5,PZV,2");
		}
		
		@Test (expected = LogHandlerException.class)
		//tests to see if customer exception is thrown from incorrect data
		public void textLogHandlerException2() throws CustomerException, LogHandlerException {
			customer = LogHandler.createCustomer("sdifuhsiodurfho873e4yto837rgfhoduhf");
		}
		
}
