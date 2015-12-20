package com.keystoneexamprep.model.business.manager;

import com.keystoneexamprep.model.domain.Student;
import com.keystoneexamprep.model.services.registeracctservice.IRegisterAcctService;
import com.keystoneexamprep.model.services.authenticateacctservice.IAuthenticateAcctService;
import org.apache.log4j.Logger;

/**
 *  This Manager class provides two key functionalities:
 *  1. Has the properties files loaded by the PropertyManager
 *  2. Calls the ServiceFactory class and executes the services being
 *     requested by the controller.
 *     
 *  Manager classes in reality provide a define set of functionality and govern
 *  the overall processing of the application.
 *
 */

public class DAOManager extends ManagerSuperType
{
	
    /*
    * Category set in config/log4j.properties as
    * log4j.category.com.classexercise=DEBUG, A1
    */
    static Logger log = Logger.getLogger("com.keystoneexamprep");
    private static DAOManager _instance;
    private IRegisterAcctService registerAcctService;
    private IAuthenticateAcctService authenticateAcctService;

    /**
    * keep the constructor private to prevent instantiation by outside callers.
    */
    
    private DAOManager() {
    // construct object . . .
    }

    
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
     * performAction method with parameters that can call on RegisterAcct
     * @param commandString
     * @param studentToSave
     * @return 
     */
    @Override
    public boolean performAction(String commandString, Student studentToSave)
    {
        boolean status = false;
        switch (commandString) {
            case "RegisterAcct":
                status = registerAcct(studentToSave);
                break;
        }
	return status;
    }//end performAction
    
    /**
     * performAction method with parameters that can call on AuthenticateAccount
     * @param commandString
     * @param email
     * @param password
     * @return 
     */
    @Override
    public boolean performAction(String commandString, String email, char[] password)
    {
        boolean status = false;
        switch (commandString) {
            case "AuthenticateAccount":
                status = authenticateAccount(email, password);
                break;
        }
	return status;
    }//end performaAction

    /**
     * registerAcct will call on the registerAcctService
     * @param studentToSave
     * @return 
     */
    private boolean registerAcct(Student studentToSave)
    {
	boolean status = false;

        if (registerAcctService != null)
	{	
            //invoke service operation
            status = registerAcctService.registerAcct(studentToSave);
        }
        return status;
    } //end registerAcct

    /**
     * authenticateAccount will call on the authenticateAcctService
     * @param email
     * @param password
     * @return 
     */
    private boolean authenticateAccount(String email, char[] password)
    {
	boolean status = false;

        if (authenticateAcctService != null)
	{	
            //invoke service operation
            status = authenticateAcctService.authenticateAcct(email, password);
        }
        return status;
    } //end authenticateAcct

} // end class DAOManager