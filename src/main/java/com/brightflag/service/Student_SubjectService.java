package com.brightflag.service;

import com.brightflag.domain.Student_Subject;
import com.brightflag.repository.Student_SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Student_SubjectService {

    @Autowired
    Student_SubjectRepository student_subjectRepository;

    public void assignSubject(Student_Subject student_subject) {
        student_subjectRepository.insert(student_subject);
    }
}
