package com.keystoneexamprep.model.services.retrieveQuestion;

import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.services.exception.InputException;

/**
 * Interface for RetrieveQuestionServiceImpl
 * @author Tony
 */
public interface IRetrieveQuestionService{
 
    /**
     * Service name
     */
    public final String NAME = "IRetrieveQuestionService";

    /**
     * retrieveQuestion Interface
     * @return
     * @throws InputException 
     */
    public Questions retrieveQuestion() throws InputException;

}
