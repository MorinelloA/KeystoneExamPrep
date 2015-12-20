package com.keystoneexamprep.model.services.storeqaservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.keystoneexamprep.model.domain.Questions;
import com.keystoneexamprep.model.domain.Results;
import com.keystoneexamprep.model.services.exception.InputException;
import com.keystoneexamprep.model.services.exception.OutputException;
import org.apache.log4j.Logger;	

/**
 * Stores a question into a file
 * @author Tony
 */
public class StoreQAServiceImpl implements IStoreQAService{
	 
    final static private Logger log = Logger.getLogger(StoreQAServiceImpl.class);

    /**
    * Store a question in the running results.
    * This is done by adding it to the Questions Object Arraylist of a Results object.
    * Other results data must be updated as well.
    *  @param currentResults - current results of questions already answers. 
     * @throws com.keystoneexamprep.model.services.exception.OutputException 
     * @throws com.keystoneexamprep.model.services.exception.InputException 
    */
    @Override
    public boolean storeQA(Results currentResults) throws OutputException, InputException{
		log.debug("Entering method GenerateQuestionServiceImpl::generateQuestion");
		
		List<Questions> currentQuestions = currentResults.getQuestions();
		
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
			log.error("File containing new question not found when storing question!", fnfe);
			throw new InputException("File containing new question not found when storing question!!", fnfe);
		} catch (IOException ioe) {
			validFile = false;
			log.error("IOException while accessing file to store  new question!", ioe);
			throw new InputException("IOException while accessing file to store new question!", ioe);
		} catch (ClassNotFoundException cnfe) {
			validFile = false;
			log.error("ClassNotFoundException while reading file containing new question to store it!", cnfe);
			throw new InputException("ClassNotFoundException while reading file containing new question to store it!", cnfe);
		}
		finally
		{
			if (validFile)
			{
				ObjectOutputStream output = null;
					
				//Add current question
				currentQuestions.add(newQuestion);
				
				//Adding 1 to the number of questions answered
				int numberOfQuestionsAnswered = currentResults.getNumberOfQuestionsAnswered() + 1;
				currentResults.setNumberOfQuestionsAnswered(numberOfQuestionsAnswered);
				
				//Get original number of correct & incorrect answers. To be changed in following section
				int numberOfCorrectAnswers = currentResults.getNumberOfCorrectAnswers();
				int numberOfIncorrectAnswers = currentResults.getNumberOfIncorrectAnswers();
				 
				//Add 1 to correct or incorrect answers
				isCorrect = newQuestion.getCorrect();
				if(isCorrect)
					numberOfCorrectAnswers++;
				else
					numberOfIncorrectAnswers++;
				
				currentResults.setNumberOfCorrectAnswers(numberOfCorrectAnswers);
				currentResults.setNumberOfIncorrectAnswers(numberOfIncorrectAnswers);
				
				//The following three lines return the original month, date, and year
				//This means that eventually, it will display the month, date, and year the assessment was started
				//This section will need changed if the ending time of the assessment is desired
				String monthTaken = currentResults.getMonthTaken();
				byte dateTaken = currentResults.getDateTaken();
				short yearTaken = currentResults.getYearTaken();
				 
				//Get assessment type. This will not change part way through an assessment
				String assessmentType = currentResults.getAssessmentType();
				
				//My way of creating a filename for results.
				String fileName = assessmentType + "-" + yearTaken + "-" + monthTaken + "-" + dateTaken + ".txt";
				try 
				{
					output = new ObjectOutputStream (new FileOutputStream("savefiles/results/"+fileName));
					output.writeObject(currentResults);
				} 
				catch(InvalidClassException ice) 
				{
					log.error("Invalid Class Exception when storing results!", ice);
					throw new OutputException("Invalid Class Exception when storing results!", ice);
				}
				catch(NotSerializableException nse)
				{
					log.error("Not Serializable Exception when storing results!", nse);
					throw new OutputException("Not Serializable Exception when storing results!", nse);
				}
				catch(IOException ioe)
				{
					log.error("IOException when storing results!", ioe);
					throw new OutputException("IOException when storing results!", ioe);
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
		return currentResults.validate();
		//Old way I did it. Tightly coupled. Left commented here for a reference.
		/*
		//ArrayList of questions, not including the question to be added.
		ArrayList<Questions> currentQuestions = currentResults.getQuestions();
		
		//Add current question
		currentQuestions.add(questionToStore);
		
		//Adding 1 to the number of questions answered
		int numberOfQuestionsAnswered = currentResults.getNumberOfQuestionsAnswered() + 1;
		
		//Get original number of correct & incorrect answers. To be changed in following section
		int numberOfCorrectAnswers = currentResults.getNumberOfCorrectAnswers();
		int numberOfIncorrectAnswers = currentResults.getNumberOfIncorrectAnswers();
		 
		//Add 1 to correct or incorrect answers
		boolean isCorrect = questionToStore.isCorrect();
		if(isCorrect)
			numberOfCorrectAnswers++;
		else
			numberOfIncorrectAnswers++;
		 
		//The following three lines return the original month, date, and year
		//This means that eventually, it will display the month, date, and year the assessment was started
		//This section will need changed if the ending time of the assessment is desired
		String monthTaken = currentResults.getMonthTaken();
		byte dateTaken = currentResults.getDateTaken();
		short yearTaken = currentResults.getYearTaken();
		 
		//Get assessment type. This will not change part way through an assessment
		String assessmentType = currentResults.getAssessmentType();

		return new Results(numberOfQuestionsAnswered, numberOfCorrectAnswers, numberOfIncorrectAnswers, monthTaken, dateTaken, yearTaken, assessmentType, currentQuestions);
		*/
	} 
}