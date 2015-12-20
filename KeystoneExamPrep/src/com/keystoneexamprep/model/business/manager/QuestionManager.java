package com.keystoneexamprep.model.business.manager;

import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.domain.Results;
import com.keystoneexamprep.model.services.checkanswerservice.ICheckAnswerService;
import com.keystoneexamprep.model.services.exception.InputException;
import com.keystoneexamprep.model.services.exception.OutputException;
import com.keystoneexamprep.model.services.generatequestionservice.IGenerateQuestionService;
import com.keystoneexamprep.model.services.retrieveQuestion.IRetrieveQuestionService;
import com.keystoneexamprep.model.services.savequestionservice.ISaveQuestionService;
import com.keystoneexamprep.model.services.storeqaservice.IStoreQAService;
import org.apache.log4j.Logger;

/**
 * QuestionManager deals with generating a question, checking it, and storing it
 * @author Tony
 */
public class QuestionManager extends QuestionManagerSuperType {
    final static private Logger log = Logger.getLogger(QuestionManager.class);

    private static QuestionManager _instance;
    private ICheckAnswerService checkAnswerService;
    private IGenerateQuestionService  generateQuestionService;
    private IStoreQAService storeQAService;
    private ISaveQuestionService saveQuestionService;
    private IRetrieveQuestionService retrieveQuestionService;
        
    /**
    * Injected Spring
    * @param _checkAnswer 
    */
    public void setCheckAnswerService(ICheckAnswerService _checkAnswer)
    {
        this.checkAnswerService = _checkAnswer;
    }

    /**
    * Injected Spring
    * @param _generateQuestion
    */
    public void setGenerateQuestionService(IGenerateQuestionService _generateQuestion)
    {
        this.generateQuestionService = _generateQuestion;
    }
    
    /**
    * Injected Spring
    * @param _storeQA
    */
    public void setStoreQAService(IStoreQAService _storeQA)
    {
        this.storeQAService = _storeQA;
    }
    
    /**
    * Injected Spring
    * @param _saveQuestion
    */
    public void setSaveQuestionService(ISaveQuestionService _saveQuestion)
    {
        this.saveQuestionService = _saveQuestion;
    }
    
    /**
    * Injected Spring
    * @param _retrieveQuestion
    */
    public void setRetrieveQuestionService(IRetrieveQuestionService _retrieveQuestion)
    {
        this.retrieveQuestionService = _retrieveQuestion;
    }

	/**
	 * Constructor should be kept to private
	 */
	private QuestionManager() {
	}

	/**
	 * Generic methods that all clients of this class can call to perform certain
	 * actions. Different parameters to accommodate the different services
	 * 
	 * @param commandString
	 *            Holds the service name to be invoked 
	 * @param currentResults
	 *            Holds current results from the application
	 * @param AssessmentNumber
	 * 			  Assessment Anchor to be generated. 0 for random anchor.
	 * @return false if action failed true if action is successful.
	 * 
	 * NOTE: This method takes 3 parameters, but this may be unnecessary. Research if this should be broken down or not.
	 */
        @Override
	public boolean performAction(String commandString, Results currentResults, byte AssessmentNumber) {
            boolean action = false;
            switch (commandString) {
                case "CheckAnswer":
                    action = checkAnswer(ICheckAnswerService.NAME);
                    break;
                case "GenerateQuestion":
                    action = generateQuestion(IGenerateQuestionService.NAME, AssessmentNumber);
                    break; 
                case "StoreQA":
                    action = storeQA(IStoreQAService.NAME, currentResults);
                    break;
            }
		return action;
	}
	
        /**
         * performAction method with parameters that can call on SaveQuestion
         * @param commandString
         * @param currentQuestion
         * @return 
         */
        @Override
	public boolean performAction(String commandString, Questions currentQuestion)
	{
		boolean action = false;
		if (commandString.equals("SaveQuestion")) {
			action = saveQuestion(ISaveQuestionService.NAME, currentQuestion);
		}
		return action;
	}
	
        /**
         * performRetrival method with parameters that can call on RetrieveQuestion
         * @param commandString
         * @return 
         */
        @Override
	public Questions performRetrival(String commandString)
	{
		Questions action = null;
		if (commandString.equals("RetrieveQuestion")) {
			action = retrieveQuestion(IRetrieveQuestionService.NAME);
		}
		return action;
	}
	
