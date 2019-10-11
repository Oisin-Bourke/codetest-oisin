package com.brightflag.repository;

import com.brightflag.domain.Exam;
import com.brightflag.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExamRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class ExamRowMapper implements RowMapper<Exam> {
		@Override
		public Exam mapRow(ResultSet rs, int rowNum) throws SQLException {
			Exam exam = new Exam();
			exam.setExamID(rs.getInt("examID"));
			exam.setExamName(rs.getString("examName"));
			return exam;
		}
	}

	public int insert(Exam exam, Student student) {
		return jdbcTemplate.update("insert into exam (examID, examName, student) " + "values(?, ?, ?)",
				new Object[] { exam.getExamID(), exam.getExamName(), student.getStudentID() });
	}

	public List<Exam> findAllById(Integer id){
		return jdbcTemplate.query("SELECT * FROM exam where subjectID = ?;", new Object[] { id }, new ExamRepository.ExamRowMapper());
	}

}
