package com.keystoneexamprep.model.domain;

import java.io.Serializable;

/**
 * Class for creating a .pdf printout of results
 */
public class Printout implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5218838271541314526L;

        /**
         * Printout constructor
         */
	public Printout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	  * @param student
	  * @param fileName
	  * @param fileLocation
	  */
	public Printout(Student student, String fileName, String fileLocation) {
		super();
		this.student = student;
		this.fileName = fileName;
		this.fileLocation = fileLocation;
	}

	//Student the results belong to
	/*This object also contains the results, so no need to add another
	 * result object
	*/	
	private Student student;
	
	//filename for the .pdf file
	private String fileName;
	
	//location the .pdf file will be saved
	private String fileLocation;

	/**
	  * student object getter
	  * 
	  * @return the student object
	  */
	public Student getStudent() {
		return student;
	}

	/**
	  * student object setter
	  * 
	  * @param student object  the student object to set
	  */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	  * fileName getter
	  * 
	  * @return the fileName
	  */
	public String getFileName() {
		return fileName;
	}

	/**
	  * fileName setter
	  * 
	  * @param fileName  the fileName to set
	  */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	  * location getter
	  * 
	  * @return the location
	  */
	public String getLocation() {
		return fileLocation;
	}

	/**
	  * fileLocation setter
	  * 
	  * @param fileLocation  the fileLocation to set
	  */
	public void setLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	/**
	 * Auto-Generated hashCode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fileLocation == null) ? 0 : fileLocation.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		Printout other = (Printout) obj;
		if (fileLocation == null) {
			if (other.fileLocation != null)
				return false;
		} else if (!fileLocation.equals(other.fileLocation))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	/**
	 * Auto-Generated toString() method
	 */
	@Override
	public String toString() {
		return "Printout [student=" + student + ", fileName=" + fileName
				+ ", fileLocation=" + fileLocation + "]";
	}
	
	 /**
	  * Validate if the instance variables are valid
	  * 
	  * @return boolean - true if instance variables are valid, else false
	  */
	 public boolean validate () 
	 {
		 if (student == null) return false;
                 else if (fileName == null) return false;
                 else if (fileLocation == null) return false;
	    
		 return true;
	 }
}
