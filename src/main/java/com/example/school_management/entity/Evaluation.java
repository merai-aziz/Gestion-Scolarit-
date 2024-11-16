package com.example.school_management.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String type;
    float coefficient;


    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToOne(mappedBy = "evaluation", cascade = CascadeType.ALL)
    private Grade grade;

}
