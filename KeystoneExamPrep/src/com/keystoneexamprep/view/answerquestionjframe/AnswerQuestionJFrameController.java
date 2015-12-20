package com.keystoneexamprep.view.answerquestionjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.keystoneexamprep.model.business.manager.QuestionManager;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.view.displayqajframe.DisplayQAJFrameController;
import com.keystoneexamprep.view.displayqajframe.DisplayQAJFrameView;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Controller for the AnswerQuestionJFrame
 * @author Tony
 */
public class AnswerQuestionJFrameController implements ActionListener{
    static private Logger log = Logger.getLogger(AnswerQuestionJFrameController.class);
    private AnswerQuestionJFrameView answerQuestionJFrame;
	
    /** Creates a new instance of AnswerQuestionJFrameController */
    public AnswerQuestionJFrameController() {
    }
    
    /**
     * Controller for the AnswerQuestionJFrame
     * @param answerQuestionJFrame 
     */
    public AnswerQuestionJFrameController (AnswerQuestionJFrameView answerQuestionJFrame)
    {
	    this.answerQuestionJFrame = answerQuestionJFrame;
	
	    //add all the action listeners here
	    answerQuestionJFrame.getSubmitButton().addActionListener(this);
	       
	    // center the frame
	    Utils.centerWindow(answerQuestionJFrame);
	    answerQuestionJFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {

      log.debug("Inside RegisterCustomerJFrameController::actionPerformed");
      
      if (event.getSource().equals(answerQuestionJFrame.getSubmitButton()))
       getSubmitButton_actionPerformed(event);
    }
    
    void getSubmitButton_actionPerformed (ActionEvent actionEvent) 
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
  		Questions questionToSave = answerQuestionJFrame.getQuestion();
  		boolean action = questionManager.performAction("SaveQuestion", questionToSave);
  		if(!action)
  		{
  			MessageDialog dlg = new MessageDialog( "Save Question" , "Problem when saving the question. Please try again!");    
  	        Utils.centerWindow(dlg);
  	        dlg.setModal(true);
  	        dlg.setVisible(true);
  		}
  		else
  		{
	  		action = questionManager.performAction("CheckAnswer");
	  		if(action)
	  		{
	  			DisplayQAJFrameView displayQAJFrame = new DisplayQAJFrameView();
	  			DisplayQAJFrameController displayQAJFrameController = new DisplayQAJFrameController(displayQAJFrame);
	  			answerQuestionJFrame.dispose();
	  		}
	  		else
	  	    {
	  	        MessageDialog dlg = new MessageDialog( "Check Answer" , "Problem when checking the answer. Please try again!");    
	  	        Utils.centerWindow(dlg);
	  	        dlg.setModal(true);
	  	        dlg.setVisible(true);
	  	    }
  		}
  		 
        }
    } //end getGenerateButton_actionPerformed
}
