package ru.marat.springApp.trainingDiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marat.springApp.trainingDiary.models.trainingModels.CardioWorkout;
import ru.marat.springApp.trainingDiary.models.trainingModels.StrengthWorkout;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;
import ru.marat.springApp.trainingDiary.models.trainingModels.WorkoutType;
import ru.marat.springApp.trainingDiary.services.WorkoutService;

@Controller
public class HomeMenuController {

    private final WorkoutService workoutService;

    @Autowired
    public HomeMenuController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/homeMenu")
    public String homeMenu() {
        return "homeMenu";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/createWorkout")
    public String selectWorkoutType(Model model) {
        model.addAttribute("workoutTypes", WorkoutType.values());
        return "createWorkout";
    }

    @GetMapping("/selectWorkoutType")
    public String selectWorkoutType(@RequestParam("workoutType") String workoutTypeStr, @ModelAttribute Workout workout) {
        WorkoutType workoutType = WorkoutType.valueOf(workoutTypeStr);
        switch (workoutType) {
            case CARDIO:
                workout = new CardioWorkout();
                break;
            case STRENGTH:
                workout = new StrengthWorkout();
                break;
            default:
                throw new IllegalArgumentException("Unknown workout type: " + workoutType);
        }
        workout.setWorkoutType(workoutType);
        return "redirect:/startWorkout?workoutType=" + workoutTypeStr;
    }

}
