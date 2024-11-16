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


public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    float value;

    @OneToOne
    @JoinColumn(name = "evaluation_id")
    private Evaluation evaluation;


}
