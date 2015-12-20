package com.keystoneexamprep.view.registeracctjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.keystoneexamprep.model.business.manager.DAOManager;
import com.keystoneexamprep.model.domain.Student;
import com.keystoneexamprep.view.mainjframe.MainJFrameController;
import com.keystoneexamprep.view.mainjframe.MainJFrameView;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;	

/**
 * RegisterAcctJFrameController
 * RegisterAcctJFrame allows the user to register for a new account
 * @author Tony
 */
public class RegisterAcctJFrameController implements ActionListener{
    static private Logger log = Logger.getLogger(RegisterAcctJFrameController.class);
	private RegisterAcctJFrameView registerAcctJFrame;
	
    /** Creates a new instance of RegisterAcctJFrameController */
    public RegisterAcctJFrameController() {
    }
    
    /**
     * RegisterAcctJFrameController Constructor
     * @param registerAcctJFrame 
     */
    public RegisterAcctJFrameController (RegisterAcctJFrameView registerAcctJFrame)
    {
	    this.registerAcctJFrame = registerAcctJFrame;
	
	    //add all the action listeners here
	    registerAcctJFrame.getCreateAcctButton().addActionListener(this);
	    registerAcctJFrame.getBackButton().addActionListener(this);
	       
	    // center the frame
	    Utils.centerWindow(registerAcctJFrame);
	    registerAcctJFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {

      log.debug("Inside RegisterAcctJFrameController::actionPerformed");
      
      if (event.getSource().equals(registerAcctJFrame.getCreateAcctButton()))
    	  getCreateAcctButton_actionPerformed(event);
      else if (event.getSource().equals(registerAcctJFrame.getBackButton()))
    	  getBackButton_actionPerformed(event);
    }
    
    void getBackButton_actionPerformed (ActionEvent actionEvent) 
    {
    	MainJFrameView mainJFrame = new MainJFrameView();
	  	MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
	  	registerAcctJFrame.dispose();
    } //end getBackButton_actionPerformed
    
    void getCreateAcctButton_actionPerformed (ActionEvent actionEvent) 
    {
    	boolean passwordsMatch = true;
    	char[] pass1 = registerAcctJFrame.getPassword();
    	char[] pass2 = registerAcctJFrame.getPasswordConfirm();
    	if (pass1.length != pass2.length)
    		passwordsMatch = false;
    	else
    	{
    		for(int i = 0; i < pass1.length; i++)
    		{
    			if (pass1[i] != pass2[i])
    			{
    				passwordsMatch = false;
    				break;
    			}
    		}
    	}
    	
    	if (passwordsMatch)
    	{
            //JDBC
            
            //DAOManager daoManager = DAOManager.getInstance();
            String propertyFileLocation = System.getProperty("prop_location");
            log.debug("Property File Location: "+propertyFileLocation);
            boolean isValid = true;
            ApplicationContext context = null;
            try
            {
                context = new ClassPathXmlApplicationContext(propertyFileLocation);
            }
            catch(Exception ex)
            {

                log.error("File error",ex);
                isValid = false;
                MessageDialog dlg = new MessageDialog("PropertyFile", "Error Locating Property");    
                Utils.centerWindow(dlg);
                dlg.setModal(true);
                dlg.setVisible(true);
            }
            if(isValid)
            {
            DAOManager daoManager = (DAOManager)context.getBean("daoManager");
            
            Student student = registerAcctJFrame.getStudentData();
            boolean action = daoManager.performAction("RegisterAcct", student);
            if(!action)
            {
                MessageDialog dlg = new MessageDialog("Register Account" , "Problem when registering the account. Please try again!");    
                Utils.centerWindow(dlg);
                dlg.setModal(true);
                dlg.setVisible(true);
            }
            else
            {
                MessageDialog dlg = new MessageDialog("Register Account" , "Account Successfully Registered!");
                Utils.centerWindow(dlg);
                dlg.setModal(true);
                dlg.setVisible(true);
                MainJFrameView mainJFrame = new MainJFrameView();
                MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
                registerAcctJFrame.dispose();
            }
            }
            //File IO
            /*
    		AccountManager accountManager = AccountManager.getInstance();
    		Student student = registerAcctJFrame.getStudentData();
    		boolean action = accountManager.performAction("RegisterAcct", student);
    		if(!action)
      		{
      			MessageDialog dlg = new MessageDialog("Register Account" , "Problem when registering the account. Please try again!");    
      	        Utils.centerWindow(dlg);
      	        dlg.setModal(true);
      	        dlg.setVisible(true);
      		}
      		else
      		{
	    		MainJFrameView mainJFrame = new MainJFrameView();
			  	MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
			  	registerAcctJFrame.dispose();
      		}
                    */
    	}
    	else
    	{
    	    MessageDialog dlg = new MessageDialog( "Create Account Problem", "Your passwords do not match!");    
    	    Utils.centerWindow(dlg);
    	    dlg.setModal(true);
    	    dlg.setVisible(true);
    	}
    } //end getCreatAcctButton_actionPerformed
}
