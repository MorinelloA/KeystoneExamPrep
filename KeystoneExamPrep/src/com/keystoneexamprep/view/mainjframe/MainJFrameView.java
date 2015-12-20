package com.keystoneexamprep.view.mainjframe;

import javax.swing.*;
import java.awt.*;

/**
 * MainJFrameView
 * @author Tony
 */
public class MainJFrameView extends javax.swing.JFrame{

	private javax.swing.JButton loginButton;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JButton viewResultsButton;
    private javax.swing.JButton takeExamButton;
    private javax.swing.JButton answerQuestionsButton;
    private javax.swing.JButton createAccountButton;

	private JPanel mainPanel;
	private JPanel accountPanel1;
	private JPanel accountPanel2;
	private JPanel testPanel;
	private JLabel loginStatus;
    
	//final variables to determine sizes of components
	final int FORM_WIDTH=500, FORM_HEIGHT=250;
			
	private static final long serialVersionUID = 5865750703786671549L;

	public MainJFrameView() {
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
	                MainJFrameView mainJFrame = new MainJFrameView();
	            }
	        });
	    }
	
         /**
          * initComponents
          */
	public void initComponents(){
		
		mainPanel = new JPanel();
		accountPanel1 = new JPanel();
		accountPanel2 = new JPanel();
		testPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		//Make inner panels transparent
		accountPanel1.setOpaque(false);
		accountPanel2.setOpaque(false);
		testPanel.setOpaque(false);
		
		//Use these to help identify design flaws with form design
		//accountPanel1.setBackground(Color.BLUE);
		//accountPanel2.setBackground(Color.GREEN);
		//testPanel.setBackground(Color.RED);
		
		//Center Panels
		accountPanel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		accountPanel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		testPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Box layout so that all components are stacked vertically
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		accountPanel1.setLayout(new BoxLayout(accountPanel1, BoxLayout.X_AXIS));
		accountPanel2.setLayout(new BoxLayout(accountPanel2, BoxLayout.X_AXIS));
		testPanel.setLayout(new BoxLayout(testPanel, BoxLayout.X_AXIS));
		
		loginStatus = new JLabel("Not logged in  ");
		Font loginStatusFont = new Font("Verdana", Font.ITALIC, 16);
		loginStatus.setFont(loginStatusFont);
		
		createAccountButton = new JButton("Create Account");
		
		//Add account 1 widgets to accountPanel1
		accountPanel1.add(loginStatus);
		accountPanel1.add(createAccountButton);
		
		loginButton = new javax.swing.JButton("Login");
		
		//Create buttons for the Account 2 panel
		//JButton loginButton = new JButton("Login");
		editProfileButton = new javax.swing.JButton("Edit Profile");
		viewResultsButton = new javax.swing.JButton("View Results");
		
		//Create fonts for Account 2 panel
		Font account2Font = new Font("Verdana", Font.BOLD, 16);
		loginButton.setFont(account2Font);
		editProfileButton.setFont(account2Font);
		viewResultsButton.setFont(account2Font);
	
		//Add account2 widgets to account2 panel
		accountPanel2.add(loginButton);
		accountPanel2.add(editProfileButton);
		accountPanel2.add(viewResultsButton);
		
		
		//Create buttons for the Test panel
		takeExamButton = new JButton("Take Exam");
		answerQuestionsButton = new JButton("Answer Questions");
				
		//Create fonts for Test panel
		Font testFont = new Font("Verdana", Font.BOLD, 16);
		takeExamButton.setFont(testFont);
		answerQuestionsButton.setFont(testFont);
			
		//Add Test widgets to Test panel
		testPanel.add(takeExamButton);
		testPanel.add(answerQuestionsButton);
		
		//Add inner panels to main(outer) panel
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(accountPanel2);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(testPanel);
		mainPanel.add(Box.createVerticalStrut(50));
		mainPanel.add(accountPanel1);
		
		//Set the panel the the contentpane of the frame
		//frame.setContentPane(mainPanel);
		getContentPane().add(mainPanel);
		
		//Close form when you click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
	}

    /**
     * Returns loginButton 
     * @return 
     */   
    public javax.swing.JButton getLoginButton()
    {
        return loginButton;
    }  
    
    /**
     * Returns editProfileButton 
     * @return 
     */    
    public javax.swing.JButton getEditProfileButton()
    {
        return editProfileButton;
    }  
    
    /**
     * Returns viewResultsButton 
     * @return 
     */    
    public javax.swing.JButton getViewResultsButton()
    {
        return viewResultsButton;
    }  
    
    /**
     * Returns takeExamButton 
     * @return 
     */    
    public javax.swing.JButton getTakeExamButton()
    {
        return takeExamButton;
    }  
    
    /**
     * Returns answerQuestionsButton 
     * @return 
     */    
    public javax.swing.JButton getAnswerQuestionsButton()
    {
        return answerQuestionsButton;
    }  
    
    /**
     * Returns createAccountButton 
     * @return 
     */    
    public javax.swing.JButton getCreateAccountButton()
    {
        return createAccountButton;
    }  
    
}
