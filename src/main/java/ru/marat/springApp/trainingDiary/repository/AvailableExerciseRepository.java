package ru.marat.springApp.trainingDiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.marat.springApp.trainingDiary.models.exerciseModels.AvailableExercise;

import java.util.List;

@Repository
public interface AvailableExerciseRepository extends JpaRepository<AvailableExercise, Long> {
    List<AvailableExercise> findByExerciseType(String workoutTypeStr);

    AvailableExercise findByName(String s);
}
