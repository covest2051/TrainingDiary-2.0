package ru.marat.springApp.trainingDiary.models.exerciseModels;

import jakarta.persistence.*;
import lombok.Data;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;

@Data
@Entity
@Table(name = "user_exercises")
public class UserExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private AvailableExercise exercise;

    private Integer sets;
    private Integer reps;
    private Integer weight;
    private String intensity;
}
