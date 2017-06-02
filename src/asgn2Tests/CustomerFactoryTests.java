package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;


/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	//TODO
	// Testing if the name is too long 
	@Test (expected=CustomerException.class) // !!
	 public  void TestNameException () throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "abcdefghijklmnopqurstuvwxyz", "0412731942", 0, 0);
	}
	// Testing if the name is white space 
	@Test (expected=CustomerException.class)// !! 
	 public  void TestNameExceptionTwo () throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "      ", "0412731942", 0, 0);
	}
	// Testing if the phone number does not start with a 0 
	@Test (expected=CustomerException.class)
	 public  void TestMobileExceptionOne () throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "2412731942", 0, 0);
		
	}
	// Testing if the Phone number  is too short 
	@Test (expected=CustomerException.class)
	 public  void TestMobileExceptionTwo () throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("PUC", "name", "041273192", 0, 0);	
	}
	
	// Testing if the Phone number  is too long 
		@Test (expected=CustomerException.class)
		 public  void TestMobileExceptionTwoThree () throws CustomerException{	
			Customer customer = CustomerFactory.getCustomer("PUC", "name", "041255573192", 0, 0);	
		}
	//Test id the Location is too big 
	@Test (expected=CustomerException.class)
	 public  void TestLocationException() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("DNC", "name", "0412731942", 12, 13);
	}
	// Test if the type is incorrect 
	@Test (expected=CustomerException.class)//!!
	 public  void TestTypeException() throws CustomerException{	
		Customer customer = CustomerFactory.getCustomer("AMC", "name", "0412731942", 5, 2);
	}
	

}
