package com.keystoneexamprep.view.loginjframe;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

/**
 * LoginJFrameController
 * LoginJFrame allows the user to enter their email and password for authentication
 * @author Tony
 */
public class LoginJFrameView extends javax.swing.JFrame{
	private static final long serialVersionUID = -1166811363283760700L;
	
	//final variables to determine sizes of components
  	final int FORM_WIDTH=500, FORM_HEIGHT=150;
  	
	//private JFrame frame;
	private JPanel mainPanel;
	private JPanel emailPanel;
	private JPanel passwordPanel;
	private JPanel buttonPanel;
	
	private JLabel emailLabel;
	private JLabel passwordLabel;

	private JTextArea emailTextArea;
	private JPasswordField passwordPasswordField;
	
	private JButton backButton;
	private JButton loginButton;
	
        /**
         * LoginJFrameView Constructor
         */
	public LoginJFrameView() {
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
                LoginJFrameView loginJFrame = new LoginJFrameView();
            }
        });
    }

        /**
         * initComponents
         */
	public void initComponents(){
		mainPanel = new JPanel();
		emailPanel = new JPanel();
		passwordPanel = new JPanel();
		buttonPanel = new JPanel();
		
		//Box layout so that all components are stacked vertically
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		emailLabel = new JLabel("E-mail Address: ");
		emailTextArea = new JTextArea();
		emailTextArea.setMaximumSize(new Dimension(300, emailTextArea.getMinimumSize().height));
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailTextArea);
		
		passwordLabel = new JLabel("Password:");
		passwordPasswordField = new JPasswordField();
		passwordPasswordField.setMaximumSize(new Dimension(300, passwordPasswordField.getMinimumSize().height));
		
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordPasswordField);
		
		backButton = new JButton("Back");
		loginButton = new JButton("Login");
		
		buttonPanel.add(backButton);
		buttonPanel.add(loginButton);
		
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(emailPanel);
		mainPanel.add(passwordPanel);
		mainPanel.add(buttonPanel);
		
		//Set the panel the the contentpane of the frame
		getContentPane().add(mainPanel);
		
		//Close form when you click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		pack();
	}
	
        /**
         * getter for the emailAddress
         * @return 
         */
	public String getEmailAddress()
    {
        String emailAddress = emailTextArea.getText();
        return emailAddress;
    }
	
        /**
         * getter for the password
         * @return 
         */
	public char[] getPassword()
    {
        char[] password = passwordPasswordField.getPassword();
        return password;
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
         * getLoginButton
         * @return 
         */
	public javax.swing.JButton getLoginButton()
	{
	    return loginButton;
	}
		
}
