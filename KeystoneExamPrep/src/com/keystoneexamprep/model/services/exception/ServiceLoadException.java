package com.keystoneexamprep.model.services.exception;

/**
 * Handles ServiceLoadException
 * @author Tony
 */
public class ServiceLoadException extends Exception {
    
    /**
     * ServiceLoadException Message
     * @param inMessage
     * @param inNestedException 
     */
    public ServiceLoadException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
