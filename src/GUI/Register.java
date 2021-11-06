package GUI;
import Controller.*;
import GUI.MainModule.STATE;
import Model.*;
import java.awt.EventQueue;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class Register extends JFrame{

	private JFrame frame;
	private JButton registerButton = new JButton("Register");
	private JTextField passwordTextField;
	private JTextField firstNameTextField;
	private JTextField surnameTextField;
	private JTextField addressLine1Field;
	private JTextField postcodeTextField;
	private JTextField houseNumberTextField;
	private JTextField emailAddressTextField;
	private JTextField mobileNumberTextField;
	private JComboBox accountTypeComboBox;
	private JComboBox registerTitleComboBox;
	
//	private Controller controller;
	private Model model;
	private Controller controller;
	private MainModule mainModule;
	
	Connection connection = null;

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("failed to close conn");
			e.printStackTrace();
		} finally {
			System.out.println("conn closed!");
		}
		frame.dispose();
	}

	/**
	 * Create the application.
	 */

	public Register(MainModule mainModule, Controller controller, Model model) {
		//initializeRegister();
		this.mainModule=mainModule;
		this.model=model;
		this.controller=controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initializeRegister() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 255));

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

		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(204, 255, 255));
		frame.getContentPane().add(registerPanel, BorderLayout.CENTER);
		registerPanel.setLayout(null);

		JLabel registerTitleLabel = new JLabel("Title");
		registerTitleLabel.setBounds(54, 57, 118, 45);
		registerPanel.add(registerTitleLabel);

		String titles[] = { "Mr", "Mrs", "Miss", "Ms", "Dr" };
		registerTitleComboBox = new JComboBox(titles);
		registerTitleComboBox.setBounds(189, 71, 276, 23);
		registerPanel.add(registerTitleComboBox);

		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(54, 102, 118, 45);
		registerPanel.add(firstNameLabel);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(189, 113, 276, 23);
		registerPanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		model.setFirstName(firstNameTextField.getText());
		
		JLabel lblNewLabel = new JLabel("Surname");
		lblNewLabel.setBounds(54, 136, 118, 45);
		registerPanel.add(lblNewLabel);

		surnameTextField = new JTextField();
		surnameTextField.setBounds(189, 147, 276, 23);
		registerPanel.add(surnameTextField);
		surnameTextField.setColumns(10);

		model.setSurname(surnameTextField.getText());
		
		JLabel emailAddressLabel = new JLabel("Email Address");
		emailAddressLabel.setBounds(54, 173, 118, 45);
		registerPanel.add(emailAddressLabel);

		emailAddressTextField = new JTextField();
		emailAddressTextField.setColumns(10);
		emailAddressTextField.setBounds(189, 181, 276, 29);
		registerPanel.add(emailAddressTextField);
		
		model.setEmail(emailAddressTextField.getText());

		JLabel mobileLabel = new JLabel("Mobile Number");
		mobileLabel.setBounds(54, 229, 125, 14);
		registerPanel.add(mobileLabel);

		mobileNumberTextField = new JTextField();
		mobileNumberTextField.setColumns(10);
		mobileNumberTextField.setBounds(189, 217, 276, 29);
		registerPanel.add(mobileNumberTextField);
		
		model.setMobileNumber(mobileNumberTextField.getText());

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(54, 267, 75, 14);
		registerPanel.add(passwordLabel);

		passwordTextField = new JTextField();
		passwordTextField.setBounds(189, 261, 276, 26);
		registerPanel.add(passwordTextField);
		
		model.setPassword(passwordTextField.getText());
		
		JLabel addressLine1Label = new JLabel("Address Line 1");
		addressLine1Label.setBounds(54, 307, 125, 14);
		registerPanel.add(addressLine1Label);

		addressLine1Field = new JTextField();
		addressLine1Field.setBounds(189,  300, 276, 29);
		registerPanel.add(addressLine1Field);
		
		model.setAddressLine1(addressLine1Field.getText());

		JLabel houseNumberLabel = new JLabel("House Name/Number");
		houseNumberLabel.setBounds(54, 346, 125, 14);
		registerPanel.add(houseNumberLabel);

		houseNumberTextField = new JTextField();
		houseNumberTextField.setBounds(189, 340 , 276, 27);
		registerPanel.add(houseNumberTextField);
		
		model.setHouseNameNum(houseNumberTextField.getText());

		JLabel postcodeLabel = new JLabel("Postcode");
		postcodeLabel.setBounds(54, 386, 125, 14);
		registerPanel.add(postcodeLabel);

		postcodeTextField = new JTextField();
		postcodeTextField.setBounds(189, 378, 276, 31);
		registerPanel.add(postcodeTextField);

		model.setPostcode(postcodeTextField.getText());
		
		JLabel accountTypeLabel = new JLabel("Register as");
		accountTypeLabel.setBounds(54, 430, 125, 14);
		registerPanel.add(accountTypeLabel);

		String accountTypes[] = { "Host", "Guest", "Both (Host & Guest)" };
		accountTypeComboBox = new JComboBox(accountTypes);
		accountTypeComboBox.setBounds(189,  426, 276, 23);
		registerPanel.add(accountTypeComboBox);

		model.setAccountType(accountTypeComboBox.getSelectedItem().toString());
		
		registerButton.setBounds(356, 480, 91, 23);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
				close();
				Login sp = new Login(mainModule,controller,model);
			}
		});
		registerPanel.add(registerButton);

		JLabel registerLabel = new JLabel("Register");
		registerLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		registerLabel.setBounds(264, 11, 183, 57);
		registerPanel.add(registerLabel);

		JButton resetRegisterButton = new JButton("Reset");
		resetRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerTitleComboBox.setSelectedItem("Mr");
				firstNameTextField.setText("");
				surnameTextField.setText("");
				emailAddressTextField.setText("");
				mobileNumberTextField.setText("");
				passwordTextField.setText("");
				addressLine1Field.setText("");
				houseNumberTextField.setText("");
				postcodeTextField.setText("");
				accountTypeComboBox.setSelectedItem("Host");
			}
		});
		resetRegisterButton.setBounds(220, 480, 91, 23);
		registerPanel.add(resetRegisterButton);


		frame.setBounds(100, 100, 600, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void submit() {
		try {
			System.out.println("1");
			connection = ConnectionManager.getConnection();
			System.out.println("2");
			String insertQuery = "insert into ACCOUNT values(?,?,?,?,?,?,?,?,?,?)";
			System.out.println("3");
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			System.out.println("4");
			ps.setString(1, model.getEmail());
			ps.setString(2, model.getTitle());
			ps.setString(3, model.getFirstName());
			ps.setString(4, model.getSurame());
			ps.setString(5, model.getMobileNumber());
			ps.setString(6, model.getPasword());
			ps.setString(7, model.getAddressLine1());
			ps.setString(8, model.getHouseNameNum());
			ps.setString(9, model.getPostcode());
			ps.setString(10, model.getAccountType());
			System.out.println("5");
			System.out.println(ps);
			int i  = ps.executeUpdate();
			System.out.println("6");
			if(i>0) {
				System.out.println("7");
				System.out.println(this);
				JOptionPane.showMessageDialog(this, "saved ok"); //remove later
			}
			
		} catch(Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	

	//getters and setters:
	

	
}

//NEED TO ALIGN CONTENT IN THE CENTER & RESIZE WINDOW