package com.brightflag.controller;

import com.brightflag.domain.Student_Subject;
import com.brightflag.service.Student_SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Student_SubjectAPIController {

    @Autowired
    Student_SubjectService student_subjectService;

    @PostMapping("/api/addSubject")
    public ResponseEntity<Object> createStudent(@RequestBody Student_Subject student_subject) {
        if(student_subject==null){
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        student_subjectService.assignSubject(student_subject);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
