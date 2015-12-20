package com.keystoneexamprep.view.loginjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.keystoneexamprep.model.business.manager.DAOManager;
import com.keystoneexamprep.view.mainjframe.MainJFrameController;
import com.keystoneexamprep.view.mainjframe.MainJFrameView;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;	

/**
 * LoginJFrameController
 * LoginJFrame allows the user to enter their email and password for authentication
 * @author Tony
 */
public class LoginJFrameController implements ActionListener{
    static private Logger log = Logger.getLogger(LoginJFrameController.class);
private LoginJFrameView loginJFrame;
	
    /** Creates a new instance of RegisterAcctJFrameController */
    public LoginJFrameController() {
    }
    
    /**
     * Create instance of LoginJFrameController
     * @param loginJFrame 
     */
    public LoginJFrameController (LoginJFrameView loginJFrame)
    {
	    this.loginJFrame = loginJFrame;
	
	    //add all the action listeners here
	    loginJFrame.getLoginButton().addActionListener(this);
	    loginJFrame.getBackButton().addActionListener(this);
	       
	    // center the frame
	    Utils.centerWindow(loginJFrame);
	    loginJFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {

      log.debug("Inside LoginJFrameController::actionPerformed");
      
      if (event.getSource().equals(loginJFrame.getLoginButton()))
    	  getLoginButton_actionPerformed(event);
      else if (event.getSource().equals(loginJFrame.getBackButton()))
    	  getBackButton_actionPerformed(event);
    }
    
    void getBackButton_actionPerformed (ActionEvent actionEvent) 
    {
    	MainJFrameView mainJFrame = new MainJFrameView();
	  	MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
	  	loginJFrame.dispose();
    } //end getBackButton_actionPerformed
    
    void getLoginButton_actionPerformed (ActionEvent actionEvent)
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
        
        String emailAddress = loginJFrame.getEmailAddress();
	char[] password = loginJFrame.getPassword();
	boolean action = daoManager.performAction("AuthenticateAccount", emailAddress, password);
	if(!action)
  	{
            MessageDialog dlg = new MessageDialog("Login", "Problem logging in. Invalid Username/Password?");    
            Utils.centerWindow(dlg);
            dlg.setModal(true);
            dlg.setVisible(true);
            }
            else
            {
            boolean studentToOpen = daoManager.performAction("AuthenticateAccount", emailAddress, password);
            if (studentToOpen == false)
            {
                    MessageDialog dlg = new MessageDialog("Login", "Account Not Authenticated");    
            Utils.centerWindow(dlg);
            dlg.setModal(true);
            dlg.setVisible(true);
            }
            else
            {
    			MessageDialog dlg = new MessageDialog("Login", "Account Information Retrived, but accounts are not yet fully implemented");    
      	        Utils.centerWindow(dlg);
      	        dlg.setModal(true);
      	        dlg.setVisible(true);
    		}
  		}
        
        //FILE IO
		/*AccountManager accountManager = AccountManager.getInstance();
		String emailAddress = loginJFrame.getEmailAddress();
		char[] password = loginJFrame.getPassword();
		boolean action = accountManager.performAction("AuthenticateAccount", emailAddress, password);
		if(!action)
  		{
  			MessageDialog dlg = new MessageDialog("Login", "Problem logging in. Invalid Username/Password?");    
  	        Utils.centerWindow(dlg);
  	        dlg.setModal(true);
  	        dlg.setVisible(true);
  		}
  		else
  		{
    		Student studentToOpen = accountManager.performRetrival("OpenAcct", emailAddress);
    		if (studentToOpen == null)
    		{
    			MessageDialog dlg = new MessageDialog("Login", "Account Authenticated, but there was a problem loading the information");    
      	        Utils.centerWindow(dlg);
      	        dlg.setModal(true);
      	        dlg.setVisible(true);
    		}
    		else
    		{
    			MessageDialog dlg = new MessageDialog("Login", "Account Information Retrived, but accounts are not yet fully implemented");    
      	        Utils.centerWindow(dlg);
      	        dlg.setModal(true);
      	        dlg.setVisible(true);
    		}
  		}*/
        }
    } //end getLoginButton_actionPerformed
}
