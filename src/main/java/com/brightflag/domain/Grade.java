package com.brightflag.domain;

public class Grade {

	private Integer gradeID;
	private String grade;

	public Grade(Integer gradeID, String grade) {
		this.gradeID = gradeID;
		this.grade = grade;
	}

	//Getters and setters
	public Integer getGradeID() {
		return gradeID;
	}

	public void setGradeID(Integer gradeID) {
		this.gradeID = gradeID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade{" +
				"gradeID=" + gradeID +
				", grade='" + grade + '\'' +
				'}';
	}
}
