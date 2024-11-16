package com.example.school_management.controller;

import com.example.school_management.entity.Subject;
import com.example.school_management.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {


    @Autowired
    private SubjectService SubjectService;

    @GetMapping
    public List<Subject> getAllSubjects(){
        return SubjectService.getAllSubjects();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable long id) {
        Optional<Subject> Subject = SubjectService.getSubjectById(id);
        return Subject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return SubjectService.createSubject(subject);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable long id, @RequestBody Subject subjectDetails) {

        try {
            Subject updatedSubject = SubjectService.updateSubject(id, subjectDetails);
            return ResponseEntity.ok(updatedSubject);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable long id) {
        SubjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }


}
