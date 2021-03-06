
package HostGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import Controller.Controller;
import GUI.ConnectionManager;
import GUI.MainModule;
import GUI.MainModule.EDITPROPERTY;
import GUI.MainModule.USER;
import Model.Model;

public class EditUtility extends JFrame {

	private JFrame frame;
	private NavHost navForHost = new NavHost();

	public void close() {
		frame.dispose();
	}

	/*
	 * Class to editUtility object's information already in database
	 */
	private Controller controller;
	private Model model;
	private MainModule mainModule;
	private JRadioButton heatingRadioBtn;
	private JRadioButton washingMachineRadioBtn;
	private JRadioButton fireExtinguisherRadioBtn;
	private JRadioButton dryingMachineRadioBtn;
	private JRadioButton smokeAlarmRadioBtn;
	private JRadioButton firstAidKitRadioBtn;
	private JButton addUtility;
	private int idAfter;
	private int facilitiesidAfter;

	private boolean heating, washingMachine, dryingMachine, fireExtinguisher, smokeAlarm, firstAidKit;

	Connection connection = null;

	//Consturctor for editUtility Class
	public EditUtility(MainModule mainModule, Controller controller, Model model) {
		this.model = model;
		this.mainModule = mainModule;
		this.controller = controller;
	}
	/**
	 * Initialize the contents of the frame so that it can be called from other GUI pages
	 */
	public void initializeEditUtility(int facilitiesId, int id) {
		//Creates the frame and adds a NavBar
		try {
			frame = new JFrame();
			navForHost.addHostNav(frame, mainModule);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		idAfter = id;
		facilitiesidAfter = facilitiesId;

		//Creates the main panel for the editUtility Page
		JPanel editUtilityPanel = new JPanel();
		editUtilityPanel.setBackground(new Color(204, 255, 255));
		frame.getContentPane().add(editUtilityPanel, BorderLayout.CENTER);
		editUtilityPanel.setLayout(null);

		JLabel utilityLabel = new JLabel("Add Utilities");
		utilityLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		utilityLabel.setBounds(248, 47, 183, 57);
		editUtilityPanel.add(utilityLabel);

		try {
			connection = ConnectionManager.getConnection();

			//Gets the information for the kitchen in the database and sets the values
			//to variables
			String selectUtilityRecord = "select heating, washingMachine, dryingMachine, fireExtinguisher, "
					+ "smokeAlarm, firstAidKit from Utility where utility_id=?";

			PreparedStatement selectingUtilityValues = connection.prepareStatement(selectUtilityRecord);

			selectingUtilityValues.setInt(1, id);
			ResultSet rs = selectingUtilityValues.executeQuery();

			while (rs.next()) {
				heating = rs.getBoolean("heating");
				washingMachine = rs.getBoolean("washingMachine");
				dryingMachine = rs.getBoolean("dryingMachine");
				fireExtinguisher = rs.getBoolean("fireExtinguisher");
				smokeAlarm = rs.getBoolean("smokeAlarm");
				firstAidKit = rs.getBoolean("firstAidKit");
			}
			connection.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		//Creates the objects such as labels and textFields and adds them to the panel
		JLabel heatingLabel = new JLabel("Heating");
		heatingLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		heatingLabel.setBounds(146, 135, 167, 34);
		editUtilityPanel.add(heatingLabel);

		heatingRadioBtn = new JRadioButton("Heating", heating);
		heatingRadioBtn.setBounds(395, 146, 21, 23);
		editUtilityPanel.add(heatingRadioBtn);

		JLabel washingMachineLabel = new JLabel("Washing Machine");
		washingMachineLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		washingMachineLabel.setBounds(146, 188, 167, 34);
		editUtilityPanel.add(washingMachineLabel);

		washingMachineRadioBtn = new JRadioButton("Washing machine", washingMachine);
		washingMachineRadioBtn.setBounds(395, 199, 21, 23);
		editUtilityPanel.add(washingMachineRadioBtn);

		JLabel fireExtinguisherLabel = new JLabel("Fire Extinguisher");
		fireExtinguisherLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fireExtinguisherLabel.setBounds(146, 254, 167, 34);
		editUtilityPanel.add(fireExtinguisherLabel);

		fireExtinguisherRadioBtn = new JRadioButton("fire extinguisher", fireExtinguisher);
		fireExtinguisherRadioBtn.setBounds(395, 262, 21, 23);
		editUtilityPanel.add(fireExtinguisherRadioBtn);

		JLabel dryingMachineLabel = new JLabel("Drying Machine");
		dryingMachineLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dryingMachineLabel.setBounds(146, 310, 167, 34);
		editUtilityPanel.add(dryingMachineLabel);

		dryingMachineRadioBtn = new JRadioButton("Drying machine", dryingMachine);
		dryingMachineRadioBtn.setBounds(395, 310, 21, 23);
		editUtilityPanel.add(dryingMachineRadioBtn);

		JLabel smokeAlarmLabel = new JLabel("Smoke Alarm");
		smokeAlarmLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		smokeAlarmLabel.setBounds(146, 369, 167, 34);
		editUtilityPanel.add(smokeAlarmLabel);

		smokeAlarmRadioBtn = new JRadioButton("Smoke alarm", smokeAlarm);
		smokeAlarmRadioBtn.setBounds(395, 380, 21, 23);
		editUtilityPanel.add(smokeAlarmRadioBtn);

		JLabel firstAidKitLabel = new JLabel("First Aid Kit");
		firstAidKitLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstAidKitLabel.setBounds(146, 424, 167, 34);
		editUtilityPanel.add(firstAidKitLabel);

		firstAidKitRadioBtn = new JRadioButton("First aid kit", firstAidKit);
		firstAidKitRadioBtn.setBounds(395, 435, 21, 23);
		editUtilityPanel.add(firstAidKitRadioBtn);

		//Button to update the Kitchens information in the database
		addUtility = new JButton("Save");
		addUtility.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateUtilityDetails();
			}
		});
		addUtility.setBounds(248, 500, 91, 23);
		editUtilityPanel.add(addUtility);

