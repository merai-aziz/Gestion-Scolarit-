package com.example.school_management.service;


import com.example.school_management.entity.Grade;
import com.example.school_management.repositories.GradeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    private GradeRepository GradeRepository;
    public List<Grade> getAllGrades(){
        return GradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id){
        return GradeRepository.findById(id);
    }

    public Grade createGrade(Grade Grade){
        return GradeRepository.save(Grade);
    }

    public Grade updateGrade(long id, Grade gradeDetails){
        return GradeRepository.findById(id).map(Grade->{
            Grade.setValue(gradeDetails.getValue());
            return GradeRepository.save(Grade);
        }).orElseThrow(() -> new RuntimeException("Grade not found with id" + id));
    }


    public void deleteGrade(long id){
        GradeRepository.deleteById(id);
    }
}