package ru.marat.springApp.trainingDiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;
import ru.marat.springApp.trainingDiary.services.WorkoutService;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/showWorkoutHistory")
    public List<Workout> getWorkouts() {
        return workoutService.findWorkouts();
    }

    @GetMapping("/endWorkout/{id}")
    public ResponseEntity<Workout> getWorkout(@PathVariable int id) {
        Optional<Workout> workoutOptional = workoutService.findWorkout(id);

        return workoutOptional
                .map(workout -> new ResponseEntity<>(workout, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
