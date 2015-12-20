package com.keystoneexamprep.model.services.openacctservice;

import com.keystoneexamprep.model.domain.Student;
import com.keystoneexamprep.model.services.exception.InputException;

/**
 * Interface for OpenAcctServiceImpl
 * @author Tony
 */
public interface IOpenAcctService{
 
        /**
         * Service name
         */
	public final String NAME = "IOpenAcctService";
	
        /**
         * openAcct interface
         * @param studentEmail
         * @return
         * @throws InputException 
         */
	public Student openAcct(String studentEmail) throws InputException;

}