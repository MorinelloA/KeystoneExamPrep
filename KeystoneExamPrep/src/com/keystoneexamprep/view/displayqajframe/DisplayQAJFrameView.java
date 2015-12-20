package com.keystoneexamprep.view.displayqajframe;

import java.awt.*;
import javax.swing.*;
import com.keystoneexamprep.model.business.manager.QuestionManager;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DisplayQAJFrameView
 * DisplayQAJFrame is used to view and question the the student has already answered
 * This way, they can see if they were correct or not.
 * @author Tony
 */
public class DisplayQAJFrameView extends javax.swing.JFrame{
	private static final long serialVersionUID = -7935992123675939377L;
	
	//final variables to determine sizes of components
  	final int FORM_WIDTH=800, FORM_HEIGHT=600;
  	final int QUESTION_PANEL_WIDTH=750, QUESTION_PANEL_HEIGHT=250;
  	
	//private JFrame frame;
	private JPanel mainPanel;
	private JPanel anchorPanel;
	private JPanel questionPanel;
	private JPanel answersPanel;
	private JPanel resultsPanel;
	private JPanel buttonsPanel;
	private JLabel anchor;
	private JLabel blankLabel;
	private JLabel assessmentNumber;
	private JLabel assessmentDescription;
	private JTextArea question;
	private JLabel studentAnswer;
	private JLabel correctAnswer;
	private JLabel rightOrWrong;
	private JLabel questionTotalLabel;
	private JLabel correctTotalLabel;
	private JLabel incorrectTotalLabel;
	private JButton nextQuestionButton;
	private JButton newQuestionButton;
	private JButton exitButton;
	
