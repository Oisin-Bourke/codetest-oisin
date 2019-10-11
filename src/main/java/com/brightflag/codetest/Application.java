package com.brightflag.codetest;

import com.brightflag.domain.Student;
import com.brightflag.domain.Student_Subject;
import com.brightflag.domain.Subject;
import com.brightflag.repository.StudentRepository;
import com.brightflag.repository.Student_SubjectRepository;
import com.brightflag.repository.SubjectRepository;
//import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.brightflag"})
public class Application {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private Student_SubjectRepository student_subjectRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Start internal H2 server so we can query the DB from IDE
	 *
	 * @return H2 Server instance
	 * @throws SQLException
	 */

	/*
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}

	 */



	/**
	 * Initialize data
	 */
	@PostConstruct
	public void init() {
		System.out.println("Running post init...");

		//1 Create two subjects and persist
		Subject french = new Subject();
		french.setSubjectID(10);
		french.setSubjectName("French");
		subjectRepository.insert(french);

		Subject savedFrench = subjectRepository.findById(french.getSubjectID());
		System.out.println(savedFrench);

		Subject german = new Subject();
		german.setSubjectID(11);
		german.setSubjectName("German");
		subjectRepository.insert(german);

		Subject savedGerman = subjectRepository.findById(german.getSubjectID());
		System.out.println(savedGerman);

		//2 Create student and persist
		Student larry = new Student(22,"Larry","Burke");
		studentRepository.insert(larry);
		Student savedLarry = studentRepository.findById(larry.getStudentID());
		System.out.println(savedLarry);

		//3 Persist to joining student_subject table
		Student_Subject entry1 = new Student_Subject(savedLarry.getStudentID(),savedFrench.getSubjectID());
		student_subjectRepository.insert(entry1);

		Student_Subject entry2 = new Student_Subject(savedLarry.getStudentID(),savedGerman.getSubjectID());
		student_subjectRepository.insert(entry2);

		//Get subjects for saved student larry
		List<Subject> subjects = subjectRepository.findAllByStudentId(savedLarry.getStudentID());
		for(Subject s : subjects){ System.out.println(s); }
	}

}
