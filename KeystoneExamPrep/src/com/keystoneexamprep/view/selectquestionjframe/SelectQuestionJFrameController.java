package com.keystoneexamprep.view.selectquestionjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.keystoneexamprep.model.business.manager.QuestionManager;
import com.keystoneexamprep.view.answerquestionjframe.AnswerQuestionJFrameController;
import com.keystoneexamprep.view.answerquestionjframe.AnswerQuestionJFrameView;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import org.apache.log4j.Logger;	
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * SelectQuestionJFrameController.java
 * Listens and handles actions generated from SelectQuestionJFrameView.java
 */
public class SelectQuestionJFrameController implements ActionListener
{
    static private Logger log = Logger.getLogger(SelectQuestionJFrameController.class);
	private SelectQuestionJFrameView selectQuestionJFrame;
	
    /** Creates a new instance of SelectQuestionJFrameController */
    public SelectQuestionJFrameController() {
    }
    
    /**
     * SelectQuestionJFrameController constructor
     * @param selectQuestionJFrame 
     */
    public SelectQuestionJFrameController (SelectQuestionJFrameView selectQuestionJFrame)
    {
	    this.selectQuestionJFrame = selectQuestionJFrame;
	
	    //add all the action listeners here
	    selectQuestionJFrame.getGenerateButton().addActionListener(this);
	       
	    // center the frame
	    Utils.centerWindow(selectQuestionJFrame);
	    selectQuestionJFrame.setVisible(true);
    }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
    @Override
  public void actionPerformed(ActionEvent event) 
  {

    log.debug("Inside RegisterCustomerJFrameController::actionPerformed");
    
    if (event.getSource().equals(selectQuestionJFrame.getGenerateButton()))
			getGenerateButton_actionPerformed(event);

  }

  /**
   * Generate Button Action Event
   *
   * @param actionEvent ActionEvent
 * @throws IOException 
 * @throws InputException 
 * @throws ClassNotFoundException 
 * @throws FileNotFoundException 
   */
  void getGenerateButton_actionPerformed (ActionEvent actionEvent) 
  {   
		byte assessmentNumber = selectQuestionJFrame.getAssessmentNumber();
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
		boolean action = questionManager.performAction("GenerateQuestion", assessmentNumber);
		if(action)
		{
			AnswerQuestionJFrameView answerQuestionJFrame = new AnswerQuestionJFrameView();
			AnswerQuestionJFrameController answerQuestionJFrameController = new AnswerQuestionJFrameController(answerQuestionJFrame);
			selectQuestionJFrame.dispose();
		}
		else
	    {
	        MessageDialog dlg = new MessageDialog("Question Generator" , "Question Generation Failed. Please try again!");    
	        Utils.centerWindow(dlg);
	        dlg.setModal(true);
	        dlg.setVisible(true);
	    }  
        }
  } //end getGenerateButton_actionPerformed
}

