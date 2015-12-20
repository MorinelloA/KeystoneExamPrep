package com.keystoneexamprep.model.services.exception;

/**
 * Handles InputException
 * @author Tony
 */
public class InputException extends Exception{
	
    private static final long serialVersionUID = 1L;

    /**
     * Message for InputException
     * @param inMessage 
     */
    public InputException(final String inMessage)
    {
        super(inMessage);
    }
	
    /**
     * Message for InputException
     * @param inMessage
     * @param inNestedException 
     */
    public InputException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}