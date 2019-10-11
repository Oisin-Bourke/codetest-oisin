package com.brightflag.domain;

import com.brightflag.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	/*
	public Set<Student_Subject> getStudent_subjectList() {

		return student_subjectList = subjectRepository.findAllByStudentId(studentID);
	}

	public void setStudent_subjectList(Set<Student_Subject> student_subjectList) {
		this.student_subjectList = student_subjectList;
	}

	public void addSubject(Subject subject){
		//this.student_subjectList.add(createStudent_Subject(subject));
		//this.student_subjectList.add(new Student_Subject(subject.getSubjectID()));
	}

	public Set<Integer> getSubjectIds(){
		return this.student_subjectList.stream()
				.map(Student_Subject::getSubject)
				.collect(Collectors.toSet());
	}

	/*
	private Student_Subject createStudent_Subject(Subject subject) {
		Assert.notNull(subject, "Subject must not be null");
		Assert.notNull(subject.getSubjectID(),"Subject ID must not be null" );
		Student_Subject student_subject = new Student_Subject();
		student_subject.setSubject(subject.getSubjectID());
		return student_subject;
	}
	 */

	@Override
	public String toString() {
		return "Student{" +
				"studentID=" + studentID +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
