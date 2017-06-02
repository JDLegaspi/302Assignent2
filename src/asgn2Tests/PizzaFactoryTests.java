package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.VegetarianPizza;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	// TO DO
	@Test 
	 public  void TestMeatloverse() throws PizzaException{	
		Pizza testing = PizzaFactory.getPizza("PZL", 2, LocalTime.of(19,20,15), LocalTime.of(19,50,15));
		MeatLoversPizza pizzaorder = new MeatLoversPizza(2,LocalTime.of(19,20,15), LocalTime.of(19,50,15)); 
		assertEquals(pizzaorder,testing);
	}
	@Test 
	public  void TestVegetariane() throws PizzaException{	
		Pizza testing = PizzaFactory.getPizza("PZV", 2, LocalTime.of(19,20,15), LocalTime.of(19,50,15));
		VegetarianPizza pizzaorder = new VegetarianPizza(2,LocalTime.of(19,20,15), LocalTime.of(19,50,15)); 
		assertEquals(pizzaorder,testing);
	}
	@Test 
	public  void TestMargherita() throws PizzaException{	
		Pizza testing = PizzaFactory.getPizza("PZM", 2, LocalTime.of(19,20,15), LocalTime.of(19,50,15));
		MargheritaPizza pizzaorder = new MargheritaPizza(2,LocalTime.of(19,20,15), LocalTime.of(19,50,15)); 
		assertEquals(pizzaorder,testing);
	}
	@Test (expected=PizzaException.class)
	public  void TestTypeException() throws PizzaException{	
		Pizza testing = PizzaFactory.getPizza("AMC", 2, LocalTime.of(19,20,15), LocalTime.of(19,50,15));
		MargheritaPizza pizzaorder = new MargheritaPizza(2,LocalTime.of(19,20,15), LocalTime.of(19,50,15)); 	
	}
	
	}
