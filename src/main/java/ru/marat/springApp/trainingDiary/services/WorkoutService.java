package ru.marat.springApp.trainingDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;
import ru.marat.springApp.trainingDiary.repository.WorkoutRepository;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public void save(Workout workout) {
        workoutRepository.save(workout);
    }
}
