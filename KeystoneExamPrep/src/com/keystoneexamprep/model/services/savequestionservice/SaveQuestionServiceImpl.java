package com.keystoneexamprep.model.services.savequestionservice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.services.exception.OutputException;
import org.apache.log4j.Logger;	

/**
 * Service for saving a question to a file
 * @author Tony
 */
public class SaveQuestionServiceImpl implements ISaveQuestionService{
	 
    final static private Logger log = Logger.getLogger(SaveQuestionServiceImpl.class);

    /**
    * Saves question updates to file.
    */
    @Override
    public boolean saveQuestion(Questions currentQuestion) throws OutputException{
		log.debug("Entering method SaveQuestionServiceImpl::saveQuestion");

		ObjectOutputStream output = null;
		
		try 
		{
			output = new ObjectOutputStream (new FileOutputStream("savefiles/questions/newquestion.txt"));
			output.writeObject(currentQuestion);
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
		
		//Will return a true if a valid question was saved.  A false will be picked up by JUNIT testing.
		if (output != null) return true;//currentQuestion.validate();
		else return false;
	} 
}
