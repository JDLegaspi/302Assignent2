package asgn2GUIs;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;


import javax.swing.JFrame;
import javax.swing.JFileChooser;



/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a �dummy� class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature � as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	private File file;
	private String filename;
	
	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	private JPanel PanelOne;
	private JPanel PanelTwo;
	private JPanel PanelThree;
	
	
	private JLabel HeadingOne ;
	private JLabel HeadingTwo;
	
	
	private JLabel CustomerNameLabel;
	private JLabel CustomerMobileLabel;
	private JLabel CustomerTypeLabel;
	private JLabel CustomerLocationLabel;
	private JLabel CustomerDistanceLabel;
	private JLabel PizzaTypeLabel;
	private JLabel PizzaQuantityLabel;
	private JLabel PizzaOrderPriceLabel;
	private JLabel PizzaOrderCostLabel;
	private JLabel PizzaOrderProfitLabel;
	
	
	private JLabel ResultCustomerNameLabel;
	private JLabel ResultCustomerMobileLabel;
	private JLabel ResultCustomerTypeLabel;
	private JLabel ResultCustomerLocationLabel;
	private JLabel ResultCustomerDistanceLabel;
	private JLabel ResultPizzaTypeLabel;
	private JLabel ResultPizzaQuantityLabel;
	private JLabel ResultPizzaOrderPriceLabel;
	private JLabel ResultPizzaOrderCostLabel;
	private JLabel ResultPizzaOrderProfitLabel;
	
	private JButton UploadButton;
	private JButton ClearButton;
	private JButton CalcualteButton;
	
	
	private JTextArea Results; 
	private String ClearText = "";
	
	
	
	
	
	private PizzaRestaurant restaurant;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		 super(title);
		 
		
	}
	
	private void createGUI() { 
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//Panel related code will go here
		PanelOne = createPanel(Color.WHITE); 
		this.getContentPane().add(PanelOne,BorderLayout.WEST); 
		
		PanelTwo = createPanel(Color.CYAN); 
		this.getContentPane().add(PanelTwo,BorderLayout.CENTER); 
		
		PanelThree = createPanel(Color.RED); 
		this.getContentPane().add(PanelThree,BorderLayout.NORTH);
		
		
		this.setVisible(true);
		repaint();
		
		
		
		PanelOne.setLayout(new BoxLayout(PanelOne, BoxLayout.Y_AXIS));
		PanelTwo.setLayout(new BoxLayout(PanelTwo, BoxLayout.Y_AXIS));
		PanelThree.setLayout(new BoxLayout(PanelThree, BoxLayout.X_AXIS));
		
		//Lables  For Customer 
		
		HeadingOne = new JLabel("Customer Information");
		HeadingTwo = new JLabel("Customer Resutlts");
		
		CustomerNameLabel = new JLabel("Name | ");
		CustomerMobileLabel = new JLabel("Mobie | ");
		CustomerTypeLabel = new JLabel("Type |");
		CustomerLocationLabel = new JLabel("Location |");
		CustomerDistanceLabel = new JLabel("Distance |");


		PanelOne.add(CustomerNameLabel);
		PanelOne.add(CustomerMobileLabel);
		PanelOne.add(CustomerTypeLabel);
		PanelOne.add(CustomerLocationLabel);
		PanelOne.add(CustomerDistanceLabel);
		
		
		//Labels for pizza 
		PizzaTypeLabel = new JLabel("Pizza Type | ");
		PizzaQuantityLabel = new JLabel("Quantity|");
		PizzaOrderPriceLabel = new JLabel("Order Price | ");
		PizzaOrderCostLabel = new JLabel("Order Cost |");
		PizzaOrderProfitLabel = new JLabel("Profit |");

		
		PanelOne.add(PizzaTypeLabel);
		PanelOne.add(PizzaQuantityLabel);
		PanelOne.add(PizzaOrderPriceLabel);
		PanelOne.add(PizzaOrderCostLabel);
		PanelOne.add(PizzaOrderProfitLabel);
		
		
		//Lables  For Customer Results 
		/*ResultCustomerNameLabel = new JLabel("");
		ResultCustomerMobileLabel = new JLabel("");
		ResultCustomerTypeLabel = new JLabel("");
		ResultCustomerLocationLabel = new JLabel("");
		ResultCustomerDistanceLabel = new JLabel("");

		PanelTwo.add(HeadingTwo);
		PanelTwo.add(ResultCustomerNameLabel);
		PanelTwo.add(ResultCustomerMobileLabel);
		PanelTwo.add(ResultCustomerTypeLabel);
		PanelTwo.add(ResultCustomerLocationLabel);
		PanelTwo.add(ResultCustomerDistanceLabel);
		

		//Labels for pizza Result
		ResultPizzaTypeLabel = new JLabel("");
		ResultPizzaQuantityLabel = new JLabel("");
		ResultPizzaOrderPriceLabel = new JLabel("");
		ResultPizzaOrderCostLabel = new JLabel("");
		ResultPizzaOrderProfitLabel = new JLabel("");

		PanelTwo.add(ResultPizzaTypeLabel);
		PanelTwo.add(ResultPizzaQuantityLabel);
		PanelTwo.add(ResultPizzaOrderPriceLabel);
		PanelTwo.add(ResultPizzaOrderCostLabel);
		PanelTwo.add(ResultPizzaOrderProfitLabel);
		*/
		Results = new JTextArea(2,1);
		PanelTwo.add(Results);
		
		
		
		//BUTTONS 
		
		 UploadButton = new JButton("Upload");
		 PanelThree.add(UploadButton);
		 UploadButton.addActionListener(this);
		 
		 
		 ClearButton = new JButton("Clear");
		 PanelThree.add(ClearButton);
		 ClearButton.addActionListener(this);
		 
		
		 
		 CalcualteButton = new JButton(">>");
		 PanelThree.add(CalcualteButton);
		 CalcualteButton.addActionListener(this);
		 
		
		 
		 
		 HeadingOne.setFont(new Font("Comic Sans ms",Font.BOLD,16));
		 HeadingTwo.setFont(new Font("Comic Sans ms",Font.BOLD,16));
		 
		}
		
		
		//buttons
		//load 
		//reset 
		//
	
	

	 
	private JPanel createPanel(Color c) {
		JPanel PanelOne = new JPanel();
		PanelOne.setBackground(c);
		return PanelOne;
		
		
		
	}
	
	
	
	
	
	
	@Override
	public void run() {
		// TO DO
		createGUI();
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src=e.getSource();
		if(src==UploadButton){
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(this);
			if(returnValue == JFileChooser.APPROVE_OPTION){
				file = fileChooser.getSelectedFile();
				filename = file.getAbsolutePath();
				//
				Scanner scan;
				try {
					scan = new Scanner (new FileReader(file));
					while(scan.hasNextLine() ==true){
					
						String Content = scan.nextLine ();
						Results.insert(Content +"\n", 0);
					}
					
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					this.ResultCustomerNameLabel.setText(restaurant.getCustomerByIndex(0).getName());
					this.ResultCustomerTypeLabel.setText(restaurant.getCustomerByIndex(0).getCustomerType());
					this.ResultCustomerMobileLabel.setText(restaurant.getCustomerByIndex(0).getMobileNumber());
					this.ResultCustomerLocationLabel.setText(restaurant.getCustomerByIndex(0).getLocationX() + " , " + restaurant.getCustomerByIndex(0).getLocationY());
					this.ResultCustomerDistanceLabel.setText(Double.toString(restaurant.getCustomerByIndex(0).getDeliveryDistance()));
				} catch (CustomerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					this.ResultPizzaTypeLabel.setText(restaurant.getPizzaByIndex(0).getPizzaType());
					this.ResultPizzaQuantityLabel.setText(Integer.toString(restaurant.getPizzaByIndex(0).getQuantity()));
					this.ResultPizzaOrderCostLabel.setText(Double.toString(restaurant.getPizzaByIndex(0).getOrderCost()));
					this.ResultPizzaOrderPriceLabel.setText(Double.toString(restaurant.getPizzaByIndex(0).getOrderPrice()));
					this.ResultPizzaOrderProfitLabel.setText(Double.toString(restaurant.getPizzaByIndex(0).getOrderProfit()));		
				} catch (PizzaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else if(src == ClearButton){
				// CLEAR FUCTION
				//JOSE PLEASE DO THIS 
				
			}else if(src == CalcualteButton){
				// Next FUCTION
				//JOSE PLEASE DO THIS 
				
			}else if (returnValue == JFileChooser.CANCEL_OPTION){}
			
		}
	
	}
		
		
		
		// TODO Auto-generated method stub
	
	
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		 SwingUtilities.invokeLater(new PizzaGUI("Pizza Place"));
		
		
	}

	

}
