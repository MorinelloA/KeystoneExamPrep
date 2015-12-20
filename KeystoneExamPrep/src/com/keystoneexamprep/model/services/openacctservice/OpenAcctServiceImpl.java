package com.keystoneexamprep.model.services.openacctservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.keystoneexamprep.model.domain.Student;
import com.keystoneexamprep.model.services.exception.InputException;
import org.apache.log4j.Logger;

/**
 * Service used to Open a student's account
 * @author Tony
 */
public class OpenAcctServiceImpl implements IOpenAcctService{
    final static private Logger log = Logger.getLogger(OpenAcctServiceImpl.class);
	
    /**
     * Service used to Open a student's account
     * @param studentEmail
     * @return
     * @throws InputException 
     */
    @Override
    public Student openAcct(String studentEmail) throws InputException{
		log.debug("Entering method OpenAcctServiceImpl::openAcct");

		ObjectInputStream input = null;
		Student studentToOpen = new Student();
		//boolean used for correct or incorrect answer
		boolean validFile = true;
		try {
			input = new ObjectInputStream(new FileInputStream("studentaccts/"+studentEmail+".txt"));
			studentToOpen = (Student) input.readObject();
		} catch (FileNotFoundException fnfe) {
			validFile = false;
			log.error("File containing student not found!", fnfe);
			throw new InputException("File containing student not found!", fnfe);
		} catch (IOException ioe) {
			validFile = false;
			log.error("IOException while accessing file containing student!", ioe);
			throw new InputException("IOException while accessing file containing student!", ioe);
		} catch (ClassNotFoundException cnfe) {
			validFile = false;
			log.error("ClassNotFoundException while reading file containing student!", cnfe);
			throw new InputException("ClassNotFoundException while reading file containing student!", cnfe);
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
		if (validFile) return studentToOpen;
		else return null;
	}
}
