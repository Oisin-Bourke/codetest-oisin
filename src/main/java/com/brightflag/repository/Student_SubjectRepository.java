package com.brightflag.repository;

import com.brightflag.domain.Student_Subject;
import com.brightflag.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Student_SubjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class Student_SubjectRowMapper implements RowMapper<Student_Subject> {
        @Override
        public Student_Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student_Subject student_subject = new Student_Subject();
            student_subject.setSubject(rs.getInt("subject"));
            student_subject.setStudent(rs.getInt("student"));
            return student_subject;
        }
    }

    public int insert(Student_Subject student_subject) {
        return jdbcTemplate.update("insert into student_subject (student, subject) " + "values(?, ?)",
                new Object[] { student_subject.getStudent(), student_subject.getSubject() });
    }

    public Student_Subject findById(Student_Subject student_subject) {
        return jdbcTemplate.queryForObject("select * from student_subject where student = ? and subject= ? ", new Object[] { student_subject.getStudent(),student_subject.getSubject() }  ,
                new BeanPropertyRowMapper<Student_Subject>(Student_Subject.class));
    }

}
