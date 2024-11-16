package com.example.school_management.service;

import com.example.school_management.entity.Subject;
import com.example.school_management.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository SubjectRepository;
    public List<Subject> getAllSubjects(){
        return SubjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id){
        return SubjectRepository.findById(id);
    }

    public Subject createSubject(Subject Subject){
        return SubjectRepository.save(Subject);
    }

    public Subject updateSubject(long id, Subject subjectDetails){
        return SubjectRepository.findById(id).map(Subject->{
            Subject.setName(subjectDetails.getName());
            Subject.setCredit(subjectDetails.getCredit());
            return SubjectRepository.save(Subject);
        }).orElseThrow(() -> new RuntimeException("subject not found with id" + id));
    }


    public void deleteSubject(long id){
        SubjectRepository.deleteById(id);
    }
}