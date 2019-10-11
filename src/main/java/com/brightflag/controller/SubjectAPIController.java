package com.brightflag.controller;

import java.util.List;

import com.brightflag.repository.Student_SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.domain.Subject;
import com.brightflag.service.SubjectService;

@RestController
public class SubjectAPIController {

	@Autowired
	SubjectService subjectService;

	@Autowired
	Student_SubjectRepository student_subjectRepository;

	@RequestMapping("api/getSubjects")
	public List<Subject> getSubjects() {
		return subjectService.getSubjects();
	}

}
