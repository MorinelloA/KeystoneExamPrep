package com.keystoneexamprep.view.registeracctjframe;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import com.keystoneexamprep.model.domain.Student;

/**
 * RegisterAcctJFrameView
 * RegisterAcctJFrame allows the user to register for a new account
 * @author Tony
 */
public class RegisterAcctJFrameView extends javax.swing.JFrame{
	private static final long serialVersionUID = -5942210065769050611L;

	//final variables to determine sizes of components
  	final int FORM_WIDTH=650, FORM_HEIGHT=500;
  	final int currentYear = 2015;
  	
	//private JFrame frame;
	private JPanel mainPanel;
	private JPanel lastNamePanel;
	private JPanel firstNamePanel;
	private JPanel birthdayPanel;
	private JPanel emailPanel;
	private JPanel passwordPanel;
	private JPanel passwordConfirmPanel;
	private JPanel phoneNumberPanel;
	private JPanel buttonPanel;
	
	private JLabel lastNameLabel;
	private JLabel firstNameLabel;
	private JLabel birthdayLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel passwordConfirmLabel;
	private JLabel phoneNumberLabel;

	private JTextArea lastNameTextArea;
	private JTextArea firstNameTextArea;
	private JTextArea phoneNumberTextArea;
	private JTextArea emailTextArea;
	private JPasswordField passwordPasswordField;
	private JPasswordField passwordConfirmPasswordField;
	
	private JSpinner monthSpinner;
	private JSpinner daySpinner;
	
	private JList yearList;
	private JScrollPane yearScroller;
	
	private SpinnerListModel monthModel;
	private SpinnerListModel daysModel;
	
	private JButton backButton;
	private JButton createAcctButton;
	
        /**
         * RegisterAcctJFrameView constructor
         */
	public RegisterAcctJFrameView() {
        initComponents();
        
        this.setSize(FORM_WIDTH,FORM_HEIGHT);                
        this.setVisible(true); 
    }
	
