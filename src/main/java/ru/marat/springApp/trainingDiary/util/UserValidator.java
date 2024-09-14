package ru.marat.springApp.trainingDiary.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.marat.springApp.trainingDiary.models.userModels.User;
import ru.marat.springApp.trainingDiary.services.UserDetailsService;

@Component
public class UserValidator implements Validator {

    private final UserDetailsService userDetailsService;

    public UserValidator(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        try {
            userDetailsService.loadUserByUsername(((User) target).getEmail());
        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("email", "", "Данный email уже зарегистрирован");
    }
}
