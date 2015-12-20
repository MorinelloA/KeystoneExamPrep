package com.keystoneexamprep.model.services.generatequestionservice;

import com.keystoneexamprep.model.services.exception.OutputException;

/**
 * Interface for GenerateQuestionServiceImpl
 * @author Tony
 */
public interface IGenerateQuestionService{
	
        /**
         * Service name
         */
	public final String NAME = "IGenerateQuestionService";
	
        /**
         * generateQuestion Interface
         * @param AssessmentNumber
         * @return
         * @throws OutputException 
         */
	public boolean generateQuestion(byte AssessmentNumber) throws OutputException;	
}