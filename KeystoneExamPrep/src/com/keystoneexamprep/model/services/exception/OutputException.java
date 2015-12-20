package com.keystoneexamprep.model.services.exception;

/**
 * Handles OutputException
 * @author Tony
 */
public class OutputException extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * OutputException Message
     * @param inMessage 
     */
    public OutputException(final String inMessage)
    {
        super(inMessage);
    }
	
    /**
     * OutputException Message
     * @param inMessage
     * @param inNestedException 
     */
    public OutputException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
