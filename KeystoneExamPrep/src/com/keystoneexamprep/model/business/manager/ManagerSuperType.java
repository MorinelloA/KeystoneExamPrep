package com.keystoneexamprep.model.business.manager;

import com.keystoneexamprep.model.domain.Student;
import org.apache.log4j.Logger;

/**
 * Abstract ManagerSuperType Class. 
 * Used by AccountManager and DAOManager
 * @author Tony
 */
public abstract class ManagerSuperType {
    final static private Logger log = Logger.getLogger("ManagerSuperType.class");

    //Abstract methods for AccountManager / DAOManager
    /**
     * performAction
     * @param commandString
     * @param studentToSave
     * @return 
     */
    public abstract boolean performAction(String commandString, Student studentToSave);
    
    /**
     * performAction
     * @param commandString
     * @param email
     * @param password
     * @return 
     */
    public abstract boolean performAction(String commandString, String email, char[] password);
}

