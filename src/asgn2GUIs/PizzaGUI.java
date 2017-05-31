package asgn2GUIs;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


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
	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private JPanel PanelOne;
	private JPanel PanelTwo;
	private JPanel PanelThree;
	
	
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
	private JButton NextButton;
	private JButton PreviousButton;
	
	
	
	
	
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
		this.getContentPane().add(PanelOne,BorderLayout.CENTER); 
		
		PanelTwo = createPanel(Color.CYAN); 
		this.getContentPane().add(PanelTwo,BorderLayout.EAST); 
		
		PanelThree = createPanel(Color.RED); 
		this.getContentPane().add(PanelThree,BorderLayout.WEST);
		
		
		this.setVisible(true);
		repaint();
		
		
		
		PanelOne.setLayout(new BoxLayout(PanelOne, BoxLayout.Y_AXIS));
		PanelTwo.setLayout(new BoxLayout(PanelTwo, BoxLayout.Y_AXIS));
		PanelThree.setLayout(new BoxLayout(PanelThree, BoxLayout.Y_AXIS));
		
		//Lables  For Customer 
		CustomerNameLabel = new JLabel("CustomerNameLabel");
		CustomerMobileLabel = new JLabel("CustomerMobileLabel");
		CustomerTypeLabel = new JLabel("CustomerTypeLabelE");
		CustomerLocationLabel = new JLabel("CustomerTypeLabel");
		CustomerDistanceLabel = new JLabel("CustomerDistanceLabel");

		PanelOne.add(CustomerNameLabel);
		PanelOne.add(CustomerMobileLabel);
		PanelOne.add(CustomerTypeLabel);
		PanelOne.add(CustomerLocationLabel);
		PanelOne.add(CustomerDistanceLabel);
		
		
		//Labels for pizza 
		PizzaTypeLabel = new JLabel("PizzaTypeLabel");
		PizzaQuantityLabel = new JLabel("PizzaQuantityLabel");
		PizzaOrderPriceLabel = new JLabel("PizzaOrderPriceLabel");
		PizzaOrderCostLabel = new JLabel("PizzaOrderCostLabel");
		PizzaOrderProfitLabel = new JLabel("PizzaOrderProfitLabel");

		PanelOne.add(PizzaTypeLabel);
		PanelOne.add(PizzaQuantityLabel);
		PanelOne.add(PizzaOrderPriceLabel);
		PanelOne.add(PizzaOrderCostLabel);
		PanelOne.add(PizzaOrderProfitLabel);
		
		
		//Lables  For Customer Results 
		ResultCustomerNameLabel = new JLabel("	ResultCustomerNameLabel");
		ResultCustomerMobileLabel = new JLabel("	ResultCustomerMobileLabel");
		ResultCustomerTypeLabel = new JLabel("	ResultCustomerTypeLabelE");
		ResultCustomerLocationLabel = new JLabel("	ResultCustomerTypeLabel");
		ResultCustomerDistanceLabel = new JLabel("	ResultCustomerDistanceLabel");

		PanelTwo.add(ResultCustomerNameLabel);
		PanelTwo.add(ResultCustomerMobileLabel);
		PanelTwo.add(ResultCustomerTypeLabel);
		PanelTwo.add(ResultCustomerLocationLabel);
		PanelTwo.add(ResultCustomerDistanceLabel);
		

		//Labels for pizza Result
		ResultPizzaTypeLabel = new JLabel("ResultPizzaTypeLabel");
		ResultPizzaQuantityLabel = new JLabel("ResultPizzaQuantityLabel");
		ResultPizzaOrderPriceLabel = new JLabel("ResultPizzaOrderPriceLabel");
		ResultPizzaOrderCostLabel = new JLabel("ResultPizzaOrderCostLabel");
		ResultPizzaOrderProfitLabel = new JLabel("ResultPizzaOrderProfitLabel");

		PanelTwo.add(ResultPizzaTypeLabel);
		PanelTwo.add(ResultPizzaQuantityLabel);
		PanelTwo.add(ResultPizzaOrderPriceLabel);
		PanelTwo.add(ResultPizzaOrderCostLabel);
		PanelTwo.add(ResultPizzaOrderProfitLabel);
		
		
		
		//BUTTONS 
		
		 UploadButton = new JButton("Upload");
		 PanelThree.add(UploadButton);
		 UploadButton.addActionListener(this);
		 
		 
		 ClearButton = new JButton("Clear");
		 PanelThree.add(ClearButton);
		 ClearButton.addActionListener(this);
		 
		 NextButton = new JButton("<<");
		 PanelThree.add(NextButton);
		 NextButton.addActionListener(this);
		 
		 PreviousButton = new JButton(">>");
		 PanelThree.add(PreviousButton);
		 PreviousButton.addActionListener(this);
		 
		 
		 
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
	
	private void ClearFuction(){
		//clear the function
		
	}
	
	private void NextFuction(){
		//move the content forward one index 
				
			}
	private void PreviousFuction(){
		//move the content back one index 
		
	}
	
	private void ReadData(){
		//reading and showing the data from the file 
				
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
			int returnValue =fileChooser.showOpenDialog(this);
			if(returnValue== JFileChooser.APPROVE_OPTION){
				File file =fileChooser.getSelectedFile();
				String fileName = file.getAbsolutePath();
			}else if(src==ClearButton){
				// CLEAR FUCTION
				ClearFuction();
			}else if(src==NextButton){
				// Next FUCTION
				NextFuction();
			}else if(src==PreviousButton){
				// previous RUCTION
				PreviousFuction();
			}else if (returnValue == JFileChooser.CANCEL_OPTION){}
			
		}
	}
		
		
		
		// TODO Auto-generated method stub
	
	
	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		 SwingUtilities.invokeLater(new PizzaGUI("Pizza Place"));
		
		
	}

	

}
