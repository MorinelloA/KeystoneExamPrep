package com.keystoneexamprep.model.services.exception;

/**
 * Handles DaoLoadException
 * @author Tony
 */
public class DaoLoadException extends Exception {
	
    /**
     * Message for DaoLoadException
     * @param inMessage
     * @param inNestedException 
     */
    public DaoLoadException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}