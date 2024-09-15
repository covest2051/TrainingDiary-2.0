package ru.marat.springApp.trainingDiary.models.trainingModels;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("CARDIO")
@Data
public class CardioWorkout extends Workout {
    private int caloriesBurned;
}
