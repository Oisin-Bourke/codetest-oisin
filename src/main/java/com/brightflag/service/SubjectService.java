package com.brightflag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightflag.domain.Subject;
import com.brightflag.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubjects() {
        return subjectRepository.getSubjects();
    }


}
