package ru.marat.springApp.trainingDiary.models.trainingModels;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import ru.marat.springApp.trainingDiary.models.exerciseModel.Exercise;
import ru.marat.springApp.trainingDiary.models.userModels.User;

import java.time.Duration;
import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public abstract class Workout {
    @Id
    @Column(name = "workout_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workoutId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "workout_type")
    private WorkoutType workoutType;

    @Column(name = "workout_duration")
    private Duration workoutDuration;

    @OneToMany(mappedBy = "workout")
    @Cascade(CascadeType.ALL)
    private List<Exercise> exercises;

    public Workout() {
    }

    public Workout(User user, WorkoutType workoutType) {
        this.user = user;
        this.workoutType = workoutType;
    }
}

