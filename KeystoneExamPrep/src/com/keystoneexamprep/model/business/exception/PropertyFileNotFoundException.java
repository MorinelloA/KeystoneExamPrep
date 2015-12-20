package com.keystoneexamprep.model.business.exception;

/**
 * Class that handles a PropertyFileNotFoundException
 * @author Tony
 */
public class PropertyFileNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

        /**
         * PropertyFileNotFoundException method
         * @param inMessage
         * @param inNestedException 
         */
	public PropertyFileNotFoundException(final String inMessage, final Throwable inNestedException)
        {
            super(inMessage, inNestedException);
        }
	
}
