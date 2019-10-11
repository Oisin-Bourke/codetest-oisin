package com.brightflag.domain;

public class Subject {

	private Integer subjectID;
	private String subjectName;

	public Subject(){

	}

	public Subject(Integer subjectID, String subjectName) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}

	//Getters and setters
	public Integer getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectID=" + subjectID + ", subjectName=" + subjectName + "]";
	}

}
