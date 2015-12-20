package com.keystoneexamprep.model.domain;

import java.io.Serializable;

/**
 * Class that holds the questions being asked. This included the
 * question type, right/wrong answers, anchors, descriptions, ect.
 */
public class Questions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2049861176063914966L;

        /**
         * Questions constructor
         */
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	  * @param question
	  * @param correctAnswer
	  * @param questionType
	  * @param incorrectAnswer1
	  * @param incorrectAnswer2
	  * @param incorrectAnswer3
	  * @param assessmentAnchor
	  * @param assessmentNumber
	  * @param eligibleContentNumber
	  * @param eligibleContentDescription
	  * @param studentAnswer
	  * @param isCorrect
	  */
	public Questions(String question, String correctAnswer,
			String questionType, String incorrectAnswer1,
			String incorrectAnswer2, String incorrectAnswer3,
			String assessmentAnchor, byte assessmentNumber, String eligibleContentNumber,
			String eligibleContentDescription, String studentAnswer,
			boolean isCorrect) {
		super();
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.questionType = questionType;
		this.incorrectAnswer1 = incorrectAnswer1;
		this.incorrectAnswer2 = incorrectAnswer2;
		this.incorrectAnswer3 = incorrectAnswer3;
		this.assessmentAnchor = assessmentAnchor;
		this.assessmentNumber = assessmentNumber;
		this.eligibleContentNumber = eligibleContentNumber;
		this.eligibleContentDescription = eligibleContentDescription;
		this.studentAnswer = studentAnswer;
		this.isCorrect = isCorrect;
	}

	//The question being asked
	private String question;
	
	//The correct answer to the question
	private String correctAnswer;
	
	//Question Type
	//Multiple Choice & Short Answer at first.
	//Later implementations for graphing questions.
	private String questionType;
	
	//The first incorrect answer (For Multiple Choice Questions)
	private String incorrectAnswer1;
	
	//The second incorrect answer (For Multiple Choice Questions)
	private String incorrectAnswer2;
	
	//The third incorrect answer (For Multiple Choice Questions)
	private String incorrectAnswer3;
	
	//Assessment anchor of the question 
	//Example: A1.1.1 Operations with Real Numbers and Expressions
	private String assessmentAnchor;
	
	//Number used to associate the assessment Anchor
	private byte assessmentNumber;
	
	//Eligible content number of the question
	//Example: A1.1.1.1.1
	private String eligibleContentNumber;
	
	//Eligible content description of the questions 
	//Example: Compare and/or order any real numbers.
	private String eligibleContentDescription;

	//Answer provided by the student
	private String studentAnswer;
	
	//boolean to determine if the questions was answered correctly or not
	private boolean isCorrect;
	
	/**
	  * question getter
	  * 
	  * @return the question
	  */
	public String getQuestion() {
		return question;
	}

	/**
	  * question setter
	  * 
	  * @param question  the question to set
	  */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	  * correctAnswer getter
	  * 
	  * @return the correctAnswer
	  */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	  * correctAnswer setter
	  * 
	  * @param correctAnswer  the correctAnswer to set
	  */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	  * incorrectAnswer1 getter
	  * 
	  * @return the incorrectAnswer1
	  */
	public String getIncorrectAnswer1() {
		return incorrectAnswer1;
	}

	/**
	  * incorrectAnswer1 setter
	  * 
	  * @param incorrectAnswer1  the incorrectAnswer1 to set
	  */
	public void setIncorrectAnswer1(String incorrectAnswer1) {
		this.incorrectAnswer1 = incorrectAnswer1;
	}

	/**
	  * incorrectAnswer2 getter
	  * 
	  * @return the incorrectAnswer2
	  */
	public String getIncorrectAnswer2() {
		return incorrectAnswer2;
	}


	/**
	  * incorrectAnswer2 setter
	  * 
	  * @param incorrectAnswer2  the incorrectAnswer2 to set
	  */
	public void setIncorrectAnswer2(String incorrectAnswer2) {
		this.incorrectAnswer2 = incorrectAnswer2;
	}

	/**
	  * incorrectAnswer3 getter
	  * 
	  * @return the incorrectAnswer3
	  */
	public String getIncorrectAnswer3() {
		return incorrectAnswer3;
	}


	/**
	  * incorrectAnswer3 setter
	  * 
	  * @param incorrectAnswer3  the incorrectAnswer3 to set
	  */
	public void setIncorrectAnswer3(String incorrectAnswer3) {
		this.incorrectAnswer3 = incorrectAnswer3;
	}

	/**
	  * assessmentAnchor getter
	  * 
	  * @return the assessmentAnchor
	  */
	public String getAssessmentAnchor() {
		return assessmentAnchor;
	}

	/**
	  * assessmentAnchor setter
	  * 
	  * @param assessmentAnchor  the assessmentAnchor to set
	  */
	public void setAssessmentAnchor(String assessmentAnchor) {
		this.assessmentAnchor = assessmentAnchor;
	}
	
	/**
	  * assessmentNumber getter
	  * 
	  * @return the assessmentNumber
	  */
	public byte getAssessmentNumber() {
		return assessmentNumber;
	}

	/**
	  * assessmentNumber setter
	  * 
	  * @param assessmentNumber  the assessmentNumber to set
	  */
	public void setAssessmentNumber(byte assessmentNumber) {
		this.assessmentNumber = assessmentNumber;
	}

	/**
	  * eligibleContentNumber getter
	  * 
	  * @return the eligibleContentNumber
	  */
	public String getEligibleContentNumber() {
		return eligibleContentNumber;
	}


	/**
	  * eligibleContentNumber setter
	  * 
	  * @param eligibleContentNumber  the eligibleContentNumber to set
	  */
	public void setEligibleContentNumber(String eligibleContentNumber) {
		this.eligibleContentNumber = eligibleContentNumber;
	}

	/**
	  * eligibleContentDescription getter
	  * 
	  * @return the eligibleContentDescription
	  */
	public String getEligibleContentDescription() {
		return eligibleContentDescription;
	}


	/**
	  * eligibleContentDescription setter
	  * 
	  * @param eligibleContentDescription  the eligibleContentDescription to set
	  */
	public void setEligibleContentDescription(String eligibleContentDescription) {
		this.eligibleContentDescription = eligibleContentDescription;
	}

	/**
	  * studentAnswer getter
	  * 
	  * @return the studentAnswer
	  */
	public String getStudentAnswer() {
		return studentAnswer;
	}


	/**
	  * studentAnswer setter
	  * 
	  * @param studentAnswer  the studentAnswer to set
	  */
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

	/**
	  * isCorrect getter
	  * 
	  * @return the isCorrect
	  */
	public boolean getCorrect() {
		return isCorrect;
	}


	/**
	  * isCorrect setter
	  * 
	  * @param isCorrect  the isCorrect to set
	  */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	/**
	  * questionType getter
	  * 
	  * @return the questionType
	  */
	public String getQuestionType() {
		return questionType;
	}

	/**
	  * questionType setter
	  * 
	  * @param questionType  the questionType to set
	  */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((assessmentAnchor == null) ? 0 : assessmentAnchor.hashCode());
		result = prime * result + assessmentNumber;
		result = prime * result
				+ ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime
				* result
				+ ((eligibleContentDescription == null) ? 0
						: eligibleContentDescription.hashCode());
		result = prime
				* result
				+ ((eligibleContentNumber == null) ? 0 : eligibleContentNumber
						.hashCode());
		result = prime
				* result
				+ ((incorrectAnswer1 == null) ? 0 : incorrectAnswer1.hashCode());
		result = prime
				* result
				+ ((incorrectAnswer2 == null) ? 0 : incorrectAnswer2.hashCode());
		result = prime
				* result
				+ ((incorrectAnswer3 == null) ? 0 : incorrectAnswer3.hashCode());
		result = prime * result + (isCorrect ? 1231 : 1237);
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result
				+ ((questionType == null) ? 0 : questionType.hashCode());
		result = prime * result
				+ ((studentAnswer == null) ? 0 : studentAnswer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questions other = (Questions) obj;
		if (assessmentAnchor == null) {
			if (other.assessmentAnchor != null)
				return false;
		} else if (!assessmentAnchor.equals(other.assessmentAnchor))
			return false;
		if (assessmentNumber != other.assessmentNumber)
			return false;
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
			return false;
		if (eligibleContentDescription == null) {
			if (other.eligibleContentDescription != null)
				return false;
		} else if (!eligibleContentDescription
				.equals(other.eligibleContentDescription))
			return false;
		if (eligibleContentNumber == null) {
			if (other.eligibleContentNumber != null)
				return false;
		} else if (!eligibleContentNumber.equals(other.eligibleContentNumber))
			return false;
		if (incorrectAnswer1 == null) {
			if (other.incorrectAnswer1 != null)
				return false;
		} else if (!incorrectAnswer1.equals(other.incorrectAnswer1))
			return false;
		if (incorrectAnswer2 == null) {
			if (other.incorrectAnswer2 != null)
				return false;
		} else if (!incorrectAnswer2.equals(other.incorrectAnswer2))
			return false;
		if (incorrectAnswer3 == null) {
			if (other.incorrectAnswer3 != null)
				return false;
		} else if (!incorrectAnswer3.equals(other.incorrectAnswer3))
			return false;
		if (isCorrect != other.isCorrect)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questionType == null) {
			if (other.questionType != null)
				return false;
		} else if (!questionType.equals(other.questionType))
			return false;
		if (studentAnswer == null) {
			if (other.studentAnswer != null)
				return false;
		} else if (!studentAnswer.equals(other.studentAnswer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questions [question=" + question + ", correctAnswer="
				+ correctAnswer + ", questionType=" + questionType
				+ ", incorrectAnswer1=" + incorrectAnswer1
				+ ", incorrectAnswer2=" + incorrectAnswer2
				+ ", incorrectAnswer3=" + incorrectAnswer3
				+ ", assessmentAnchor=" + assessmentAnchor
				+ ", assessmentNumber=" + assessmentNumber
				+ ", eligibleContentNumber=" + eligibleContentNumber
				+ ", eligibleContentDescription=" + eligibleContentDescription
				+ ", studentAnswer=" + studentAnswer + ", isCorrect="
				+ isCorrect + "]";
	}
	
	 /**
	  * Validate if the instance variables are valid
	  * 
	  * @return boolean - true if instance variables are valid, else false
	  */
	 public boolean validate () 
	 {
		if (question == null) return false;
		if (correctAnswer == null) return false;
		if (questionType == null) return false;
		//questionType should only equal MultipleChoice, ShortAnswer, or Graph
		if (!(questionType.equals("MultipleChoice") || questionType.equals("ShortAnswer") || questionType.equals("Graph"))) return false;
		if (incorrectAnswer1 == null && !questionType.equals("ShortAnswer")) return false;
		if (incorrectAnswer2 == null && !questionType.equals("ShortAnswer")) return false;
		if (incorrectAnswer3 == null && !questionType.equals("ShortAnswer")) return false;
		
		if (assessmentAnchor == null) return false;
		if (eligibleContentNumber == null) return false;
		if (eligibleContentDescription == null) return false;
		
		//There may be a time when a student answer could be null.
		//if (studentAnswer == null) return false;
		if(correctAnswer.equals(studentAnswer) && !isCorrect) return false;
		
		return true;
	 }

}
