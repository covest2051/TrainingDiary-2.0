package ru.marat.springApp.trainingDiary.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marat.springApp.trainingDiary.models.trainingModels.CardioWorkout;
import ru.marat.springApp.trainingDiary.models.trainingModels.StrengthWorkout;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;
import ru.marat.springApp.trainingDiary.models.trainingModels.WorkoutType;
import ru.marat.springApp.trainingDiary.models.userModels.User;
import ru.marat.springApp.trainingDiary.repository.UserRepository;
import ru.marat.springApp.trainingDiary.secutiry.UserDetails;
import ru.marat.springApp.trainingDiary.services.UserDetailsService;
import ru.marat.springApp.trainingDiary.services.WorkoutService;

import java.util.Optional;
import java.util.Random;

@Controller
public class HomeMenuController {

    private final WorkoutService workoutService;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    @Autowired
    public HomeMenuController(WorkoutService workoutService, UserDetailsService userDetailsService, UserRepository userRepository) {
        this.workoutService = workoutService;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
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

    @GetMapping("/startWorkout")
    public String startWorkout(@RequestParam("workoutType") String workoutTypeStr, Model model, HttpSession session) {
        WorkoutType workoutType = WorkoutType.valueOf(workoutTypeStr);
        session.setAttribute("workoutType", workoutType);

        Workout workout;
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
        model.addAttribute("workout", workout);
        model.addAttribute("workoutType", workoutType);
        return "startWorkout";
    }

    @PostMapping("/endWorkout")
    public String endWorkout(@RequestParam("workoutDuration") String workoutDurationStr,
                             @ModelAttribute Workout workout, HttpSession session) {
        WorkoutType workoutType = (WorkoutType) session.getAttribute("workoutType");
        workout.setWorkoutType(workoutType);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        int userId = userDetails.getUser().getUserId();

        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(workout::setUser);

        workoutService.save(workout);
        return "startWorkout";
    }


}
