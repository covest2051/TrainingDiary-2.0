package ru.marat.springApp.trainingDiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
}
