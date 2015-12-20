package com.keystoneexamprep.view.answerquestionjframe;

import javax.swing.*;
import com.keystoneexamprep.model.business.manager.QuestionManager;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.view.utility.MessageDialog;
import com.keystoneexamprep.view.utility.Utils;
import java.awt.*;
import java.util.Random;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * View for the AnswerQuestion JFrame
 * @author Tony
 */
public class AnswerQuestionJFrameView extends javax.swing.JFrame{
	private static final long serialVersionUID = -7116183229292017180L;
	
	//final variables to determine sizes of components
	final int FORM_WIDTH=800, FORM_HEIGHT=600;
	final int QUESTION_PANEL_WIDTH=750, QUESTION_PANEL_HEIGHT=250;
	final int BUTTONS_PANEL_WIDTH=200, BUTTONS_PANEL_HEIGHT=100;
	
	private Questions newQuestion;
	private JPanel mainPanel;
	private JPanel questionPanel;
	private JPanel answersPanel;
	private JPanel buttonsPanel;
	private JTextArea question;
	private JRadioButton answer1;
	private JRadioButton answer2;
	private JRadioButton answer3;
	private JRadioButton answer4;
	private ButtonGroup answerGroup;
	private JButton submitButton;
	
        /**
         * Constructor
         */
	public AnswerQuestionJFrameView(){
        initComponents();
        
        this.setSize(FORM_WIDTH,FORM_HEIGHT);                
        this.setVisible(true); 
    }
	
        /**
         * Main Method
         * @param args 
         */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
				AnswerQuestionJFrameView answerQuestionJFrame = new AnswerQuestionJFrameView();
            }
        });
    }
	
    /**
     * initComponents
     */
	public void initComponents(){
		newQuestion = setQuestion();
		
		mainPanel = new JPanel();
		questionPanel = new JPanel();
		answersPanel = new JPanel();
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
		
		
		//Center Panels
		//Technically we don't need to center the question panel, but just in case we change something later on
		questionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		answersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Box layout so that all components are stacked vertically
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		
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
		
		String[] answers = new String[4];
		answers[0] = newQuestion.getCorrectAnswer();
		answers[1] = newQuestion.getIncorrectAnswer1();
		answers[2] = newQuestion.getIncorrectAnswer2();
		answers[3] = newQuestion.getIncorrectAnswer3();
		
		Random rand = new Random();
		for(int i=0; i<2; i++)
		{
			String temp = answers[i];
			int randNum = rand.nextInt(4);
			answers[i] = answers[randNum];
			answers[randNum] = temp;
		}
			
		
		//Radio buttons that hold the possible answers to the questions 
		answer1 = new JRadioButton(answers[0]);
		answer2 = new JRadioButton(answers[1]);
		answer3 = new JRadioButton(answers[2]);
		answer4 = new JRadioButton(answers[3]);
		
		//Set the answer RadioButtons to the same group
		//This way you can only check one radio button
		answerGroup = new ButtonGroup();
		answerGroup.add(answer1);
        answerGroup.add(answer2);
        answerGroup.add(answer3);
        answerGroup.add(answer4);
		
		//Set the font of the Answer Radio Buttons
		Font answerFont = new Font("Verdana", 0, 16);
		answer1.setFont(answerFont);
		answer2.setFont(answerFont);
		answer3.setFont(answerFont);
		answer4.setFont(answerFont);
		
		//Align Answer RadioButtons to the center of the answerPanel
		answer1.setAlignmentX(Component.CENTER_ALIGNMENT);
		answer2.setAlignmentX(Component.CENTER_ALIGNMENT);
		answer3.setAlignmentX(Component.CENTER_ALIGNMENT);
		answer4.setAlignmentX(Component.CENTER_ALIGNMENT);
	
        //Add Answer RadioButtons to the answerPanel
		//Include Vertical struts to have proper spacing
        answersPanel.add(answer1);
        answersPanel.add(Box.createVerticalStrut(5));
		answersPanel.add(answer2);
		answersPanel.add(Box.createVerticalStrut(5));
		answersPanel.add(answer3);
		answersPanel.add(Box.createVerticalStrut(5));
		answersPanel.add(answer4);
		answersPanel.add(Box.createVerticalStrut(5));
		
		submitButton = new JButton("Submit Answer");
		Font buttonFont = new Font("Verdana", Font.BOLD, 20);
		submitButton.setFont(buttonFont);
		
		//Add submitButton to the buttonsPanel
		buttonsPanel.add(submitButton);
		
		questionPanel.setMaximumSize(new Dimension(QUESTION_PANEL_WIDTH, QUESTION_PANEL_HEIGHT));
		buttonsPanel.setMaximumSize(new Dimension(BUTTONS_PANEL_WIDTH, BUTTONS_PANEL_HEIGHT));
		
		//Add inner panels to main(outer) panel
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(questionPanel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(answersPanel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(buttonsPanel);
		
		//Set the panel the the contentpane of the frame
		getContentPane().add(mainPanel);
		//frame.setContentPane(mainPanel);
		//frame.setSize(FORM_WIDTH, FORM_HEIGHT);
		//frame.setVisible(true);
		
		//Close form when you click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//}
	}

        /**
         * getSubmitButton
         * @return submitButton
         */
	 public javax.swing.JButton getSubmitButton()
	 {
	     return submitButton;
	 }
	 
         /**
          * Retrieving the question
          * @return 
          */
	 public Questions setQuestion()
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
          * gets the student answer and returns it before it is saved
          * @return 
          */
	 public Questions getQuestion()
	    {
	        Questions questionToSave = newQuestion;
	        if (answer1.isSelected())
	        	questionToSave.setStudentAnswer(answer1.getText());
	        else if (answer2.isSelected())
	        	questionToSave.setStudentAnswer(answer2.getText());
	        else if (answer3.isSelected())
	        	questionToSave.setStudentAnswer(answer3.getText());
	        else if (answer4.isSelected())
	        	questionToSave.setStudentAnswer(answer4.getText());
	        return questionToSave;
	    }
}
