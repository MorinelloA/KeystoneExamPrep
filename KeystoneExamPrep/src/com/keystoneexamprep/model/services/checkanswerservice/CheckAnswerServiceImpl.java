package com.keystoneexamprep.model.services.checkanswerservice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.services.exception.InputException;
import com.keystoneexamprep.model.services.exception.OutputException;
import org.apache.log4j.Logger;	

/**
* Checks if the student answered a question correctly or not.
*/
public class CheckAnswerServiceImpl implements ICheckAnswerService{
	 
    final static private Logger log = Logger.getLogger(CheckAnswerServiceImpl.class);
	
    /**
     * method used to check if the user's answer is correct or not
     * @return true is correct, false if incorrect
     * @throws OutputException
     * @throws InputException 
     */
    @Override
    public boolean checkAnswer() throws OutputException, InputException{
		log.debug ("Entering method CheckAnswerServiceImpl::checkAnswer");

		ObjectInputStream input = null;
		Questions newQuestion = new Questions();
		//boolean used for correct or incorrect answer
		boolean isCorrect;
		boolean validFile = true;
		try {
			input = new ObjectInputStream(new FileInputStream("savefiles/questions/newquestion.txt"));
			newQuestion = (Questions) input.readObject();
		} catch (FileNotFoundException fnfe) {
			validFile = false;
			log.error("File containing new question not found!", fnfe);
			throw new InputException("File containing new question not found!", fnfe);
		} catch (IOException ioe) {
			validFile = false;
			log.error("IOException while accessing file containing new question!", ioe);
			throw new InputException("IOException while accessing file containing new question!", ioe);
		} catch (ClassNotFoundException cnfe) {
			validFile = false;
			log.error("ClassNotFoundException while reading file containing new question!", cnfe);
			throw new InputException("ClassNotFoundException while reading file containing new question!", cnfe);
		}
		finally
		{
			if (validFile)
			{
				ObjectOutputStream output = null;
					
				if(newQuestion.getCorrectAnswer().equals(newQuestion.getStudentAnswer()))
				{
					isCorrect = true;
				}
				else
				{
					isCorrect = false;
				}
				
				newQuestion.setCorrect(isCorrect);
				
				try 
				{
					output = new ObjectOutputStream (new FileOutputStream("savefiles/questions/newquestion.txt"));
					output.writeObject(newQuestion);
				} 
				catch(InvalidClassException ice) 
				{
					log.error("Invalid Class Exception when checking student's answer!", ice);
					throw new OutputException("Invalid Class Exception when checking student's answer", ice);
				}
				catch(NotSerializableException nse)
				{
					log.error("Not Serializable Exception when checking student's answer!", nse);
					throw new OutputException("Not Serializable Exception when checking student's answer!", nse);
				}
				catch(IOException ioe)
				{
					log.error("IOException when checking student's answer!", ioe);
					throw new OutputException("IOException when checking student's answer!", ioe);
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
			}

			if (input != null)
			{
				try
				{
					input.close();
				} catch (IOException e) {
					// log error
					e.printStackTrace();
				}
			}
		}
		
		//Will return a true if a valid question was saved.  A false will be picked up by JUNIT testing.
		return newQuestion.validate();
	} 
}