        /**
         * Main Method
         * @param args 
         */
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegisterAcctJFrameView registerAcctJFrame = new RegisterAcctJFrameView();
            }
        });
    }
	
        /**
         * initComponent
         */
	public void initComponents(){
		mainPanel = new JPanel();
		lastNamePanel = new JPanel();
		firstNamePanel = new JPanel();
		birthdayPanel = new JPanel();
		emailPanel = new JPanel();
		passwordPanel = new JPanel();
		passwordConfirmPanel = new JPanel();
		phoneNumberPanel = new JPanel();
		buttonPanel = new JPanel();
		
		//Box layout so that all components are stacked vertically
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		lastNamePanel.setLayout(new BoxLayout(lastNamePanel, BoxLayout.X_AXIS));
		firstNamePanel.setLayout(new BoxLayout(firstNamePanel, BoxLayout.X_AXIS));
		birthdayPanel.setLayout(new BoxLayout(birthdayPanel, BoxLayout.X_AXIS));
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		passwordConfirmPanel.setLayout(new BoxLayout(passwordConfirmPanel, BoxLayout.X_AXIS));
		phoneNumberPanel.setLayout(new BoxLayout(phoneNumberPanel, BoxLayout.X_AXIS));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		lastNameLabel = new JLabel("Last Name: ");
		lastNameTextArea = new JTextArea();
		lastNameTextArea.setMaximumSize(new Dimension(300, lastNameTextArea.getMinimumSize().height));
		
		lastNamePanel.add(lastNameLabel);
		lastNamePanel.add(lastNameTextArea);
		
		firstNameLabel = new JLabel("First Name: ");
		firstNameTextArea = new JTextArea();
		firstNameTextArea.setMaximumSize(new Dimension(300, firstNameTextArea.getMinimumSize().height));
		
		firstNamePanel.add(firstNameLabel);
		firstNamePanel.add(firstNameTextArea);
		
		birthdayLabel = new JLabel("Birthday: ");
		
		String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		monthModel = new SpinnerListModel(months);
		monthSpinner = new JSpinner(monthModel);
		monthSpinner.setMaximumSize(new Dimension(200, monthSpinner.getMinimumSize().height));
		
		String[] days = new String[31];
		for (int i=0; i<31; i++)
		{
			days[i] = Integer.toString(i+1);
		}
		
		daysModel = new SpinnerListModel(days);
		daySpinner = new JSpinner(daysModel);
		daySpinner.setMaximumSize(new Dimension(75, daySpinner.getMinimumSize().height));
		
		String[] years = new String[currentYear - 1899];
		for (int i=0; i<currentYear - 1899; i++)
		{
			years[i] = Integer.toString(i+1900);
		}
		
		yearList = new JList(years);
		yearList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		yearList.setLayoutOrientation(JList.VERTICAL);
		yearScroller = new JScrollPane(yearList);
		yearList.setSelectedIndex(0);
		//listScroller.setPreferredSize(new Dimension(250, 80));
		yearScroller.setMaximumSize(new Dimension(120, yearScroller.getMinimumSize().height));
		birthdayPanel.add(birthdayLabel);
		birthdayPanel.add(monthSpinner);
		birthdayPanel.add(daySpinner);
		birthdayPanel.add(yearScroller);
		
		emailLabel = new JLabel("E-mail Address: ");
		emailTextArea = new JTextArea();
		emailTextArea.setMaximumSize(new Dimension(300, emailTextArea.getMinimumSize().height));
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailTextArea);
		
		passwordLabel = new JLabel("Password: ");
		passwordPasswordField = new JPasswordField();
		passwordPasswordField.setMaximumSize(new Dimension(300, passwordPasswordField.getMinimumSize().height));
		
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordPasswordField);
		
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordPasswordField);
		
		passwordConfirmLabel = new JLabel("Confirm Password: ");
		passwordConfirmPasswordField = new JPasswordField();
		passwordConfirmPasswordField.setMaximumSize(new Dimension(300, passwordConfirmPasswordField.getMinimumSize().height));
		
		passwordConfirmPanel.add(passwordConfirmLabel);
		passwordConfirmPanel.add(passwordConfirmPasswordField);
		
		phoneNumberLabel = new JLabel("Phone Number: ");
		phoneNumberTextArea = new JTextArea();
		phoneNumberTextArea.setMaximumSize(new Dimension(300, phoneNumberTextArea.getMinimumSize().height));
		
		phoneNumberPanel.add(phoneNumberLabel);
		phoneNumberPanel.add(phoneNumberTextArea);
		
		backButton = new JButton("Back");
		createAcctButton = new JButton("Create Account");
		
		buttonPanel.add(backButton);
		buttonPanel.add(createAcctButton);
		
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(lastNamePanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(firstNamePanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(birthdayPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(emailPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(passwordPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(passwordConfirmPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(phoneNumberPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(buttonPanel);
		
		//Set the panel the the contentpane of the frame
		getContentPane().add(mainPanel);
		
		//Close form when you click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		pack();
	}
	
        /**
         * LastName getter
         * @return 
         */
	public String getLastName()
	{
		String lastName = lastNameTextArea.getText();
		return lastName;
	}
	
        /**
         * FirstName getter
         * @return 
         */
	public String getFirstName()
	{
		String firstName = firstNameTextArea.getText();
		return firstName;
	}

        /**
         * EmailAddress getter
         * @return 
         */
	public String getEmailAddress()
        {
            String emailAddress = emailTextArea.getText();
            return emailAddress;
        }
	
        /**
         * Password getter
         * @return 
         */
	public char[] getPassword()
    {
        char[] password = passwordPasswordField.getPassword();
        return password;
    }	
	
        /**
         * PasswordConfirm getter
         * @return 
         */
	public char[] getPasswordConfirm()
    {
        char[] passwordConfirm = passwordConfirmPasswordField.getPassword();
        return passwordConfirm;
    }	
	
        /**
         * PhoneNumber getter
         * @return 
         */
	public String getPhoneNumber()
	{
		String phoneNumber = phoneNumberTextArea.getText();
		return phoneNumber;
	}
	
        /**
         * getBackButton
         * @return 
         */
	 public javax.swing.JButton getBackButton()
	 {
	     return backButton;
	 }
	 
         /**
          * getCreateAcctButton
          * @return 
          */
	 public javax.swing.JButton getCreateAcctButton()
	 {
	     return createAcctButton;
	 }
	 
         /**
          * getStudentData 
          * returns students data that is entered by the user
          * @return 
          */
	 public Student getStudentData()
	    {
	        Student student = new Student();
	        String tempString = (daySpinner.getValue()).toString();
	        student.setBirthDate(Byte.parseByte(tempString));
	        tempString = (monthSpinner.getValue()).toString();
	        student.setBirthMonth(tempString);
	        tempString = (yearList.getSelectedValue().toString());
	        student.setBirthYear(Short.parseShort(tempString));
	        student.setEmailAddress(emailTextArea.getText());
	        student.setFirstName(firstNameTextArea.getText());
	        student.setLastName(lastNameTextArea.getText());
	        student.setPassword(passwordPasswordField.getPassword());
	        student.setPhoneNumber(phoneNumberTextArea.getText());

	        return student;
	    }
}
