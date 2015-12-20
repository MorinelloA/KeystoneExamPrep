package com.keystoneexamprep.model.business.exception;

/**
 * Class that handles a ServiceLoadException
 * @author Tony
 */
public class ServiceLoadException extends Exception
{
	private static final long serialVersionUID = 1L;

        /**
         * ServiceLoadException method
         * @param inMessage
         * @param inNestedException 
         */
	public ServiceLoadException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
	
} // end class ServiceLoadException