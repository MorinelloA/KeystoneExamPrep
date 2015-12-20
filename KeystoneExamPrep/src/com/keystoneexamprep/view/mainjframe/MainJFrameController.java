package com.keystoneexamprep.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.keystoneexamprep.view.loginjframe.LoginJFrameController;
import com.keystoneexamprep.view.loginjframe.LoginJFrameView;
import com.keystoneexamprep.view.registeracctjframe.RegisterAcctJFrameController;
import com.keystoneexamprep.view.registeracctjframe.RegisterAcctJFrameView;
import com.keystoneexamprep.view.selectquestionjframe.SelectQuestionJFrameController;
import com.keystoneexamprep.view.selectquestionjframe.SelectQuestionJFrameView;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import org.apache.log4j.Logger;	

/**
 * MainJFrameController
 * @author Tony
 */
public class MainJFrameController implements ActionListener {
    static private Logger log = Logger.getLogger(MainJFrameController.class);
	private MainJFrameView mainJFrame;
	
    /** Creates a new instance of MainJFrameController */
    public MainJFrameController() {
    }
     

  /**
   * MainJFrame
   * @param mainJFrame 
   */
  public MainJFrameController (MainJFrameView mainJFrame) 
  {
    this.mainJFrame = mainJFrame;

    //add all the action listeners here
    mainJFrame.getLoginButton().addActionListener(this);
    mainJFrame.getEditProfileButton().addActionListener(this);
    mainJFrame.getViewResultsButton().addActionListener(this);
    mainJFrame.getTakeExamButton().addActionListener(this);
    mainJFrame.getAnswerQuestionsButton().addActionListener(this);
    mainJFrame.getCreateAccountButton().addActionListener(this);
       
    // center the frame
    Utils.centerWindow(mainJFrame);
    //mainJFrame.setVisible(true);
  }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  @Override
  public void actionPerformed(ActionEvent event) 
  {

    log.debug("Inside MainJFrameController::actionPerformed");
    
    if (event.getSource().equals(mainJFrame.getLoginButton()))
    	getLoginButton_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getEditProfileButton()))
    	getEditProfileButton_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getViewResultsButton()))
    	getViewResultsButton_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getTakeExamButton()))
    	getTakeExamButton_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getAnswerQuestionsButton()))
    	getAnswerQuestionsButton_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getCreateAccountButton()))
    	getCreateAccountButton_actionPerformed(event);
  }  
  
/**
   * Processes Login action
   *
   * @param actionEvent ActionEvent
   */
  void getLoginButton_actionPerformed(ActionEvent actionEvent) 
  {
	  LoginJFrameView loginJFrame = new LoginJFrameView();
	  LoginJFrameController loginJFrameController = new LoginJFrameController(loginJFrame);
	  mainJFrame.dispose();
  } //end getLoginButton_actionPerformed

  /**
   * Processes Edit Profile action
   *
   * @param actionEvent ActionEvent
   */
  void getEditProfileButton_actionPerformed(ActionEvent actionEvent) 
  {
     MessageDialog dlg = new MessageDialog( "Edit Profile", "Not Implemented Yet!");    
     Utils.centerWindow(dlg);
     dlg.setModal(true);
     dlg.setVisible(true);
       
  } //end getEditProfileButton_actionPerformed
  
  /**
   * Processes Login action
   *
   * @param actionEvent ActionEvent
   */
  void getViewResultsButton_actionPerformed(ActionEvent actionEvent) 
  {
     MessageDialog dlg = new MessageDialog( "View Results", "Not Implemented Yet!");    
     Utils.centerWindow(dlg);
     dlg.setModal(true);
     dlg.setVisible(true);
       
  } //end getViewResultsButton_actionPerformed
  
  /**
   * Processes Login action
   *
   * @param actionEvent ActionEvent
   */
  void getTakeExamButton_actionPerformed(ActionEvent actionEvent) 
  {
     MessageDialog dlg = new MessageDialog( "Take Exam", "Not Implemented Yet!");    
     Utils.centerWindow(dlg);
     dlg.setModal(true);
     dlg.setVisible(true); 
      
  } //end getTakeExamButton_actionPerformed
  
  /**
   * Processes Login action
   *
   * @param actionEvent ActionEvent
   */
  void getCreateAccountButton_actionPerformed(ActionEvent actionEvent) 
  {
	  RegisterAcctJFrameView registerAcctJFrame = new RegisterAcctJFrameView();
	  RegisterAcctJFrameController registerAcctJFrameController = new RegisterAcctJFrameController(registerAcctJFrame);
	  mainJFrame.dispose();
  } //end getCreateAccountButton_actionPerformed
  
 private void getAnswerQuestionsButton_actionPerformed(ActionEvent event) {
  SelectQuestionJFrameView selectQuestionJFrame = new SelectQuestionJFrameView();
  SelectQuestionJFrameController selectQuestionJFrameController = new SelectQuestionJFrameController(selectQuestionJFrame);
  mainJFrame.dispose();
 }
  
} //end class 