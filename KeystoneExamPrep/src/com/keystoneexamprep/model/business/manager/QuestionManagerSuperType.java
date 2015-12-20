/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keystoneexamprep.model.business.manager;

import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.domain.Results;
import org.apache.log4j.Logger;

/**
 *
 * @author Tony
 */
public abstract class QuestionManagerSuperType {
    final static private Logger log = Logger.getLogger("QuestionManagerSuperType.class");
    
    //Abstract methods for QuestionManager
    
    /**
     * performAction
     * @param commandString
     * @param currentResults
     * @param AssessmentNumber
     * @return 
     */
    public abstract boolean performAction(String commandString, Results currentResults, byte AssessmentNumber);
    
    /**
     * performAction
     * @param commandString
     * @param currentQuestion
     * @return 
     */
    public abstract boolean performAction(String commandString, Questions currentQuestion);
    
    /**
     * performRetrival
     * @param commandString
     * @return 
     */
    public abstract Questions performRetrival(String commandString);
    
    /**
     * performAction
     * @param commandString
     * @return 
     */
    public abstract boolean performAction(String commandString);
    
    /**
     * performAction
     * @param commandString
     * @param currentResults
     * @return 
     */
    public abstract boolean performAction(String commandString, Results currentResults);
    
    /**
     * performAction
     * @param commandString
     * @param AssessmentNumber
     * @return 
     */
    public abstract boolean performAction(String commandString, byte AssessmentNumber);
}
