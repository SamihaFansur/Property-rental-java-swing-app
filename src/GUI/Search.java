package GUI;
import Controller.*;
import GUI.MainModule.STATE;
import Model.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Search extends JFrame{

	private JFrame frame;
	private final JButton filterButton = new JButton("Apply Filters");
	private JTextField numberOfGuestsFilter;
	private JTextField minPriceFilter;
	private JTextField maxPriceFilter;
	private JTable propertiesTable;
	/**
	 * @wbp.nonvisual location=718,143
	 */

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	
	private Controller controller;
	private Model model;
	private MainModule mainModule;
	public Search(MainModule mainModule, Controller controller, Model model) {
		//initializeSearch();
		this.controller=controller;
		this.model=model;
		this.mainModule=mainModule;
	}

	 public void close() {
		 	frame.dispose();
	    }	
	/**
	 * Initialize the contents of the frame.
	 */
	 public void initializeSearch() {
			frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.NORTH);

			
			JPanel navBarPanel = new JPanel();
			navBarPanel.setBackground(new Color(51, 255, 255));
			frame.getContentPane().add(navBarPanel, BorderLayout.NORTH);
			
			System.out.println("Initialise homepage");
			
			JButton navHomeButton = new JButton("Home");
			navHomeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Homepage sp = new Homepage();

					mainModule.currentState=STATE.HOMEPAGE;
					MainModule.controller.drawNewView();
					//close();
				}
			});
			navBarPanel.add(navHomeButton);
		
			
			JButton navSearchButton = new JButton("Search");
			navSearchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainModule.currentState=STATE.SEARCH;
					MainModule.controller.drawNewView();
				}
			});
			navBarPanel.add(navSearchButton);
			
			JButton navRegisterButton = new JButton("Register");
			navRegisterButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainModule.currentState=STATE.SELF_REGISTRATION;
					MainModule.controller.drawNewView();
				}
			});
			navBarPanel.add(navRegisterButton);
			
			JButton navLoginButton = new JButton("Login");
			navLoginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainModule.currentState=STATE.LOGIN;
					MainModule.controller.drawNewView();
					//close();
							//Login sp = new Login();
				}
			});
			navBarPanel.add(navLoginButton);
			
			JButton navContactButton = new JButton("Contact");
			navContactButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					mainModule.currentState=STATE.CONTACT_US;
					MainModule.controller.drawNewView();
					//close();
					//Register sp = new Register();
				}
			});
			navBarPanel.add(navContactButton);
			
			JPanel loginPanel = new JPanel();
			loginPanel.setBackground(new Color(204, 255, 255));
			frame.getContentPane().add(loginPanel, BorderLayout.CENTER);
			loginPanel.setLayout(null);
			
			JLabel numberOfGuestsLabel = new JLabel("Number of Guests");
			numberOfGuestsLabel.setBounds(70, 45, 115, 45);
			loginPanel.add(numberOfGuestsLabel);
			filterButton.setBounds(165, 182, 141, 36);
			loginPanel.add(filterButton);
			
			JLabel minPriceFilterLabel = new JLabel("Min Price Per Night");
			minPriceFilterLabel.setBounds(70, 109, 100, 14);
			loginPanel.add(minPriceFilterLabel);
			
			numberOfGuestsFilter = new JTextField();
			numberOfGuestsFilter.setBounds(194, 52, 63, 31);
			loginPanel.add(numberOfGuestsFilter);
			numberOfGuestsFilter.setColumns(10);
			
			JLabel maxPriceFilterLabel = new JLabel("Max Price Per Night");
			maxPriceFilterLabel.setBounds(318, 109, 100, 14);
			loginPanel.add(maxPriceFilterLabel);
			
			JLabel locationFilterLabel = new JLabel("Location");
			locationFilterLabel.setBounds(318, 45, 115, 45);
			loginPanel.add(locationFilterLabel);
			
			JComboBox locationComboBox = new JComboBox();
			locationComboBox.setBounds(423, 51, 63, 33);
			loginPanel.add(locationComboBox);
			
			minPriceFilter = new JTextField();
			minPriceFilter.setColumns(10);
			minPriceFilter.setBounds(194, 106, 63, 31);
			loginPanel.add(minPriceFilter);
			
			maxPriceFilter = new JTextField();
			maxPriceFilter.setColumns(10);
			maxPriceFilter.setBounds(423, 106, 63, 31);
			loginPanel.add(maxPriceFilter);
			
			propertiesTable = new JTable();
			propertiesTable.setBounds(98, 256, 428, 244);
			loginPanel.add(propertiesTable);
			
			JButton resetFiltersButton = new JButton("Reset");
			resetFiltersButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numberOfGuestsFilter.setText("");
					minPriceFilter.setText("");
					maxPriceFilter.setText("");
					locationComboBox.setSelectedItem("");
					//while (propertiesTable.getRowCount()>0)
					//{
						//propertiesTable.removeRow(0);
					//}
				}
			});
			resetFiltersButton.setBounds(323, 182, 141, 36);
			loginPanel.add(resetFiltersButton);
			frame.setBounds(100, 100, 600, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setVisible(true);
	}
}
