package ru.marat.springApp.trainingDiary.models.exerciseModels;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "available_exercises")
public class AvailableExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "exercise_type", length = 50)
    private String exerciseType;
}