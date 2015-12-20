package com.keystoneexamprep.model.services.checkanswerservice;

import com.keystoneexamprep.model.services.exception.InputException;
import com.keystoneexamprep.model.services.exception.OutputException;

/**
 * interface for CheckAnswerServiceImpl
 * @author Tony
 */
public interface ICheckAnswerService{
 
        /**
         * Name of service
         */
	public final String NAME = "ICheckAnswerService";
	
        /**
         * checkAnswer interface
         * @return
         * @throws OutputException
         * @throws InputException 
         */
	public boolean checkAnswer() throws OutputException, InputException;

}