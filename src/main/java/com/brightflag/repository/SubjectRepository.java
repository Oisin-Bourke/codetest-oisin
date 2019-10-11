package com.brightflag.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.brightflag.domain.Subject;

@Repository
public class SubjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class SubjectRowMapper implements RowMapper<Subject> {
        @Override
        public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
            Subject subject = new Subject();
            subject.setSubjectID(rs.getInt("subjectID"));
            subject.setSubjectName(rs.getString("subjectName"));
            return subject;
        }
    }

    public int insert(Subject subject) {
        return jdbcTemplate.update("insert into subject (subjectID, subjectName ) " + "values(?, ?)",
                new Object[] { subject.getSubjectID(), subject.getSubjectName() });
    }

    public List<Subject> getSubjects() {
        return jdbcTemplate.query("SELECT * FROM subject;", new SubjectRepository.SubjectRowMapper());

    }

    public List<Subject> findAllById(Integer id){
        return jdbcTemplate.query("SELECT * FROM subject where subjectID = ?;", new Object[] { id }, new SubjectRepository.SubjectRowMapper());
    }

    public List<Subject> findAllByStudentId(Integer id){
        return jdbcTemplate.query("select * from SUBJECT\n" +
                "    inner join STUDENT_SUBJECT SS on SUBJECT.SUBJECTID = SS.SUBJECT\n" +
                "where STUDENT = ?;", new Object[] { id }, new SubjectRepository.SubjectRowMapper());
    }

    public Subject findById(long id) {
        return jdbcTemplate.queryForObject("select * from subject where subjectID=?", new Object[] { id },
                new BeanPropertyRowMapper<Subject>(Subject.class));
    }


}
