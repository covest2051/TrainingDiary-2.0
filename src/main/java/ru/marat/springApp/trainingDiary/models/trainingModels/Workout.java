package ru.marat.springApp.trainingDiary.models.trainingModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import ru.marat.springApp.trainingDiary.models.userModels.User;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "workout_type", discriminatorType = DiscriminatorType.STRING)
public class Workout {
    @Id
    @Column(name = "workout_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workoutId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "workout_type", insertable = false, updatable = false)
    private WorkoutType workoutType;

    @Column(name = "workout_duration")
    private String workoutDuration;

    public Workout() {
    }

    public Workout(User user, WorkoutType workoutType) {
        this.user = user;
        this.workoutType = workoutType;
    }
}
