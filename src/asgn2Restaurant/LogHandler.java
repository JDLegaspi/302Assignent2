package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Person B
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		
		ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			while ((line = br.readLine()) != null) {
				customerArrayList.add(createCustomer(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return customerArrayList;
		
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{

		ArrayList<Pizza> pizzaArrayList = new ArrayList<Pizza>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			while ((line = br.readLine()) != null) {
				pizzaArrayList.add(createPizza(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pizzaArrayList;
		
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{

		if (!line.matches(".+,.+,.+,.+,.+,.+,.+,.+,.+")) {
			throw new LogHandlerException("Line does not match format required");
		} else {
			String[] customerInfo  = line.split(",");
			
			String customerCode = customerInfo[4];
			String name = customerInfo[2];
			String mobileNumber = customerInfo[3];
			int locationX = Integer.parseInt(customerInfo[5]);
			int locationY = Integer.parseInt(customerInfo[6]);
			
			Customer customer = CustomerFactory.getCustomer(customerCode, name, mobileNumber, locationX, locationY);
			
			return customer;
		}

	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		
		if (!line.matches(".+,.+,.+,.+,.+,.+,.+,.+,.+")) {
			throw new LogHandlerException("Line does not match format required");
		} else {
		
			String[] customerInfo  = line.split(",");
	
			String pizzaCode = customerInfo[7];
			int pizzaQuantity = Integer.parseInt(customerInfo[8]);
			LocalTime orderTime = LocalTime.parse(customerInfo[0]);
			LocalTime deliveryTime = LocalTime.parse(customerInfo[1]);
			
			
			Pizza pizza = PizzaFactory.getPizza(pizzaCode, pizzaQuantity, orderTime, deliveryTime);		
			
			return pizza;
		}
	}

}
