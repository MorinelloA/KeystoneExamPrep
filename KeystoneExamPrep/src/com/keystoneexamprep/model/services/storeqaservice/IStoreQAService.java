package com.keystoneexamprep.model.services.storeqaservice;

import com.keystoneexamprep.model.domain.Results;
import com.keystoneexamprep.model.services.exception.InputException;
import com.keystoneexamprep.model.services.exception.OutputException;

/**
 * Interface for StoreQAServiceImpl
 * @author Tony
 */
public interface IStoreQAService{
 
    /**
     * Service Name
     */
	public final String NAME = "IStoreQAService";
	
        /**
         * storeQA Interface
         * @param currentResults
         * @return
         * @throws OutputException
         * @throws InputException 
         */
	public boolean storeQA(Results currentResults) throws OutputException, InputException;

}