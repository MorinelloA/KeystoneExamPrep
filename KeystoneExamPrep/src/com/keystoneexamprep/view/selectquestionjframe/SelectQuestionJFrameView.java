package com.keystoneexamprep.view.selectquestionjframe;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * SelectQuestionJFrameView
 * SelectQuestionJFrame allows the user to select what anchor they want a question to be generated from
 * @author Tony
 */
public class SelectQuestionJFrameView extends javax.swing.JFrame{
	private static final long serialVersionUID = -8886673106206740008L;

	final int FORM_WIDTH=1000, FORM_HEIGHT=100;

    private JPanel mainPanel;
	private JLabel label;
	private JComboBox anchorBox;
	private JButton generateButton;
	
        /**
         * SelectionQuestionJFrameView constructor
         */
	public SelectQuestionJFrameView() {
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
                SelectQuestionJFrameView selectQuestionJFrame = new SelectQuestionJFrameView();
            }
        });
    }
		
    /**
     * initComponents
     */
	public void initComponents(){
		mainPanel = new JPanel();
		
		label = new JLabel("Question to Generate: ");
		
		String[] anchors = { "Random", 
				"A.1.1.1.1.1 - Compare and/or order and real numbers", 
				"A.1.1.1.1.2 - Simplify square roots", 
				"A.1.1.1.2.1 - Find the Greatest Common Factor (GCF) and/or the Least Common Multiple (LCM) for sets of monomials", 
				"A.1.1.1.3.1 - Simplify/evaluate expressions involving properties/laws of exponents, root, and/or absolute values to solve problems", 
				"A.1.1.1.4.1 - Use estimation to solve problems", "A.1.1.1.5.1 - Add, subtract, and/or multiply polynomial expressions (express answers in simplest form)", 
				"A.1.1.1.5.2 - Factor algebraic expressions, including difference of squares and trinomials" };
		
		anchorBox = new JComboBox(anchors);
		
		generateButton = new JButton("Go");
		
		mainPanel.add(label);
		mainPanel.add(anchorBox);
		mainPanel.add(generateButton);
		
		//Set the panel the the contentpane of the frame
		getContentPane().add(mainPanel);
		
		//Close form when you click the X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		pack();
	}
	
        /**
         * AssessmentNumber getter
         * @return 
         */
	public byte getAssessmentNumber()
    {
        byte assessmentNumber = (byte)anchorBox.getSelectedIndex();
        return assessmentNumber;
    }
	
        /**
         * getGenerateButton
         * @return 
         */
	 public javax.swing.JButton getGenerateButton()
	 {
	     return generateButton;
	 }
}
