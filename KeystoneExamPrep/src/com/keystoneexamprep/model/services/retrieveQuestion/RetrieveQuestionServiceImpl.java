package com.keystoneexamprep.model.services.retrieveQuestion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.services.exception.InputException;
import org.apache.log4j.Logger;

/**
 * Retrieves a question from the proper file
 * @author Tony
 */
public class RetrieveQuestionServiceImpl implements IRetrieveQuestionService{
    final static private Logger log = Logger.getLogger(RetrieveQuestionServiceImpl.class);

    /**
     * Method for retrieving the question
     * @return
     * @throws InputException 
     */
    @Override
    public Questions retrieveQuestion() throws InputException{
		log.debug("Entering method CheckAnswerServiceImpl::checkAnswer");

		ObjectInputStream input = null;
		Questions newQuestion = new Questions();
		//boolean used for correct or incorrect answer
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
		if (validFile) return newQuestion;
		else return null;
	}
}
