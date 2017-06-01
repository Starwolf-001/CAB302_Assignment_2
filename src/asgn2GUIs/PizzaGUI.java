package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Matthew Pike
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	
	private PizzaRestaurant restaurant;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		
		super(title);
		String[] columnCustomers = {
				"Customer Name",
				"Mobile Number",
				"Customer Type",
				"X Location",
				"Y Location",
				"Delivery Distance"
		};
		
		String[] columnPizzas = {
				"Pizza Type",
				"Quantity",
				"Order Price",
				"Order Cost",
				"Order Profit"
		};
		
		Object[][] dataCustomers = {{"Matthew", "0412345678", "PUC", new Integer(4), new Integer(5), new Integer(0)}};
		Object[][] dataPizzas = {{"PZL", new Integer(2), new Integer(4), new Integer(3), new Integer(1)}};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Text Files", "txt");
	    fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(this);
		String filename = null;
		if(returnVal==JFileChooser.APPROVE_OPTION){
			File file = fc.getSelectedFile();
			filename = file.getAbsolutePath();
		} else if (returnVal==JFileChooser.CANCEL_OPTION){
			System.exit(1);
		}

		try {
			PizzaRestaurant.processLog(filename);
		} 
		catch (CustomerException | PizzaException | LogHandlerException e) {
			
		}
		
		JTable customer = new JTable(dataCustomers, columnCustomers);
		JTable pizza = new JTable(dataPizzas, columnPizzas);
		
		
		JTabbedPane pane = new JTabbedPane();
		JPanel panel1 = new JPanel();
		panel1.add(customer);
		JPanel panel2 = new JPanel();
		panel2.add(pizza);
		
		pane.add("testing", panel1);
		pane.add("testing2", panel2);
		getContentPane().add(pane);
		
		setPreferredSize(new Dimension (500, 300));
		setLocation(new Point(500, 100));
		pack();
		setVisible(true);
		
	}

	
	@Override
	public void run() {
		// TO DO
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
