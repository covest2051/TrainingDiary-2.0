package ru.marat.springApp.trainingDiary.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.marat.springApp.trainingDiary.models.trainingModels.WorkoutType;
import ru.marat.springApp.trainingDiary.models.userModels.User;
import ru.marat.springApp.trainingDiary.services.RegistrationService;
import ru.marat.springApp.trainingDiary.util.UserValidator;

import java.util.List;

@Controller
public class AuthController {

    private final RegistrationService registrationService;
    private final UserValidator userValidator;

    @Autowired
    public AuthController(RegistrationService registrationService, UserValidator userValidator) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
    }

    @GetMapping("/registrationAndAuthorization")
    public String registrationAndAuthorization() {
        return "registrationAndAuthorization";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute User user, Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors())
            return "registration";

        registrationService.register(user);
        return "redirect:/login";
    }
}