		//Button to return user to the previous GUI page
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		backButton.setBounds(29, 66, 91, 23);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainModule.userState = USER.HOST;
				mainModule.editPropertyState = EDITPROPERTY.EDIT_PROPERTY_FACILITIES;
				MainModule.controller.editPropertyView(facilitiesidAfter, idAfter); 
				frame.dispose();
			}
		});
		editUtilityPanel.add(backButton);

		frame.setBounds(100, 100, 600, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	//Function to update the kitchens values in the database
	public void updateUtilityDetails() {
		try {
			connection = ConnectionManager.getConnection();

			//Sets the radio button son GUI to display the inforamtion about th kitchen
			// in the database so the user can see what they are editing
			model.setHeating(heatingRadioBtn.isSelected());
			model.setWashingMachine(washingMachineRadioBtn.isSelected());
			model.setFireExtinguisher(fireExtinguisherRadioBtn.isSelected());
			model.setDryingMachine(dryingMachineRadioBtn.isSelected());
			model.setSmokeAlarm(smokeAlarmRadioBtn.isSelected());
			model.setFirstAidKit(firstAidKitRadioBtn.isSelected());

			//Updates the database with the new information from the radioButtons
			//that the user has changed
			String updateUtilityRecord = "update Utility set heating=?, washingMachine=?, "
					+ "dryingMachine=?, fireExtinguisher=?, smokeAlarm=?, firstAidKit=? " + "where utility_id=?";

			PreparedStatement ps_utility = connection.prepareStatement(updateUtilityRecord);

			ps_utility.setBoolean(1, model.getHeating());
			ps_utility.setBoolean(2, model.getWashingMachine());
			ps_utility.setBoolean(3, model.getFireExtinguisher());
			ps_utility.setBoolean(4, model.getDryingMachine());
			ps_utility.setBoolean(5, model.getSmokeAlarm());
			ps_utility.setBoolean(6, model.getFirstAidKit());
			ps_utility.setInt(7, idAfter);

			ps_utility.executeUpdate();

			String updateUtilityIdInFacilities = "update Facilities set utility_id=? where facilities_id=?";

			PreparedStatement updatingUtilityIdInFacilities = connection.prepareStatement(updateUtilityIdInFacilities);
			updatingUtilityIdInFacilities.setInt(1, idAfter);
			updatingUtilityIdInFacilities.setInt(2, facilitiesidAfter);
			updatingUtilityIdInFacilities.executeUpdate();
			
			connection.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
}