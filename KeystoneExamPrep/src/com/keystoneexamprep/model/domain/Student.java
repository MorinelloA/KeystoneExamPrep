package com.keystoneexamprep.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** 
 * Class that holds information about the student. This
 * will be used extensively for their profile
 */
public class Student implements Serializable{
	
	 
	private static final long serialVersionUID = -755099901118827484L;

        /**
         * Student constructor
         */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	 /**
	  * @param lastName
	  * @param firstName
	  * @param birthMonth
	  * @param birthDate
	  * @param birthYear
	  * @param emailAddress
	  * @param password
	  * @param phoneNumber
	  * @param results
	  */
	public Student(String lastName, String firstName, String birthMonth,
			byte birthDate, short birthYear, String emailAddress,
			char[] password, String phoneNumber, List<Results> results) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthMonth = birthMonth;
		this.birthDate = birthDate;
		this.birthYear = birthYear;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.results = results;
	}

	//Student last name 
	 private String lastName;

	 //Student first name
	 private String firstName;

	 //Student birthMonth
	 private String birthMonth;
	 
	 //Student birthDate
	 private byte birthDate;
	 
	 //Student birthYear
	 private short birthYear;
	 
	 //Student email address
	 private String emailAddress;

	 //Student password
	 private char[] password;

	 //Student phone number
	 private String phoneNumber;

	//Holds results objects
	private List<Results> results = new ArrayList<Results>();
		
	 /**
	  * lastName getter
	  * 
	  * @return the lastName
	  */
	 public String getLastName() {
		 return lastName;
	 }

	 /**
	  * lastName setter
	  * 
	  * @param lastName  the lastName to set
	  */
	 public void setLastName(String lastName) {
		 this.lastName = lastName;
	 }
	 
	 /**
	  * firstName getter
	  * 
	  * @return the firstName
	  */
	 public String getFirstName() {
		 return firstName;
	 }

	 /**
	  * firstName setter
	  * 
	  * @param firstName  the firstName to set
	  */
	 public void setFirstName(String firstName) {
		 this.firstName = firstName;
	 }

	 /**
	  * birthMonth getter
	  * 
	  * @return the birthMonth
	  */
	public String getBirthMonth() {
		return birthMonth;
	}

	/**
	  * birthMonth setter
	  * 
	  * @param birthMonth the birthMonth to set
	  */
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	/**
	  * birthDate getter
	  * 
	  * @return the birthDate
	  */
	public byte getBirthDate() {
		return birthDate;
	}

	/**
	  * birthDate setter
	  * 
	  * @param birthDate  the birthDate to set
	  */
	public void setBirthDate(byte birthDate) {
		this.birthDate = birthDate;
	}

	/**
	  * birthYear getter
	  * 
	  * @return the birthYear
	  */
	public short getBirthYear() {
		return birthYear;
	}

	/**
	  * birthYear setter
	  * 
	  * @param birthYear  the birthYear to set
	  */
	public void setBirthYear(short birthYear) {
		this.birthYear = birthYear;
	}

	/**
	  * emailAddress getter
	  * 
	  * @return the emailAddress
	  */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	  * emailAddress setter
	  * 
	  * @param emailAddress  the emailAddress to set
	  */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	  * phoneNumber getter
	  * 
	  * @return the phoneNumber
	  */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	  * phoneNumber setter
	  * 
	  * @param phoneNumber  the phoneNumber to set
	  */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	  * password getter
	  * 
	  * @return the password
	  */
	public char[] getPassword() {
		return password;
	}

	/**
	  * password setter
	  * 
	  * @param password  the password to set
	  */
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	/**
	  * results object getter
	  * 
	  * @return the results object
	  */
	public List<Results> getResults() {
		return results;
	}

	/**
	  * results list object setter
	  * 
	  * @param results  the results list object to set
	  */
	public void setResults(List<Results> results) {
		this.results = results;
	}

	/**
	 * Auto-Generated hashCode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birthDate;
		result = prime * result
				+ ((birthMonth == null) ? 0 : birthMonth.hashCode());
		result = prime * result + birthYear;
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
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
		Student other = (Student) obj;
		if (birthDate != other.birthDate)
			return false;
		if (birthMonth == null) {
			if (other.birthMonth != null)
				return false;
		} else if (!birthMonth.equals(other.birthMonth))
			return false;
		if (birthYear != other.birthYear)
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}

	//My attempt at making my own equals method
	/*
	public boolean equals(Student student) 
	 {		
		 if (birthDate != student.birthDate) return false;
		 if (birthYear != student.birthYear) return false;
		 if (!lastName.equals(student.lastName)) return false;
		 if (!firstName.equals(student.lastName)) return false;
		 if (!birthMonth.equals(student.birthMonth)) return false;
		 if (!emailAddress.equals(student.emailAddress)) return false;
		 if (!password.equals(student.password)) return false;
		 if (!phoneNumber.equals(student.phoneNumber)) return false;
		 if (!results.equals(student.results)) return false;
	  
	  return true;
	 }
	 */
	
	/**
	 * Auto-Generated toString() method
	 */
	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", firstName=" + firstName
				+ ", birthMonth=" + birthMonth + ", birthDate=" + birthDate
				+ ", birthYear=" + birthYear + ", emailAddress=" + emailAddress
				+ ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", results=" + results + "]";
	}
	
	 /**
	  * Validate if the instance variables are valid
	  * 
	  * @return boolean - true if instance variables are valid, else false
	  */
	 public boolean validate () 
	 {
		 
		 if (lastName == null) return false;
		 
		 if (firstName == null) return false;
		 
		 if (birthMonth == null) return false;
		 
		 //Month not one of the 12 months
		 if (!(birthMonth.equals("January") || birthMonth.equals("February") || birthMonth.equals("March") || birthMonth.equals("April") || birthMonth.equals("May") || birthMonth.equals("June") || birthMonth.equals("July") || birthMonth.equals("August") || birthMonth.equals("September") || birthMonth.equals("October") || birthMonth.equals("November") || birthMonth.equals("December"))) return false;
		 if (birthDate <= 0 || birthDate > 31) return false;
		 if (birthYear <= 0) return false;
		 if (emailAddress == null) return false;
		 if (password == null) return false;
		 if (phoneNumber == null) return false;
		 
		 //Results may equal null whenever an account is first created
		 //if (results == null) return false;

		 return true;
	 }
}
