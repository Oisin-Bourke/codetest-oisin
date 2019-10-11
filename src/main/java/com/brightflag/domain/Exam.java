package com.brightflag.domain;

public class Exam {

	private Integer examID;
	private String examName;

	public Exam() {

	}

	public Exam(Integer examID, String examName) {
		this.examID = examID;
		this.examName = examName;
	}

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

	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", examName=" + examName + "]";
	}

}
