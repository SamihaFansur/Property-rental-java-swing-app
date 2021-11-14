package HostGUI;

import java.awt.EventQueue;
import javax.swing.*;

import Controller.Controller;
import GUI.ConnectionManager;
import GUI.Login;
import GUI.MainModule;
import GUI.MainModule.EDITPROPERTY;
import GUI.MainModule.STATE;
import GUI.MainModule.USER;
import Model.Model;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class AddFacility extends JFrame{


	private NavHost navForHost = new NavHost();
	private JFrame frame;

	Connection connection = null;
	
	public void close() {
		frame.dispose();
	}

	/**
	 * Create the application.
	 */

	 private Controller controller;
	 private Model model;
	 private MainModule mainModule;
	 
	 public AddFacility(MainModule mainModule, Controller controller, Model model) {
		//initializeHomePage();
		this.model=model;
		this.mainModule=mainModule;
		this.controller=controller;
	 }

	/**
	 * Initialize the contents of the frame.
	 */
	public void initializeAddFacility() {
		
		try {
			frame = new JFrame();
			navForHost.addHostNav(frame, mainModule);
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(204, 255, 255));
		frame.getContentPane().add(registerPanel, BorderLayout.CENTER);
		registerPanel.setLayout(null);

		JLabel addFacilityLabel = new JLabel("Add Facility");
		addFacilityLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		addFacilityLabel.setBounds(222, 53, 183, 57);
		registerPanel.add(addFacilityLabel);
//		
//		JButton addSleepingButton = new JButton("Add Sleeping Facility");
//		addSleepingButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainModule.editPropertyState= EDITPROPERTY.EDIT_SLEEPING;
//				MainModule.controller.editPropertyView();
//			}
//		});
//		addSleepingButton.setBounds(190, 160, 196, 51);
//		registerPanel.add(addSleepingButton);
//		
//		JButton btnAddBathingFacility = new JButton("Add Bathing Facility");
//		btnAddBathingFacility.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainModule.editPropertyState= EDITPROPERTY.EDIT_BATHING;
//				MainModule.controller.editPropertyView();
//			}
//		});
//		btnAddBathingFacility.setBounds(190, 222, 196, 51);
//		registerPanel.add(btnAddBathingFacility);
		
		JButton btnAddKitchenfacility = new JButton("Add Kitchen Facility");
		btnAddKitchenfacility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainModule.editPropertyState= EDITPROPERTY.EDIT_KITCHEN;
				//create a record and set values to null
				int id=0;
				try {
					connection = ConnectionManager.getConnection();
					
					String insertKitchenQuery = "insert into Kitchen (refrigerator, microwave, oven, "
												+ "stove, dishwasher, tableware, cookware, basicProvision)"
												+ " values(?,?,?,?,?,?,?,?) ";
					PreparedStatement ps_kitchen = connection.prepareStatement(insertKitchenQuery, Statement.RETURN_GENERATED_KEYS);
					
					ps_kitchen.setBoolean(1, false);
					ps_kitchen.setBoolean(2, false);
					ps_kitchen.setBoolean(3, false);
					ps_kitchen.setBoolean(4, false);
					ps_kitchen.setBoolean(5, false);
					ps_kitchen.setBoolean(6, false);
					ps_kitchen.setBoolean(7, false);
					ps_kitchen.setBoolean(8, false);

					System.out.println(ps_kitchen);
					ps_kitchen.executeUpdate();
					
					ResultSet rs=ps_kitchen.getGeneratedKeys();
					if(rs.next()){
						id=rs.getInt(1);
					}
					
					//create public id var
					//call it in editKitchen, set it as the id using select k_id from k where
					
				} catch(Exception s) {
					System.err.println("Got an exception!");
					System.err.println(s.getMessage());
				}
				System.out.println("IDDDDDDDDDDDD = "+id);
				
				
				MainModule.controller.editPropertyView(id);
			}
		});
		btnAddKitchenfacility.setBounds(190, 289, 196, 57);
		registerPanel.add(btnAddKitchenfacility);
		
//		JButton btnAddUtilityFacility = new JButton("Add Utility Facility");
//		btnAddUtilityFacility.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainModule.editPropertyState= EDITPROPERTY.EDIT_UTILITY;
//				MainModule.controller.editPropertyView();
//			}
//		});
//		btnAddUtilityFacility.setBounds(192, 363, 194, 57);
//		registerPanel.add(btnAddUtilityFacility);
//		
//		JButton btnAddLivingFacility = new JButton("Add Living Facility");
//		btnAddLivingFacility.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainModule.editPropertyState= EDITPROPERTY.EDIT_LIVING;
//				MainModule.controller.editPropertyView();
//			}
//		});
//		btnAddLivingFacility.setBounds(192, 437, 194, 57);
//		registerPanel.add(btnAddLivingFacility);
//		
//		JButton btnAddOutdoorsFacility = new JButton("Add Outdoors Facility");
//		btnAddOutdoorsFacility.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainModule.editPropertyState= EDITPROPERTY.EDIT_OUTDOORS;
//				MainModule.controller.editPropertyView();
//			}
//		});
//		btnAddOutdoorsFacility.setBounds(190, 505, 196, 51);
//		registerPanel.add(btnAddOutdoorsFacility);


		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

//NEED TO ALIGN CONTENT IN THE CENTER & RESIZE WINDOW