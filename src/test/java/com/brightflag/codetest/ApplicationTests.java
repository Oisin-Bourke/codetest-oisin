package com.brightflag.codetest;

import com.brightflag.domain.Student;
import com.brightflag.domain.Student_Subject;
import com.brightflag.domain.Subject;
import com.brightflag.repository.StudentRepository;
import com.brightflag.repository.Student_SubjectRepository;
import com.brightflag.repository.SubjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private Student_SubjectRepository student_subjectRepository;

	@Test
	public void contextLoads(){
		//ensure app loads...
	}

	@Test
	public void addSubjectToStudent() {

		//1 Create two new subjects then persist and test

		Subject java = new Subject();
		java.setSubjectID(30);
		java.setSubjectName("Java");
		subjectRepository.insert(java);

		Subject savedJava = subjectRepository.findById(java.getSubjectID());
		assertThat(savedJava).isNotNull();

		Subject javaScript = new Subject();
		javaScript.setSubjectID(31);
		javaScript.setSubjectName("JavaScript");
		subjectRepository.insert(javaScript);

		Subject savedJavaScript = subjectRepository.findById(javaScript.getSubjectID());
		assertThat(savedJavaScript).isNotNull();

		//2 Create new student then persist and test

		Student ciaran = new Student(15,"Ciaran","Flood");
		studentRepository.insert(ciaran);
		Student savedCiaran = studentRepository.findById(ciaran.getStudentID());
		assertThat(savedCiaran).isNotNull();

		//3 Create two new student_subject 'enrollments' in joining table then persist and test

		Student_Subject enrollment1 = new Student_Subject(savedCiaran.getStudentID(),savedJava.getSubjectID());
		student_subjectRepository.insert(enrollment1);
		Student_Subject savedEnrollment1 = student_subjectRepository.findById(enrollment1);
		assertThat(savedEnrollment1).isNotNull();

		Student_Subject enrollment2 = new Student_Subject(savedCiaran.getStudentID(),savedJavaScript.getSubjectID());
		student_subjectRepository.insert(enrollment2);
		Student_Subject savedEnrollment2 = student_subjectRepository.findById(enrollment2);
		assertThat(savedEnrollment2).isNotNull();

		//4) Check size of students subject list as expected

		List<Subject> subjects = subjectRepository.findAllByStudentId(savedCiaran.getStudentID());
		savedCiaran.setSubjects(subjects);
		assertThat(savedCiaran.getSubjects().size()).isEqualTo(2);
	}

}
