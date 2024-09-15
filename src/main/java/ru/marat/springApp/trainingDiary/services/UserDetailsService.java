package ru.marat.springApp.trainingDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.marat.springApp.trainingDiary.models.userModels.User;
import ru.marat.springApp.trainingDiary.repository.UserRepository;
import ru.marat.springApp.trainingDiary.secutiry.UserDetails;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new UserDetails(user.get());
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
}
