package com.keystoneexamprep.model.services.authenticateacctservice;

/**
 * Interface for AuthenticaAcctServiceImpl
 * @author Tony
 */
public interface IAuthenticateAcctService{
	 
        /**
         * Service name
         */
	public final String NAME = "IAuthenticateAcctService";
	
        /**
         * authenticateAcct interface
         * @param email
         * @param password
         * @return 
         */
	public boolean authenticateAcct(String email, char[] password);

}
