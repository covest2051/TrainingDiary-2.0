package ru.marat.springApp.trainingDiary.models.exerciseModel;

import jakarta.persistence.*;
import lombok.Data;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;

import java.time.Duration;

@Data
@Entity(name = "Exercises")
public class Exercise {
    @Id
    @Column(name = "exercise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int exerciseId;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "exercise_duration")
    private Duration exerciseDuration;

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    public Exercise() {
    }

    public Exercise(String exerciseName, ExerciseType exerciseType) {
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
    }
}
