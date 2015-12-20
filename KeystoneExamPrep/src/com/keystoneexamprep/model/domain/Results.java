package com.keystoneexamprep.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
 * Class that stores the results of students answering questions
 */
public class Results implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4653601629378078598L;

	/**
	 * @param numberOfQuestionsAnswered
	 * @param numberOfCorrectAnswers
	 * @param numberOfIncorrectAnswers
	 * @param monthTaken
	 * @param dateTaken
	 * @param yearTaken
	 * @param assessmentType
	 * @param questions
	 */
	public Results(int numberOfQuestionsAnswered, int numberOfCorrectAnswers,
			int numberOfIncorrectAnswers, String monthTaken, byte dateTaken,
			short yearTaken, String assessmentType,
			List<Questions> questions) {
		super();
		this.numberOfQuestionsAnswered = numberOfQuestionsAnswered;
		this.numberOfCorrectAnswers = numberOfCorrectAnswers;
		this.numberOfIncorrectAnswers = numberOfIncorrectAnswers;
		this.monthTaken = monthTaken;
		this.dateTaken = dateTaken;
		this.yearTaken = yearTaken;
		this.assessmentType = assessmentType;
		this.questions = questions;
	}

        /**
         * Results constructor
         */
	public Results() {
		super();
		// TODO Auto-generated constructor stub
	}


	//Holds how many total questions were answered
	private int numberOfQuestionsAnswered;
	
	//Holds how many questions were answered correctly
	private int numberOfCorrectAnswers;
	
	//Holds how many questions were answered incorrectly
	private int numberOfIncorrectAnswers;
	
	//Month the question(s) were taken 
	private String monthTaken;
	
	//Date the question(s) were taken 
	private byte dateTaken;
	
	//Year the question(s) were taken 
	private short yearTaken;
	
	//Holds the type of assessment
	//(Random questions, Exam, or Custom Exam)
	private String assessmentType;
	
	//Holds question objects
	private List<Questions> questions = new ArrayList<Questions>();

	/**
	  * numberOfQuestionsAnswered getter
	  * 
	  * @return numberOfQuestionsAnswered
	  */
	public int getNumberOfQuestionsAnswered() {
		return numberOfQuestionsAnswered;
	}

	/**
	  * numberOfQuestionsAnswered setter
	  * 
	  * @param numberOfQuestionsAnswered  the numberOfQuestionsAnswered to set
	  */
	public void setNumberOfQuestionsAnswered(int numberOfQuestionsAnswered) {
		this.numberOfQuestionsAnswered = numberOfQuestionsAnswered;
	}

	/**
	  * numberOfCorrectAnswers getter
	  * 
	  * @return numberOfCorrectAnswers
	  */
	public int getNumberOfCorrectAnswers() {
		return numberOfCorrectAnswers;
	}

	/**
	  * numberOfCorrectAnswers setter
	  * 
	  * @param numberOfCorrectAnswers  the numberOfCorrectAnswers to set
	  */
	public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
		this.numberOfCorrectAnswers = numberOfCorrectAnswers;
	}

	/**
	  * numberOfIncorrectAnswers getter
	  * 
	  * @return numberOfIncorrectAnswers
	  */
	public int getNumberOfIncorrectAnswers() {
		return numberOfIncorrectAnswers;
	}

	/**
	  * numberOfIncorrectAnswers setter
	  * 
	  * @param numberOfIncorrectAnswers  the numberOfIncorrectAnswers to set
	  */
	public void setNumberOfIncorrectAnswers(int numberOfIncorrectAnswers) {
		this.numberOfIncorrectAnswers = numberOfIncorrectAnswers;
	}

	/**
	  * monthTaken getter
	  * 
	  * @return monthTaken
	  */
	public String getMonthTaken() {
		return monthTaken;
	}

	/**
	  * monthTaken setter
	  * 
	  * @param monthTaken  the monthTaken to set
	  */
	public void setMonthTaken(String monthTaken) {
		this.monthTaken = monthTaken;
	}

	/**
	  * dateTaken getter
	  * 
	  * @return dateTaken
	  */
	public byte getDateTaken() {
		return dateTaken;
	}

	/**
	  * dateTaken setter
	  * 
	  * @param dateTaken  the dateTaken to set
	  */
	public void setDateTaken(byte dateTaken) {
		this.dateTaken = dateTaken;
	}

	/**
	  * yearTaken getter
	  * 
	  * @return yearTaken
	  */
	public short getYearTaken() {
		return yearTaken;
	}

	/**
	  * yearTaken setter
	  * 
	  * @param yearTaken  the yearTaken to set
	  */
	public void setYearTaken(short yearTaken) {
		this.yearTaken = yearTaken;
	}

	/**
	  * assessmentType getter
	  * 
	  * @return assessmentType
	  */
	public String getAssessmentType() {
		return assessmentType;
	}

	/**
	  * assessmentType setter
	  * 
	  * @param assessmentType  the assessmentType to set
	  */
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	/**
	  * questions list getter
	  * 
	  * @return questions object
	  */
	public List<Questions> getQuestions() {
		return questions;
	}

	/**
	  * questions arraylist object setter
	  * 
	  * @param questions  the questions Arraylist object to set
	  */
	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	/**
	 * Auto-Generated hashCode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assessmentType == null) ? 0 : assessmentType.hashCode());
		result = prime * result + dateTaken;
		result = prime * result
				+ ((monthTaken == null) ? 0 : monthTaken.hashCode());
		result = prime * result + numberOfCorrectAnswers;
		result = prime * result + numberOfIncorrectAnswers;
		result = prime * result + numberOfQuestionsAnswered;
		result = prime * result
				+ ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + yearTaken;
		return result;
	}

	/**
	 * Auto-Generated equals() method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Results other = (Results) obj;
		if (assessmentType == null) {
			if (other.assessmentType != null)
				return false;
		} else if (!assessmentType.equals(other.assessmentType))
			return false;
		if (dateTaken != other.dateTaken)
			return false;
		if (monthTaken == null) {
			if (other.monthTaken != null)
				return false;
		} else if (!monthTaken.equals(other.monthTaken))
			return false;
		if (numberOfCorrectAnswers != other.numberOfCorrectAnswers)
			return false;
		if (numberOfIncorrectAnswers != other.numberOfIncorrectAnswers)
			return false;
		if (numberOfQuestionsAnswered != other.numberOfQuestionsAnswered)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

	/**
	 * Auto-Generated toString() method
	 */
	@Override
	public String toString() {
		return "Results [numberOfQuestionsAnswered="
				+ numberOfQuestionsAnswered + ", numberOfCorrectAnswers="
				+ numberOfCorrectAnswers + ", numberOfIncorrectAnswers="
				+ numberOfIncorrectAnswers + ", monthTaken=" + monthTaken
				+ ", dateTaken=" + dateTaken + ", yearTaken=" + yearTaken
				+ ", assessmentType=" + assessmentType + ", questions="
				+ questions + "]";
	}
	
	 /**
	  * Validate if the instance variables are valid
	  * 
	  * @return boolean - true if instance variables are valid, else false
	  */
	 public boolean validate () 
	 {
		 if (numberOfQuestionsAnswered < 0) return false;
		 if (numberOfCorrectAnswers < 0) return false;
		 if (numberOfIncorrectAnswers < 0) return false;
		 //Number of correct and incorrect answers should equal total questions
		 if (numberOfQuestionsAnswered != numberOfCorrectAnswers + numberOfIncorrectAnswers) return false;
		 if (monthTaken == null) return false;
		 //Month not one of the 12 months
		 if (!(monthTaken.equals("January") || monthTaken.equals("February") || monthTaken.equals("March") || monthTaken.equals("April") || monthTaken.equals("May") || monthTaken.equals("June") || monthTaken.equals("July") || monthTaken.equals("August") || monthTaken.equals("September") || monthTaken.equals("October") || monthTaken.equals("November") || monthTaken.equals("December"))) return false;
		 if (dateTaken <= 0 || dateTaken > 31) return false;
		 if (yearTaken <= 0) return false;
		 if (assessmentType == null) return false;
		 if (questions == null) return false;

		 return true;
	 }
}
