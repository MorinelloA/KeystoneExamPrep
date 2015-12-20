package com.keystoneexamprep.model.services.authenticateacctservice;

import com.keystoneexamprep.model.dao.IKeystoneExamPrepDao;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony
 */
public class AuthenticateAcctServiceJDBCImpl implements IAuthenticateAcctService{
    private IKeystoneExamPrepDao keystoneExamPrepDao;
    /*
    * Category set in config/log4j.properties as
    * log4j.category.com.classexercise=DEBUG, A1
    */
    static Logger log = Logger.getLogger("com.keystoneexamprep");
    
    /**
    * Injected Spring
    * @param _keystoneExamPrepDao 
    */
    public void setKeystoneExamPrepDao (IKeystoneExamPrepDao _keystoneExamPrepDao)
    {
        this.keystoneExamPrepDao = _keystoneExamPrepDao;
    }
    
    /**
     * Delegates request to the DAO.
     * 
     * @param email contains email of the account to authenticate
     * @param password contains password of the account to authenticate
     * @return status
     */

    @Override
    public boolean authenticateAcct(String email, char[] password)
    {
        log.info("Inside AuthenticateAcctServiceJDBCImpl - authenticateAcct");
        boolean status = false;

        if (keystoneExamPrepDao != null)
        {	
           status = keystoneExamPrepDao.authenticateAcct(email, password);
        }	
        return status;
    } // end authenticateAcct
} // end class AuthenticateAcctServiceJDBCImpl