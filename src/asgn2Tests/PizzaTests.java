package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	@Test (expected=PizzaException.class)
	 public  void TestQuantityLower () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(0, LocalTime.of(21, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestQuantityhigher () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(11, LocalTime.of(21, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestOrderTimeUnder () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(5, LocalTime.of(16, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestOrderTimeover () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(5, LocalTime.of(23, 30, 59), LocalTime.of(21, 30, 59, 11001)); 
	}
	@Test (expected=PizzaException.class)
	 public  void TestDeliveryTimeover () throws PizzaException{	
		MeatLoversPizza pizzaorder = new MeatLoversPizza(5, LocalTime.of(19, 30, 00), LocalTime.of(18, 40, 59, 11001)); 
	}
	//test get cost 
	@Test 
	 public  void TestGetCost () throws PizzaException{	 
		MeatLoversPizza pizzaorder = new MeatLoversPizza(1, LocalTime.of(19, 30, 00), LocalTime.of(18, 40, 59, 11001)); 
		double costOfPizza = pizzaorder.getCostPerPizza();
		assertEquals(5, costOfPizza, 0);
	}
	@Test 
	 public  void TestGetOrderCost () throws PizzaException{	 
		MeatLoversPizza pizzaorder = new MeatLoversPizza(1, LocalTime.of(19, 30, 00), LocalTime.of(18, 40, 59, 11001)); 
		double costOfPizza = pizzaorder.getOrderCost();
		assertEquals(5, costOfPizza, 0);
	}
	
	@Test 
	 public  void TestGetOrderpricMeate () throws PizzaException{	 
		MeatLoversPizza pizzaorder = new MeatLoversPizza(1, LocalTime.of(19, 30, 00), LocalTime.of(18, 40, 59, 11001)); 
		double expectedPrice = 12.0;
		assertEquals(expectedPrice, pizzaorder.getOrderPrice(), (double) expectedPrice);
	}
	
	@Test 
	 public  void TestMargaritaprice () throws PizzaException{	  
		MargheritaPizza pizzaorder = new MargheritaPizza(1, LocalTime.of(19, 30, 00), LocalTime.of(19, 40, 59, 11001)); 
		double expectedPrice = 8.0;
		assertEquals(expectedPrice, pizzaorder.getOrderPrice(), (double) expectedPrice);
	}
	
	@Test 
	 public  void Testvegeprice () throws PizzaException{	 
		VegetarianPizza pizzaorder = new VegetarianPizza(1, LocalTime.of(19, 30, 00), LocalTime.of(18, 40, 59, 11001)); 
		double expectedPrice = 10.0;
		assertEquals(expectedPrice, pizzaorder.getOrderPrice(), (double) expectedPrice);
	}
	
	@Test 
	 public  void TestGetTypeMeat () throws PizzaException{	 
		Pizza testing = PizzaFactory.getPizza("PZL", 2, LocalTime.of(19,20,15), LocalTime.of(19,50,15));
		MeatLoversPizza pizzaorder = new MeatLoversPizza(2,LocalTime.of(19,20,15), LocalTime.of(19,50,15)); 
		assertEquals("Meat Lovers", pizzaorder.getPizzaType());	
	}
	
	@Test 
	 public  void TestGetTypeVege () throws PizzaException{	 
		Pizza testing = PizzaFactory.getPizza("PZV", 2, LocalTime.of(19,20,15), LocalTime.of(19,50,15));
		VegetarianPizza pizzaorder = new VegetarianPizza(2,LocalTime.of(19,20,15), LocalTime.of(19,50,15)); 
		assertEquals("Vegetarian", pizzaorder.getPizzaType());	
	}
	
	@Test 
	 public  void TestGetTypeMargahrits () throws PizzaException{	 
		Pizza testing = PizzaFactory.getPizza("PZM", 2, LocalTime.of(19,20,15), LocalTime.of(19,50,15));
		MargheritaPizza pizzaorder = new MargheritaPizza(2,LocalTime.of(19,20,15), LocalTime.of(19,50,15)); 
		assertEquals("Margherita", pizzaorder.getPizzaType());	
	}
	
	

	
	


}
