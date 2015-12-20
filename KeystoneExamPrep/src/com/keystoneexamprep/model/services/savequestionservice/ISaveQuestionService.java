package com.keystoneexamprep.model.services.savequestionservice;

import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.services.exception.OutputException;

/**
 * Interface for SaveQuestionServiceImpl
 * @author Tony
 */
public interface ISaveQuestionService{
 
    /**
     * Service Name
     */
	public final String NAME = "ISaveQuestionService";
	
        /**
         * saveQuestion interface
         * @param currentQuestion
         * @return
         * @throws OutputException 
         */
	public boolean saveQuestion(Questions currentQuestion) throws OutputException;

}