package com.keystoneexamprep.view.displayqajframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.keystoneexamprep.model.business.manager.QuestionManager;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.view.answerquestionjframe.AnswerQuestionJFrameController;
import com.keystoneexamprep.view.answerquestionjframe.AnswerQuestionJFrameView;
import com.keystoneexamprep.view.selectquestionjframe.SelectQuestionJFrameController;
import com.keystoneexamprep.view.selectquestionjframe.SelectQuestionJFrameView;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import org.apache.log4j.Logger;	
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DisplayQAJFrame Controller
 * DisplayQAJFrame is used to view and question the the student has already answered
 * This way, they can see if they were correct or not.
 * @author Tony
 */
public class DisplayQAJFrameController implements ActionListener{
    static private Logger log = Logger.getLogger(DisplayQAJFrameController.class);
	private DisplayQAJFrameView displayQAJFrame;
	
    /** Creates a new instance of DisplayQAJFrameController */
    public DisplayQAJFrameController() {
    }
    
    /**
     * DisplayQAJFrameController
     * @param displayQAJFrame 
     */
    public DisplayQAJFrameController (DisplayQAJFrameView displayQAJFrame)
    {
	    this.displayQAJFrame = displayQAJFrame;
	
	    //add all the action listeners here
	    displayQAJFrame.getNextQuestionButton().addActionListener(this);
	    displayQAJFrame.getNewQuestionButton().addActionListener(this);
	    displayQAJFrame.getExitButton().addActionListener(this);
	       
	    // center the frame
	    Utils.centerWindow(displayQAJFrame);
	    displayQAJFrame.setVisible(true);
    }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  
    @Override
    public void actionPerformed(ActionEvent event) 
    {
	    log.debug("Inside DisplayQAJFrameController::actionPerformed");
	    
	    if (event.getSource().equals(displayQAJFrame.getNextQuestionButton()))
	    	getNextQuestionButton_actionPerformed(event);
	    else if (event.getSource().equals(displayQAJFrame.getNewQuestionButton()))
	    	getNewQuestionButton_actionPerformed(event);
	    else if (event.getSource().equals(displayQAJFrame.getExitButton()))
	    	getExitButton_actionPerformed(event);     
    }

    /**
     * Proceed with next question of same type
     *
     * @param actionEvent ActionEvent
     */
    void getNextQuestionButton_actionPerformed(ActionEvent actionEvent) 
    {
    	//QuestionManager questionManager = QuestionManager.getInstance();
        String propertyFileLocation = System.getProperty("prop_location");
        log.debug("Property File Location: "+propertyFileLocation);
        boolean isValid = true;
        ApplicationContext context = null;
        try
        {
            context = new ClassPathXmlApplicationContext(propertyFileLocation);
        }
        catch(Exception ex)
        {
            
            log.error("File error",ex);
            isValid = false;
            MessageDialog dlg = new MessageDialog("PropertyFile", "Error Locating Property");    
            Utils.centerWindow(dlg);
            dlg.setModal(true);
            dlg.setVisible(true);
        }
        if(isValid)
        {
        QuestionManager questionManager = (QuestionManager)context.getBean("questionManager");
		Questions questionToGenerate = displayQAJFrame.getQuestion();
  		boolean action = questionManager.performAction("GenerateQuestion", questionToGenerate.getAssessmentNumber());
			
		if(action)
		{
			AnswerQuestionJFrameView answerQuestionJFrame = new AnswerQuestionJFrameView();
			AnswerQuestionJFrameController answerQuestionJFrameController = new AnswerQuestionJFrameController(answerQuestionJFrame);
			displayQAJFrame.dispose();
		}
		else
	    {
	        MessageDialog dlg = new MessageDialog( "Question Generator" , "Question Generation Failed. Please try again!");    
	        Utils.centerWindow(dlg);
	        dlg.setModal(true);
	        dlg.setVisible(true);
	    }
        }
    } //end getNextQuestionButton_actionPerformed
    
    /**
     * Proceed with next question of same type
     *
     * @param actionEvent ActionEvent
     */
    private void getNewQuestionButton_actionPerformed(ActionEvent actionEvent) 
    {
    	SelectQuestionJFrameView selectQuestionJFrame = new SelectQuestionJFrameView();
    	SelectQuestionJFrameController selectQuestionJFrameController = new SelectQuestionJFrameController(selectQuestionJFrame);
    	displayQAJFrame.dispose();
    } //end getNewQuestionButton_actionPerformed
    
    /**
     * Exit Application
     *
     * @param actionEvent ActionEvent
     */
    void getExitButton_actionPerformed(ActionEvent actionEvent) 
    {
    	System.exit(0);
    } //end getExitButton_actionPerformed
}
