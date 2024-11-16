package com.example.school_management.service;

import com.example.school_management.entity.Evaluation;
import com.example.school_management.repositories.EvaluationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository EvaluationRepository;
    public List<Evaluation> getAllEvaluations(){
        return EvaluationRepository.findAll();
    }

    public Optional<Evaluation> getEvaluationById(Long id){
        return EvaluationRepository.findById(id);
    }

    public Evaluation createEvaluation(Evaluation Evaluation){
        return EvaluationRepository.save(Evaluation);
    }

    public Evaluation updateEvaluation(long id, Evaluation evaluationDetails){
        return EvaluationRepository.findById(id).map(Evaluation->{
            Evaluation.setType(evaluationDetails.getType());
            Evaluation.setCoefficient(evaluationDetails.getCoefficient());
            return EvaluationRepository.save(Evaluation);
        }).orElseThrow(() -> new RuntimeException("Evaluation not found with id" + id));
    }


    public void deleteEvaluation(long id){
        EvaluationRepository.deleteById(id);
    }
}