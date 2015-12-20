package com.keystoneexamprep.model.services.registeracctservice;

import com.keystoneexamprep.model.dao.IKeystoneExamPrepDao;
import com.keystoneexamprep.model.domain.Student;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony
 */

public class RegisterAcctServiceJDBCImpl implements IRegisterAcctService
{
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
     * @param studentToSave contains the student to be saved into the database
     * @return status
     */
    @Override
    public boolean registerAcct(Student studentToSave)
    {
        log.info("Inside RegisterAcctServiceJDBCImpl - registerAcct");
        boolean status = false;

        if (keystoneExamPrepDao != null)
        {	
           status = keystoneExamPrepDao.registerAcct(studentToSave);
        }	
        return status;
    } // end registerAcct
} // end class RegisterAcctServiceJDBCImpl