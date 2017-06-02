package asgn2GUIs;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JPanel;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
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
	// setting up the variables and the Java Gui elements
	private File file;
	private String filename;
	
	private static final long serialVersionUID = -7031008862559936404L;
	//Initialize the frame height
	public static final int WIDTH = 610;
	public static final int HEIGHT = 300;
	//Initialize the panels 
	private JPanel PanelOne;
	private JPanel PanelTwo;
	private JPanel PanelThree;
	
	//Initialize Jlables
	private JLabel HeadingOne;
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
	
	//Initialize the buttons 
	private JButton UploadButton;
	private JButton ClearButton;
	private JButton CalculateButton;
	private JButton DistanceButton;
	private JButton CustomerButton;	
	
	private PizzaRestaurant restaurant;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {

		 super(title);
		 
		
	}
	
	private void createGUI() { 
		//Panel related code will go here
		setSize(WIDTH, HEIGHT);
		//The height and width
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// This is setting the closing function 
		setLayout(new BorderLayout());
		// setting the positions of the panels and what color they appear. 
		PanelOne = createPanel(Color.WHITE); 
		this.getContentPane().add(PanelOne,BorderLayout.WEST); 
		
		PanelTwo = createPanel(Color.WHITE); 
		this.getContentPane().add(PanelTwo,BorderLayout.CENTER); 
		
		PanelThree = createPanel(Color.WHITE); 
		this.getContentPane().add(PanelThree,BorderLayout.NORTH);
		
		// Setting the panels to be seen and painting them to the screen 
		this.setVisible(true);
		repaint();
		
		
		// This is setting the content in the panels to either go vertiaclly or horizontaly. 
		PanelOne.setLayout(new BoxLayout(PanelOne, BoxLayout.Y_AXIS));
		PanelTwo.setLayout(new BoxLayout(PanelTwo, BoxLayout.Y_AXIS));
		PanelThree.setLayout(new BoxLayout(PanelThree, BoxLayout.X_AXIS));
		
		//Labels  For Customer 
		HeadingOne = new JLabel("Customer Information");
		CustomerNameLabel = new JLabel("Name :  ");
		CustomerMobileLabel = new JLabel("Mobie :  ");
		CustomerTypeLabel = new JLabel("Type : ");
		CustomerLocationLabel = new JLabel("Location : ");
		CustomerDistanceLabel = new JLabel("Distance : ");


		PanelOne.add(CustomerNameLabel);
		PanelOne.add(CustomerMobileLabel);
		PanelOne.add(CustomerTypeLabel);
		PanelOne.add(CustomerLocationLabel);
		PanelOne.add(CustomerDistanceLabel);
		
		
		//Labels for pizza 
		PizzaTypeLabel = new JLabel("Pizza Type :  ");
		PizzaQuantityLabel = new JLabel("Quantity: ");
		PizzaOrderPriceLabel = new JLabel("Order Price :  ");
		PizzaOrderCostLabel = new JLabel("Order Cost : ");
		PizzaOrderProfitLabel = new JLabel("Profit : ");

		
		PanelOne.add(PizzaTypeLabel);
		PanelOne.add(PizzaQuantityLabel);
		PanelOne.add(PizzaOrderPriceLabel);
		PanelOne.add(PizzaOrderCostLabel);
		PanelOne.add(PizzaOrderProfitLabel);
		
		
		//Lables  For Customer Results 
		ResultCustomerNameLabel = new JLabel("");
		ResultCustomerMobileLabel = new JLabel("");
		ResultCustomerTypeLabel = new JLabel("");
		ResultCustomerLocationLabel = new JLabel("");
		ResultCustomerDistanceLabel = new JLabel("");

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
		//Results = new JTextArea(2,1);
		//PanelTwo.add(Results);
		
		
		
		//BUTTONS 
		
		 UploadButton = new JButton("Upload");
		 PanelThree.add(UploadButton);
		 UploadButton.addActionListener(this);
		 
		 
		 ClearButton = new JButton("Clear");
		 PanelThree.add(ClearButton);
		 ClearButton.addActionListener(this);
		 
		 CustomerButton = new JButton("Display Customer by ID");
		 PanelThree.add(CustomerButton);
		 CustomerButton.addActionListener(this);
		 
		 CalculateButton = new JButton("Total Profit Made");
		 PanelThree.add(CalculateButton);
		 CalculateButton.addActionListener(this);
		 
		 DistanceButton = new JButton("Total Distance Travelled");
		 PanelThree.add(DistanceButton);
		 DistanceButton.addActionListener(this);		
		 
		 
		 HeadingOne.setFont(new Font("Comic Sans ms",Font.BOLD,16));
		 
	}

	 
	private JPanel createPanel(Color c) {
		JPanel PanelOne = new JPanel();
		PanelOne.setBackground(c);
		return PanelOne;
	}

	@Override
	public void run() {
		// TO DO
		createGUI();
		// ruffning the gui 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src=e.getSource();
		if(src == UploadButton){
			restaurant = new PizzaRestaurant();
			// this is choosing the file 
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(this);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				// this is where you get the path of the file
				file = fileChooser.getSelectedFile();
				filename = file.getAbsolutePath();
				// Trying to catch any exceptions when the file is being selected. 
				try {
					restaurant.processLog(filename);
				} catch (CustomerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (PizzaException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (LogHandlerException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// this is where the display button is engauged.
				int reply = JOptionPane.showConfirmDialog(null, "Would you like do display the data for the first customer?", "Display Data?", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION)
                {
                    displayCustomerData(0);
                }
			} 
			
		} else if (src == ClearButton) {
					// this is where the clear button resets the text
			if (restaurant != null) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear data?", "Clear", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION)
	            {
					restaurant = null;
					
					this.ResultCustomerNameLabel.setText("");
					this.ResultCustomerTypeLabel.setText("");
					this.ResultCustomerMobileLabel.setText("");
					this.ResultCustomerLocationLabel.setText("");
					this.ResultCustomerDistanceLabel.setText("");
					
					this.ResultPizzaTypeLabel.setText("");
					this.ResultPizzaQuantityLabel.setText("");
					this.ResultPizzaOrderCostLabel.setText("");
					this.ResultPizzaOrderPriceLabel.setText("");
					this.ResultPizzaOrderProfitLabel.setText("");
	            }		
			}
			
		} else if (src == CalculateButton) {
			// this is where the calualte buttons functions are 
			if (restaurant == null) {
				//if no file is selected show error message
				JOptionPane.showMessageDialog(null, "Please load a restaurant file");
			} else {
				// show the tial profit on a pup up 
				JOptionPane.showMessageDialog(null, "Total Profit Made Today: $" + restaurant.getTotalProfit());
			}
		
		} else if (src == DistanceButton) {
			// Calculate distance 
			if (restaurant == null) {
				//if no file is selected show error message
				JOptionPane.showMessageDialog(null, "Please load a restaurant file");
			} else {
				JOptionPane.showMessageDialog(null, "Total Distance Travelled Today: " + ((double)Math.round(restaurant.getTotalDeliveryDistance()*100)/100) + " units travelled");
			}
			
		} else if (src == CustomerButton) {
			
			if (restaurant == null) {
				//if no file is selected show error message
				JOptionPane.showMessageDialog(null, "Please load a restaurant file");
			} else {
				
				// selects the number typed into the box and finds the corelating number in the log file and shows it on the screen. 
				String customerIDInput = JOptionPane.showInputDialog("Please select a Customer ID from 0 to " + (restaurant.getNumCustomerOrders() - 1));
				
				if (customerIDInput != null) {
					// show an error message if the number is invalid. 
					int customerID = Integer.parseInt(customerIDInput);
					
					if (customerID < 0 || customerID > restaurant.getNumCustomerOrders() - 1) {
						JOptionPane.showMessageDialog(null, "Customer ID not valid");
					} else {
						displayCustomerData(customerID);
					}
				}
			}
			
		}
	
	}
		
	private void displayCustomerData(int customerID) {
		try {
			//Try Showing the data from the logfiles and catch any problems for the customer information 
			this.ResultCustomerNameLabel.setText(restaurant.getCustomerByIndex(customerID).getName());
			this.ResultCustomerTypeLabel.setText(restaurant.getCustomerByIndex(customerID).getCustomerType());
			this.ResultCustomerMobileLabel.setText(restaurant.getCustomerByIndex(customerID).getMobileNumber());
			this.ResultCustomerLocationLabel.setText(restaurant.getCustomerByIndex(customerID).getLocationX() + " , " + restaurant.getCustomerByIndex(0).getLocationY());
			this.ResultCustomerDistanceLabel.setText(Double.toString(restaurant.getCustomerByIndex(customerID).getDeliveryDistance()));
		} catch (CustomerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			//Try Showing the data from the logfiles and catch any problems for the pizza information 
			this.ResultPizzaTypeLabel.setText(restaurant.getPizzaByIndex(customerID).getPizzaType());
			this.ResultPizzaQuantityLabel.setText(Integer.toString(restaurant.getPizzaByIndex(customerID).getQuantity()));
			this.ResultPizzaOrderCostLabel.setText(Double.toString(restaurant.getPizzaByIndex(customerID).getOrderCost()));
			this.ResultPizzaOrderPriceLabel.setText(Double.toString(restaurant.getPizzaByIndex(customerID).getOrderPrice()));
			this.ResultPizzaOrderProfitLabel.setText(Double.toString(restaurant.getPizzaByIndex(customerID).getOrderProfit()));		
		} catch (PizzaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
		// TODO Auto-generated method stub
	
	
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new PizzaGUI("Pizza Place"));
		
		
	}

	

}
