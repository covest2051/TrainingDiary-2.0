package ru.marat.springApp.trainingDiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.marat.springApp.trainingDiary.models.exerciseModels.UserExercise;

@Repository
public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {
}
