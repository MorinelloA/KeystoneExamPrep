package com.keystoneexamprep.model.business.manager;

import org.apache.log4j.Logger;

import com.keystoneexamprep.model.domain.Student;
import com.keystoneexamprep.model.services.authenticateacctservice.IAuthenticateAcctService;
import com.keystoneexamprep.model.services.openacctservice.IOpenAcctService;
import com.keystoneexamprep.model.services.registeracctservice.IRegisterAcctService;


/**
 * This class handles all services related to a student's account
 * @author Tony
 */
public class AccountManager extends ManagerSuperType{
final static private Logger log = Logger.getLogger("AccountManager.class");	
    
    private static AccountManager _instance;
    private IRegisterAcctService registerAcctService;
    private IAuthenticateAcctService authenticateAcctService;
    
    /**
    * Injected Spring
    * @param _registerAcct 
    */
    public void setRegisterAcctService(IRegisterAcctService _registerAcct)
    {
        this.registerAcctService = _registerAcct;
    }

    /**
    * Injected Spring
    * @param _authenticateAcct 
    */
    public void setAuthenticateAcctService(IAuthenticateAcctService _authenticateAcct)
    {
        this.authenticateAcctService = _authenticateAcct;
    }
    
    
    
	/**
	 * Constructor should be kept to private
	 */
	private AccountManager() {
	}

	/**
	 * Assures that there is only one AccountManager created.
	 * 
	 * @return AccountManager instance
	 */
	public static synchronized AccountManager getInstance() {
		if (_instance == null) {
			_instance = new AccountManager();
		}
		return _instance;
	}
	
        /**
         * performAction method with parameters that can call on AuthenticateAccount or RegisterAcct
         * @param commandString
         * @param email
         * @param password
         * @param studentToSave
         * @return 
         */
	public boolean performAction(String commandString, String email, char[] password, Student studentToSave) {
		boolean action = false;
            switch (commandString) {
                case "AuthenticateAccount":
                    action = authenticateAcct(IAuthenticateAcctService.NAME, email, password);
                    break;
                case "RegisterAcct":
                    action = registerAcct(IRegisterAcctService.NAME, studentToSave);
                    break;
    } 
		return action;
	}
	
        /**
         * perforamAction method with parameters that can call on AuthenticateAccount
         * @param commandString
         * @param email
         * @param password
         * @return 
         */
        @Override
	public boolean performAction(String commandString, String email, char[] password) {
		boolean action = false;
		if (commandString.equals("AuthenticateAccount")) {
			action = authenticateAcct(IAuthenticateAcctService.NAME, email, password);
		}
		return action;
	}
	
        /**
         * perforamAction method with parameters that can call on RegisterAcct
         * @param commandString
         * @param studentToSave
         * @return 
         */
        @Override
	public boolean performAction(String commandString, Student studentToSave) {
		boolean action = false;
		if (commandString.equals("RegisterAcct")) {
			action = registerAcct(IRegisterAcctService.NAME, studentToSave);
		}
		return action;
	}
	
        /**
         * performRetrival method with parameters that can call on OpenAcct
         * @param commandString
         * @param studentEmail
         * @return 
         */
	public Student performRetrival(String commandString, String studentEmail)
	{
		Student action = null;
		if (commandString.equals("OpenAcct")) {
			action = openAcct(IOpenAcctService.NAME, studentEmail);
		}
		return action;
	}
	
        /**
         * authenticateAcct is used to check if the student entered the correct email and password
         * @param commandString
         * @param email
         * @param password
         * @return 
         */
	public boolean authenticateAcct(String commandString, String email, char[] password) {
		boolean isAuthenticated = false;
                
                if (authenticateAcctService != null)
                {	
                    //invoke service operation
                    isAuthenticated = authenticateAcctService.authenticateAcct(email, password);
                }
                
		return isAuthenticated;
	}//End authenticateAcct

        /**
         * registerAcct is used to register a new student account based on the entered data
         * @param commandString
         * @param studentToSave
         * @return 
         */
	public boolean registerAcct(String commandString, Student studentToSave) {
            boolean isRegistered = false;

            if (registerAcctService != null)
            {	
                //invoke service operation
                isRegistered = registerAcctService.registerAcct(studentToSave);
            }
                
            return isRegistered;
	}//End registerAcct

        /**
         * openAcct will load a student's account
         * This is done only if it has been authenticated first
         * @param commandString
         * @param studentEmail
         * @return 
         */
	public Student openAcct(String commandString, String studentEmail) {
		Student isOpened = null;
                
		return isOpened;

	}//End openAcct
	
}