        /**
         * Main Method
         * @param args 
         */
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayQAJFrameView displayQAJFrame = new DisplayQAJFrameView();
            }
        });
    }
	
        /**
         * DisplayQAJFrameView Constructor
         */
	public DisplayQAJFrameView() {
        initComponents();
        
        this.setSize(FORM_WIDTH,FORM_HEIGHT);                
        this.setVisible(true); 
    }
        /**
         * initComponents
         */
	public void initComponents(){
		Questions newQuestion = getQuestion();
		
		mainPanel = new JPanel();
		anchorPanel = new JPanel();
		questionPanel = new JPanel();
		answersPanel = new JPanel();
		resultsPanel = new JPanel();
		buttonsPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		
		//Make inner panels transparent
		questionPanel.setOpaque(false);
		answersPanel.setOpaque(false);
		buttonsPanel.setOpaque(false);
		
		/*Use these to help identify design flaws with form design
		answersPanel.setBackground(Color.BLUE);
		questionPanel.setBackground(Color.GREEN);
		buttonsPanel.setBackground(Color.RED);*/
		
		anchorPanel.setBackground(Color.ORANGE);
		resultsPanel.setBackground(Color.CYAN);
		
		//Center Panels
		anchorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Technically we don't need to center the question panel, but just in case we change something later on
		questionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		answersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		resultsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Box layout so that all components are stacked appropriately
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		anchorPanel.setLayout(new BoxLayout(anchorPanel, BoxLayout.Y_AXIS));
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));
		resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.X_AXIS));
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		
		//Anchors Panel components
		anchor = new JLabel();
		blankLabel = new JLabel();
		assessmentNumber = new JLabel();
		assessmentDescription = new JLabel();
		
		//Add proper text to Anchor labels
		anchor.setText(newQuestion.getAssessmentAnchor());
		blankLabel.setText("   ");
		assessmentNumber.setText(newQuestion.getEligibleContentNumber());
		assessmentDescription.setText(newQuestion.getEligibleContentDescription());
		
		//Add anchor labels to anchor panel
		anchorPanel.add(anchor);
		anchorPanel.add(blankLabel);
		anchorPanel.add(assessmentNumber);
		anchorPanel.add(assessmentDescription);
		
		question = new JTextArea();
		question.setText(newQuestion.getQuestion());
		question.setWrapStyleWord(true);
		Font questionFont = new Font("Verdana", Font.BOLD, 16);
		question.setFont(questionFont);
		question.setLineWrap(true);
		question.setOpaque(false);
		question.setEditable(false);
		question.setFocusable(false);
		
		//Add question to the questionPanel
		questionPanel.add(question);
		
		//Labels that hold the answers to the question
		studentAnswer = new JLabel();
		correctAnswer = new JLabel("Correct Answer - " + newQuestion.getCorrectAnswer());
		//Add an if statement that has the font color green for correct, red for incorrect
		
		if(newQuestion.getCorrect())
		{
			rightOrWrong = new JLabel("Correct!");
			rightOrWrong.setForeground(Color.GREEN);
		}
		else
		{
			rightOrWrong = new JLabel("Incorrect!");
			rightOrWrong.setForeground(Color.RED);
		}
		
		studentAnswer.setText("Student Answer - " + newQuestion.getStudentAnswer());
		
		//Set the font of the Answer Labels
		Font answerFont = new Font("Verdana", Font.BOLD, 20);
		studentAnswer.setFont(answerFont);
		correctAnswer.setFont(answerFont);
		rightOrWrong.setFont(answerFont);
		
		//Align Answer Labels to the center of the answerPanel
		/*studentAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
		correctAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightOrWrong.setAlignmentX(Component.CENTER_ALIGNMENT);*/
	
        //Add Answer Labels to the answerPanel
		//Include Vertical struts to have proper spacing
        answersPanel.add(rightOrWrong);
        answersPanel.add(Box.createVerticalStrut(5));
		answersPanel.add(studentAnswer);
		answersPanel.add(correctAnswer);
		answersPanel.add(Box.createVerticalStrut(5));
		
		//Label that hold the results to the questions
		questionTotalLabel = new JLabel("Questions Answered - " + "?");
		correctTotalLabel = new JLabel("     # Correct - " + "?" + "     ");
		//Add an if statement that has the font color green for correct, red for incorrect
		incorrectTotalLabel = new JLabel("# Incorrect - " + "?");
		
		//Set the font of the results Labels
		Font resultsFont = new Font("Verdana", Font.PLAIN, 16);
		questionTotalLabel.setFont(resultsFont);
		correctTotalLabel.setFont(resultsFont);
		incorrectTotalLabel.setFont(resultsFont);
		
		//Align Answer Labels to the center of the answerPanel
		studentAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
		correctAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightOrWrong.setAlignmentX(Component.CENTER_ALIGNMENT);
	
        //Add results Labels to the resultsPanel
        resultsPanel.add(questionTotalLabel);
		resultsPanel.add(correctTotalLabel);
		resultsPanel.add(incorrectTotalLabel);
		
		//Create buttons
		nextQuestionButton = new JButton("Next Question");
		newQuestionButton = new JButton("New Question");
		exitButton = new JButton("Exit");
		
		//Button fonts
		Font buttonFont = new Font("Verdana", Font.BOLD, 20);
		nextQuestionButton.setFont(buttonFont);
		newQuestionButton.setFont(buttonFont);
		exitButton.setFont(buttonFont);
		
		//Add Buttons to the buttonsPanel
		buttonsPanel.add(nextQuestionButton);
		buttonsPanel.add(newQuestionButton);
		buttonsPanel.add(exitButton);
		
		questionPanel.setMaximumSize(new Dimension(QUESTION_PANEL_WIDTH, QUESTION_PANEL_HEIGHT));
		//buttonsPanel.setMaximumSize(new Dimension(BUTTONS_PANEL_WIDTH, BUTTONS_PANEL_HEIGHT));
		
		//Add inner panels to main(outer) panel
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(anchorPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(questionPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(answersPanel);
		mainPanel.add(Box.createVerticalStrut(30));
		mainPanel.add(resultsPanel);
		mainPanel.add(Box.createVerticalStrut(30));
		mainPanel.add(buttonsPanel);
		
		//Set the panel the the contentpane of the frame
		getContentPane().add(mainPanel);
		
		//Close form when you click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
        /**
         * Retrieves the question from a file
         * @return 
         */
	 public Questions getQuestion()
	 {
            Questions newQuestion = null;
            //QuestionManager questionManager = QuestionManager.getInstance();
            String propertyFileLocation = System.getProperty("prop_location");
            //log.debug("Property File Location: "+propertyFileLocation);
            boolean isValid = true;
            ApplicationContext context = null;
            try
            {
                context = new ClassPathXmlApplicationContext(propertyFileLocation);
            }
            catch(Exception ex)
            {
                //log.error("File error",ex);
                isValid = false;
                MessageDialog dlg = new MessageDialog("PropertyFile", "Error Locating Property");    
                Utils.centerWindow(dlg);
                dlg.setModal(true);
                dlg.setVisible(true);
                newQuestion = null;
            }
            if(isValid)
            {
                QuestionManager questionManager = (QuestionManager)context.getBean("questionManager");
                newQuestion = questionManager.performRetrival("RetrieveQuestion");
            }
            return newQuestion;
	 }
	 
         /**
          * getNextQuestionButton
          * @return 
          */
	 public javax.swing.JButton getNextQuestionButton()
	 {
	     return nextQuestionButton;
	 }
	 
         /**
          * getNewQuestionButton
          * @return 
          */
	 public javax.swing.JButton getNewQuestionButton()
	 {
	     return newQuestionButton;
	 }
	 
         /**
          * getExitButton
          * @return 
          */
	 public javax.swing.JButton getExitButton()
	 {
	     return exitButton;
	 }

}
