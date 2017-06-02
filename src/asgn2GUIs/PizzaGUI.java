package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;
import javax.swing.JFileChooser; 
import java.awt.*;
import javax.swing.*;

/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * @author Matthew Pike and Michael Cartwright
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 975;
	public static final int HEIGHT = 500;
	
	private PizzaRestaurant restaurant;
	// Define panels
	private JPanel pnlBase;
	private JPanel pnlButtons;
	// Define buttons
	private JButton btnLoadFile;
	private JButton btnResetData;
	private JButton btnDisplayData;
	private JButton btnDisplayResult;
	// Define text area and scroll for log output
	private JTextArea displayCustomers; 
	private JTextArea displayPizzas; 
	private JScrollPane scrollDisplay;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		super(title);
	}
	
	/**
	 * Creates a Graphical User Interface (GUI) with panels, buttons, text areas and a scroll for the text areas.
	 * pnlBase - A panel that contains the text areas of displayPizzas and displayCustomers
	 * pblBtn - A panel that contains the buttons btnLoadFile,  btnResetData,  btnDisplayData and btnDisplayResult
	 */
	private void createGUI() {
		setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());
	    
	    pnlBase = createPanel(Color.WHITE);
	    pnlButtons = createPanel(Color.LIGHT_GRAY);
	    
	    btnLoadFile = createButton("Load Log Data");
	    btnDisplayData = createButton("Display Data");
	    btnDisplayResult = createButton("Display Calculation");
	    btnResetData = createButton("Reset Data");
	    
	    displayCustomers = createTextArea();
	    displayPizzas = createTextArea();
	    
	    scrollDisplay = createScroll(pnlBase);
	    
	    pnlBase.setLayout(new GridLayout(0,2));
	    pnlBase.add(displayCustomers);
	    pnlBase.add(displayPizzas);
	    
	    layoutButtonPanel(); 
	    
	    // Positions panel layout
	    this.getContentPane().add(scrollDisplay,BorderLayout.CENTER);
	    this.getContentPane().add(pnlButtons,BorderLayout.SOUTH);
	    
	    repaint(); 
	    this.setVisible(true);
	    this.setResizable(false);
	}
	
	/**
	 * Creates a panel
	 */
	private JPanel createPanel(Color c) {
		JPanel jp = new JPanel();
		jp.setBackground(c);
		return jp;
	}
	
	/**
	 * Creates a button
	 */
	private JButton createButton(String str) {
		JButton jb = new JButton(str);
		jb.setBackground(Color.GRAY);
		jb.setForeground(Color.WHITE);
		jb.addActionListener(this);
		return jb; 
	}
	
	/**
	 * Creates a text area
	 */
	private JTextArea createTextArea() {
		JTextArea jta = new JTextArea(); 
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
		return jta;
	}
	
	/**
	 * Creates a scroll
	 */
	private JScrollPane createScroll(JPanel jp){
		JScrollPane jsp = new JScrollPane(jp);
		// Set to only scroll vertically and never horizontally
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return jsp;
	}
	
	/**
	 * Creates a panel used for the buttons of the GUI
	 * Adds the buttons btnLoadFile, btnResetData, btnDisplayData and btnDisplayResult
	 */
	private void layoutButtonPanel() {
		GridBagLayout layout = new GridBagLayout();
		pnlButtons.setLayout(layout);
	    
	    GridBagConstraints constraints = new GridBagConstraints(); 
	    
	    constraints.fill = GridBagConstraints.NONE;
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 50;
	    constraints.weighty = 50;
	    
	    addToPanel(pnlButtons, btnLoadFile, constraints, 0, 0, 1, 1); 
	    addToPanel(pnlButtons, btnDisplayData, constraints, 1, 0, 1, 1); 
	    addToPanel(pnlButtons, btnDisplayResult, constraints, 2, 0, 1, 1); 
	    addToPanel(pnlButtons, btnResetData, constraints, 3, 0, 1, 1); 	
	}
	
	/**
	 * Allocates a component to the specified JPanel
	 * Used for buttons to be allocated to pnlButtons panel
	 */
	private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints, int x, int y, int w, int h) {  
		constraints.gridx = x;
	    constraints.gridy = y;
	    constraints.gridwidth = w;
	    constraints.gridheight = h;
	    jp.add(c, constraints);
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		createGUI();
	}
	
	String line;
	Customer currentCustomer;
	Pizza currentPizza;
	Boolean infoLoaded = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		// Gets the event source
		Object src = e.getSource(); 
  		// Source of loading the Log file from button btnLoadFile
		if(src == btnLoadFile) {
			JButton btn = ((JButton)src);
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int result = fileChooser.showOpenDialog(btn);
			if(result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String filename = selectedFile.getAbsolutePath();
				restaurant = new PizzaRestaurant();
				try {
					restaurant.processLog(filename);
					infoLoaded = true;
					displayCustomers.setText(filename + " Loaded");
				} catch (CustomerException | PizzaException | LogHandlerException e1) {
					JOptionPane.showMessageDialog(this,"The file: " + filename + " failed to load due to" + "\n" + 
				                                  e1.toString(),"File failed to load",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		// Source of displaying displayPizzas and displayCustomers from button btnDisplayData but only when the data
		// has been loaded
		} else if (src == btnDisplayData && infoLoaded) {
			displayPizzas.setText(String.format("   Pizza\n%-3s %-12s %-4s %-6s %-6s %-6s", " | ", "Type", "Qty", "Price", "Cost", 
					                            "Profit\n"));
			displayCustomers.setText(String.format("Customers\n%-19s %-11s %-16s %-6s %-6s %-5s", "Name", "Mobile", 
					                               "Type", "Loc X", "Loc Y", "Dist\n"));
			try {
				for(int indexPizza = 0; indexPizza < restaurant.getNumPizzaOrders(); indexPizza++) {
					currentPizza = restaurant.getPizzaByIndex(indexPizza);
					line = String.format("%-3s %-12s %-4d %-6.2f %-6.2f %-6.2f", " | ", currentPizza.getPizzaType(), 
							             currentPizza.getQuantity(), currentPizza.getOrderPrice(), 
							             currentPizza.getOrderCost(), currentPizza.getOrderProfit());
					displayPizzas.append(line + "\n");
				}
			} catch (PizzaException e1) {
				JOptionPane.showMessageDialog(this, "Failed to display Pizza data due to:/n" + e1.toString(), 
						                      "Failed to display Pizza data", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				for(int indexCustomer = 0; indexCustomer < restaurant.getNumCustomerOrders(); indexCustomer++) {
					currentCustomer = restaurant.getCustomerByIndex(indexCustomer);
					line = String.format("%-19s %-11s %-16s %-6d %-6d %-5.2f", currentCustomer.getName(), 
							             currentCustomer.getMobileNumber(), currentCustomer.getCustomerType(), 
							             currentCustomer.getLocationX(), currentCustomer.getLocationY(),
							             currentCustomer.getDeliveryDistance());
					displayCustomers.append(line + "\n");
				}
			} catch (CustomerException e1) {
				JOptionPane.showMessageDialog(this, "Failed to display Customer data due to:/n" + e1.toString(), 
						                      "Failed to display Customer data", JOptionPane.ERROR_MESSAGE);
			}
		
		// Source of displaying total profit and total distance traveled from button btnDisplayResult but only when the
		// data has been loaded
		} else if (src == btnDisplayResult && infoLoaded) {
			displayPizzas.setText(String.format("Total Profit: $%.2f", restaurant.getTotalProfit()));
			displayCustomers.setText(String.format("Total Delivery Distance: %.2f" + "km", 
					                 restaurant.getTotalDeliveryDistance()));
		
		// Source of resetting displayPizzas and displayCustomers from button btnResetData but only when the data has
		// been loaded
		} else if (src == btnResetData && infoLoaded) {
			restaurant.resetDetails();
			displayPizzas.setText("");
			displayCustomers.setText("");
			infoLoaded = false;
		}
	}
}
