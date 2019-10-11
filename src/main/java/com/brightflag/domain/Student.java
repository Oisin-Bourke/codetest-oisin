package com.brightflag.domain;

import com.brightflag.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {

	@Autowired
	SubjectRepository subjectRepository;

	private Integer studentID;
	private String firstName;
	private String lastName;
	private Set<Exam> exams = new HashSet<>();
	private List<Subject> subjects = new ArrayList<>();

	public Student(){

	}

	public Student(Integer studentID, String firstName, String lastName) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Student(Integer studentID, String firstName, String lastName, Set<Exam> exams, List<Subject> subjects) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.exams = exams;
		this.subjects = subjects;
	}

	//Getters and setters
	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentID=" + studentID +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}

}
