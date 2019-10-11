package com.brightflag.domain;

public class Exam {

	private Integer examID;
	private String examName;
	private Grade grade;

	public Exam() {

	}

	public Exam(Integer examID, String examName, Grade grade) {
		this.examID = examID;
		this.examName = examName;
		this.grade = grade;
	}

	//Getters and setters
	public Integer getExamID() {
		return examID;
	}

	public void setExamID(Integer examID) {
		this.examID = examID;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Exam{" +
				"examID=" + examID +
				", examName='" + examName + '\'' +
				", grade=" + grade +
				'}';
	}
}
