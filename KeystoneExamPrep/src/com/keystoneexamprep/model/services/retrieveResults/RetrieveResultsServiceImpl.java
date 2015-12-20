package com.keystoneexamprep.model.services.retrieveResults;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import com.keystoneexamprep.model.domain.Results;
import com.keystoneexamprep.model.services.exception.InputException;
import org.apache.log4j.Logger;	

/**
 * Retrieves full results, which includes a list of all questions answered
 * @author Tony
 */
public class RetrieveResultsServiceImpl implements IRetrieveResultsService{
    final static private Logger log = Logger.getLogger(RetrieveResultsServiceImpl.class);

    /**
     * Method used for retrieving results
     * @return
     * @throws InputException 
     */
    @Override
    public Results retrieveResults() throws InputException{
		log.debug("Entering method RetrieveResultsServiceImpl::retrieveResults");

		ObjectInputStream input = null;
		Results newResults = new Results();
		//boolean used for correct or incorrect answer
		boolean validFile = true;
		try {
			input = new ObjectInputStream(new FileInputStream("savefiles/questions/newquestion.txt"));
			newResults = (Results) input.readObject();
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
		if (validFile) return newResults;
		else return null;
	}
}
