package com.keystoneexamprep.model.domain;

/*
 * Class that generates an Exam for the student to take.  
 * This exam has a set number of questions by each type of assessment 
 * anchor. The idea is to assess the student to see 
 * if they are proficient or not for each anchor 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores questions taken and general information on the exam
 * @author Tony
 */
public class Exam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6575092081064484019L;
	/**
	  * @param isFinished
	  * @param questions
	  * @param questionOn
	  */
	public Exam(boolean isFinished, ArrayList<Questions> questions,
			short questionOn) {
		super();
		this.isFinished = isFinished;
		this.questions = questions;
		this.questionOn = questionOn;
	}

        /**
         * Exam constructor
         */
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	//boolean to determine if the student is complete or not
	//Used for if the student saves and comes back later
	private boolean isFinished;
	
	//holds question objects
	private List<Questions> questions = new ArrayList<Questions>();

	//Question number the student is answering.
	private short questionOn;
	/**
	  * isFinished getter
	  * 
	  * @return the isFinished
	  */
	public boolean isFinished() {
		return isFinished;
	}

	/**
	  * isFinished setter
	  * 
	  * @param isFinished  the isFinished to set
	  */
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	/**
	  * questions object getter
	  * 
	  * @return the questions object
	  */
	public List<Questions> getQuestions() {
		return questions;
	}
	
	/**
	  * questions object setter
	  * 
	  * @param questions  the questions object to set
	  */
	public void setQuestions(ArrayList<Questions> questions) {
		this.questions = questions;
	}
	
	/**
	  * questionOn getter
	  * 
	  * @return the questionOn
	  */
	public short getQuestionOn() {
		return questionOn;
	}

	/**
	  * questionsOn setter
	  * 
	  * @param questionOn  the questionOn to set
	  */
	public void setQuestionOn(short questionOn) {
		this.questionOn = questionOn;
	}

	/**
	 * Auto-Generated hashCode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isFinished ? 1231 : 1237);
		result = prime * result + questionOn;
		result = prime * result
				+ ((questions == null) ? 0 : questions.hashCode());
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
		Exam other = (Exam) obj;
		if (isFinished != other.isFinished)
			return false;
		if (questionOn != other.questionOn)
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
		return "Exam [isFinished=" + isFinished + ", questions=" + questions
				+ ", questionOn=" + questionOn + "]";
	}
	
	 /**
	  * Validate if the instance variables are valid
	  * 
	  * @return boolean - true if instance variables are valid, else false
	  */
	 public boolean validate () 
	 {
	  if (questions == null) return false;
          else if (questionOn <= 0) return false;
	  return true;
	 }
}
