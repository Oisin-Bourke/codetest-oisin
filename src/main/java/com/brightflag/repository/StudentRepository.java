package com.brightflag.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.brightflag.domain.Student;

@Repository
public class StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SubjectRepository subjectRepository;

	class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudentID(rs.getInt("studentID"));
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
			//add method here to get exams...
			student.setSubjects(subjectRepository.findAllByStudentId(rs.getInt("studentID")));
			return student;
		}
	}

	public int insert(Student student) {
		return jdbcTemplate.update("insert into student (studentID, firstName, lastName) " + "values(?, ?, ?)",
				new Object[] { student.getStudentID(), student.getFirstName(), student.getLastName() });
	}

	public List<Student> getStudents() {
		return jdbcTemplate.query("SELECT * FROM student;", new StudentRowMapper());

	}

	public Student findById(long id) {
		return jdbcTemplate.queryForObject("select * from student where studentID=?", new Object[] { id },
				new BeanPropertyRowMapper<Student>(Student.class));
	}

}