        /**
         * performAction method with parameters that can call on CheckAnswer
         * @param commandString
         * @return 
         */
        @Override
	public boolean performAction(String commandString) 
        {
		boolean action = false;
		if (commandString.equals("CheckAnswer")) {
			action = checkAnswer(ICheckAnswerService.NAME);
		} 
		return action;
	}
        
        /**
         * performAction method with parameters that can call on CheckAnswer or StoreQA
         * @param commandString
         * @param currentResults
         * @return 
         */
        @Override
	public boolean performAction(String commandString, Results currentResults) 
        {
		boolean action = false;
        switch (commandString) {
            case "CheckAnswer":
                action = checkAnswer(ICheckAnswerService.NAME);
                break;
            case "StoreQA":
                action = storeQA(IStoreQAService.NAME, currentResults);
                break;
        }
		return action;
	}
        
        /**
         * performAction method with parameters that can call on CheckAnswer or GenerateQuestion
         * @param commandString
         * @param AssessmentNumber
         * @return 
         */
	@Override
	public boolean performAction(String commandString, byte AssessmentNumber)
        {
		boolean action = false;
        switch (commandString) {
            case "CheckAnswer":
                action = checkAnswer(ICheckAnswerService.NAME);
                break;
            case "GenerateQuestion":
                action = generateQuestion(IGenerateQuestionService.NAME, AssessmentNumber);
                break;
        }
		return action;
	}

        /**
         * Method used to call on the storeQAService
         * @param commandString
         * @param currentResults
         * @return 
         */
	public boolean storeQA(String commandString, Results currentResults) {
		boolean isQuestionStored = false;

                if (storeQAService != null)
                {	
                    try {
                        //invoke service operation
                        isQuestionStored = storeQAService.storeQA(currentResults);
                    } catch (OutputException ex) {
                        log.error("Output Exception in QuestionManager - storeQA", ex);
                    } catch (InputException ex) {
                        log.error("Input Exception in QuestionManager - storeQA", ex);
                    }
                }
                
		return isQuestionStored;
	}

        /**
         * method user to call on the checkAnswer method
         * @param commandString
         * @return 
         */
	public boolean checkAnswer(String commandString) {
		boolean isAnswerChecked = false;

		if (checkAnswerService != null)
                {	
                    try {
                        //invoke service operation
                        isAnswerChecked = checkAnswerService.checkAnswer();
                    } catch (OutputException ex) {
                        log.error("OutputException in QuestionManager - checkAnswer ", ex);
                    } catch (InputException ex) {
                        log.error("InputException in QuestionManager - checkAnswer ", ex);
                    }
                }

		return isAnswerChecked;

	}//End checkAnswer
		
        /**
         * method user to call on the generateQuestionService
         * @param commandString
         * @param assessmentNumber
         * @return 
         */
	public boolean generateQuestion(String commandString, byte assessmentNumber) {
		boolean isQuestionGenerated = false;

		if (generateQuestionService != null)
                {	
                    try {
                        //invoke service operation
                        isQuestionGenerated = generateQuestionService.generateQuestion(assessmentNumber);
                    } catch (OutputException ex) {
                        log.error("OutputException in QuestionManager - generateQuestion",ex);
                    }
                }

		return isQuestionGenerated;
	}//End generateQuestion
	
        /**
         * Method used to call on the retrieveQuestionService
         * @param commandString
         * @return 
         */
	public Questions retrieveQuestion(String commandString) {
		Questions isRetrieved = null;

		if (retrieveQuestionService != null)
                {	
                    try {
                        //invoke service operation
                        isRetrieved = retrieveQuestionService.retrieveQuestion();
                    } catch (InputException ex) {
                        log.error("InputException in QuestionManager - retrieveQuestion", ex);
                    }
                }

		return isRetrieved;

	}//End retrieveQuestion
	
        /**
         * Method used to call on the saveQuestionService
         * @param commandString
         * @param currentQuestion
         * @return 
         */
	public boolean saveQuestion(String commandString, Questions currentQuestion) {
		boolean isQuestionSaved = false;

		if (saveQuestionService != null)
                {	
                    try {
                        //invoke service operation
                        isQuestionSaved = saveQuestionService.saveQuestion(currentQuestion);
                    } catch (OutputException ex) {
                        log.error("OutputException in QuestionManager - saveQuestion", ex);
                    }
                }

		return isQuestionSaved;
	}//End generateQuestion
}
