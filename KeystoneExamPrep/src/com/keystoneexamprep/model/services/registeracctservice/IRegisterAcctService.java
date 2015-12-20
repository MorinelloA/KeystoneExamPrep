package com.keystoneexamprep.model.services.registeracctservice;

import com.keystoneexamprep.model.domain.Student;

/**
 * Interface for RegisterAcctServiceImpl
 * @author Tony
 */
public interface IRegisterAcctService{
 
    /**
     * Interface Name
     */
    public final String NAME = "IRegisterAcctService";
	
    /**
     * registerAcct Interface
     * @param studentToSave
     * @return 
     */
    public boolean registerAcct(Student studentToSave);
}
