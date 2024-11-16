package com.example.school_management.controller;

import com.example.school_management.entity.Grade;
import com.example.school_management.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeController {


    @Autowired
    private GradeService GradeService;

    @GetMapping
    public List<Grade> getAllGrades(){
        return GradeService.getAllGrades();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable long id) {
        Optional<Grade> Grade = GradeService.getGradeById(id);
        return Grade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return GradeService.createGrade(grade);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable long id, @RequestBody Grade GradeDetails) {

        try {
            Grade updatedGrade = GradeService.updateGrade(id, GradeDetails);
            return ResponseEntity.ok(updatedGrade);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable long id) {
        GradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }


}




