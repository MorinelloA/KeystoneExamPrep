package com.keystoneexamprep.model.services.generatequestionservice;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.services.exception.OutputException;
import java.util.Random;
//import java.lang.Math;
import java.text.DecimalFormat;
import org.apache.log4j.Logger;	

/**
* Generate a question for the student to answer.
* 
*  returns Questions object
*  	Contains null values for usersAnswer. Default false for isCorrect boolean)
* @throws IOException 
* @throws FileNotFoundException 
* @throws OutputException 
*/
public class GenerateQuestionServiceImpl implements IGenerateQuestionService{
    final static private Logger log = Logger.getLogger(GenerateQuestionServiceImpl.class);

    /**
     * method used to generate a keystone exam question
     * @param assessmentNumber
     * @return
     * @throws OutputException 
     */
    @Override
    public boolean generateQuestion(byte assessmentNumber) throws OutputException {	    
		
		ObjectOutputStream output = null;
		Questions newQuestion = new Questions();
		
		try{
		    //Needed for random numbers
			Random rand = new Random();
			
			log.debug("Entering method GenerateQuestionServiceImpl::generateQuestion");
			
			int anchorNumber;
			
			//Flag to determine if a question was created or not
			boolean questionCreated = false;
			
			//Loops until a question is generated
			do{	
				
				//A value of 0 for the assessmentNumber means generate a question from a random anchor
				if (assessmentNumber == 0)
				{
					//Random number from 1-32.
					//Used to figure out which random anchor to pull a question from
					anchorNumber = rand.nextInt(32) + 1; 
				}
				else
				{
					anchorNumber = assessmentNumber;
				}
				
				
				if (anchorNumber == 1)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.1.1
					* Compare and/or order and real numbers. 
					*/
					newQuestion = anchor1();
				    questionCreated = true;
				}//End of random anchor 1
				else if (anchorNumber == 2)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.1.2
					* Simplify square roots 
					*/
					newQuestion = anchor2();
			       questionCreated = true;
				}//End of Random anchor 2
				else if (anchorNumber == 3)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.2.1
					* Find the Greatest Common Factor (GCF) and/or the Least Common Multiple (LCM) for sets of monomials
					*/
					
					
				}//End of Random anchor 3
				else if (anchorNumber == 4)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.3.1
					* Simplify/evaluate expressions involving properties/laws of exponents, root, and/or absolute values to solve problems.
					*/
					newQuestion = anchor4();
				    questionCreated = true;
				}//End of Random anchor 4
				else if (anchorNumber == 5)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.4.1
					* Use estimation to solve problems
					*/
					newQuestion = anchor5();
				    questionCreated = true;
				}//End of Random anchor 5
				else if (anchorNumber == 6)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.5.1
					* Add, subtract, and/or multiply polynomial expressions (express answers in simplest form)
					*/
					newQuestion = anchor6();
					questionCreated = true;
				}//End of Random anchor 6
				else if (anchorNumber == 7)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.5.2
					* Factor algebraic expressions, including difference of squares and trinomials.
					*/
					newQuestion = anchor7();
					questionCreated = true;
					
				}//End of Random anchor 7
				else if (anchorNumber == 8)
				{
					/* A.1.1.1 - Operations with Real Numbers and Expressions
					* Eligible Content - A.1.1.1.5.3
					* Simplify/reduce a rational algebraic expression
					*/
					
					
				}//End of Random anchor 8
				else if (anchorNumber == 9)
				{
					/* A.1.1.2 - Linear Equations
					* Eligible Content - A.1.1.2.1.1
					* Write, solve, and/or apply a linear equation (including problem situations)
					*/
					
					
				}//End of Random anchor 9
				else if (anchorNumber == 10)
				{
					/* A.1.1.2 - Linear Equations
					* Eligible Content - A.1.1.2.1.2
					* Use and/or identify an algebraic property to justify any step in an equation-solving process
					*/
					
					
				}//End of Random anchor 10
				else if (anchorNumber == 11)
				{
					/* A.1.1.2 - Linear Equations
					* Eligible Content - A.1.1.2.1.3
					* Interpret solutions to problems in the context of the problem situation
					*/
					
					
				}//End of Random anchor 11
				else if (anchorNumber == 12)
				{
					/* A.1.1.2 - Linear Equations
					* Eligible Content - A.1.1.2.2.1
					* Write and/or solve a system of linear equations using graphing, substitution, and/or elimination.
					*/
					
					
				}//End of Random anchor 12
				else if (anchorNumber == 13)
				{
					/* A.1.1.2 - Linear Equations
					* Eligible Content - A.1.1.2.2.2
					* Interpret solutions to problems in the context of the problem situation.
					*/
					
					
				}//End of Random anchor 13
				else if (anchorNumber == 14)
				{
					/* A.1.1.3 - Linear Inequalities
					* Eligible Content - A.1.1.3.1.1
					* Write or solve compound inequalities and/or graph their solution sets on a number line
					*/
					
					
				}//End of Random anchor 14
				else if (anchorNumber == 15)
				{
					/* A.1.1.3 - Linear Inequalities
					* Eligible Content - A.1.1.3.1.2
					* Identify or graph the solution set to a linear inequality on a number line
					*/
					
					
				}//End of Random anchor 15
				else if (anchorNumber == 16)
				{
					/* A.1.1.3 - Linear Inequalities
					* Eligible Content - A.1.1.3.1.3
					* Interpret solutions to problems in the context of the problem situation
					*/
					
					
				}//End of Random anchor 16
				else if (anchorNumber == 17)
				{
					/* A.1.1.3 - Linear Inequalities
					* Eligible Content - A.1.1.3.2.1
					* Write and/or solve a system of linear inequalities using graphing
					*/
					
					
				}//End of Random anchor 17
				else if (anchorNumber == 18)
				{
					/* A.1.2.1 - Functions
					* Eligible Content - A.1.2.1.1.1
					* Analyze a set of data for the existence of a pattern and represent the pattern algebraically and/or graphically.
					*/
					
					
				}//End of Random anchor 18
				else if (anchorNumber == 19)
				{
					/* A.1.2.1 - Functions
					 * Eligible Content - A.1.2.1.1.2
					 * Determine whether a relation is a function, given a set of points or a graph.
					 */
				}//End of Random anchor 19
				else if (anchorNumber == 20)
				{
					/* A.1.2.1 - Functions
					 * Eligible Content - A.1.2.1.1.3
					 * Identify the domain or range of a relation
					 */
				}//End of Random anchor 20
				else if (anchorNumber == 21)
				{
					/* A.1.2.1 - Functions
					 * Eligible Content - A.1.2.1.2.1
					 * Create, interpret, and/or use the equation, graph, or table of a linear function.
					 */
					
				}//End of Random anchor 21
				else if (anchorNumber == 22)
				{
					/* A.1.2.1 - Functions
					 * Eligible Content - A.1.2.1.2.2
					 * Translate from one representation of a linear function to another
					 */
				}//End of Random anchor 22
				else if (anchorNumber == 23)
				{
					/* A.1.2.2 - Coordinate Geometry
					 * Eligible Content - A.1.2.2.1.1
					 * Identify, describe, and/or use constant rates of change
					 */
				}//End of Random anchor 23
				else if (anchorNumber == 24)
				{
					/* A.1.2.2 - Coordinate Geometry
					 * Eligible Content - A.1.2.2.1.2
					 * Apply the concept of linear rate of change (slope) to solve problems
					 */
				}//End of Random anchor 24
				else if (anchorNumber == 25)
				{
					/* A.1.2.2 - Coordinate Geometry
					 * Eligible Content - A.1.2.2.1.3
					 * Write or identify a linear equation
					 */ 
				}//End of Random anchor 25
				else if (anchorNumber == 26)
				{
					/* A.1.2.2 - Coordinate Geometry
					 * Eligible Content - A.1.2.2.1.4
					 * Determine the slope and/or y-intercept represented by a linear equation or graph
					 */ 
				}//End of Random anchor 26
				else if (anchorNumber == 27)
				{
					/* A.1.2.2 - Coordinate Geometry
					 * Eligible Content - A.1.2.2.2.1
					 * Draw, identify, find, and/or write an equation for a line of best fit for a scatter plot.
					 */ 
				}//End of Random anchor 27
				else if (anchorNumber == 28)
				{
					/* A.1.2.3 Data Analysis
					 * Eligible Content - A.1.2.3.1.1
					 * Calculate and/or interpret the range, quartiles, and interquartile range of data
					 */
				}//End of Random anchor 28
				else if (anchorNumber == 29)
				{
					/* A.1.2.3 Data Analysis
					 * Eligible Content - A.1.2.3.2.1
					 * Estimate or calculate to make predictions based on a circle, line, bar graph, measure of central tendency, or other representation
					 */
				}//End of Random anchor 29
				else if (anchorNumber == 30)
				{
					/* A.1.2.3 Data Analysis
					 * Eligible Content - A.1.2.3.2.2
					 * Analyze data, make predictions, and/or answer questions based on displayed data
					 */
				}//End of Random anchor 30
				else if (anchorNumber == 31)
				{
					/* A.1.2.3 Data Analysis
					 * Eligible Content - A.1.2.3.2.3
					 * Make predictions using the equations or graphs of best-fit lines of scatter plots
					 */
				}//End of Random anchor 31
				else if (anchorNumber == 32)
				{
					/* A.1.2.3 Data Analysis
					 * Eligible Content - A.1.2.3.3.1
					 * Find probabilities for compound events 
					 */
				}//End of Random anchor 32
				newQuestion.setAssessmentNumber((byte)anchorNumber);
				//Random assessment number if needed to go through the loop again. Avoids forever loop
				assessmentNumber = 0;
			}while(!questionCreated);	
			
			output = new ObjectOutputStream (new FileOutputStream("savefiles/questions/newquestion.txt"));
			output.writeObject(newQuestion);
		} //End Try
		catch(InvalidClassException ice) 
		{
			log. error("Invalid Class Exception when creating a question!", ice);
			throw new OutputException("Invalid Class Exception when creating a question!", ice);
		}
		catch(NotSerializableException nse)
		{
			log.error("Not Serializable Exception when creating a question!", nse);
			throw new OutputException("Not Serializable Exception when creating a question!", nse);
		}
		catch(IOException ioe)
		{
			log.error("IOException when creating a question!", ioe);
			throw new OutputException("IOException when creating a question!", ioe);
		}
		finally 
		{
			if (output != null)
			{
				try
				{
					output.flush();
					output.close();
				} catch (IOException e) {
					// log error
					e.printStackTrace();
				}
			}
		}
		
		
		//If invalid question, a false will be returned. JUnit tests will pickup the error.
		return newQuestion.validate();
	}//End of generateQuestion method
	
        /**
         * Anchor 1
         * @return 
         */
	public static Questions anchor1() {
		/* A.1.1.1 - Operations with Real Numbers and Expressions
		* Eligible Content - A.1.1.1.1.1
		* Compare and/or order and real numbers. 
		*/
		
		Random rand = new Random();
		Questions newQuestion = new Questions();
		
		//Flag for duplicate correct answers
		boolean isValid = false;
	    do
	    {
	      String part1, part2, part3, part4;
	      double part1Value, part2Value, part3Value, part4Value;
	      int tempWholeRand = rand.nextInt(7) + 2;
	      int tempDecimalRand = (rand.nextInt(3) + 1) * 25;
	      int temp, temp2, temp3;
	      
	      part1Value = (double)tempWholeRand + ((double)tempDecimalRand / 100 - .01); 
	      part1 = Double.toString(part1Value);
	      
	      part2Value = (double)tempWholeRand + (double)tempDecimalRand / 100;
	      part2 = Integer.toString(tempWholeRand) + " " + Integer.toString(tempDecimalRand / 25) + "/4";
	      
	      //Random number to determine which way to round the number, up or down, to be square rooted
	      temp = rand.nextInt(2);
	      if (temp == 1)
	        part3Value = tempWholeRand;
	      else
	        part3Value = tempWholeRand + 1;
	      
	      part3 = "\u221A" + Integer.toString((int)part3Value*(int)part3Value);
	      
	      //3-6, generated to determine the denominator
	      temp = rand.nextInt(4) + 3;
	      
	      //Random number to determine which way to round the numerator, up or down
	      temp2 = rand.nextInt(2);
	      
	      //1-5 chance of adding 1 to the fraction
	      temp3 = rand.nextInt(5);
	      if (temp3 == 0)
	        tempWholeRand++;
	      
	      if (temp2 == 1)
	      {
	        part4Value = tempWholeRand + (1.0 / (double)temp);
	        part4 = Integer.toString(temp * tempWholeRand + 1) + "/" + Integer.toString(temp);
	      }
	      else
	      {
	        part4Value = tempWholeRand - (1.0 / (double)temp);
	        part4 = Integer.toString(temp * tempWholeRand - 1) + "/" + Integer.toString(temp);                            
	      }                             
	      
	      newQuestion.setQuestion("Which has the greatest value? " + part1 + ", " + part2 + ", " + part3 + ", or " + part4);
	      newQuestion.setQuestionType("MultipleChoice");
	      newQuestion.setAssessmentAnchor("A1.1.1 - Operations with Real Numbers and Expressions");
	      newQuestion.setEligibleContentNumber("A1.1.1.1.1");
	      newQuestion.setEligibleContentDescription("Compare and/or order any real numbers");
	      
	      //Finding and setting the correct value (The max value in this case)
	      double correctAnswerValue = part1Value;
	      newQuestion.setCorrectAnswer(part1);
	      newQuestion.setIncorrectAnswer1(part2);
	      newQuestion.setIncorrectAnswer2(part3);
	      newQuestion.setIncorrectAnswer3(part4);
	      if (part2Value > correctAnswerValue)
	      {
	    	  newQuestion.setCorrectAnswer(part2);
	    	  correctAnswerValue = part2Value;
	    	  
	    	  newQuestion.setIncorrectAnswer1(part1);
	    	  newQuestion.setIncorrectAnswer2(part3);
	    	  newQuestion.setIncorrectAnswer3(part4);
	      }
	      if (part3Value > correctAnswerValue)
	      {
	    	  newQuestion.setCorrectAnswer(part3);
	    	  correctAnswerValue = part3Value;
	    	  
	    	  newQuestion.setIncorrectAnswer1(part1);
		      newQuestion.setIncorrectAnswer2(part2);
		      newQuestion.setIncorrectAnswer3(part4);
	      }
	      if (part4Value > correctAnswerValue)
	      {
	    	  newQuestion.setCorrectAnswer(part4);
	    	  correctAnswerValue = part4Value;
	    	  
	    	  newQuestion.setIncorrectAnswer1(part1);
		      newQuestion.setIncorrectAnswer2(part2);
		      newQuestion.setIncorrectAnswer3(part3);
	      }//End setting correct value
	      
	      //Question is not valid if there is more than 1 correct answer
	      byte correctCount = 0;
	      if (part1Value == correctAnswerValue)
	    	  correctCount++;
	      if (part2Value == correctAnswerValue)
	    	  correctCount++;
	      if (part3Value == correctAnswerValue)
	    	  correctCount++;
	      if (part4Value == correctAnswerValue)
	    	  correctCount++;
	      
	      if (correctCount == 1)
	      {
	    	  isValid = true;
	      }//end testing for valid question/answers
	    	  
	    }while(!isValid);
	    //questionCreated = true;

		return newQuestion;
	}
	
        /**
         * Anchor 2
         * @return 
         */
        public static Questions anchor2() {
		/* A.1.1.1 - Operations with Real Numbers and Expressions
		* Eligible Content - A.1.1.1.1.2
		* Simplify square roots 
		*/
		
		Random rand = new Random();
		Questions newQuestion = new Questions();
		
		int tempOutside, tempInside, x;

		//Random number 2-6. Used for outside of SqRt
       tempOutside = rand.nextInt(5) + 2;
       do
       {
        //Random number 21 - 81. Used for inside of SqRt
        //Checked in loop to make sure its not a SqRt
        tempInside = rand.nextInt(61) + 21;
       }while(Math.sqrt(tempInside) % 1 == 0);
       
       //Two lines to find x
       //random number 3-7
       x = rand.nextInt(5) + 3;
       newQuestion.setIncorrectAnswer1(Integer.toString(x));
       x *= x;
       
       newQuestion.setCorrectAnswer(Integer.toString(x));
       newQuestion.setIncorrectAnswer2(Integer.toString(x*2));
       newQuestion.setIncorrectAnswer3(Integer.toString(x*4));
       
       newQuestion.setQuestion("What value of x makes the expression " + tempOutside + "\u221A" + tempInside + "x equivalent to " + (tempOutside * (int)(Math.sqrt(x)) + "\u221A" + Integer.toString(tempInside)));
       newQuestion.setQuestionType("MultipleChoice");
       newQuestion.setAssessmentAnchor("A1.1.1 - Operation with Real Numbers and Expressions");
       newQuestion.setEligibleContentNumber("A1.1.1.1.2");
       newQuestion.setEligibleContentDescription("Simplify square roots");
       
       return newQuestion;
	}
	
        /**
         * Anchor 4
         * @return 
         */
        public static Questions anchor4() {
		/* A.1.1.1 - Operations with Real Numbers and Expressions
		* Eligible Content - A.1.1.1.3.1
		* Simplify/evaluate expressions involving properties/laws of exponents, root, and/or absolute values to solve problems.
		*/
		
		Random rand = new Random();
		Questions newQuestion = new Questions();
		
		DecimalFormat formatter = new DecimalFormat("0.000");
	    int temp1, temp2, temp3, temp4;
	    
	    //Loop for valid question
	    //With random numbers, possibility of answers equaling each other
	    boolean isValid = false;
	    do
	    {
		    //Equation setup below
		    //temp1(temp2 sqrt(temp3))^temp4
		    
		    temp1 = rand.nextInt(4) + 1;
		    if (temp1 < 2)
		     temp1 = 2;
		    
		    temp2 = rand.nextInt(4) + 1;
		    if (temp2 < 2)
		     temp2 = 2;
		     
		    temp3 = rand.nextInt(7) + 2;
		    temp3 *= temp3;
		    
		    temp4 = rand.nextInt(8) - 4;
		    if (temp4 == 0 || temp4 == 1) temp4 = 2;
		    if (temp4 == -1) temp4 = -2;
		    
		    double correctAnswerDouble = temp1 * Math.pow(temp2 * Math.sqrt(temp3),temp4);

		    if (temp4 > 0)
		    {
		      newQuestion.setCorrectAnswer(Integer.toString((int)correctAnswerDouble));
		      newQuestion.setIncorrectAnswer1(Integer.toString((int)correctAnswerDouble / 2));
		      newQuestion.setIncorrectAnswer2(Integer.toString((int)correctAnswerDouble * 2));
		      newQuestion.setIncorrectAnswer3(Integer.toString((int)correctAnswerDouble * 10));
		    }
		    else
		    {
		      newQuestion.setCorrectAnswer(formatter.format(correctAnswerDouble));
		      newQuestion.setIncorrectAnswer1(formatter.format(correctAnswerDouble / 2));
		      newQuestion.setIncorrectAnswer2(formatter.format(correctAnswerDouble * 2));
		      newQuestion.setIncorrectAnswer3(formatter.format(correctAnswerDouble * 10));
		    }
		    
		    newQuestion.setQuestion("Simplify:  " + temp1 + "(" + temp2 + "\u221A" + temp3 + ")^" + temp4);
		    newQuestion.setQuestionType("MultipleChoice");
		    newQuestion.setAssessmentAnchor("A1.1.1 - Operation with Real Numbers and Expressions");
		    newQuestion.setEligibleContentNumber("A1.1.1.1.4");
		    newQuestion.setEligibleContentDescription("Simplify/evaluate expressions involving properties/laws of exponents, roots, and/or absolute values to solve problems");
		    
		    if (!(newQuestion.getCorrectAnswer().equals(newQuestion.getIncorrectAnswer1()) || newQuestion.getCorrectAnswer().equals(newQuestion.getIncorrectAnswer2()) || newQuestion.getCorrectAnswer().equals(newQuestion.getIncorrectAnswer3()) || newQuestion.getIncorrectAnswer1().equals(newQuestion.getIncorrectAnswer2()) || newQuestion.getIncorrectAnswer1().equals(newQuestion.getIncorrectAnswer3()) || newQuestion.getIncorrectAnswer2().equals(newQuestion.getIncorrectAnswer3())))
		    {
		    	isValid = true;
		    }
	    }while(!isValid);
	    
	    return newQuestion;
	}
	
        /**
         * Anchor 5
         * @return 
         */
        public static Questions anchor5() {
		/* A.1.1.1 - Operations with Real Numbers and Expressions
		* Eligible Content - A.1.1.1.4.1
		* Use estimation to solve problems
		*/
		
		Random rand = new Random();
		Questions newQuestion = new Questions();
		
		//Store and items will be generated by random
	    String store, item1, item2;
	    
	    //random number 0-4
	    //5 different store/items
	    int temp1 = rand.nextInt(5);
	    if (temp1 == 0)
	    {
	     store = "Hardware store";
	     item1 = "Totes of nails";
	     item2 = "Totes of screws";
	    }
	    else if (temp1 == 1)
	    {
	     store = "Pet shop";
	     item1 = "Cats";
	     item2 = "Dogs";
	    }
	    else if (temp1 == 2)
	    {
	     store = "Electronic store";
	     item1 = "Speakers";
	     item2 = "Tvs";
	    }
	    else if (temp1 == 3)
	    {
	     store = "Sports shop";
	     item1 = "Hockey sticks";
	     item2 = "Baseball bats";
	    }
	    else
	    {
	     store = "Furniture store";
	     item1 = "Chairs";
	     item2 = "Tables";
	    }
	    
	    int item1Cost, item1CostEstimate, item1Sales, item1SalesEstimate;
	    int item2Cost, item2CostEstimate, item2Sales, item2SalesEstimate;
	    //Loop to make sure correct answer is divisible by 10000
	    do
	    {
	    
	      //Random cost of $50, $100, $150, $200, or $250
	      item1CostEstimate = (rand.nextInt(5) + 1) * 50;
	      
	      //Random cost estimate of $300, $400, $500, or $600 
	      item2CostEstimate = (rand.nextInt(4) + 3) * 100;
	      
	      //random number -10 to 10, not including 0
	      temp1 = rand.nextInt(20) - 10;
	      if (temp1 == 0) temp1 = 10; 
	      item1Cost = item1CostEstimate + temp1;
	      
	      //random number -20 to 20, not including 0
	      temp1 = rand.nextInt(40) - 20;
	      if (temp1 == 0) temp1 = 20; 
	      item2Cost = item2CostEstimate + temp1;
	      
	      //random number, 100-800, every 100
	      item1SalesEstimate = (rand.nextInt(8) + 1) * 100;
	      
	      //random number, 100-800, every 100
	      item2SalesEstimate = (rand.nextInt(8) + 1) * 100;
	      
	      //random number -20 to 20, not including 0
	      temp1 = rand.nextInt(40) - 20;
	      if (temp1 == 0) temp1 = 20; 
	      item1Sales = item1SalesEstimate + temp1;
	      
	      //random number -20 to 20, not including 0
	      temp1 = rand.nextInt(40) - 20;
	      if (temp1 == 0) temp1 = 20; 
	      item2Sales = item2SalesEstimate + temp1;
	      
	      newQuestion.setCorrectAnswer(Integer.toString((item1SalesEstimate * item1CostEstimate) + (item2SalesEstimate * item2CostEstimate)));
	    
	    }while(Integer.parseInt(newQuestion.getCorrectAnswer()) % 10000 != 0);  //End divisible by 10000 loop
	    
	    String ia1;
	    String ia2;
	    String ia3;
	    
	    //Randomness to to determine incorrect answers.
	    //All are 1,000's apart. 4 possible scenarios
	    temp1 = rand.nextInt(4);
	    
	    String tempCorrectAnswer = newQuestion.getCorrectAnswer();
	    if (temp1 == 0) // correct answer is lowest
	    {
	      ia1 = Integer.toString(Integer.parseInt(tempCorrectAnswer) + 10000);
	      ia2 = Integer.toString(Integer.parseInt(tempCorrectAnswer) + 20000);
	      ia3 = Integer.toString(Integer.parseInt(tempCorrectAnswer) + 30000);
	    }
	    else if (temp1 == 1) // correct answer is second lowest
	    {
	      ia1 = Integer.toString(Integer.parseInt(tempCorrectAnswer) - 10000);
	      ia2 = Integer.toString(Integer.parseInt(tempCorrectAnswer) + 10000);
	      ia3 = Integer.toString(Integer.parseInt(tempCorrectAnswer) + 20000);
	    }
	    else if (temp1 == 2) // correct answer is second highest
	    {
	      ia1 = Integer.toString(Integer.parseInt(tempCorrectAnswer) - 20000);
	      ia2 = Integer.toString(Integer.parseInt(tempCorrectAnswer) - 10000);
	      ia3 = Integer.toString(Integer.parseInt(tempCorrectAnswer) + 10000);
	    }
	    else // correct answer is highest
	    {
	      ia1 = Integer.toString(Integer.parseInt(tempCorrectAnswer) - 30000);
	      ia2 = Integer.toString(Integer.parseInt(tempCorrectAnswer) - 20000);
	      ia3 = Integer.toString(Integer.parseInt(tempCorrectAnswer) - 10000);
	    }
	    
	    newQuestion.setIncorrectAnswer1(ia1);
	    newQuestion.setIncorrectAnswer2(ia2);
	    newQuestion.setIncorrectAnswer3(ia3);
	    
	    newQuestion.setQuestion("A " + store + " sells " + item1 + " for $" + item1Cost + " and " + item2 + " for $" + item2Cost + ". Last month, they sold " + item1Sales + " " + item1 + " and " + item2Sales + " " + item2 + ". What is the closest estimate for the total amount of many the " + store + " made on these two items last month?");
	    newQuestion.setQuestionType("MultipleChoice");
	    newQuestion.setAssessmentAnchor("A1.1.1 - Operation with Real Numbers and Expressions");
	    newQuestion.setEligibleContentNumber("A1.1.1.1.5");
	    newQuestion.setEligibleContentDescription("Use estimation to solve problems");
	    
	    return newQuestion;
	}
    
        /**
         * Anchor 6
         * @return 
         */
        public static Questions anchor6() {
    	/* A.1.1.1 - Operations with Real Numbers and Expressions
		* Eligible Content - A.1.1.1.5.1
		* Add, Subtract, and/or Multiply polynomial expressions
		*/
		
		Random rand = new Random();
		Questions newQuestion = new Questions();
		
		
		int LX3, LX2, LX1, L;
		int RX3, RX1, R;
		
		//Setup for equation
		//((LX3)x^3+(LX2)x^2+(LX)x+(L)) + ((RX3)x^3+(RX)x+(R))
		
		///Loop to eliminate the slim chance of producing the same possible answers
		do{
			//Random numbers 2-9
			LX3 = rand.nextInt(8) + 2;
			LX2 = rand.nextInt(8) + 2;
			LX1 = rand.nextInt(8) + 2;
			L = rand.nextInt(8) + 2;
			RX3 = rand.nextInt(8) + 2;
			RX1 = rand.nextInt(8) + 2;
			R = rand.nextInt(8) + 2;
			
		    newQuestion.setCorrectAnswer((LX3 + RX3) + "x^3 + " + LX2 + "x^2 + " + (LX1 + RX1) + "x + " + (L + R));
		    
		    newQuestion.setIncorrectAnswer1((LX3 + RX3) + "x^6 + " + LX2 + "x^4 + " + (LX1 + RX1) + "x^2 + " + (L + R));
		    newQuestion.setIncorrectAnswer2((LX3 + RX3) + "x^3 + " + (LX2 + RX1) + "x^2 + " + (LX1 + R) + "x + " + L);
		    newQuestion.setIncorrectAnswer3((LX3 + RX3) + "x^6 + " + (LX2 + LX1 + RX1) + "x^2 + " + (L + R));
		}while(newQuestion.getCorrectAnswer().equals(newQuestion.getIncorrectAnswer2()) || newQuestion.getIncorrectAnswer1().equals(newQuestion.getIncorrectAnswer3()));
	    
	    newQuestion.setQuestion("Simplify: (" + LX3 + "x^3 + " + LX2 + "x^2 + " + LX1 + "x + " + L + ") + (" + RX3 + "x^3 + " + RX1 + "x + " + R + ")");
	    newQuestion.setQuestionType("MultipleChoice");
	    newQuestion.setAssessmentAnchor("A1.1.1 - Operation with Real Numbers and Expressions");
	    newQuestion.setEligibleContentNumber("A1.1.1.5.1");
	    newQuestion.setEligibleContentDescription("Add, Subtract, and/or Multiply polynomial expressions");
	    
	    return newQuestion;
    }
	
        /**
         * Anchor 7
         * @return 
         */
        public static Questions anchor7() {
		/* A.1.1.1 - Operations with Real Numbers and Expressions
		* Eligible Content - A.1.1.1.5.2
		* Factor algebraic expressions, including difference of squares and trinomials.
		*/
		
		Random rand = new Random();
		Questions newQuestion = new Questions();
		
		
		int num1, num2;
		String strCorNum1, strCorNum2, strIn1Num1, strIn1Num2, strIn2Num1, strIn2Num2, strIn3Num1, strIn3Num2;
		
		//Random number -9 to 9, not including 1's or 0
		//num1 + num2 cannot equal -1, 0, or 1
		do{
			do{
				num1 = rand.nextInt(19) - 9;
			}while(num1 < 2 && num1 > -2);
			
			do{
				num2 = rand.nextInt(19) - 9;
			}while(num2 < 2 && num2 > -2);
		}while(num1 + num2 >= -1 && num1 + num2 <= 1);
		if (num1 > 0)
		{
			strCorNum1 = "+"+num1;
			strIn1Num1 = Integer.toString(num1 * -1);
		}
		else
		{
			strCorNum1 = Integer.toString(num1);
			strIn1Num1 = "+"+(num1 * -1);
		}
		
		if (num2 > 0)
		{
			strCorNum2 = "+"+num2;
			strIn1Num2 = Integer.toString(num2 * -1);
		}
		else
		{
			strCorNum2 = Integer.toString(num2);
			strIn1Num2 = "+"+(num2 * -1);
		}
		
		if (num1 + num2 > 0)
		{
			strIn2Num1 = "+"+(num1+num2);
			strIn3Num1 = Integer.toString((num1+num2) * -1);
		}
		else
		{
			strIn2Num1 = Integer.toString(num1+num2);
			strIn3Num1 = "+"+((num1+num2) * -1);
		}
		
		if (num1 * num2 > 0)
		{
			strIn2Num2 = "+"+(num1*num2);
			strIn3Num2 = Integer.toString(num1*num2*-1);
		}
		else
		{
			strIn2Num2 = Integer.toString(num1*num2);
			strIn3Num2 = "+"+(num1*num2*-1);
		}
		
	    newQuestion.setCorrectAnswer("(x" + strCorNum1 + ")(x" + strCorNum2 + ")"); 
	    newQuestion.setIncorrectAnswer1("(x" + strIn1Num1 + ")(x" + strIn1Num2 + ")");
	    newQuestion.setIncorrectAnswer2("(x" + strIn2Num1 + ")(x" + strIn2Num2 + ")");
	    newQuestion.setIncorrectAnswer3("(x" + strIn3Num1 + ")(x" + strIn3Num2 + ")");
	    
	    newQuestion.setQuestion("Factor: x^2" + strIn2Num1 + "x" + strIn2Num2);
	   	    
	    newQuestion.setQuestionType("MultipleChoice");
	    newQuestion.setAssessmentAnchor("A1.1.1 - Operation with Real Numbers and Expressions");
	    newQuestion.setEligibleContentNumber("A1.1.1.5.2");
	    newQuestion.setEligibleContentDescription("Factor algebraic expressions, including difference of squares and trinomials");
	    
	    return newQuestion;
	}

        /**
         * Tests whether a number is a prime number or not
         * @param number
         * @return 
         */
        public static boolean isPrimeNumber(int number)
    {
    	if (number == 2 || number == 3)
    	{
    		return true;
	    }
	      	if (number % 2 == 0)
	      	{
	      		return false;
	      	}
	      	int sqrt = (int) Math.sqrt(number) + 1;
	      	for (int i = 3; i < sqrt; i += 2)
	      	{
	      		if (number % i == 0)
	      		{ 
	      			return false;
	      		} 
	      	} 
	      	return true; 
	    }
}