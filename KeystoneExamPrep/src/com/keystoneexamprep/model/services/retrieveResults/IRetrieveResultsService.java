package com.keystoneexamprep.model.services.retrieveResults;

import com.keystoneexamprep.model.domain.Results;
import com.keystoneexamprep.model.services.exception.InputException;

/**
 * Interface for RetrieveResultsServiceImpl
 * @author Tony
 */
public interface IRetrieveResultsService{
 
    /**
     * Service Name
     */
	public final String NAME = "IRetrieveResultsService";
	
        /**
         * retrieveResults interface
         * @return
         * @throws InputException 
         */
	public Results retrieveResults() throws InputException;

}
