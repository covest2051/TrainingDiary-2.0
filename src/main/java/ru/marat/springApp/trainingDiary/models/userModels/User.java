package ru.marat.springApp.trainingDiary.models.userModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import ru.marat.springApp.trainingDiary.models.trainingModels.Workout;

import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Workout> workouts;

    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }
}
