package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	// TO DO
	// Check if the name is returning correctly 
	@Test 
	 public  void TestName() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "0412731942", 0, 0);
		assertEquals("name", customer.getName());
	}
	

	// Check if the mobile is returning correctly 
	@Test 
	 public  void TestMobile () throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "0412731942", 0, 0);
		assertEquals("0412731942", customer.getMobileNumber());
	}
	
	// Check if the location x is returning correctly 
	
	@Test
	 public  void TestLocationX() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "0412731942", 0, 0);
		assertEquals(0, customer.getLocationX());
	}
	// Check if the location Y is returning correctly 
	@Test
	 public  void TestLocationY() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "0412731942", 0, 0);
		assertEquals(0, customer.getLocationY());
	}
	// Check if the type is returning correctly 
	@Test 
	 public  void TestTypePickUp() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "0412731942", 0, 0);
		assertEquals("Pick-up Customer", customer.getCustomerType());
	}
	// Check if the type is returning correctly 
	@Test 
	 public  void TestTypeDrone() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("DNC", "name", "0412731942", 5, 2);
		assertEquals("Drove Delivery Customer", customer.getCustomerType());
	}
	// Check if the type is returning correctly 
	@Test 
	 public  void TestTypeDrive() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("DVC", "name", "0412731942", 5, 2);
		assertEquals("Deliver Delivery Customer", customer.getCustomerType());
	}
	
	
	
	
	
	
	

}
