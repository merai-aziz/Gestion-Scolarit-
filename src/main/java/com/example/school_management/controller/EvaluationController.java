package com.example.school_management.controller;

import com.example.school_management.entity.Evaluation;
import com.example.school_management.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {


    @Autowired
    private EvaluationService EvaluationService;

    @GetMapping
    public List<Evaluation> getAllEvaluations(){
        return EvaluationService.getAllEvaluations();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable long id) {
        Optional<Evaluation> Evaluation = EvaluationService.getEvaluationById(id);
        return Evaluation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return EvaluationService.createEvaluation(evaluation);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable long id, @RequestBody Evaluation evaluationDetails) {

        try {
            Evaluation updatedEvaluation = EvaluationService.updateEvaluation(id, evaluationDetails);
            return ResponseEntity.ok(updatedEvaluation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable long id) {
        EvaluationService.deleteEvaluation(id);
        return ResponseEntity.noContent().build();
    }


}
