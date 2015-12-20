package com.keystoneexamprep.model.dao;

import com.keystoneexamprep.model.domain.Student;

/**
 *
 * @author Tony
 */
public interface IKeystoneExamPrepDao {
    /**
     * registerAcct interface
     * @param studentToSave
     * @return 
     */
    public boolean registerAcct(Student studentToSave);
    
    /**
     * authenticateAcct interface
     * @param email
     * @param password
     * @return 
     */
    public boolean authenticateAcct(String email, char[] password);
}
